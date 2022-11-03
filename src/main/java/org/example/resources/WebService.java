package org.example.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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
        return "Employee added to database: " + employee.getName();
    }
}
