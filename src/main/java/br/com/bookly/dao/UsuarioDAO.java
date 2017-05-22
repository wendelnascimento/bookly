package br.com.bookly.dao;

import br.com.bookly.bean.Usuario;
import br.com.bookly.factory.PersistenceManager;
import javax.persistence.EntityManager;
import javax.transaction.Transaction;
import java.util.List;

/**
 * Created by wendelnascimento on 20/05/17.
 */
public class UsuarioDAO {
    private static UsuarioDAO instance;
    protected EntityManager entityManager;

    public static UsuarioDAO getInstance() {
        if(instance == null) {
            instance = new UsuarioDAO();
        }
        return instance;
    }

    private UsuarioDAO() {
        entityManager = PersistenceManager.INSTANCE.getEntityManager();
    }



    @SuppressWarnings("unchecked")
    public List<Usuario> usuarioList() {
        List<Usuario> usuarios = null;
        try {
            entityManager.createQuery("from Usuario").getResultList();
        } catch (Exception ex) {

        } finally {
            try {
                entityManager.close();
            } catch (Exception ex) {

            }
        }
        return usuarios;
    }

    public void save(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
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
