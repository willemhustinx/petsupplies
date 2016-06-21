package nl.sogeti.petshop.service;

import java.util.List;

import javax.ejb.Stateless;

import nl.sogeti.petshop.model.Category;
import nl.sogeti.petshop.model.Product;

@Stateless
public class ProductService extends AbstractCrudRepository<Product> {

    @Override
    protected Class<Product> getEntityClass() {
        return Product.class;
    }

    public void removeProductsWithCategory(Category category) {
        List<Product> products;
        products = entityManager.createQuery("Select e From Product e Where CATEGORY_ID = '" + category.getId() + "'")
                .getResultList();
        for (Product p : products) {
            p.setCategory(null);
        }
    }

}