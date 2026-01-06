package com.main.java.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.main.java.jdbc.DBConnectionManager;

public class ReadStudent {

    // Method for Reading All Students
    public static void selectStudent() {

        // JDBC API
        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            String selectQuery = "select * from student";
            con = DBConnectionManager.connectDB();
            ps = con.prepareStatement(selectQuery);
            rs = ps.executeQuery();

            System.out.println();
            System.out.println("\t\tID\t\tName\t\t\tEmail\t\tFee");
            System.out.println("\t***************************************************************");

            while (rs.next()) {
                int studId = rs.getInt("sid");
                String studName = rs.getString("name");
                String studEmail = rs.getString("email");
                double studFee = rs.getDouble("fee");

                System.out.println();
                System.out.print("\t\t" + studId + "\t\t" + studName + "\t\t" + studEmail + "\t\t" + studFee);
            }

        } catch (Exception e) {
            System.out.println("\t Error : " + e.getMessage());
        }
    }
}
