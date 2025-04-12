
// Medium Level🌿Task:Create a program that filters students scoring above
// 75%,sorts them by marks,and displays their names using lambda expressions and
// stream operations.

import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', marks=" + marks + "}";
    }
}

public class StudentFilterAndSort {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 80),
                new Student("Bob", 65),
                new Student("Charlie", 90),
                new Student("David", 70),
                new Student("Eve", 85));

        // Filter students scoring above 75% and sort them by marks
        System.out.println("Students scoring above 75% sorted by marks:");
        students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted(Comparator.comparingDouble(Student::getMarks))
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
