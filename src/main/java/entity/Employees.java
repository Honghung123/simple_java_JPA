package entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity(name = "employees")
@Table
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="type")
public class Employees implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String first_name;
    private String last_name;

    public Employees(){}
    public Employees(int id, String first_name, String last_name) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
