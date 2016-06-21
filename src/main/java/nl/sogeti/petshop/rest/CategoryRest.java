package nl.sogeti.petshop.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nl.sogeti.petshop.model.Category;
import nl.sogeti.petshop.service.CategoryService;

@Path("/category")
public class CategoryRest {

    @Inject
    CategoryService cs;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getCategories() {

        return cs.findAll();
    }

}