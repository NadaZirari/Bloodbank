package dao;

import model.Receveur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ReceveurDAO {

    public void save(Receveur r) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void update(Receveur r) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(r);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Receveur findById(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Receveur r = em.find(Receveur.class, id);
        em.close();
        return r;
    }

    public void delete(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Receveur r = em.find(Receveur.class, id);
            if (r != null) em.remove(r);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Receveur> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Receveur> query = em.createQuery(
                "SELECT r FROM Receveur r ORDER BY CASE r.situation WHEN 'CRITIQUE' THEN 1 WHEN 'URGENT' THEN 2 ELSE 3 END",
                Receveur.class);
        List<Receveur> result = query.getResultList();
        em.close();
        return result;
    }

    public List<Receveur> findNonSatisfaits() {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Receveur> query = em.createQuery(
                "SELECT r FROM Receveur r WHERE r.etat='EN_ATTENTE'", Receveur.class);
        List<Receveur> result = query.getResultList();
        em.close();
        return result;
    }
}
