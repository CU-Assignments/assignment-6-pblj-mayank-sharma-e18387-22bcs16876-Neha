// Easy Level 🌱
// Task: Write a program to sort a list of Employee objects based on different attributes such as name, age, and salary using lambda expressions.

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}

public class EmployeeSorting {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 30, 50000),
                new Employee("Bob", 45, 60000),
                new Employee("Charlie", 25, 45000),
                new Employee("David", 35, 55000));

        // Sort by Name (Alphabetically)
        System.out.println("Sorting by Name:");
        employees.stream()
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .forEach(System.out::println);

        // Sort by Age (Ascending)
        System.out.println("\nSorting by Age:");
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .forEach(System.out::println);

        // Sort by Salary (Descending)
        System.out.println("\nSorting by Salary (Descending):");
        employees.stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}