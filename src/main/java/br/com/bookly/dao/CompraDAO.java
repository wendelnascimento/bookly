package br.com.bookly.dao;

import br.com.bookly.bean.Compra;
import br.com.bookly.factory.PersistenceManager;

import javax.persistence.EntityManager;

/**
 * Created by wendelnascimento on 24/05/17.
 */
public class CompraDAO {
    private static CompraDAO instance;
    protected EntityManager entityManager;

    public static CompraDAO getInstance() {
        if(instance == null) {
            instance = new CompraDAO();
        }
        return instance;
    }

    private CompraDAO() {
        entityManager = PersistenceManager.INSTANCE.getEntityManager();
    }

    public void save(Compra compra) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(compra);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }
}
