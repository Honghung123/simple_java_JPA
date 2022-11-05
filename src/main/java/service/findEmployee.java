package service;


import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class findEmployee {
    public static void main( String[ ] args ) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
        EntityManager entitymanager = emfactory.createEntityManager( );
        Employee employee = entitymanager.find( Employee.class, 2 ); // Find id of student
        System.out.println("Id: "+ employee.getId() );
        System.out.println("Full Name: "+ employee.getFirst_name()+" "+ employee.getLast_name()  );
        entitymanager.close();
        emfactory.close();
    }
}