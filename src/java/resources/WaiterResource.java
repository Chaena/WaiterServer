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

import data.WaiterEntity;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 * item resource class.
 * @author LL
 * @version 26.06.2014
 */
@Stateless
@Path("data.WaiterProperty")
public class WaiterResource extends BaseResource<WaiterEntity> {

    /**
     * Ctor.
     */
    public WaiterResource() {
        super(WaiterEntity.class);
    }
}
