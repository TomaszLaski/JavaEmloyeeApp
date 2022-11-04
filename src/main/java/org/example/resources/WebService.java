package org.example.resources;


import org.example.WebServiceApplication;
import io.swagger.annotations.Api;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

import java.sql.SQLException;

import static org.example.db.EmployeeDB.postEmployee;
@Api("Engineering Academy Dropwizard API")
@Path("/api")
public class WebService {
    @GET
    @Path("/employees/{employee}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMsg(@PathParam("employee") String employee) {
        return "Hello from a RESTful Web service: " + employee;
    }
    @POST
    @Path("/employees/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String sendMsg(Employee employee) {
        try {
            postEmployee(employee);
        }catch (SQLException e){
            e.printStackTrace();
            return "Employee added to database: " + employee.getName();
        }
        return null;
    }

    @GET
    @Path("/employeesReport/{department}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmployeeInfo(@PathParam("department") String department){
        try {
            return EmployeesDB.getReport(EmployeesDB.getEmployees(WebServiceApplication.getConnection(), department));
        } catch (SQLException e) {
            return "SQL error";
        }
    }
}
