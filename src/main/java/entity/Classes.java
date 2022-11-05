package entity;

import jakarta.persistence.*;

import java.util.Set;
@Entity(name = "classes")
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @ManyToMany(targetEntity = Teacher.class)
    private Set teacherSet;
    public Classes() {
    }

    public Classes(int id, String name, Set teacherSet) {
        this.id = id;
        this.name = name;
        this.teacherSet = teacherSet;
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

    public Set getTeacherSet() {
        return teacherSet;
    }

    public void setTeacherSet(Set teacherSet) {
        this.teacherSet = teacherSet;
    }
}
