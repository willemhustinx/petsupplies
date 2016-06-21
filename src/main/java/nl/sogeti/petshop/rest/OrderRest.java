package nl.sogeti.petshop.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import nl.sogeti.petshop.model.PetShopOrder;
import nl.sogeti.petshop.service.OrderService;

@Path("/order")
public class OrderRest {

    @Inject
    OrderService os;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createOrder(PetShopOrder petShopOrder) {
        
        os.persist(petShopOrder);
    }
}
