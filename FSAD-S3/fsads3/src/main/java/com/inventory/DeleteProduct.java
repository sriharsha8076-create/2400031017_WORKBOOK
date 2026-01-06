package com.inventory;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeleteProduct {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p = session.get(Product.class, 2);
        if (p != null) {
            session.delete(p);
            System.out.println("Product deleted");
        } else {
            System.out.println("Product not found");
        }

        tx.commit();
        session.close();
    }
}
