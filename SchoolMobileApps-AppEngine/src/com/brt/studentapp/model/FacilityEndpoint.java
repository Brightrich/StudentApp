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

@Api(name = "facilityendpoint", namespace = @ApiNamespace(ownerDomain = "brt.com", ownerName = "brt.com", packagePath = "studentapp.model"))
public class FacilityEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listFacility", path = "list_facility")
	public CollectionResponse<Facility> listFacility(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		EntityManager mgr = null;
		Cursor cursor = null;
		List<Facility> execute = null;

		try {
			mgr = getEntityManager();
			Query query = mgr.createQuery("select from Facility as Facility");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}

			if (limit != null) {
				query.setFirstResult(0);
				query.setMaxResults(limit);
			}

			execute = (List<Facility>) query.getResultList();
			cursor = JPACursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Facility obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Facility> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getFacility", path = "get_facility")
	public Facility getFacility(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		Facility facility = null;
		try {
			facility = mgr.find(Facility.class, id);
		} finally {
			mgr.close();
		}
		return facility;
	}
	
	@ApiMethod(name = "getFacilityByKey", path = "get_facility_by_key")
	public Facility getFacilityByKey(@Named("kind")String kind, @Named("name") String name) {
		EntityManager mgr = getEntityManager();
		Facility facility = null;
		try {
			Key key = KeyFactory.createKey(kind, name);
			facility = mgr.find(Facility.class, key);
		} finally {
			mgr.close();
		}
		return facility;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param facility the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertFacility", path = "insert_facility")
	public Facility insertFacility(Facility facility) {
		EntityManager mgr = getEntityManager();
		try {
			if (containsFacility(facility)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.persist(facility);
		} finally {
			mgr.close();
		}
		return facility;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param facility the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateFacility", path = "update_facility")
	public Facility updateFacility(Facility facility) {
		EntityManager mgr = getEntityManager();
		try {
			if (!containsFacility(facility)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.persist(facility);
		} finally {
			mgr.close();
		}
		return facility;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeFacility", path = "remove_facility")
	public void removeFacility(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		try {
			Facility facility = mgr.find(Facility.class, id);
			mgr.remove(facility);
		} finally {
			mgr.close();
		}
	}

	private boolean containsFacility(Facility facility) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			Facility item = mgr.find(Facility.class, facility.getKey());
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
