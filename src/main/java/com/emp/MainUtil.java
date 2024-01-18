package com.emp;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainUtil {
    public static void main(String[] args) {

        List<Employee> data = Arrays.asList(
                new Employee("mike", 5000),
                new Employee("smith", 10000),
                new Employee("tom", 5000)
        );

        Map<Double, List<Employee>> groups = data.stream().collect(Collectors.groupingBy(Employee::getSalary));

        System.out.println(groups);

        for (Map.Entry<Double, List<Employee>> entry : groups.entrySet()) {
            double salary = entry.getKey();
            List<Employee> employeeList = entry.getValue();
            System.out.println("Employees with salary" + salary + ":");
              for (Employee employee : employeeList) {
                System.out.println("\t" + employee.getName());
            }

        }

    }
}
