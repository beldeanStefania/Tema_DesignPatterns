package com.proiectBetFair.demo.Controller;

import com.proiectBetFair.demo.Domain.Employee;
import com.proiectBetFair.demo.Factory.Laptop;
import com.proiectBetFair.demo.Factory.LenovoFactory;
import com.proiectBetFair.demo.Factory.MacBookFactory;
import com.proiectBetFair.demo.Factory.MacBookPc;
import com.proiectBetFair.demo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    // get all employees
    @GetMapping("/employees/getAll")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // create employee rest api
    @PostMapping("/employees/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        if (employee.getLaptopType() != null) {
            LenovoFactory LenovoFactory = new LenovoFactory();
            MacBookFactory MacBookFactory = new MacBookFactory();
            Laptop laptop;

            if (employee.getLaptopType().equals("LENOVO")) {
                laptop = LenovoFactory.getComputer();
            } else if (employee.getLaptopType().equals("APPLE")) {
                laptop = MacBookFactory.getComputer();
            } else laptop = null;

            if (laptop != null) {
                employee.setLaptop(laptop);
            }

            return employeeRepository.save(employee);
        }
        return employeeRepository.save(employee);
    }

    // get employee by id rest api
    @GetMapping("/employees/get/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws Exception {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee not exist with id :" + id));
        return ResponseEntity.ok(employee);
    }

    // update employee rest api

    @PutMapping("/employees/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) throws Exception {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee not exist with id :" + id));

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());

        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    // delete employee rest api
    @DeleteMapping("/employees/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) throws Exception {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee not exist with id :" + id));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
