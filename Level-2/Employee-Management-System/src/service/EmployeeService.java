package service;

import entity.Employee;

public interface EmployeeService {

    void addEmployee(Employee employee);

    void viewAllEmployees();

    void viewEmployeeById(Integer id);

    void updateEmployee(Employee employee, Integer id);

    void deleteEmployee(Integer id);

}
