package com.rest.serviceapi.controller;
import com.rest.serviceapi.dto.EmpDTO;
import com.rest.serviceapi.service.EmpConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
   private EmpConvertService empConvertService;

    // private EmployeeService empService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/employee-list")
    public List<EmpDTO> getEmployeeList() {

        return empConvertService.findAllEmployees();

    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/employee-list/{id}")
    public ResponseEntity<EmpDTO> getEmployeeById(@PathVariable(value = "id") int employeeId) {
        EmpDTO employee = empConvertService.findEmpByIds(employeeId);
        return ResponseEntity.ok().body(employee);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/edit-employee/{id}")
    public ResponseEntity<EmpDTO> updateById(@PathVariable(value = "id") int employeeId, @RequestBody EmpDTO employeeDetails) {
        EmpDTO updatedEmployee = empConvertService.updateEmployee(employeeId, employeeDetails);
        return ResponseEntity.ok(updatedEmployee);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add-employee")
    public void createEmployee(@RequestBody EmpDTO employeeDetails) {
        empConvertService.addEmployee(employeeDetails);
      //  return  ResponseEntity.ok().body(employee);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping ("/delete-employee/{id}")
    public void deleteEmployee(@PathVariable(value = "id") int employeeId) {
        empConvertService.removeEmployee(employeeId);

    }

}

