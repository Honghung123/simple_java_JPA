package service;


import entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class CriteriaAPI_Employees {
    public static void main( String[ ] args ) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
        EntityManager entitymanager = emfactory.createEntityManager( );
        // Create a criteriaBuilder object
        CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
        // Create a query object
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
        // Set the query root
        Root<Teacher> setQueryRoot = criteriaQuery.from(Teacher.class);

        // ============ Select all records =============
        System.out.println("---------->   Select all record from table TEACHER: ");
        // Set the result list type
        CriteriaQuery<Object> setResListType = criteriaQuery.select(setQueryRoot);
        // Prepare a query for execution and specifying the type of the query result
        TypedQuery<Object> prepareAQuery = entitymanager.createQuery(setResListType);
        // Execute query and returns a collection of entities
        List<Object> listTeacher = prepareAQuery.getResultList();
        for (Object teacher: listTeacher){
            Teacher t = (Teacher) teacher;
            System.out.println("Teacher Id: " + t.getId());
            System.out.println("Teacher Name: "+ t.getName());
            System.out.println("Teacher Subject: "+ t.getSubject());
        }

        // ========== Select all records with  ordering ===========
        System.out.println("---------->   Select all record from table TEACHER decrease by id : ");
        CriteriaQuery<Object> setResultListType = criteriaQuery.select(setQueryRoot);
        setResultListType.orderBy(criteriaBuilder.desc(setQueryRoot.get("id")));
        TypedQuery<Object> prepareAQuery2 = entitymanager.createQuery(setResultListType);
        List<Object> listTeacher2 = prepareAQuery2.getResultList();
        for (Object teacher: listTeacher2){
            Teacher t = (Teacher) teacher;
            System.out.println("Teacher Id: " + t.getId());
            System.out.println("Teacher Name: "+ t.getName());
            System.out.println("Teacher Subject: "+ t.getSubject());
        }

        entitymanager.close();
        emfactory.close();
    }
}