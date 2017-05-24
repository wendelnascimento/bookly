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
    public List<Livro> livroList() {
        List<Livro> livros = null;
        try {
            livros = entityManager.createQuery("from Livro").getResultList();
        } catch (Exception ex) {

        }
        return livros;
    }

    public Livro getLivroById(Integer id) {
        Livro livro = null;
        try {
            livro = entityManager.find(Livro.class, id);
        } catch (Exception ex) {

        }
        return livro;
    }

    public void save(Livro livro) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(livro);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }

    public void update(Livro livro) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(livro);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }

    public void delete(Integer id) {
        Livro livro;
        try {
            entityManager.getTransaction().begin();
            livro = entityManager.find(Livro.class, id);
            entityManager.remove(livro);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }
}
