package nl.sogeti.petshop.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nl.sogeti.petshop.model.Product;
import nl.sogeti.petshop.service.ProductService;

@Path("/product")
public class ProductRest {

    @Inject
    ProductService ps;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts() {

        return ps.findAll();
    }

}
