package com.crud;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Student;
import com.util.HibernateUtil;

public class StudentCRUDOperations {

    // Global declared variable
    static Scanner sc = new Scanner(System.in);

    // For Insert/Create Student into Database
    public static void insertStudent() {
        Session session = HibernateUtil.getFactory().openSession();
        Transaction tx = session.beginTransaction();

        // Name
        System.out.print("\t\t Enter Student Name \t: ");
        String name = sc.next();

        // Department
        System.out.print("\t\t Enter Student Department \t: ");
        String dept = sc.next();

        // Course
        System.out.print("\t\t Enter Student Course \t: ");
        String course = sc.next();

        // Email
        System.out.print("\t\t Enter Student Email \t: ");
        String email = sc.next();

        // Age
        System.out.print("\t\t Enter Student Age \t: ");
        int age = sc.nextInt();

        // Fee
        System.out.print("\t\t Enter Student Fee \t: ");
        double fee = sc.nextDouble();

        Student s = new Student();
        s.setStudName(name);
        s.setStudDept(dept);
        s.setStudEnrollCourse(course);
        s.setStudEmail(email);
        s.setStudAge(age);
        s.setStudFee(fee);

        session.save(s);
        tx.commit();
        session.close();
    }

    // For Display/Read All Student
    public static void viewAllStudent() {
        Session session = HibernateUtil.getFactory().openSession();

        List<Student> list = session.createQuery("from Student", Student.class).list();
        System.out.println("\tID\tName\tDepartment\tCourse\tEmail\tAge\tFee");

        for(Student s : list) {
            System.out.println("\t"+s.getStudId()+"\t"+s.getStudName()+"\t"+s.getStudDept()+"\t"+
                    s.getStudEnrollCourse()+"\t"+s.getStudEmail()+"\t"+s.getStudAge()+"\t"+s.getStudFee());
        }
        session.close();
    }
 // For Update Student
    public static void updateStudent() {

        Session session = HibernateUtil.getFactory().openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("\t Enter Student ID to Update : ");
        int id = sc.nextInt();

        Student s = session.get(Student.class, id);

        if (s != null) {
            System.out.print("\t Enter New Student Name : ");
            s.setStudName(sc.next());

            System.out.print("\t Enter New Student Fee : ");
            s.setStudFee(sc.nextDouble());

            session.update(s);
            tx.commit();
            System.out.println("\t Student Updated Successfully");
        } else {
            System.out.println("\t Student Not Found");
        }

        session.close();
    }
 // For Delete Student
    public static void deleteStudent() {

        Session session = HibernateUtil.getFactory().openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("\t Enter Student ID to Delete : ");
        int id = sc.nextInt();

        Student s = session.get(Student.class, id);

        if (s != null) {
            session.delete(s);
            tx.commit();
            System.out.println("\t Student Deleted Successfully");
        } else {
            System.out.println("\t Student Not Found");
        }

        session.close();
    }


}
