package br.com.bookly.dao;

import br.com.bookly.bean.Editora;
import br.com.bookly.factory.PersistenceManager;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by wendelnascimento on 21/05/17.
 */
public class EditoraDAO {
    private static EditoraDAO instance;
    protected EntityManager entityManager;

    public static EditoraDAO getInstance() {
        if(instance == null) {
            instance = new EditoraDAO();
        }
        return instance;
    }

    private EditoraDAO() {
        entityManager = PersistenceManager.INSTANCE.getEntityManager();
    }

    @SuppressWarnings("unchecked")
    public List<Editora> editoraList() {
        List<Editora> editoras = null;
        try {
            editoras = entityManager.createQuery("from Editora").getResultList();
        } catch (Exception ex) {

        }
        return editoras;
    }

    public Editora getEditoraById(Integer id) {
        Editora editora = null;
        try {
            editora = entityManager.find(Editora.class, id);
        } catch (Exception ex) {

        }
        return editora;
    }

    public void save(Editora editora) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(editora);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }

    public void update(Editora editora) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(editora);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }

    public void delete(Integer id) {
        Editora editora;
        try {
            entityManager.getTransaction().begin();
            editora = entityManager.find(Editora.class, id);
            entityManager.remove(editora);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }
}
