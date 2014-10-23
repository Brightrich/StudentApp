package com.brt.studentapp.model;

import com.brt.studentapp.EMF;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.datanucleus.query.JPACursorHelper;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Api(name = "matpelendpoint", namespace = @ApiNamespace(ownerDomain = "brt.com", ownerName = "brt.com", packagePath = "studentapp.model"))
public class MatpelEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listMatpel", path = "list_matpel")
	public CollectionResponse<Matpel> listMatpel(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		EntityManager mgr = null;
		Cursor cursor = null;
		List<Matpel> execute = null;

		try {
			mgr = getEntityManager();
			Query query = mgr.createQuery("select from Matpel as Matpel");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}

			if (limit != null) {
				query.setFirstResult(0);
				query.setMaxResults(limit);
			}

			execute = (List<Matpel>) query.getResultList();
			cursor = JPACursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Matpel obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Matpel> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getMatpel", path = "get_matpel")
	public Matpel getMatpel(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		Matpel matpel = null;
		try {
			matpel = mgr.find(Matpel.class, id);
		} finally {
			mgr.close();
		}
		return matpel;
	}
	
	@ApiMethod(name = "getMatpelByKey", path = "get_matpel_by_key")
	public Matpel getMatpelByKey(@Named("id")String kind, @Named("name") String name) {
		EntityManager mgr = getEntityManager();
		Matpel matpel = null;
		try {
			Key key = KeyFactory.createKey(kind, name);
			matpel = mgr.find(Matpel.class, key);
		} finally {
			mgr.close();
		}
		return matpel;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param matpel the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertMatpel", path = "insert_matpel")
	public Matpel insertMatpel(Matpel matpel) {
		EntityManager mgr = getEntityManager();
		try {
			if (containsMatpel(matpel)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.persist(matpel);
		} finally {
			mgr.close();
		}
		return matpel;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param matpel the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateMatpel", path = "update_matpel")
	public Matpel updateMatpel(Matpel matpel) {
		EntityManager mgr = getEntityManager();
		try {
			if (!containsMatpel(matpel)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.persist(matpel);
		} finally {
			mgr.close();
		}
		return matpel;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeMatpel", path = "remove_matpel")
	public void removeMatpel(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		try {
			Matpel matpel = mgr.find(Matpel.class, id);
			mgr.remove(matpel);
		} finally {
			mgr.close();
		}
	}

	private boolean containsMatpel(Matpel matpel) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			Matpel item = mgr.find(Matpel.class, matpel.getKey());
			if (item == null) {
				contains = false;
			}
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}

}
