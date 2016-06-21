package nl.sogeti.petshop.service;

import javax.ejb.Stateless;
import nl.sogeti.petshop.model.Category;

@Stateless
public class CategoryService extends AbstractCrudRepository<Category> {

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }

}