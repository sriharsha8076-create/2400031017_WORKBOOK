package com.inventory;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UpdateProduct {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p = session.get(Product.class, 1);
        if (p != null) {
            p.setPrice(60000);
            p.setQuantity(8);
            session.update(p);
            System.out.println("Product updated");
        }

        tx.commit();
        session.close();
    }
}
