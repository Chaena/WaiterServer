/*
 * (C) Nhu-Huy Le, Jonas Aschenbrenner, Long Mathias Yan
 * Oracle Corporation Java 1.8.0
 * Microsoft Windows 7 Professional
 * 6.1.7601 Service Pack 1 Build 7601
 * This program is created while attending the courses
 * at Hochschule Muenchen Fak07, Germany in SS14.

SA: Praktikum
Excercise 2 - McBar

 - 24/6/2014
 */

package resources;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Base Resource class of Persistence.
 * @author LL
 * @version 26.06.2014
 */
public abstract class BaseResource<T> {

    @PersistenceContext(unitName = "WaiterServerPU")
    private EntityManager em;
    private final Class<T> type;

    /**
     * Sets the class type of the resource.
     * @param type type of class.
     */
    public BaseResource(Class<T> type) {
        this.type = type;
    }

    /**
     * Gets the EM.
     * @return  enitity manager.
     */
    public EntityManager getEntityManager() {
        return this.em;
    }

    /**
     * Gets the type.
     * @return class type.
     */
    public Class<T> getType() {
        return type;
    }

    /**
     * Creates data in persistence.
     * @param data  data to create.
     */
    @POST
    @Consumes("application/json")
    public void createData(T data) {
        em.merge(data);
    }

    /**
     * Updates existent data in persistence.
     * @param data  data to update.
     */
    @PUT
    @Consumes("application/json")
    public void updateData(T data) {
        em.merge(data);
    }

    /**
     * Gets all data in persistence.
     */
    @GET
    @Path("getAll")
    @Produces({"application/json", "application/xml"})
    public List<T> getListOfData() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(type));
        Query q = em.createQuery(cq);
        return q.getResultList();
    }

    /**
     * Gets data by id in persistence.
     * @param id  data id to find..
     */
    @GET
    @Path("find/{id}")
    @Produces({"application/json", "application/xml"})
    public T findDataById(@PathParam("id") int id) {
        T data = em.find(type, id);
        return data;
    }

    /**
     * Deletes data in persistence.
     * @param id  data id to delete.
     */
    @DELETE
    @Path("delete/{id}")
    @Consumes({"application/json", "application/xml"})
    public void deleteDataById(@PathParam("id") int id) {
        System.out.println("DELETE: " + id);
        T e = em.find(type, id);
        em.remove(e);
    }
}
