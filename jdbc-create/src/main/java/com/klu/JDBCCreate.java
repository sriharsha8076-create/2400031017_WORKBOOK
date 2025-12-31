package com.klu;

import java.sql.*;

public class JDBCCreate {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/fsads3";
        String user = "root";
        String pwd = "Harsha@0821";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, pwd);
            System.out.println("Connection Established");

            Statement st = con.createStatement();
   
            // Create Dept table
            String createDept =
                    "CREATE TABLE IF NOT EXISTS Dept (" +
                    "dept_id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "dept_name VARCHAR(20))";
            st.execute(createDept);
            System.out.println("Department table created");

            // Create Emp table with foreign key
            String createEmp =
                    "CREATE TABLE IF NOT EXISTS Emp (" +
                    "emp_id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "emp_name VARCHAR(50), " +
                    "sal DOUBLE, " +
                    "dept_id INT, " +
                    "FOREIGN KEY (dept_id) REFERENCES Dept(dept_id))";
            st.execute(createEmp);
            System.out.println("Employee table created");
            st.executeUpdate("INSERT INTO Dept VALUES (120, 'CSE')");
            System.out.println("Record inserted into Dept table");
            st.executeUpdate("INSERT INTO Emp VALUES (31017, 'Harsha', 100000, 120)");
            System.out.println("Record inserted into Emp table");
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
