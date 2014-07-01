package data;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Table Entity class in Persistence.
 * @author Long Mathias Yan
 * @version 1.0
 */
@Entity
@XmlRootElement
public class TableEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String tablenumber;

    /**
     * Empty Ctor.
     */
    public TableEntity() {
    }

    /**
     * Ctor with table number.
     * @param number    table number.
     */
    public TableEntity(String number) {
        tablenumber = number;
    }

    /*
     * Getter and Setter.
    */
    public String getNumber() {
        return tablenumber;
    }
    public void setNumber(String number) {
        tablenumber = number;
    }
}
