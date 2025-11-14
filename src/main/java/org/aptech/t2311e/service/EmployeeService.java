package org.aptech.t2311e.service;

import org.aptech.t2311e.model.Employee;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface EmployeeService {

    @WebMethod
    List<Employee> getEmployees();

    @WebMethod
    boolean addEmployees(Employee e);

    @WebMethod
    boolean updateEmployee(Employee e);
}
