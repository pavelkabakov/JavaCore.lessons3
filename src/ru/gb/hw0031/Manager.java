package ru.gb.hw0031;

public class Manager extends Employee {
    public Manager(String name, String midName, String surName, String phone, String position, int salary, int birth) {
        super(name, midName, surName, phone, position, salary, birth);
    }

    // Move the salary increase functionality here and modify it
    public static void increaseSalaries(Employee[] employees, int increaseAmount) {
        for (Employee employee : employees) {
            if (!(employee instanceof Manager)) {
                employee.setSalary(employee.getSalary() + increaseAmount);
            }
        }
    }
}
