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


}
