package br.com.bookly.dao;

import br.com.bookly.bean.Frete;
import br.com.bookly.factory.PersistenceManager;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by wendelnascimento on 21/05/17.
 */
public class FreteDAO {
    private static FreteDAO instance;
    protected EntityManager entityManager;

    public static FreteDAO getInstance() {
        if(instance == null) {
            instance = new FreteDAO();
        }
        return instance;
    }

    public FreteDAO() {
        entityManager = PersistenceManager.INSTANCE.getEntityManager();
    }

    @SuppressWarnings("unchecked")
    public List<Frete> freteList() {
        List<Frete> fretes = null;
        try {
            fretes = entityManager.createQuery("from Frete").getResultList();
        } catch (Exception ex) {

        }
        return fretes;
    }

    public Frete getFreteById(Integer id) {
        Frete frete = null;
        try {
            frete = entityManager.find(Frete.class, id);
        } catch (Exception ex) {

        }
        return frete;
    }

    public void save(Frete frete) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(frete);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }

    public void update(Frete frete) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(frete);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }

    public void delete(Integer id) {
        Frete frete;
        try {
            entityManager.getTransaction().begin();
            frete = entityManager.find(Frete.class, id);
            entityManager.remove(frete);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }
}
