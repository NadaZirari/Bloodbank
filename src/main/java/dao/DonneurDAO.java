package dao;

import model.Donneur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class DonneurDAO {

    public void save(Donneur d) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void update(Donneur d) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(d);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Donneur findById(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Donneur d = em.find(Donneur.class, id);
        em.close();
        return d;
    }

    public void delete(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Donneur d = em.find(Donneur.class, id);
            if (d != null) em.remove(d);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Donneur> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Donneur> query = em.createQuery("SELECT d FROM Donneur d", Donneur.class);
        List<Donneur> result = query.getResultList();
        em.close();
        return result;
    }

    public List<Donneur> findDisponibles() {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Donneur> query = em.createQuery(
                "SELECT d FROM Donneur d WHERE d.statut='DISPONIBLE'", Donneur.class);
        List<Donneur> result = query.getResultList();
        em.close();
        return result;
    }
}
