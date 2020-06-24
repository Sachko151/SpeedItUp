package com.sachko;

public class Employee {
    String firstNameOfPerson;
    int ageOfPerson;
    String genderOfPerson;
    int amountOfInternship;

    public Employee(String name, int age, String gender, int internship) {
        this.firstNameOfPerson = name;
        this.ageOfPerson = age;
        this.genderOfPerson = gender;
        this.amountOfInternship = internship;
    }
}
