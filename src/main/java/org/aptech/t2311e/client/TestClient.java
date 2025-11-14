package org.aptech.t2311e.client;

import org.aptech.t2311e.model.Employee;
import org.aptech.t2311e.service.EmployeeService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class TestClient {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/employee?wsdl");

        QName qname = new QName(
                "http://service.t2311e.aptech.org/",
                "EmployeeServiceImplService"
        );

        Service service = Service.create(url, qname);
        EmployeeService empService = service.getPort(EmployeeService.class);

        // TEST ADD EMPLOYEE
        empService.addEmployees(new Employee(1, "John", 5000));
        empService.addEmployees(new Employee(2, "Alice", 7000));

        // TEST GET EMPLOYEES
        for (Employee e : empService.getEmployees()) {
            System.out.println(e.getId() + " | " + e.getName() + " | " + e.getSalary());
        }

        // TEST UPDATE
        empService.updateEmployee(new Employee(1, "John Updated", 9999));
    }
}
