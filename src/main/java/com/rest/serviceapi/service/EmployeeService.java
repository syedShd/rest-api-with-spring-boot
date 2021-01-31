package com.rest.serviceapi.service;

import com.rest.serviceapi.dao.model.Employee;
import com.rest.serviceapi.dao.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeService implements IEmployee {
 //   private static final EmployeeService INSTANCE = new EmployeeService();

    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
 /*   static {
        Employee ob1 = new Employee(1,"Rameez","ramiz89@gmail.com","Male",
                Arrays.asList("Devops", "Advanced Java", "Angular"));
        Employee ob2 = new Employee(2,"Rahmath","rahmath45@gmail.com","Female",
                Arrays.asList("Node js", "Php", "MySql", "MongoDb", "Laravel"));
        Employee ob3 = new Employee(3,"Shareef","shrf9010@gmail.com","Male",
                ("Angular", "Node js", "Mongo"));
        Employee ob4 = new Employee(4,"Ameen","amin87@gmail.com","Male",
                Arrays.asList("Devops", "Advanced Java", "Aws"));
        Employee ob5 = new Employee(5,"Ismail","ismail231@gmail.com","Male",
                Arrays.asList("Php", "Advanced Java", "Angular"));
        employees.add(ob1);
        employees.add(ob2);
        employees.add(ob3);
        employees.add(ob4);
        employees.add(ob5);
    }*/
/*

    public int largest() {
        List<Integer> IDs = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        employees = (List<Employee>) employeeRepository.findAll();
        Iterator<Employee> itr = employees.iterator();
        while(itr.hasNext()){
            Employee id = itr.next();
          int curId = id.getId();
            IDs.add(curId);
        }

        int i;

        // Initialize maximum element
        List <Integer>arr = IDs;
        int max = arr.get(0);

        // Traverse array elements from second and
        // compare every element with current max
        for (i = 1; i < arr.size(); i++)
            if (arr.get(i) > max)
                max = arr.get(i);

        return max;
    }
*/



    public Employee addEmployee(Employee employeeDetails) {
        employeeRepository.save(employeeDetails);

       /* List<Employee> employee = getAllEmployees();
        Employee emp = new Employee();
        SecureRandom random = new SecureRandom();
       // String randomId = new BigInteger(120, random);
        //emp.setId(parseInt(randomId,16));

        emp.setId(largest()+1);
        emp.setEmail(employeeDetails.getEmail());
        emp.setName(employeeDetails.getName());
        emp.setGender(employeeDetails.getGender());
        emp.setSkillSet(employeeDetails.getSkillSet());
        employee.add(emp);*/
return employeeDetails;
    }


    public Employee updateEmployee( int id, Employee employeeDetails) {
        employeeRepository.save(employeeDetails);
     /*   Employee employee = null;
        for (Employee emp : getAllEmployees()){
            if (emp.getId().equals(id)) {
                employee = emp;
            }
        }
        employee.setEmail(employeeDetails.getEmail());
        employee.setName(employeeDetails.getName());
        employee.setGender(employeeDetails.getGender());
        employee.setGender(employeeDetails.getGender());
        employee.setSkillSet(employeeDetails.getSkillSet());*/
        return employeeDetails;
    }


    public Employee removeEmployee(int empId) {
        employeeRepository.deleteById(empId);
      //  employees.removeIf((Employee a) -> a.getId() == empId);
      /*  Iterator<Employee> itr = employees.iterator();
        while(itr.hasNext()){
            Employee id = itr.next();
            if(id.getId().equals(empId)){
                itr.remove();
            }
        }*/
        return null;
    }


    public Employee getEmpByIds(int id) {


        /*Employee employee = null;
        for (Employee emp : getAllEmployees()){
            if (emp.getId().equals(id)) {
                employee = emp;
            }
        }*/
        return employeeRepository.findById(id).orElse(null);
    }


    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return  employees;

    }


  /*  public static EmployeeService getInstance() {
        return INSTANCE;
    }*/
}
