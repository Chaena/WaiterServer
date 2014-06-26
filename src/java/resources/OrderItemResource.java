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
import data.OrderItem;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.Path;

/**
 * @author LL
 * @version 26.06.2014
 */
@Stateless
@Path("data.OrderItem")
public class OrderItemResource extends BaseResource<OrderItem> {
    public OrderItemResource() {
        super(OrderItem.class);
    }
    
    public List<Item> findItemByName(String name) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<OrderItem> cq = cb.createQuery(getType());
        Root<OrderItem> root = cq.from(getType());
        cq.where(cb.equal(root.get("first"), name));
        TypedQuery query = em.createQuery(cq);
        List<Item> result = query.getResultList();

        return result;
    }    
}