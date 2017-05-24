package br.com.bookly.dao;

import br.com.bookly.bean.Autor;
import br.com.bookly.factory.PersistenceManager;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by wendelnascimento on 21/05/17.
 */
public class AutorDAO {
    private static AutorDAO instance;
    protected EntityManager entityManager;

    public static AutorDAO getInstance() {
        if(instance == null) {
            instance = new AutorDAO();
        }
        return instance;
    }

    private AutorDAO() {
        entityManager = PersistenceManager.INSTANCE.getEntityManager();
    }

    @SuppressWarnings("unchecked")
    public List<Autor> autorList() {
        List<Autor> autores = null;
        try {
            autores = entityManager.createQuery("from Autor").getResultList();
        } catch (Exception ex) {

        }
        return autores;
    }

    public Autor getAutorById(Integer id) {
        Autor autor = null;
        try {
            autor = entityManager.find(Autor.class, id);
        } catch (Exception ex) {

        }
        return autor;
    }

    public void save(Autor autor) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(autor);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }

    public void update(Autor autor) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(autor);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }

    public void delete(Integer id) {
        Autor autor;
        try {
            entityManager.getTransaction().begin();
            autor = entityManager.find(Autor.class, id);
            entityManager.remove(autor);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }
}
