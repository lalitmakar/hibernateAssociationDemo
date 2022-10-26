package com.lalit.UI;

import com.lalit.Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Tester {

    public static void main(String[] args) {

        EmployeeEntity employee = new EmployeeEntity();
        employee.setFname("Lalit");
        employee.setMname("Malaram");
        employee.setLname("Makar");
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(employee);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        entityManagerFactory.close();

        Employee emp = new Employee();
        Name name = new Name();
        name.setTitle("Ms");
        name.setFirstName("Lalit");
        name.setMiddleName("ram");
        name.setLastName("Makar");
        emp.setName(name);

        Asset asset = new Asset("Laptop","MACBOOK",98000);
        asset.setEmp(emp);
        emp.setAsset(asset);

        List<Course> courses = new ArrayList<>();
        Course course1 = new Course("java","OOP");
        course1.setEmp(emp);
        Course course2 = new Course("python","ML");
        course2.setEmp(emp);
        courses.add(course1);
        courses.add(course2);

        emp.setCourses(courses);

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

//        session.save(employee);

        session.save(asset);
        session.save(emp);

        tx.commit();

//        Employee resEmp = (Employee)session.load(Employee.class,20000);// load gives error org.hibernate.ObjectNotFoundException: No row with the given identifier exists:

//        Employee resEmp = (Employee)session.get(Employee.class,4); // returns null if not found
//
//        System.out.println("fetched from db : - : "+resEmp.getId()+" "+resEmp.getName().getFirstName());

        session.close();

        factory.close();

    }

}
