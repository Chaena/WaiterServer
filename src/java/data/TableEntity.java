package data;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class TableEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String tablenumber;

    public TableEntity() {
    }

    public TableEntity(String number) {
        tablenumber = number;
    }

    public String getNumber() {
        return tablenumber;
    }

    public void setNumber(String number) {
        tablenumber = number;
    }
}
