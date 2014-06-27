/*
 * (C) Nhu-Huy Le, nle@hm.edu
 * Oracle Corporation Java 1.8.0
 * Microsoft Windows 7 Professional
 * 6.1.7601 Service Pack 1 Build 7601
 * This program is created while attending the courses
 * at Hochschule Muenchen Fak07, Germany in SS14.
 */

package data;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
public class ItemEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String name;
    private String price;

    public ItemEntity() {
    }

    public ItemEntity(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
