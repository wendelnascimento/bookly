package br.com.bookly.dao;

import br.com.bookly.bean.Livro;
import br.com.bookly.factory.PersistenceManager;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by wendelnascimento on 21/05/17.
 */
public class LivroDAO {
    private static LivroDAO instance;
    protected EntityManager entityManager;

    public static LivroDAO getInstance() {
        if(instance == null) {
            instance = new LivroDAO();
        }
        return instance;
    }

    private LivroDAO() {
        entityManager = PersistenceManager.INSTANCE.getEntityManager();
    }

    @SuppressWarnings("unchecked")
    public List<Livro> usuarioList() {
        List<Livro> livros = null;
        try {
            livros = entityManager.createQuery("from Livro").getResultList();
        } catch (Exception ex) {

        } finally {
            try {
                entityManager.close();
            } catch (Exception ex) {

            }
        }
        return livros;
    }

    public void save(Livro livro) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(livro);
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
