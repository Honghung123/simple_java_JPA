package service;


import entity.Classes;
import entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashSet;
import java.util.Set;

public class Relationship_manyToMany {
    public static void main( String[ ] args ) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
        EntityManager entitymanager = emfactory.createEntityManager( );
        entitymanager.getTransaction().begin();

        // Create entity Classes
        Classes class1 = new Classes(0,"21CTT2",null);
        Classes class2 = new Classes(0,"21CTT3",null);
        Classes class3 = new Classes(0,"21CTT4",null);
        // Store entity
        entitymanager.persist(class1);
        entitymanager.persist(class2);
        entitymanager.persist(class3);
        // Create set
        Set<Classes> set1 = new HashSet<>();
        set1.add(class1);
        set1.add(class2);
        set1.add(class3);
        Set<Classes> set2= new HashSet<>();
        set2.add(class2);
        set2.add(class1);
        set2.add(class3);
        Set<Classes> set3= new HashSet<>();
        set3.add(class3);
        set3.add(class2);
        set3.add(class1);

        // Create entity Teacher
        Teacher teacher1 = new Teacher(0,"Anna Gau","Math",set1);
        Teacher teacher2 = new Teacher(0,"Fukada","Literature",set2);
        Teacher teacher3 = new Teacher(0,"Tokuda","History",set3);
        // Store entity
        entitymanager.persist(teacher1);
        entitymanager.persist(teacher2);
        entitymanager.persist(teacher3);

        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();
    }
}