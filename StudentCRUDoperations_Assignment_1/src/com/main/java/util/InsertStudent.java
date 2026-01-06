package com.main.java.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.main.java.jdbc.DBConnectionManager;

public class InsertStudent {

    // Method for Inserting Student
    public static void insertStudent() {

        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.print("\t Enter Student Id : ");
        int id = sc.nextInt();

        System.out.println();
        System.out.print("\t Enter Student Name : ");
        String name = sc.next();

        System.out.println();
        System.out.print("\t Enter Student Email : ");
        String email = sc.next();

        System.out.println();
        System.out.print("\t Enter Student Fee : ");
        double fee = sc.nextDouble();

        try {
            Connection con = DBConnectionManager.connectDB();

            String insertQuery = "insert into student values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(insertQuery);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setDouble(4, fee);

            int count = ps.executeUpdate();

            if (count > 0) {
                System.out.println();
                System.out.println("\t ******** Student Inserted Successfully ********");
            } else {
                System.out.println();
                System.out.println("\t ******** Failed To Insert Student ********");
            }

        } catch (Exception e) {
            System.out.println("\t Error : " + e.getMessage());
        }
    }
}
