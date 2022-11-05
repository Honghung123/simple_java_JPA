package entity;

import jakarta.persistence.*;

import java.util.Set;
@Entity(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String subject;
    @ManyToMany(targetEntity = Classes.class)
    private Set classSet;

    public Teacher(){}

    public Teacher(int id, String name, String subject, Set classSet) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.classSet = classSet;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getClassSet() {
        return classSet;
    }

    public void setClassSet(Set classSet) {
        this.classSet = classSet;
    }
}
