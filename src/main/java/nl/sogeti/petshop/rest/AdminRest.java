package nl.sogeti.petshop.rest;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nl.sogeti.petshop.model.Account;
import nl.sogeti.petshop.model.Category;
import nl.sogeti.petshop.model.OrderProduct;
import nl.sogeti.petshop.model.Product;
import nl.sogeti.petshop.service.AccountService;
import nl.sogeti.petshop.service.CategoryService;
import nl.sogeti.petshop.service.OrderService;
import nl.sogeti.petshop.service.ProductService;

@Path("/admin")
@Stateless
@LocalBean
@RolesAllowed("admin")
public class AdminRest {

    @Inject
    ProductService ps;

    @Inject
    CategoryService cs;

    @Inject
    AccountService as;

    @Inject
    OrderService os;

    @DELETE
    @Path("/removeProduct/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean removeProduct(@PathParam("id") Long id) {
        Product temp = new Product();
        temp.setId(id);
        ps.remove(temp);

        return true;
    }

    @POST
    @Path("/addProduct")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addProduct(Product product) {
        if (product.getId() != null && ps.find(product.getId()) != null) {
            ps.merge(product);
        } else {
            ps.persist(product);
        }
    }

    @DELETE
    @Path("/removeCategory/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean removeCategory(@PathParam("id") Long id) {
        Category temp = new Category();
        temp.setId(id);

        // set all products with this category null
        ps.removeProductsWithCategory(temp);

        cs.remove(temp);
        return true;
    }

    @POST
    @Path("/addCategory")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCategory(Category category) {
        if (category.getId() != null && cs.find(category.getId()) != null) {
            cs.merge(category);
        } else {
            cs.persist(category);
        }
    }

    @GET
    @Path("/info/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getInfoByEmail(@PathParam("email") String email) {
        // Cant send @ sign in get request, so revert the change here
        String accountEmail = email.replaceAll("-", "@");

        Account ac = as.find(accountEmail);

        ac.setPassword("null");
        return ac;
    }

    @POST
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editAccount(Account account) {

        Account ac = as.find(account.getEmail());

        ac.getName().setFirstName(account.getName().getFirstName());
        ac.getName().setInsertion(account.getName().getInsertion());
        ac.getName().setLastName(account.getName().getLastName());
        ac.setAddress(account.getAddress());
        ac.getAddress().setAddressInsertion(account.getAddress().getAddressInsertion());
        ac.getAddress().setAddressNumber(account.getAddress().getAddressNumber());
        ac.getAddress().setPostalCode(account.getAddress().getPostalCode());
        ac.getAddress().setCity(account.getAddress().getCity());

        as.merge(ac);
    }

    @GET
    @Path("/order/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<List<OrderProduct>> getOrder(@PathParam("email") String email) {
        // Cant send @ sign in get request, so revert the change here
        String accountEmail = email.replaceAll("-", "@");

        return os.findOrders(accountEmail);
    }
}
