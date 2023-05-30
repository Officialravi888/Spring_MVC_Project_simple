package org.example.service;

import org.example.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
   List<Employee> employeeList= Arrays.asList(
      new Employee("spiderman","Peter Parker",
         "New York"),
      new Employee("batman","Bruce Wayne",
         "Gotham City"),
      new Employee("superman","Clark Kent",
         "Metropolis"),
      new Employee("blackpanther","T'Challa",
         "Wakanda"),
      new Employee("ironman","Tony Stark",
         "New York")
   );
   public List<Employee> getEmployees(){
      return employeeList;
   }
   public Employee getEmployee(String id){
      return employeeList.stream().filter(e->e.getId()
         .equals(id)).findFirst().get();
   }
   public void addEmployee(Employee employee){
   }
   public void updateEmployee(Employee employee, String id){
      for(int i=0;i<employeeList.size();i++){
         Employee e=employeeList.get(i);
         if(e.getId().equals(id)) {
            employeeList.set(i, employee);
            break;
         }
      }
   }
   public void deleteEmployee(String id){
      employeeList.removeIf(e->e.getId().equals(id));
   }
}
