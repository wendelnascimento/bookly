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

        } finally {
            try {
                entityManager.close();
            } catch (Exception ex) {

            }
        }
        return editoras;
    }

    public void save(Editora editora) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(editora);
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
