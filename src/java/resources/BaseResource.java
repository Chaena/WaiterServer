/*
 *University of Applied Science Munich 2014
 *Faculty:    Computer Science FK07
 *Name:       Mathias Long Yan
 *Date:       26.06.2014
 *Subject:
 *Lecturer:
 *Project:
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
 * @author LL
 * @version 26.06.2014
 */
public abstract class BaseResource<T> {
    @PersistenceContext(unitName = "WaiterServerPU")
    private EntityManager em;

    private final Class<T> type;

    public BaseResource(Class<T> type) {
        this.type = type;
    }

    public EntityManager getEntityManager() {
        return this.em;
    }

    public Class<T> getType() {
        return type;
    }

    @POST
    @Consumes("application/json")
    public void createData(T data) {
        em.merge(data);
    }

    @PUT
    @Consumes("application/json")
    public void updateData(T data) {
        em.merge(data);
    }

    @GET
    @Path("getAll")
    @Produces({"application/json", "application/xml"})
    public List<T> getListOfData() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(type));
        Query q = em.createQuery(cq);
        return q.getResultList();
    }

    @GET
    @Path("find/{id}")
    @Produces({"application/json", "application/xml"})
    public T findDataById(@PathParam("id") int id) {
        T data = em.find(type, id);
        return data;
    }

    @DELETE
    @Path("delete/{id}")
    @Consumes({"application/json", "application/xml"})
    public void deleteDataById(@PathParam("id") int id) {
        System.out.println("DELETE: " + id);
        T e = em.find(type, id);
        em.remove(e);
    }

//    @POST
//    @Consumes("application/json")
//    public void insertListOfData(List<T> dataList){
//        EntityManager em = getEntityManager();
//        for(T data: dataList){
//            em.merge(data);
//        }
//    }
}
