package dao;

import model.Association;
import jakarta.persistence.EntityManager;

public class AssociationDAO {

    public void save(Association a) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(Association a) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.contains(a) ? a : em.merge(a));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
