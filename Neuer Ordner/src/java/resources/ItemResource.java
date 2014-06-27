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

import data.Item;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author LL
 * @version 26.06.2014
 */
@Stateless
@Path("data.item")
public class ItemResource extends BaseResource<Item> {
    public ItemResource() {
        super(Item.class);
    }
    
    @Path("findByName/{name}")
    public List<Item> findItemByName(@PathParam("name") String name) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Item> cq = cb.createQuery(getType());
        Root<Item> root = cq.from(getType());
        cq.where(cb.equal(root.get("first"), name));
        TypedQuery query = getEntityManager().createQuery(cq);
        List<Item> result = query.getResultList();
        return result;        
    }
}