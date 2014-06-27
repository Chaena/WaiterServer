package data;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class WaiterEntity implements Serializable {

    @Id
    private String waiterName;

    public WaiterEntity() {
    }

    public WaiterEntity(String name) {
        waiterName = name;
    }

    public String getName() {
        return waiterName;
    }

    public void setName(String name) {
        waiterName = name;
    }
}