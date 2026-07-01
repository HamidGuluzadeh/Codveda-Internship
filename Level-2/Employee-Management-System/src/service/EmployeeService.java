package service;

import entity.Employee;
import exception.EmployeeNotFoundException;
import exception.EmptyDataException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeService {
    private static final List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added!");
    }

    public void viewAllEmployees() {
        if (employees.isEmpty()) {
            System.err.println("No employees found!");
            return;
        }

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void viewEmployeeById(Integer id) {
        if (employees.isEmpty()) {
            System.err.println("No employees found!");
        }

        for (Employee employee : employees) {
            if (Objects.equals(employee.getId(), id)) {
                System.out.println(employee);
                return;
            }
        }

        throw new EmployeeNotFoundException("Employee not found!");
    }

    public void updateEmployee(Employee updatedEmployee, Integer id) {
        if (employees.isEmpty()) {
            System.err.println("No employees found!");
        }

        if (Objects.isNull(updatedEmployee)) {
            throw new EmptyDataException("Request data cannot be empty!");
        }

        for (Employee employee : employees) {
            if (Objects.equals(employee.getId(), id)) {
                if (!Objects.isNull(updatedEmployee.getFirstName())) {
                    employee.setFirstName(updatedEmployee.getFirstName());
                } if (!Objects.isNull(updatedEmployee.getLastName())) {
                    employee.setLastName(updatedEmployee.getLastName());
                } if (!Objects.isNull(updatedEmployee.getAge())) {
                    employee.setAge(updatedEmployee.getAge());
                } if (!Objects.isNull(updatedEmployee.getPhoneNumber())) {
                    employee.setPhoneNumber(updatedEmployee.getPhoneNumber());
                } if (!Objects.isNull(updatedEmployee.getPosition())) {
                    employee.setPosition(updatedEmployee.getPosition());
                } if (!Objects.isNull(updatedEmployee.getSalary())) {
                    employee.setSalary(updatedEmployee.getSalary());
                }

                System.out.println(employee);
                System.out.println("Employee updated!");

                return;
            }
        }
    }

    public void deleteEmployee(Integer id) {
        boolean isRemoved = employees.removeIf(employee -> Objects.equals(employee.getId(), id));

        if (isRemoved) {
            System.out.println("Employee deleted!");
        } else {
            throw new EmployeeNotFoundException("Employee not found!");
        }
    }
}
