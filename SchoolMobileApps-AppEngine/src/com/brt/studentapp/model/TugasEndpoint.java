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

@Api(name = "tugasendpoint", namespace = @ApiNamespace(ownerDomain = "brt.com", ownerName = "brt.com", packagePath = "studentapp.model"))
public class TugasEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listTugas")
	public CollectionResponse<Tugas> listTugas(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		EntityManager mgr = null;
		Cursor cursor = null;
		List<Tugas> execute = null;

		try {
			mgr = getEntityManager();
			Query query = mgr.createQuery("select from Tugas as Tugas");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}

			if (limit != null) {
				query.setFirstResult(0);
				query.setMaxResults(limit);
			}

			execute = (List<Tugas>) query.getResultList();
			cursor = JPACursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Tugas obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Tugas> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getTugas")
	public Tugas getTugas(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		Tugas tugas = null;
		try {
			tugas = mgr.find(Tugas.class, id);
		} finally {
			mgr.close();
		}
		return tugas;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param tugas the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertTugas")
	public Tugas insertTugas(Tugas tugas) {
		EntityManager mgr = getEntityManager();
		try {
			if (containsTugas(tugas)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.persist(tugas);
		} finally {
			mgr.close();
		}
		return tugas;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param tugas the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateTugas")
	public Tugas updateTugas(Tugas tugas) {
		EntityManager mgr = getEntityManager();
		try {
			if (!containsTugas(tugas)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.persist(tugas);
		} finally {
			mgr.close();
		}
		return tugas;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeTugas")
	public void removeTugas(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		try {
			Tugas tugas = mgr.find(Tugas.class, id);
			mgr.remove(tugas);
		} finally {
			mgr.close();
		}
	}

	private boolean containsTugas(Tugas tugas) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			Tugas item = mgr.find(Tugas.class, tugas.getKey());
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

	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listTugasByParent", path = "list_tugas_by_parent")
	public CollectionResponse<Tugas> listMatpelDetailByParent(@Named("parent") String matpelName,@Named("kelas") String kelas,
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		EntityManager mgr = null;
		Cursor cursor = null;
		List<Tugas> execute = null;

		try {
			mgr = getEntityManager();
			Query query = mgr
					.createQuery("select from Tugas as Tugas WHERE matpelName='"+ matpelName+"' and Kelas='"+ kelas +"'");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}

			if (limit != null) {
				query.setFirstResult(0);
				query.setMaxResults(limit);
			}

			execute = (List<Tugas>) query.getResultList();
			cursor = JPACursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Tugas obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Tugas> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}
	
}
