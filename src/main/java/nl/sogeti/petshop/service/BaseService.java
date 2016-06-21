package nl.sogeti.petshop.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nl.sogeti.petshop.model.HasGeneratedId;

/**
 *
 * @author geenenju
 * @param <T>
 */
public abstract class BaseService<T extends HasGeneratedId> {
     
     @PersistenceContext
     private EntityManager entityManager;     
     
     public abstract Class<T> getEntityClass();

     protected EntityManager getEntityManager() {
          return entityManager;
     }
     
     public void create(T instance){
          entityManager.persist(instance);
     }
     
     public T find(Long id){
          return entityManager.find(getEntityClass(), id);
     }
}
