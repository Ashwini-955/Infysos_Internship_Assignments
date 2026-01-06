package com.main.java.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.main.java.jdbc.DBConnectionManager;

public class DeleteStudent {

    // Method for Deleting Student
    public static void deleteStudent() {

        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.print("\t Enter Student Id To Delete : ");
        int id = sc.nextInt();

        try {
            Connection con = DBConnectionManager.connectDB();

            String deleteQuery = "delete from student where sid = ?";
            PreparedStatement ps = con.prepareStatement(deleteQuery);

            ps.setInt(1, id);

            int count = ps.executeUpdate();

            if (count > 0) {
                System.out.println();
                System.out.println("\t ******** Student Deleted Successfully ********");
            } else {
                System.out.println();
                System.out.println("\t ******** Student Not Found ********");
            }

        } catch (Exception e) {
            System.out.println("\t Error : " + e.getMessage());
        }
    }
}
