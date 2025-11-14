package org.aptech.t2311e.service;

import org.aptech.t2311e.dao.EmployeeDAO;
import org.aptech.t2311e.model.Employee;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "org.aptech.t2311e.service.EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeDAO dao = new EmployeeDAO();

    @Override
    public List<Employee> getEmployees() {
        return dao.getAll();
    }

    @Override
    public boolean addEmployees(Employee e) {
        return dao.add(e);
    }

    @Override
    public boolean updateEmployee(Employee e) {
        return dao.update(e);
    }
}
