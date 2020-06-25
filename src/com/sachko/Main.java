package com.sachko;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private static final String nameOfFile = "listOfPeople.txt";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            //PersonDetails person = new PersonDetails(input.next(), input.nextInt(), input.next(), input.nextDouble()); Input manually
            Employee person = new Employee("name" + i, i, "male", i);
            //addPersonToTheList(person);


        }
        sortByName();
        readEveryPersonInTheList();

    }

    private static void addPersonToTheList(Employee person) {
        FileWriter writer;
        try {
            writer = new FileWriter(nameOfFile, true);

            writer.write(person.firstNameOfPerson + "-" + person.ageOfPerson +
                    "-" + person.genderOfPerson + "-" + person.amountOfInternship + "\n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void readEveryPersonInTheList() {
        try {
            File fileWithNames = new File(nameOfFile);
            Scanner reader = new Scanner(fileWithNames);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void sortByName() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nameOfFile));
            ArrayList<Employee> peopleRecords = new ArrayList<>();
            String currentLine = reader.readLine();
            while (currentLine != null) {
                String[] personDetail = currentLine.split("-");
                String name = personDetail[0];
                int age = Integer.parseInt(personDetail[1]);
                String gender = personDetail[2];
                int internship = Integer.parseInt(personDetail[3]);
                peopleRecords.add(new Employee(name, age, gender, internship));
                currentLine = reader.readLine();
            }
            peopleRecords.sort(new CompareByName());
            BufferedWriter writer = new BufferedWriter(new FileWriter(nameOfFile));
            for (Employee employee : peopleRecords) {
                writer.write(employee.firstNameOfPerson);
                writer.write("-" + employee.ageOfPerson);
                writer.write("-" + employee.genderOfPerson);
                writer.write("-" + employee.amountOfInternship);
                writer.newLine();
            }
            reader.close();

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void sortByInternship() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nameOfFile));
            ArrayList<Employee> peopleRecords = new ArrayList<>();
            String currentLine = reader.readLine();
            while (currentLine != null) {
                String[] personDetail = currentLine.split("-");
                String name = personDetail[0];
                int age = Integer.parseInt(personDetail[1]);
                String gender = personDetail[2];
                int internship = Integer.parseInt(personDetail[3]);
                peopleRecords.add(new Employee(name, age, gender, internship));
                currentLine = reader.readLine();
            }
            peopleRecords.sort(new CompareByInternship());
            BufferedWriter writer = new BufferedWriter(new FileWriter(nameOfFile));
            for (Employee employee : peopleRecords) {
                writer.write(employee.firstNameOfPerson);
                writer.write("-" + employee.ageOfPerson);
                writer.write("-" + employee.genderOfPerson);
                writer.write("-" + employee.amountOfInternship);
                writer.newLine();
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void sortByGender() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nameOfFile));
            ArrayList<Employee> peopleRecords = new ArrayList<>();
            String currentLine = reader.readLine();
            while (currentLine != null) {
                String[] personDetail = currentLine.split("-");
                String name = personDetail[0];
                int age = Integer.parseInt(personDetail[1]);
                String gender = personDetail[2];
                int internship = Integer.parseInt(personDetail[3]);
                peopleRecords.add(new Employee(name, age, gender, internship));
                currentLine = reader.readLine();
            }
            peopleRecords.sort(new CompareByGender());
            BufferedWriter writer = new BufferedWriter(new FileWriter(nameOfFile));
            for (Employee employee : peopleRecords) {
                writer.write(employee.firstNameOfPerson);

                writer.write("-" + employee.ageOfPerson);

                writer.write("-" + employee.genderOfPerson);

                writer.write("-" + employee.amountOfInternship);

                writer.newLine();
            }
            reader.close();

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Employee {
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

class CompareByName implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.firstNameOfPerson.contains("Polq") || o2.firstNameOfPerson.contains("Polq")){
            if (o1.firstNameOfPerson.contains("Polq")){
                return -1;
            } else if(o2.firstNameOfPerson.contains("Polq")) {
                return 1;
            } else {
                return 0;
            }

        } else {
            return o1.firstNameOfPerson.compareToIgnoreCase(o2.firstNameOfPerson);
        }


    }
}

class CompareByInternship implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.firstNameOfPerson.contains("Polq") || o2.firstNameOfPerson.contains("Polq")){
            if (o1.firstNameOfPerson.contains("Polq")){
                return -1;
            } else if(o2.firstNameOfPerson.contains("Polq")) {
                return 1;
            } else {
                return 0;
            }

        } else {
            return o2.amountOfInternship - o1.amountOfInternship;
        }

    }
}

class CompareByGender implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.firstNameOfPerson.contains("Polq") || o2.firstNameOfPerson.contains("Polq")){
            if (o1.firstNameOfPerson.contains("Polq")){
                return -1;
            } else if(o2.firstNameOfPerson.contains("Polq")) {
                return 1;
            } else {
                return 0;
            }

        } else {
            return o1.genderOfPerson.compareToIgnoreCase(o2.genderOfPerson);
            //същия код като при сортирането с име за да няма дискриминация :)
        }
    }
}