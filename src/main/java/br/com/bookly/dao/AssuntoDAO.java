package br.com.bookly.dao;

import br.com.bookly.bean.Assunto;
import br.com.bookly.factory.PersistenceManager;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by wendelnascimento on 21/05/17.
 */
public class AssuntoDAO {
    private static AssuntoDAO instance;
    protected EntityManager entityManager;

    public static AssuntoDAO getInstance() {
        if(instance == null) {
            instance = new AssuntoDAO();
        }
        return instance;
    }

    public AssuntoDAO() {
        entityManager = PersistenceManager.INSTANCE.getEntityManager();
    }

    @SuppressWarnings("unchecked")
    public List<Assunto> assuntoList() {
        List<Assunto> assuntos = null;
        try {
            assuntos = entityManager.createQuery("from Assunto").getResultList();
        } catch (Exception ex) {

        }
        return assuntos;
    }

    public Assunto getAssuntoById(Integer id) {
        Assunto assunto = null;
        try {
            assunto = entityManager.find(Assunto.class, id);
        } catch (Exception ex) {

        }
        return assunto;
    }

    public void save(Assunto assunto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(assunto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }

    public void update(Assunto assunto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(assunto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }

    public void delete(Integer id) {
        Assunto assunto;
        try {
            entityManager.getTransaction().begin();
            assunto = entityManager.find(Assunto.class, id);
            entityManager.remove(assunto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }
}
