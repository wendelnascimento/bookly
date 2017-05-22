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

        } finally {
            try {
                entityManager.close();
            } catch (Exception ex) {

            }
        }
        return fretes;
    }

    public void save(Frete frete) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(frete);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        } finally {
            try {
                entityManager.close();
            } catch (Exception ex) {

            }
        }
    }
}
