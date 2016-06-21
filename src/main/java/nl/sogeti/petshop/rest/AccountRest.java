package nl.sogeti.petshop.rest;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import nl.sogeti.petshop.mail.Mail;
import nl.sogeti.petshop.model.Account;
import nl.sogeti.petshop.service.AccountService;

@Path("/account")
public class AccountRest {

    @Inject
    AccountService as;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)

    public void create(Account account) {
        account.getRoles().add("customer");
        account.setActivated(false);

        as.create(account);

        Mail mt = new Mail();

        String url = "http://localhost:8080/PetShop/#/activate/" + account.getEmail() + ";" + account.createHash();

        mt.send(account.getEmail(), "PetSupplies Online Account",
                "Your account has been created! To Activate you account go to \n " + url
                        + "\n\n\nUw Account is aangemaakt! Om uw account te activeren ga naar \n " + url);
    }

    @GET
    @Path("/info")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getInfo(@Context HttpServletRequest req) {
        if (req.getUserPrincipal() != null) {
            Account ac = as.find(req.getUserPrincipal().getName());

            ac.setPassword(null);
            return ac;
        }
        return null;
    }

    @POST
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean editAccount(Account account, @Context HttpServletRequest req) {
        if (req.getUserPrincipal() != null) {

            Account ac = as.find(req.getUserPrincipal().getName());

            if (ac.getEmail().equals(account.getEmail())) {
                ac.setFirstName(account.getFirstName());
                ac.setInsertion(account.getInsertion());
                ac.setLastName(account.getLastName());
                ac.setAddress(account.getAddress());
                ac.setAddressInsertion(account.getAddressInsertion());
                ac.setAddressNumber(account.getAddressNumber());
                ac.setPostalCode(account.getPostalCode());
                ac.setCity(account.getCity());

                as.merge(ac);
                return true;
            }
        }
        return false;
    }

    @POST
    @Path("/changePassword")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean changePassword(Map account, @Context HttpServletRequest req) {
        if (req.getUserPrincipal() != null) {

            Account ac = as.find(req.getUserPrincipal().getName());

            String newPassword = (String) account.get("newPassword");
            String oldPassword = (String) account.get("oldPassword");

            if (ac.getPassword().equals(oldPassword)) {
                ac.setPassword(newPassword);
                as.merge(ac);
                return true;
            }
        }
        return false;

    }

    @POST
    @Path("/activate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean activate(String hash) {

        String[] parts = hash.split(";");

        if (parts[0] == null) {
            return false;
        }

        Account ac = as.find(parts[0]);

        if (ac == null) {
            return false;
        }

        if (ac.createHash().equals(parts[1])) {
            ac.setActivated(true);
            as.merge(ac);
            return true;
        }

        return false;
    }

}
