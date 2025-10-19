package dao;

import model.Association;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

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
   
    public Association findByDonneurId(Long donneurId) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT a FROM Association a WHERE a.donneur.id = :id", Association.class)
                    .setParameter("id", donneurId)
                    .getResultStream()
                    .findFirst()
                    .orElse(null);
        } finally {
            em.close();
        }
    }

}
