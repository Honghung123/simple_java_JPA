package service;


import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class updateEmployee {
    public static void main( String[ ] args ) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
        EntityManager entitymanager = emfactory.createEntityManager( );
        entitymanager.getTransaction( ).begin( );
        Employee employee = entitymanager.find( Employee.class, 2 ); // Find id of student
        //before update
        System.out.println( employee.getLast_name() );
        employee.setLast_name( "Hoang" );
        entitymanager.getTransaction( ).commit( );

        //after update
        System.out.println( employee.getLast_name());
        entitymanager.close();
        emfactory.close();
    }
}