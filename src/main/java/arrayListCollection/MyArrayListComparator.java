package arrayListCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * The Employee class is created to create a worker object and its fields - age and name.
 */

class Employee {
    int age;
    String name;
    Employee(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

/**
 * The AgeComparator class was created for an object
 * that will subsequently compare one of the fields of the employee object
 * for the purpose of subsequent sorting.
 */

class AgeComparator implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
        if (e1.age == e2.age)
            return 0;
        else if (e1.age > e2.age)
            return 1;
        else
            return -1;
    }
}

/**
 * The MyArrayListComparator class was created to create a
 * new object with the new command and
 * obtain a dynamic collection of the form ArrayList
 * after use a comparator to sort by the employee name field.
 * * @author Ivan Makhorin.
 */

public class MyArrayListComparator {
    public static void main(String[] args) {
        ArrayList<Employee> e = new ArrayList<>();
        e.add(new Employee(35, "Ivan"));
        e.add(new Employee(42, "Sem"));
        e.add(new Employee(21, "Egor"));
        e.add(new Employee(27, "Deni"));
        e.add(new Employee(19, "Petr"));

        System.out.println("before sorting");

        for (Employee Employee : e) {
            System.out.println(Employee.age + " " + Employee.name);
        }

        System.out.println();

        System.out.println("After sorting(sorted by age)");

        Collections.sort(e, new AgeComparator());
        for (Employee Employee : e) {
            System.out.println(Employee.age + " " + Employee.name);
        }
    }
}