package com.rest.serviceapi.service.converters;

import com.rest.serviceapi.dao.model.Employee;
import com.rest.serviceapi.dto.beanpojo.EmpDTO;
import com.rest.serviceapi.dto.operations.IEmpDTO;
import com.rest.serviceapi.service.providers.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Service
public class EmpConvertService implements IEmpDTO {
    @Autowired
    private EmployeeService employeeService;
    @Override
    public EmpDTO addEmployee(EmpDTO employee) {

        return convertToEmpDTO(employeeService.addEmployee(convertToEmp(employee)));
    }

    @Override
    public EmpDTO updateEmployee(int id, EmpDTO employee) {
        return convertToEmpDTO(employeeService.updateEmployee(id,convertToEmp(employee)));
    }

    @Override
    public EmpDTO removeEmployee(int id) {
        return convertToEmpDTO(employeeService.removeEmployee(id));
    }

    @Override
    public EmpDTO findEmpById(int id) {

        return  convertToEmpDTO(employeeService.getEmpByIds(id));
    }



    @Override
    public List<EmpDTO> findAllEmployees() {
        return  listToEmpDTO(employeeService.getAllEmployees());
    }

    // DAO to DTO
    private EmpDTO convertToEmpDTO(Employee emp) {
        EmpDTO empDTO = new EmpDTO();
        empDTO.seteName(emp.getName());
        empDTO.seteId(emp.getId());
        empDTO.seteEmail(emp.getEmail());
        empDTO.seteGender(emp.getGender());
        empDTO.seteSkillSet(emp.getSkillSet());
        return empDTO;
    }

    // DTO to DAO
    private Employee convertToEmp(EmpDTO empDTO) {
        Employee emp = new Employee();
        emp.setName(empDTO.geteName());
        emp.setId(empDTO.geteId());
        emp.setEmail(empDTO.geteEmail());
        emp.setGender(empDTO.geteGender());
        emp.setSkillSet(empDTO.geteSkillSet());
        return emp;
    }

    // List
    private List<EmpDTO> listToEmpDTO(List<Employee> emp) {
         return emp.stream().map(this::convertToEmpDTO).collect(Collectors.toList());
    }
}
