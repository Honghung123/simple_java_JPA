package entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.PrimaryKeyJoinColumn;


@Entity
@DiscriminatorValue(value = "FT")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class FullTimeEmployee extends Employees {

    @GeneratedValue
    private int weekWorking;


    public FullTimeEmployee(){}

    public FullTimeEmployee(int id, String first_name, String last_name, int weekWorking  ){
        super(id,first_name,last_name);
        this.weekWorking = weekWorking;
    }

    public int getWeekWorking() {
        return weekWorking;
    }

    public void setWeekWorking(int weekWorking) {
        this.weekWorking = weekWorking;
    }
}
