package com.kush;

import java.util.Arrays;
import java.util.Comparator;

class CompareCustomObjects2 {

    public static void main(String args[]) {
        Employee employeeArr[] = new Employee[5];
        employeeArr[0] = new Employee(1, "AAA", 11, 4000);
        employeeArr[1] = new Employee(2, "BBB", 19, 3000);
        employeeArr[2] = new Employee(3, "CCC", 15, 2000);
        employeeArr[3] = new Employee(4, "DDD", 27, 1000);
        employeeArr[4] = new Employee(5, "EEE", 27, 9000);

        // Arrays.sort(employeeArr); will give CTE as Comparable is not implemented and compareTo() is not overriden
        Arrays.sort(employeeArr, new Employee(5, "EEE", 27, 9000)); //since there is no comparator name available to pass as an arg in Arrays.sort() method, we have to pass the object of class implementing the comparator interface.
        for (Employee emp : employeeArr)
            System.out.println(emp);

    }
}

class Employee implements Comparator<Employee> {

    private int id;
    private String name;
    private int age;
    private long salary;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getSalary() {
        return salary;
    }

    public Employee(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public int compare(Employee emp, Employee emp2) {
        // let's sort the employee based on an id in ascending order
        // returns a negative integer, zero, or a positive integer as this employee id
        // is less than, equal to, or greater than the specified object.
        return (this.id - emp.id);
    }

    @Override
    // this is required to print the user-friendly information about the Employee
    public String toString() {
        return "[id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", salary=" + this.salary + "]";
    }
}
