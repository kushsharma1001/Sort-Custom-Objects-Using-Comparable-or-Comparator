package com.kush;

import java.util.Arrays;
import java.util.Comparator;

class CompareCustomObjects {

    public static void main(String args[]) {
        Employee employeeArr[] = new Employee[5];
        employeeArr[0] = new Employee(1, "AAA", 11, 4000);
        employeeArr[1] = new Employee(2, "BBB", 19, 3000);
        employeeArr[2] = new Employee(3, "CCC", 15, 2000);
        employeeArr[3] = new Employee(4, "DDD", 27, 1000);
        employeeArr[4] = new Employee(5, "EEE", 27, 9000);

        Arrays.sort(employeeArr); // Arrays.sort(employeeArr, Collections.reverseOrder());
        for (Employee emp : employeeArr)
            System.out.println(emp);

        Arrays.sort(employeeArr, Employee.AgeComparator); // Arrays.sort(employeeArr, Collections.reverseOrder(Employee.AgeComparator));
        for (Employee emp : employeeArr)
            System.out.println(emp);

        Arrays.sort(employeeArr, Employee.SalaryComparator); // Arrays.sort(employeeArr, Collections.reverseOrder(Employee.SalaryComparator));
        for (Employee emp : employeeArr)
            System.out.println(emp);

        Arrays.sort(employeeArr, Employee.NameComparator); // Arrays.sort(employeeArr, Collections.reverseOrder(Employee.NameComparator));
        for (Employee emp : employeeArr)
            System.out.println(emp);

        Arrays.sort(employeeArr, Employee.AgeAndNameComparator); // Arrays.sort(employeeArr, Collections.reverseOrder(Employee.AgeAndNameComparator));
        for (Employee emp : employeeArr)
            System.out.println(emp);

    }
}

class Employee implements Comparable<Employee> { // we can also implement comparator interface and then override the comparator interface.

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
    public int compareTo(Employee emp) {
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

    /**
     * Comparator to sort employees list or array in order of Salary
     */
    public static Comparator<Employee> SalaryComparator = new Comparator<Employee>() {

        @Override
        public int compare(Employee e1, Employee e2) {
            return (int) (e1.getSalary() - e2.getSalary());
        }
    };

    /**
     * Comparator to sort employees list or array in order of Age
     */
    public static Comparator<Employee> AgeComparator = new Comparator<Employee>() {

        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.getAge() - e2.getAge();
        }
    };

    /**
     * Comparator to sort employees list or array in order of Name
     */
    public static Comparator<Employee> NameComparator = new Comparator<Employee>() {

        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.getName().compareTo(e2.getName());
        }
    };

    public static Comparator<Employee> AgeAndNameComparator = new Comparator<Employee>() {

        @Override
        public int compare(Employee e1, Employee e2) {
            int flag = e1.getAge() - e2.getAge();
            if (flag == 0)
                flag = e1.getName().compareTo(e2.getName());
            return flag;
        }
    };
}
