package br.com.bookly.dao;

import br.com.bookly.bean.Cartao;
import br.com.bookly.factory.PersistenceManager;

import javax.persistence.EntityManager;

/**
 * Created by wendelnascimento on 24/05/17.
 */
public class CartaoDAO {
    private static CartaoDAO instance;
    protected EntityManager entityManager;

    public static CartaoDAO getInstance() {
        if(instance == null) {
            instance = new CartaoDAO();
        }
        return instance;
    }

    private CartaoDAO() {
        entityManager = PersistenceManager.INSTANCE.getEntityManager();
    }

    public void save(Cartao cartao) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cartao);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }

}
