package com.inventory;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class InsertProduct {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p1 = new Product("Laptop", "HP Laptop", 55000, 10);
        Product p2 = new Product("Mouse", "Wireless Mouse", 800, 50);

        session.save(p1);
        session.save(p2);

        tx.commit();
        session.close();

        System.out.println("Products inserted successfully");
    }
}
