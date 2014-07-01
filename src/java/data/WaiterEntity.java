package data;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Waiter Entity class in Persistence.
 * @author Long Mathias Yan
 * @version 1.0
 */
@Entity
@XmlRootElement
public class WaiterEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String waiterName;

    /**
     * Empty Ctor.
     */
    public WaiterEntity() {
    }

    /**
     * Ctor with name.
     * @param name  Name.
     */
    public WaiterEntity(String name) {
        waiterName = name;
    }

    /*
    Getter and Setter.
    */
    public String getName() {
        return waiterName;
    }
    public void setName(String name) {
        waiterName = name;
    }
}