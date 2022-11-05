package entity;

import jakarta.persistence.*;


@Entity
@DiscriminatorValue(value = "PT")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class PartTimeEmployee extends Employees {

    @GeneratedValue
    private int dayWorking;
    private String salary;

    public PartTimeEmployee(){}

    public PartTimeEmployee(int id, String first_name, String last_name,int dayWorking , String salary){
        super(id,first_name,last_name);
        this.dayWorking = dayWorking;
        this.salary = salary;
    }

    public int getDayWorking() {
        return dayWorking;
    }

    public void setDayWorking(int dayWorking) {
        this.dayWorking = dayWorking;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
