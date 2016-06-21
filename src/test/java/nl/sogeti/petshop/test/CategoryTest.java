package nl.sogeti.petshop.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import nl.sogeti.petshop.model.Category;
import nl.sogeti.petshop.service.CategoryService;

public class CategoryTest extends AbstractTest {

    CategoryService repository;

    @Before
    public void setup() {
        repository = new CategoryService();
        repository.entityManager = getEntityManager();
        getTransaction().begin();
    }

    @Test
    public void testPersist() {
        
        HashMap<String, String> cn = new HashMap<>();
        cn.put("NL", "Draak");
        cn.put("EN", "Drake");
        Category c = new Category();
        c.setName(cn);
        
        c = repository.persist(c);
        
        assertNotNull(repository.find(c.getId()));
    }
    
    @Test
    public void testMerge() {
        
        HashMap<String, String> cn = new HashMap<>();
        cn.put("NL", "Draak");
        cn.put("EN", "Drake");
        Category c = new Category();
        c.setName(cn);
        
        c = repository.persist(c);
        assertNotNull(repository.find(c.getId()));
        assertTrue(repository.find(c.getId()).getName().get("NL").equals("Draak"));
        
        cn = new HashMap<>();
        cn.put("NL", "Vis");
        cn.put("EN", "Fish");
        c.setName(cn);
        c = repository.merge(c);
        
        System.out.println(c);
        
        assertNotNull(repository.find(c.getId()));
        assertTrue(repository.find(c.getId()).getName().get("NL").equals("Vis"));
    }

    @After
    public void teardown() {
        if (getTransaction().isActive()) {
            getTransaction().rollback();
        }
    }

}


