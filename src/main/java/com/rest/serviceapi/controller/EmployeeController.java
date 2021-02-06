package com.rest.serviceapi.controller;
import com.rest.serviceapi.config.Constants;
import com.rest.serviceapi.dto.beanpojo.EmpDTO;
import com.rest.serviceapi.service.converters.EmpConvertService;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class EmployeeController {
    @Autowired
   private EmpConvertService empConvertService;
    @Autowired
    private RabbitTemplate template;

    // private EmployeeService empService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/employee-list")
    public List<EmpDTO> getEmployeeList() {

        return empConvertService.findAllEmployees();

    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/employee-list/{id}")
    public ResponseEntity<EmpDTO> getEmployeeById(@PathVariable(value = "id") int employeeId) {
        EmpDTO employee = empConvertService.findEmpById(employeeId);
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
        EmpDTO emp = new EmpDTO();
        emp.seteName(employeeDetails.geteName());
        emp.seteEmail(employeeDetails.geteEmail());
        emp.seteGender(employeeDetails.geteGender());
        emp.seteSkillSet(employeeDetails.geteSkillSet());

        template.convertAndSend(Constants.EXCHANGE, Constants.ROUTING_KEY, emp);
      //  consumeMessageFromQueue(emp);
        empConvertService.addEmployee(employeeDetails);
      //  return  ResponseEntity.ok().body(employee);
    }

    @RabbitListener(queues = Constants.QUEUE)
    public void consumeMessageFromQueue(EmpDTO employeeDetails) {
        System.out.println("Message received from queue : " + employeeDetails);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping ("/delete-employee/{id}")
    public void deleteEmployee(@PathVariable(value = "id") int employeeId) {
        empConvertService.removeEmployee(employeeId);

    }

}

