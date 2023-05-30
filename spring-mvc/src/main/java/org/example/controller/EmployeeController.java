package org.example.controller;

import org.example.entity.Employee;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
   @Autowired
   private EmployeeService employeeService;
   @RequestMapping("/employees")
   public List<Employee> getEmployees(){
      return employeeService.getEmployees();
   }
   @RequestMapping("/employees/{empid}")
   public Employee getEmployee(@PathVariable("empid")
         String id){
      return employeeService.getEmployee(id);
   }
   @RequestMapping(method= RequestMethod.POST,
      value="/employees")
   public void addEmployee(@RequestBody Employee employee){
      employeeService.addEmployee(employee);
   }
   @RequestMapping(method = RequestMethod.PUT,
      value="/employees/{id}")
   public void updateEmployee(@RequestBody Employee employee,
         @PathVariable String id){
      employeeService.updateEmployee(employee, id);
   }
   @RequestMapping(method = RequestMethod.DELETE,
      value="/employees/{id}")
   public void deleteEmployee(@PathVariable String id){
       employeeService.deleteEmployee(id);
   }
}