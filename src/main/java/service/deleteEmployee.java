package service;


import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class deleteEmployee {
    public static void main( String[ ] args ) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
        EntityManager entitymanager = emfactory.createEntityManager( );
        entitymanager.getTransaction( ).begin( );
        Employee employee = entitymanager.find( Employee.class, 301 ); // Find id of student
        entitymanager.remove(employee);
        entitymanager.getTransaction( ).commit( );
        entitymanager.close();
        emfactory.close();
    }
}