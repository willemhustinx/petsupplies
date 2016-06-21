package nl.sogeti.petshop.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.BeforeClass;

/**
 * @author Erwin de Gier
 */
 public class AbstractTest {

    private static EntityManagerFactory emf;
    private EntityManager entityManager;
    private EntityTransaction transaction;

    @BeforeClass
    public static void oneTimeSetUp() throws Exception {
        emf = Persistence.createEntityManagerFactory("testPU");
    }

    @Before
    public final void transactionSetUp() throws Exception {
        this.entityManager = emf.createEntityManager();
        this.transaction = this.entityManager.getTransaction();
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    public EntityTransaction getTransaction() {
        return this.transaction;
    }

}