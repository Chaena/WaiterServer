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

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * App Config for Rest.
 * @author Long Mathias Yan
 * @version 1.0
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    /**
     * Gets all the classes of the resources.
     * @return Set of all classes.
     */
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Adds all the resources classes.
     * @param resources
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(resources.BaseResource.class);
        resources.add(resources.ItemResource.class);
        resources.add(resources.OrderItemResource.class);
        resources.add(resources.OrderResource.class);
        resources.add(resources.TableResource.class);
        resources.add(resources.WaiterResource.class);
    }

}
