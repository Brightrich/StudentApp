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
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Api(name = "locationendpoint", namespace = @ApiNamespace(ownerDomain = "brt.com", ownerName = "brt.com", packagePath = "studentapp.model"))
public class LocationEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listLocation", path = "list_location")
	public CollectionResponse<Location> listLocation(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		EntityManager mgr = null;
		Cursor cursor = null;
		List<Location> execute = null;

		try {
			mgr = getEntityManager();
			Query query = mgr.createQuery("select from Location as Location");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}

			if (limit != null) {
				query.setFirstResult(0);
				query.setMaxResults(limit);
			}

			execute = (List<Location>) query.getResultList();
			cursor = JPACursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Location obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Location> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getLocation", path = "get_location")
	public Location getLocation(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		Location location = null;
		try {
			location = mgr.find(Location.class, id);
		} finally {
			mgr.close();
		}
		return location;
	}
	
	@ApiMethod(name = "getLocationByKey", path = "get_location_by_key")
	public Location getLocationByKey(@Named("kind")String kind, @Named("name") String name) {
		EntityManager mgr = getEntityManager();
		Location location = null;
		try {
			Key key = KeyFactory.createKey(kind, name);
			location = mgr.find(Location.class, key);
		} finally {
			mgr.close();
		}
		return location;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param location the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertLocation", path = "insert_location")
	public Location insertLocation(Location location) {
		EntityManager mgr = getEntityManager();
		try {
			if (containsLocation(location)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.persist(location);
		} finally {
			mgr.close();
		}
		return location;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param location the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateLocation", path = "update_location")
	public Location updateLocation(Location location) {
		EntityManager mgr = getEntityManager();
		try {
			if (!containsLocation(location)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.persist(location);
		} finally {
			mgr.close();
		}
		return location;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeLocation", path = "remove_location")
	public void removeLocation(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		try {
			Location location = mgr.find(Location.class, id);
			mgr.remove(location);
		} finally {
			mgr.close();
		}
	}

	private boolean containsLocation(Location location) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			Location item = mgr.find(Location.class, location.getKey());
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
