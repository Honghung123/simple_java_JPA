package service;


import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class JPQL_nameQueries {
    public static void main( String[ ] args ) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
        EntityManager entitymanager = emfactory.createEntityManager( );
        Query sql = entitymanager.createNamedQuery("find employee by id");
        sql.setParameter("id",3);
        Employee e = (Employee)sql.getSingleResult();
        System.out.println("Id:  "+ e.getId());
        System.out.println("Full Name: "+ e.getFirst_name()+" "+ e.getLast_name());
        entitymanager.close();
        emfactory.close();
    }
}