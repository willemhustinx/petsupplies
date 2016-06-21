package nl.sogeti.petshop.service;

import java.util.List;

import javax.ejb.Stateless;

import nl.sogeti.petshop.model.Account;
import nl.sogeti.petshop.model.LoginCart;

@Stateless
public class CartService extends AbstractCrudRepository<LoginCart> {

    @Override
    protected Class<LoginCart> getEntityClass() {
        return LoginCart.class;
    }

    public LoginCart find(Account key) {
        List<LoginCart> results = entityManager
                .createQuery("Select e From LoginCart e Where OWNER_EMAIL = '" + key.getEmail() + "'", LoginCart.class)
                .getResultList();
        return results.isEmpty() ? null : results.get(0);
    }
}