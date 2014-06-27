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

import data.OrderEntity;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 * @author LL
 * @version 26.06.2014
 */
@Stateless
@Path("data.OrderProperty")
public class OrderResource extends BaseResource<OrderEntity> {

    public OrderResource() {
        super(OrderEntity.class);
    }
}