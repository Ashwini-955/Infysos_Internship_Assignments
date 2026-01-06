package com.main.java.main;

import java.util.Scanner;

import com.main.java.exception.InvalidInputChoiceException;
import com.main.java.util.DeleteStudent;
import com.main.java.util.InsertStudent;
import com.main.java.util.ReadStudent;
import com.main.java.util.UpdateStudent;

public class JdbcCRUDMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice; // Hold Keyboard Input Value

        while (true) {
            try {
                System.out.println();
                System.out.println("\t\tJDBC CRUD (C-Insert, R-Select, U-Update, D-Delete) Application");
                System.out.println("\t\t************************************************************");
                System.out.println();
                System.out.println("\t\t1. Create \n\t\t2. Read \n\t\t3. Update \n\t\t4. Delete \n\t\t0. Exit");
                System.out.println();
                System.out.print("\t\tEnter Your Choice : ");
                choice = sc.nextInt();

                if (choice < 0) {
                    throw new InvalidInputChoiceException("\t Enter Valid Choice... Try Again...!!");
                } else {
                    switch (choice) {
                        case 1:
                            InsertStudent.insertStudent();
                            break;

                        case 2:
                            ReadStudent.selectStudent();
                            break;

                        case 3:
                            UpdateStudent.updateStudent();
                            break;

                        case 4:
                            DeleteStudent.deleteStudent();
                            break;

                        case 0:
                            System.out.println("\t\tThank You... Application Closed.");
                            sc.close();
                            System.exit(0);
                            break;

                        default:
                            System.out.println("\t Enter Valid Choice... Try Again...!!");
                    }
                }
            } catch (InvalidInputChoiceException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("\t Error : " + e.getMessage());
            }
        }
    }
}
