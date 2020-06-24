package com.sachko;

import java.util.Comparator;

public class CompareByName implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.firstNameOfPerson.equals("Polq") || o2.firstNameOfPerson.equals("Polq") ||
                o1.firstNameOfPerson.equals("Поля") || o2.firstNameOfPerson.equals("Поля")){
            return 1;
        }
        return o1.firstNameOfPerson.compareTo(o2.firstNameOfPerson);

    }
}
