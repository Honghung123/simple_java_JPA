package service;


import entity.FullTimeEmployee;
import entity.PartTimeEmployee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Mapping_advancedEmployees {
    public static void main( String[ ] args ) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
        EntityManager entitymanager = emfactory.createEntityManager( );
        entitymanager.getTransaction( ).begin( );

        // Part-time employee entity
        PartTimeEmployee pt1 = new PartTimeEmployee(1,"Hong" , "Hung",6,"15000");
        PartTimeEmployee pt2 = new PartTimeEmployee(2,"Hong" , "Huy",3,"25000");

        // Full-time employee entity
        FullTimeEmployee ft1 = new FullTimeEmployee(3,"Hong" , "Hoa",10);
        FullTimeEmployee ft2 = new FullTimeEmployee(4,"Huy" , "Hoang",14);

        // storing all entity
        // add record to table parttime
        entitymanager.persist(pt1);
        entitymanager.persist(pt2);
        // add record to  table fulltime
        entitymanager.persist(ft1);
        entitymanager.persist(ft2);
        entitymanager.getTransaction( ).commit( );

        entitymanager.close();
        emfactory.close();
    }
}