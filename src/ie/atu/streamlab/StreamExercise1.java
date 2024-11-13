package ie.atu.streamlab;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Student {
    private String name;
    private int age;
    private double gpa;

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }


    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getGpa() {
        return gpa;
    }
}
public class StreamExercise1 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 22, 3.8));
        students.add(new Student("Bob", 19, 3.5));
        students.add(new Student("Charlie", 21, 3.9));
        students.add(new Student("Diana", 20, 2.7));
        students.add(new Student("Edward", 21, 3.2));
        students.add(new Student("Fiona", 20, 3.8));

        // students.stream()
        //         .filter(s -> s.getAge() > 20)
        //         .sorted(Comparator.comparing(Student::getGpa).reversed())
        //         .map(s -> String.format("Name: %-10s GPA: %.2f", s.getName(), s.getGpa()))
        //         .forEach(System.out::println);
        students.stream()
                .filter(s -> s.getGpa() > 3.7)
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .map(s -> String.format("Name: %-10s GPA: %.2f Age: %d", s.getName(), s.getGpa(), s.getAge()))
                .forEach(System.out::println);
        }
}

