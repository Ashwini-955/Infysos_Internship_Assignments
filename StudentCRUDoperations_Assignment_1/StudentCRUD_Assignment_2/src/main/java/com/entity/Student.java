package com.entity;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studId;
    private String studName;
    private String studDept;
    private String studEnrollCourse;
    private String studEmail;
    private int studAge;
    private double studFee;

    // getters and setters

//Getters and Setters

public int getStudId() {
 return studId;
}

public void setStudId(int studId) {
 this.studId = studId;
}

public String getStudName() {
 return studName;
}

public void setStudName(String studName) {
 this.studName = studName;
}

public String getStudDept() {
 return studDept;
}

public void setStudDept(String studDept) {
 this.studDept = studDept;
}

public String getStudEnrollCourse() {
 return studEnrollCourse;
}

public void setStudEnrollCourse(String studEnrollCourse) {
 this.studEnrollCourse = studEnrollCourse;
}

public String getStudEmail() {
 return studEmail;
}

public void setStudEmail(String studEmail) {
 this.studEmail = studEmail;
}

public int getStudAge() {
 return studAge;
}

public void setStudAge(int studAge) {
 this.studAge = studAge;
}

public double getStudFee() {
 return studFee;
}

public void setStudFee(double studFee) {
 this.studFee = studFee;
}
}