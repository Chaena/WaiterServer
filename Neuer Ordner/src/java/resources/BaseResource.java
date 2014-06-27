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

import java.util.HashSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.hibernate.Session;

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
        getEntityManager().persist(data);
    }

    @PUT
    @Consumes("application/json")
    public void updateData(T data) {
        getEntityManager().merge(data);
    }

    @GET
    @Path("find/{id}")
    @Produces({"application/json", "application/xml"})
    public T findDataById(@PathParam("id") String id) {
        T data = getEntityManager().find(type, id);
        return data;
    }

    @DELETE
    @Consumes({"application/json", "application/xml"})
    public void deleteDataById(String id) {
        EntityManager em = getEntityManager();
        T data = em.getReference(type, id);
        em.remove(data);
    }

    @GET
    @Path("getAll")
    @Produces({"application/json", "application/xml"})
    public List<T> getListOfData() {
        EntityManager em = getEntityManager();
        Session session = (Session) em.getDelegate();
        List<T> list = session.createCriteria(getType()).list();

        // delete duplicates following the tables join
        HashSet hs = new HashSet();
        hs.addAll(list);
        list.clear();
        list.addAll(hs);
        return list;
    }

    @POST
    @Consumes("application/json")
    public void insertListOfData(List<T> dataList){
        EntityManager em = getEntityManager();
        for(T data: dataList){
            em.merge(data);
        }
    }
}
