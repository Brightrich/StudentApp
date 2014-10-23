package com.brt.studentapp.model;

import com.brt.studentapp.model.EMF;
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
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Api(name = "pageendpoint", namespace = @ApiNamespace(ownerDomain = "brt.com", ownerName = "brt.com", packagePath = "studentapp.model"))
public class PageEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listPage", path = "list_page")
	public CollectionResponse<Page> listPage(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		EntityManager mgr = null;
		Cursor cursor = null;
		List<Page> execute = null;

		try {
			mgr = getEntityManager();
			Query query = mgr.createQuery("select from Page as Page");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}

			if (limit != null) {
				query.setFirstResult(0);
				query.setMaxResults(limit);
			}

			execute = (List<Page>) query.getResultList();
			cursor = JPACursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Page obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Page> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getPage", path = "get_page")
	public Page getPage(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		Page page = null;
		try {
			page = mgr.find(Page.class, id);
		} finally {
			mgr.close();
		}
		return page;
	}
	
	@ApiMethod(name = "getPageByKey", path = "get_page_by_key")
	public Page getPageByKey(@Named("kind")String kind, @Named("name") String name) {
		EntityManager mgr = getEntityManager();
		Page page = null;
		try {
			Key key = KeyFactory.createKey(kind, name);
			page = mgr.find(Page.class, key);
		} finally {
			mgr.close();
		}
		return page;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param page the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertPage", path = "insert_page")
	public Page insertPage(Page page) {
		EntityManager mgr = getEntityManager();
		try {
			//if (containsPage(page)) {
			//	throw new EntityExistsException("Object already exists");
			//}
			mgr.persist(page);
		} finally {
			mgr.close();
		}
		return page;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param page the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updatePage", path = "update_page")
	public Page updatePage(Page page) {
		EntityManager mgr = getEntityManager();
		try {
			if (!containsPage(page)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.persist(page);
		} finally {
			mgr.close();
		}
		return page;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removePage", path = "remove_page")
	public void removePage(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		try {
			Page page = mgr.find(Page.class, id);
			mgr.remove(page);
		} finally {
			mgr.close();
		}
	}

	private boolean containsPage(Page page) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			Page item = mgr.find(Page.class, page.getKey());
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
