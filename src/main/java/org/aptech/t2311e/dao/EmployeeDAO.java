package org.aptech.t2311e.dao;

import org.aptech.t2311e.model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root",
                "password"
        );
    }

    public List<Employee> getAll() {
        List<Employee> list = new ArrayList<>();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Employee");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary")
                ));
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) { e.printStackTrace(); }

        return list;
    }

    public boolean add(Employee e) {
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Employee VALUES (?, ?, ?)");

            ps.setInt(1, e.getId());
            ps.setString(2, e.getName());
            ps.setDouble(3, e.getSalary());

            boolean ok = ps.executeUpdate() > 0;

            ps.close();
            con.close();
            return ok;

        } catch (Exception ex) { ex.printStackTrace(); }

        return false;
    }

    public boolean update(Employee e) {
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE Employee SET name=?, salary=? WHERE id=?"
            );

            ps.setString(1, e.getName());
            ps.setDouble(2, e.getSalary());
            ps.setInt(3, e.getId());

            boolean ok = ps.executeUpdate() > 0;

            ps.close();
            con.close();
            return ok;

        } catch (Exception ex) { ex.printStackTrace(); }

        return false;
    }
}
