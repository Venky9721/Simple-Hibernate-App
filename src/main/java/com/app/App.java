package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.local.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Student s1 = new Student("Venky", 21);
        session.persist(s1);
        System.out.println("Inserted ID: " + s1.getId());

        Student dbStudent = session.get(Student.class, s1.getId());
        System.out.println("Fetched: " + dbStudent);

        dbStudent.setAge(22);

        tx.commit();

        session.close();
        factory.close();

        System.out.println("✅ Done");
    }
}
