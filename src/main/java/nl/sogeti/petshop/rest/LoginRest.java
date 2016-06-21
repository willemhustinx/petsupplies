package nl.sogeti.petshop.rest;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import nl.sogeti.petshop.model.Account;
import nl.sogeti.petshop.service.AccountService;

@Path("/login")
public class LoginRest {

    @Inject
    AccountService as;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public boolean login(Map account, @Context HttpServletRequest req) throws ServletException {
        // get data from the linkedhashmap
        String email = (String) account.get("email");
        String password = (String) account.get("password");
        
        Account ac = as.find(email);

        if (ac == null || !ac.getActivated()) {
            return false;
        }

        try {
            req.login(email, password);
            return true;
        } catch (ServletException e) {
            Logger.getLogger(LoginRest.class.getName()).log(Level.WARNING, "Cannot login", e);
        }
        return false;
    }

    @GET
    @Path("/logout")
    @Produces("text/plain")
    public void logout(@Context HttpServletRequest req) {
        HttpSession session = req.getSession(false);

        if (session != null) {
            session.invalidate();
        }

    }

    @GET
    @Path("/isLoggedIn")
    @Produces("text/plain")
    public boolean isLoggedIn(@Context HttpServletRequest req) {
        
        req.getSession(true);

        // check if there is a user logged in
        if (req.getUserPrincipal() != null) {
            return true;
        }
        return false;
    }

    @GET
    @Path("/isAdmin")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean isAdmin(@Context HttpServletRequest req) {
        if ("admin".equals(req.getUserPrincipal().toString())) {
            return true;
        }
        return false;
    }

}
