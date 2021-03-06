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
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Order Entity class in Persistence.
 * @author Long Mathias Yan
 * @version 1.0
 */
@Entity
@XmlRootElement
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String tablenr;
    private String waiter;
    private String date;
    private boolean closed;

    @XmlElement(name="items")
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private ArrayList<OrderItemEntity> items = new ArrayList<>();

    /**
     * Empty Ctor.
     */
    public OrderEntity() {
    }

    /**
     * Ctor for Order Entity.
     * @param id        id.
     * @param date      date.
     * @param table     table.
     * @param waiter    waiter.
     * @param items     list of items.
     */
    public OrderEntity(int id, String date, String table ,String waiter, ArrayList items) {
        this.id = id;
        this.date = date;
        this.tablenr = table;
        this.waiter = waiter;
        this.items = items;
        closed = false;
    }

    /*
     * Getter and Setter.
    */
    public boolean getClosed() {
        return closed;
    }
    public void setClosed(boolean closed) {
        this.closed = closed;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setItems(ArrayList items) {
        this.items = items;
    }
    @XmlTransient
    public ArrayList getItems() {
        return items;
    }
    public String getTable() {
        System.out.println("GET_TABLE");
        return tablenr;
    }
    public void setTable(String table) {
        System.out.println("SET_TABLE");
        this.tablenr = table;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }
    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }
    public String getWaiter() {
        return waiter;
    }

    /**
     * Adds an Item to order.
     * @param item      Item to add.
     */
    public void addItem(OrderItemEntity item) {
        items.add(item);
    }


}