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

@Api(name = "matpeldetailendpoint", namespace = @ApiNamespace(ownerDomain = "brt.com", ownerName = "brt.com", packagePath = "studentapp.model"))
public class MatpelDetailEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listMatpelDetail", path = "list_matpel_detail")
	public CollectionResponse<MatpelDetail> listMatpelDetail(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		EntityManager mgr = null;
		Cursor cursor = null;
		List<MatpelDetail> execute = null;

		try {
			mgr = getEntityManager();
			Query query = mgr
					.createQuery("select from MatpelDetail as MatpelDetail");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}

			if (limit != null) {
				query.setFirstResult(0);
				query.setMaxResults(limit);
			}

			execute = (List<MatpelDetail>) query.getResultList();
			cursor = JPACursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (MatpelDetail obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<MatpelDetail> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getMatpelDetail", path = "get_matpel_detail")
	public MatpelDetail getMatpelDetail(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		MatpelDetail matpeldetail = null;
		try {
			matpeldetail = mgr.find(MatpelDetail.class, id);
		} finally {
			mgr.close();
		}
		return matpeldetail;
	}
	
	@ApiMethod(name = "getMatpelDetailByKey", path = "get_matpel_detail_by_key")
	public MatpelDetail getMatpelDetailByKey(@Named("id") String kind, @Named("name") String name) {
		EntityManager mgr = getEntityManager();
		MatpelDetail matpeldetail = null;
		try {
			Key key = KeyFactory.createKey(kind, name);
			matpeldetail = mgr.find(MatpelDetail.class, key);
		} finally {
			mgr.close();
		}
		return matpeldetail;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param matpeldetail the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertMatpelDetail")
	public MatpelDetail insertMatpelDetail(MatpelDetail matpeldetail) {
		EntityManager mgr = getEntityManager();
		try {
			if (containsMatpelDetail(matpeldetail)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.persist(matpeldetail);
		} finally {
			mgr.close();
		}
		return matpeldetail;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param matpeldetail the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateMatpelDetail")
	public MatpelDetail updateMatpelDetail(MatpelDetail matpeldetail) {
		EntityManager mgr = getEntityManager();
		try {
			if (!containsMatpelDetail(matpeldetail)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.persist(matpeldetail);
		} finally {
			mgr.close();
		}
		return matpeldetail;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeMatpelDetail")
	public void removeMatpelDetail(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		try {
			MatpelDetail matpeldetail = mgr.find(MatpelDetail.class, id);
			mgr.remove(matpeldetail);
		} finally {
			mgr.close();
		}
	}

	private boolean containsMatpelDetail(MatpelDetail matpeldetail) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			MatpelDetail item = mgr.find(MatpelDetail.class,
					matpeldetail.getKey());
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
