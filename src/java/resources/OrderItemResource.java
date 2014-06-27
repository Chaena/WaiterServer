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

import data.ItemEntity;
import data.OrderItemEntity;
import java.util.List;
import javax.ejb.Stateless;
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
@Path("data.OrderItemProperty")
public class OrderItemResource extends BaseResource<OrderItemEntity> {

    public OrderItemResource() {
        super(OrderItemEntity.class);
    }

    @Path("findByName/{name}")
    public List<ItemEntity> findItemByName(@PathParam("name") String name) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<OrderItemEntity> cq = cb.createQuery(getType());
        Root<OrderItemEntity> root = cq.from(getType());
        cq.where(cb.equal(root.get("first"), name));
        TypedQuery query = getEntityManager().createQuery(cq);
        List<ItemEntity> result = query.getResultList();
        return result;
    }
}