package org.example.db;

import org.example.resources.Employee;
import org.example.resources.SalesEmployee;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.example.WebServiceApplication.getConnection;

public class SalesEmployeeDB extends EmployeeDB{

    public static void postSalesEmployee(SalesEmployee salesEmployee) throws SQLException {

        Connection c = getConnection();
        Statement st = c.createStatement();
        st.executeUpdate(
                String.format("INSERT INTO Employee (first_name, address, bank_account, salary, NIN, email  ) " +
                        "VALUES ('%s', '%s', '%s', '%d', '%s', '%d')",
                        salesEmployee.getName(), salesEmployee.getAddress(),
                        salesEmployee.getBankAccountIBANorBic(),
                        salesEmployee.getStartingSalary(),
                        salesEmployee.getNationalInsuranceNo(),
                        salesEmployee.getEmployeeNumber() ));




        st.executeUpdate(
                String.format("INSERT INTO Sales_Employees (employee_id_fk, comission_rate, total_sales) " +
                        "VALUES (%d, %d)", salesEmployee.getComissionRate(),
                        salesEmployee.getTotalSales() ));
    }
}
}
