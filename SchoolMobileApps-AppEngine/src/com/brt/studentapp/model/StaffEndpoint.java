package com.brt.studentapp.model;

import com.brt.studentapp.EMF;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JPACursorHelper;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Api(name = "staffendpoint", namespace = @ApiNamespace(ownerDomain = "brt.com", ownerName = "brt.com", packagePath = "studentapp.model"))
public class StaffEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listStaff")
	public CollectionResponse<Staff> listStaff(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		EntityManager mgr = null;
		Cursor cursor = null;
		List<Staff> execute = null;

		try {
			mgr = getEntityManager();
			Query query = mgr.createQuery("select from Staff as Staff");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}

			if (limit != null) {
				query.setFirstResult(0);
				query.setMaxResults(limit);
			}

			execute = (List<Staff>) query.getResultList();
			cursor = JPACursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Staff obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Staff> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getStaff")
	public Staff getStaff(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		Staff staff = null;
		try {
			staff = mgr.find(Staff.class, id);
		} finally {
			mgr.close();
		}
		return staff;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param staff the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertStaff")
	public Staff insertStaff(Staff staff) {
		EntityManager mgr = getEntityManager();
		try {
			if (containsStaff(staff)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.persist(staff);
		} finally {
			mgr.close();
		}
		return staff;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param staff the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateStaff")
	public Staff updateStaff(Staff staff) {
		EntityManager mgr = getEntityManager();
		try {
			if (!containsStaff(staff)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.persist(staff);
		} finally {
			mgr.close();
		}
		return staff;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeStaff")
	public void removeStaff(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		try {
			Staff staff = mgr.find(Staff.class, id);
			mgr.remove(staff);
		} finally {
			mgr.close();
		}
	}

	private boolean containsStaff(Staff staff) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			Staff item = mgr.find(Staff.class, staff.getKey());
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
