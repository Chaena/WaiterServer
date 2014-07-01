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

import data.ItemEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * item resource class.
 * @author LL
 * @version 26.06.2014
 */
@Stateless
@Path("data.ItemProperty")
public class ItemResource extends BaseResource<ItemEntity> {

    /**
     * Ctor.
     */
    public ItemResource() {
        super(ItemEntity.class);
    }

    /**
     * Finds data by name.
     * @param name  data name to find.
     * @return      data.
     */
    @Path("findByName/{name}")
    public List<ItemEntity> findItemByName(@PathParam("name") String name) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<ItemEntity> cq = cb.createQuery(getType());
        Root<ItemEntity> root = cq.from(getType());
        cq.where(cb.equal(root.get("first"), name));
        TypedQuery query = getEntityManager().createQuery(cq);
        List<ItemEntity> result = query.getResultList();
        return result;
    }
}