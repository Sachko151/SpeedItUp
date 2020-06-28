package com.sachko;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final String nameOfFile = "listOfPeople.txt";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        showMenuOptions();
        do {
            try {
                menuAction(input.nextInt(), input);
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid option next time!");
                break;
            }

        } while (true);
    }
    private static void showMenuOptions() {
        System.out.println("Welcome, what would you like to do? |please enter the number of the task which you want to " +
                "perform|");
        System.out.println("1. Create a new list with employees or add them to an already existing list");
        System.out.println("2. Sort list by Name");
        System.out.println("3. Sort list by Age");
        System.out.println("4. Sort list by Gender");
        System.out.println("5. View the list");
        System.out.println("6. Delete the list");
        System.out.println("7. Exit");

    }

    private static void menuAction(int n, Scanner input) {
        switch (n) {
            case 1:
                System.out.println("How many people would you like to add?");
                int amountOfPeopleTheUserWishedToAdd = input.nextInt();
                for (int i = 1; i <= amountOfPeopleTheUserWishedToAdd; i++) {
                    System.out.println("Please enter the person's name: ");
                    String personName = input.next();
                    System.out.println("Please enter the person's age: ");
                    int personAge = input.nextInt();
                    System.out.println("Please enter the person's gender: ");
                    String personGender = input.next();
                    System.out.println("Please enter the person's internship: ");
                    int personInternship = input.nextInt();
                    Employee person = new Employee(personName, personAge, personGender, personInternship);
                    //Employee person = new Employee("name" + i, i, "male", i);
                    addPersonToTheList(person);
                }
                showMenuOptions();
                break;
            case 2:
                sortByName();

                break;
            case 3:
                sortByAge();

                break;
            case 4:
                sortByGender();
                break;
            case 5:
                readTheList();
                break;
            case 6:
                deleteTheList();
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Please choose a valid option!");
        }
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

    private static void readTheList() {
        try {
            System.out.println("|Name-Age-Gender-Internship|");
            File fileWithNames = new File(nameOfFile);
            Scanner reader = new Scanner(fileWithNames);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nothing to view!");
        }
    }

    private static void deleteTheList() {
        File file = new File(nameOfFile);
        file.delete();
        System.out.println("The list has been deleted!");
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
            System.out.println("The list has been sorted by name!");
        } catch (IOException e) {
            System.out.println("Nothing to sort!");
        }

    }

    private static void sortByAge() {
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
            peopleRecords.sort(new CompareByAge());
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
            System.out.println("The list has been sorted by age!");
        } catch (IOException e) {
            System.out.println("Nothing to sort!");
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
            System.out.println("The list has been sorted by gender!");
        } catch (IOException e) {
            System.out.println("Nothing to sort!");
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
        if (o1.firstNameOfPerson.equalsIgnoreCase("Polq") ||
                o2.firstNameOfPerson.equalsIgnoreCase("Polq") ||
                o1.firstNameOfPerson.equalsIgnoreCase("Поля") ||
                o2.firstNameOfPerson.equalsIgnoreCase("Поля")) {
            if (o1.firstNameOfPerson.equalsIgnoreCase("Polq") || o1.firstNameOfPerson.equalsIgnoreCase("Поля")) {
                return -1;
            } else if (o2.firstNameOfPerson.equalsIgnoreCase("Polq") || o2.firstNameOfPerson.equalsIgnoreCase("Поля")) {
                return 1;
            } else {
                return 0;
            }

        } else {
            return o1.firstNameOfPerson.compareToIgnoreCase(o2.firstNameOfPerson);
        }


    }
}

class CompareByAge implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.firstNameOfPerson.equalsIgnoreCase("Polq") ||
                o2.firstNameOfPerson.equalsIgnoreCase("Polq") ||
                o1.firstNameOfPerson.equalsIgnoreCase("Поля") ||
                o2.firstNameOfPerson.equalsIgnoreCase("Поля")) {
            if (o1.firstNameOfPerson.equalsIgnoreCase("Polq") || o1.firstNameOfPerson.equalsIgnoreCase("Поля")) {
                return -1;
            } else if (o2.firstNameOfPerson.equalsIgnoreCase("Polq") || o2.firstNameOfPerson.equalsIgnoreCase("Поля")) {
                return 1;
            } else {
                return 0;
            }

        } else {
            return o2.ageOfPerson - o1.ageOfPerson;
        }

    }
}

class CompareByGender implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.firstNameOfPerson.equalsIgnoreCase("Polq") ||
                o2.firstNameOfPerson.equalsIgnoreCase("Polq") ||
                o1.firstNameOfPerson.equalsIgnoreCase("Поля") ||
                o2.firstNameOfPerson.equalsIgnoreCase("Поля")) {
            if (o1.firstNameOfPerson.equalsIgnoreCase("Polq") || o1.firstNameOfPerson.equalsIgnoreCase("Поля")) {
                return -1;
            } else if (o2.firstNameOfPerson.equalsIgnoreCase("Polq") || o2.firstNameOfPerson.equalsIgnoreCase("Поля")) {
                return 1;
            } else {
                return 0;
            }

        } else {
            return o1.genderOfPerson.compareToIgnoreCase(o2.genderOfPerson);
            //същия код като при сортирането с име за да няма дискриминация :)
            //иначе кода за сортирането по пол е отдолу
           /* if (o1.genderOfPerson.equalsIgnoreCase("male")) {
                return -1;
            } else if (o2.genderOfPerson.equalsIgnoreCase("female")) {
                return 1;
            } else {
                return 0;
            }*/
        }
    }
}