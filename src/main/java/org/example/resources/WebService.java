package org.example.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
public class WebService {
    @GET
    @Path("/employees/{employee}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMsg(@PathParam("employee") String employee) {
        return "Hello from a RESTful Web service: " + employee;
    }
}
