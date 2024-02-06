package ru.gb.hw0031;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("John", "Doe", "Smith", "123456", "Developer", 5000, 1985);
        Manager manager = new Manager("Jane", "Doe", "Smith", "654321", "Manager", 7000, 1980);

        Employee[] employees = new Employee[]{emp1, manager};

        // Increase salaries by 500, excluding managers
        Manager.increaseSalaries(employees, 500);

        // Display salaries to verify
        for (Employee emp : employees) {
            System.out.println(emp.getName() + ": " + emp.getSalary());
        }
    }
}
