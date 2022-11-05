package service;

import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class createEmployee {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Employee employee = new Employee();
        employee.setId(3);
        employee.setFirst_name("Hong");
        employee.setLast_name("Hoa");
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        System.out.println("success");

    }
}
