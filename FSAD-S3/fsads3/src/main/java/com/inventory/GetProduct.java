package com.inventory;

import org.hibernate.Session;

public class GetProduct {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Product p = session.get(Product.class, 1);

        if (p != null) {
            System.out.println("Name: " + p.getName());
            System.out.println("Price: " + p.getPrice());
        } else {
            System.out.println("Product not found");
        }

        session.close();
    }
}
