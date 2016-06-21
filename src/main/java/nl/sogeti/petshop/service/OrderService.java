package nl.sogeti.petshop.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import nl.sogeti.petshop.model.OrderProduct;
import nl.sogeti.petshop.model.PetShopOrder;

@Stateless
public class OrderService extends AbstractCrudRepository<PetShopOrder> {

    @Override
    protected Class<PetShopOrder> getEntityClass() {
        return PetShopOrder.class;
    }

    public List<List<OrderProduct>> findOrders(String email) {
        List<PetShopOrder> pso = entityManager.createQuery("Select e From PetShopOrder e Where EMAIL = '" + email + "'")
                .getResultList();
        List<List<OrderProduct>> op = new ArrayList<>();
        for (PetShopOrder p : pso) {
            op.add(p.getOrderProducts());
        }
        return op;
    }

}