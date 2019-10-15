package com.tw.apistackbase.employee;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final Logger log = Logger.getLogger(this.getClass().getName());
    private List<Employee> employeeList = new ArrayList<>();

    @GetMapping(path = "/", produces = {"application/json"})
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @PostMapping(path = "/addEmployee", produces = {"application/json"})
    public ResponseEntity<String> addEmployee(@RequestBody List<Employee> employeeToAdd){
        employeeList.addAll(employeeToAdd);
        return ResponseEntity.ok("Employee/s has been added!");
    }

    @PutMapping(path = "/updateEmployee/{employeeID}", produces = {"application/json"})
    public ResponseEntity<String> updateEmployee(@PathVariable int employeeID, @RequestBody Employee employee) {
        Employee employeeToUpdate = employeeList.stream()
                .filter( employeeInList -> employeeInList.getId() == employeeID )
                .findFirst()
                .orElse(null);
         int index = employeeList.indexOf(employeeToUpdate);
         employeeList.set(index , employee);
         return ResponseEntity.ok("Employee/s has been updated!");
    }

}
