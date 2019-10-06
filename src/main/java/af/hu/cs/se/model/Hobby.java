package af.hu.cs.se.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Hobby implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
