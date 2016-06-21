package nl.sogeti.petshop.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import nl.sogeti.petshop.model.Account;
import nl.sogeti.petshop.model.LoginCart;
import nl.sogeti.petshop.model.LoginCartItem;
import nl.sogeti.petshop.service.AccountService;
import nl.sogeti.petshop.service.CartService;

@Path("/cart")
public class CartRest {

    @Inject
    CartService cs;

    @Inject
    AccountService as;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<LoginCartItem> getCategories(@Context HttpServletRequest req) {

       if (req.getUserPrincipal() != null) {
            Account ac = as.find(req.getUserPrincipal().getName());

            LoginCart lc = cs.find(ac);

            if (lc == null) {
                return new ArrayList<>();
            }

            return lc.getLoginCartItems();
        }
        return new ArrayList<>();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void fillCart(List<LoginCartItem> loginCartItems, @Context HttpServletRequest req) {
        if (req.getUserPrincipal() != null) {
            Account ac = as.find(req.getUserPrincipal().getName());

            LoginCart lc = cs.find(ac);

            if (lc == null) {
                lc = new LoginCart();
                lc.setOwner(ac);
                lc.setLoginCartItems(loginCartItems);
                cs.persist(lc);
            } else {
                lc.setLoginCartItems(loginCartItems);
                cs.merge(lc);
            }

        }

    }

}