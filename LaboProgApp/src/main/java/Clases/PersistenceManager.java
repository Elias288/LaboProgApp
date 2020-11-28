package Clases;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class PersistenceManager {
   static private final String PERSISTENCE_UNIT_NAME = "LaboProgApp";
   protected static PersistenceManager me = null;
   private EntityManagerFactory emf = null;
 
   private PersistenceManager() {
      if (emf == null) {
         emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
         this.setEntityManagerFactory(emf);
      }
   }
 
   public static PersistenceManager getInstance() {
      if (me == null) {
         me = new PersistenceManager();
      }
      return me;
   }
 
   public void setEntityManagerFactory(EntityManagerFactory emf) {
      this.emf = emf;
   }
 
   public EntityManagerFactory getEntityManagerFactory() {
      return this.emf;
   }
 
   public EntityManager createEntityManager() {
      return emf.createEntityManager();
   }
}
