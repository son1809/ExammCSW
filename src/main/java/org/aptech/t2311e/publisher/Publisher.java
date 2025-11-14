package org.aptech.t2311e.publisher;

import org.aptech.t2311e.service.EmployeeServiceImpl;
import javax.xml.ws.Endpoint;

public class Publisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/employee",
                new EmployeeServiceImpl());

        System.out.println("Employee Web Service is running...");
        System.out.println("WSDL available at: http://localhost:8080/employee?wsdl");
    }
}
