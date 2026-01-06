package com.inventory;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== PRODUCT MENU =====");
            System.out.println("1. Insert Product");
            System.out.println("2. Get Product by ID");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

            case 1: // INSERT
                insertProduct(sc);
                break;

            case 2: // READ
                getProduct(sc);
                break;

            case 3: // UPDATE
                updateProduct(sc);
                break;

            case 4: // DELETE
                deleteProduct(sc);
                break;

            case 5:
                System.out.println("Exiting...");
                break;

            default:
                System.out.println("Invalid choice");
            }

        } while (choice != 5);

        sc.close();
    }

    // ================= INSERT =================
    private static void insertProduct(Scanner sc) {

        System.out.print("Enter name: ");
        String name = sc.next();

        System.out.print("Enter description: ");
        String desc = sc.next();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p = new Product(name, desc, price, qty);
        session.save(p);

        tx.commit();
        session.close();

        System.out.println("Product inserted successfully");
    }

    // ================= READ =================
    private static void getProduct(Scanner sc) {

        System.out.print("Enter product ID: ");
        int id = sc.nextInt();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Product p = session.get(Product.class, id);
        session.close();

        if (p != null) {
            System.out.println("Name: " + p.getName());
            System.out.println("Description: " + p.getDescription());
            System.out.println("Price: " + p.getPrice());
            System.out.println("Quantity: " + p.getQuantity());
        } else {
            System.out.println("Product not found");
        }
    }

    // ================= UPDATE =================
    private static void updateProduct(Scanner sc) {

        System.out.print("Enter product ID: ");
        int id = sc.nextInt();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p = session.get(Product.class, id);

        if (p != null) {
            System.out.print("Enter new price: ");
            p.setPrice(sc.nextDouble());

            System.out.print("Enter new quantity: ");
            p.setQuantity(sc.nextInt());

            session.update(p);
            System.out.println("Product updated");
        } else {
            System.out.println("Product not found");
        }

        tx.commit();
        session.close();
    }

    // ================= DELETE =================
    private static void deleteProduct(Scanner sc) {

        System.out.print("Enter product ID: ");
        int id = sc.nextInt();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p = session.get(Product.class, id);

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
