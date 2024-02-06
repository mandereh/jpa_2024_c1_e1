package org.example;/*
 *
 *Created by phron on 1/24/2024
 *
 */

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.entities.entityInheritance.Book;
import org.example.entities.entityInheritance.ElectronicDevice;
import org.example.entities.entityInheritance.Product;
import org.example.entities.manyToMany.Team;
import org.example.entities.manyToMany.User;
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

            var sql = "SELECT p FROM Book p";
            em.createQuery(sql, Book.class)
                    .getResultList().forEach(System.out::println);

//            Book book = new Book();
//            book.setId(1L);
//            book.setAuthor("George");
//
//            ElectronicDevice device = new ElectronicDevice();
//            device.setId(2L);
//            device.setVoltage(220);
//
//            em.persist(book);
//            em.persist(device);

//            Team team1 = new Team();
//            team1.setName("Team 1");
//
//            Team team2 = new Team();
//            team2.setName("Team 2");
//
//            User user1 = new User();
//            user1.setName("User 1");
//
//            User user2 = new User();
//            user2.setName("User 2");
//
//
//
//
//            team1.setUsers(List.of(user1, user2));
//            team2.setUsers(List.of(user2));
//
//            user1.setTeams(List.of(team1));
//            user2.setTeams(List.of(team1, team2));
//
//            em.persist(user1);
//            em.persist(user2);
//            em.persist(team1);
//            em.persist(team2);
////            Post post = new Post();
//            post.setTitle("post 1");
//            post.setContent("My first post");
//
//            Comment comment1 = new Comment();
//            comment1.setContent("comment 1");
//
//            Comment comment2 = new Comment();
//            comment2.setContent("comment 1");
//
//            post.setComments(List.of(comment1,comment2));
//             comment1.setPost(post);
//             comment2.setPost(post);
//
//            em.persist(post);
////            em.persist(comment);

//            Person person = new Person();
//            person.setName("Daerego Braide");
//
//            Passport passport = new Passport();
//            passport.setNumber("abcd123");
//
//            person.setPassport(passport);
//            passport.setPerson(person);
//
//            em.persist(person);

//            User user = new User();
//            user.setName("Akonzi");
//            user.setDescription("just new desc");
//            em.persist(user);
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
