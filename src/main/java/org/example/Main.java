package org.example;/*
 *
 *Created by phron on 1/24/2024
 *
 */

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.example.entities.Product;
import org.example.entities.Student;
import org.example.entities.keys.StudentKey;
import org.example.entities.oneToOne.Passport;
import org.example.entities.oneToOne.Person;
import org.example.entities.oneToOne.User;
import org.example.persistence.customPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String puName = "pu-name";
        Map<String,String> props = new HashMap<>();
        props.put("hibernate.show_sql","true");
        props.put("hibernate.hbm2ddl.auto","create");

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new customPersistenceUnitInfo(puName),props);
        EntityManager em = emf.createEntityManager();//represents the context.


        try{
            em.getTransaction().begin();


            Person person = new Person();
            person.setName("Daerego Braide");

            Passport passport = new Passport();
            passport.setNumber("abcd123");

            person.setPassport(passport);
            passport.setPerson(person);

            em.persist(person);

            User user = new User();
            user.setName("Akonzi");
            user.setDescription("just new desc");
            em.persist(user);
//            em.persist(passport);

//            TypedQuery<Person> q = em.createQuery("SELECT p FROM Person p WHERE p.passport.number = :number", Person.class);
//            q.setParameter("number", "abcd123");
//            System.out.println(q.getResultList());


//            Product p1 = new Product();
//            p1.setCode("ABC");
//            p1.setNumber(10);
//            p1.setColor("RED");
//
//
//            em.persist(p1);

//            StudentKey id = new StudentKey();
//            id.setCode("ABC");
//            id.setNumber(10);
//
//            Student s = new Student();
//            s.setId(id);
//            s.setName("John");
//
//            em.persist(s);

//            Student s = em.find(Student.class, id);
//            System.out.println(s);


            //operations of the context
            // 1 em.persist() --> Adding entity to the context or marking entity to be persisted.
            // 2 em.find()    --> Finds by primary key ie get from DB and add it to the context if it doesnt exist already
            // 3 em.remove()  --> Marking entity for removal
            // 4 em.merge()   --> Merges an entity form outside the context.
            // 5 em.refresh() --> Mirror the context from the DB
            // 6 em.detach()  --> Taking the entity out of the context
            // 7 em.getReference() -->

            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
}
