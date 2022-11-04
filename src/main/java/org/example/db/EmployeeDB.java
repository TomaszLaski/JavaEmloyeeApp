package org.example.db;

import org.example.resources.Employee;

import java.sql.Connection;
import java.sql.*;

import static org.example.WebServiceApplication.getConnection;

public class EmployeeDB {
    public static void postEmployee(Employee employee) throws SQLException {

        Connection c = getConnection();
        Statement st = c.createStatement();
        st.executeUpdate(
                String.format("INSERT INTO Employee (first_name, address, bank_account, salary, NIN, email  ) VALUES ('%s', '%s', '%s', '%d', '%s', '%d')", employee.getName(), employee.getAddress(), employee.getBankAccountIBANorBic(), employee.getStartingSalary(), employee.getNationalInsuranceNo(), employee.getEmployeeNumber()      ));
    }

}