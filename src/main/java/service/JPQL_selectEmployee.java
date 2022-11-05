package service;


import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class JPQL_selectEmployee {
    public static void main(String[] args) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        // SELECT many records
        List<String> listName = entitymanager.createQuery("select e.first_name from employee e").getResultList();
        for (String name : listName) {
            System.out.print(name + "   ");
        }

        // SELECT one record
        Query sql = entitymanager.createQuery("select count(e.id) from employee e");
        Long rowCount = (Long) sql.getSingleResult();
        System.out.println("Row count:  " + rowCount);

        // Select all records
        List<Employee> listE = (List<Employee>) entitymanager.createQuery("SELECT  e from employee e order by e.id desc").getResultList();
        for (Employee employee : listE) {
            System.out.println("Id: " + employee.getId()+"  "+((Object )employee.getId()).getClass().getSimpleName() );
            System.out.println("Full Name: " + employee.getFirst_name() + " " + employee.getLast_name());
        }

        entitymanager.close();
        emfactory.close();
    }
}