package com.main.java.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.main.java.jdbc.DBConnectionManager;

public class UpdateStudent {

    // Method for Updating Student
    public static void updateStudent() {

        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.print("\t Enter Student Id To Update : ");
        int id = sc.nextInt();

        System.out.println();
        System.out.print("\t Enter New Student Name : ");
        String name = sc.next();

        System.out.println();
        System.out.print("\t Enter New Student Email : ");
        String email = sc.next();

        System.out.println();
        System.out.print("\t Enter New Student Fee : ");
        double fee = sc.nextDouble();

        try {
            Connection con = DBConnectionManager.connectDB();

            String updateQuery = "update student set name=?, email=?, fee=? where sid=?";
            PreparedStatement ps = con.prepareStatement(updateQuery);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setDouble(3, fee);
            ps.setInt(4, id);

            int count = ps.executeUpdate();

            if (count > 0) {
                System.out.println();
                System.out.println("\t ******** Student Updated Successfully ********");
            } else {
                System.out.println();
                System.out.println("\t ******** Student Not Found ********");
            }

        } catch (Exception e) {
            System.out.println("\t Error : " + e.getMessage());
        }
    }
}
