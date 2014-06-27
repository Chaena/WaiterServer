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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;


@Entity
@XmlRootElement
public class OrderItemEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private int amount;
    private String price;

    public OrderItemEntity() {
    }

    public OrderItemEntity(String name, int amount, String price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
