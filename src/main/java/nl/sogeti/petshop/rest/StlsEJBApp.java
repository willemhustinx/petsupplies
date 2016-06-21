package nl.sogeti.petshop.rest;

import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.Context;

@Path("/stateless")
@RolesAllowed("admin")
@Stateless
@LocalBean
public class StlsEJBApp {

    @GET
    @Produces("text/plain")
    @Path("/hello")
    @RolesAllowed("admin")
    public String sayHello(@Context SecurityContext sc) {
        if (sc.isUserInRole("admin"))
            return "Hello World!";
        return "oh no";
    }
}