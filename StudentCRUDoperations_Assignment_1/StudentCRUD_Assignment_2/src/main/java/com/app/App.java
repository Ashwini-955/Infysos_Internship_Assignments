package com.app;

import java.util.Scanner;
import com.crud.StudentCRUDOperations;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\nStudent CRUD Management System Using Hibernate");
            System.out.println("1. Insert Student (Create)");
            System.out.println("2. View All Student (Read)");
            System.out.println("3. Modify Student (Update)");
            System.out.println("4. Delete Student (Delete)");
            System.out.println("0. Exit");
            System.out.print("Enter your Choice : ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    StudentCRUDOperations.insertStudent();
                    break;

                case 2:
                    StudentCRUDOperations.viewAllStudent();
                    break;

                case 3:
                    StudentCRUDOperations.updateStudent();
                    break;

                case 4:
                    StudentCRUDOperations.deleteStudent();
                    break;

                case 0:
                    System.out.println("Exiting Application...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
