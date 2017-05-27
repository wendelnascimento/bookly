package br.com.bookly.dao;

import br.com.bookly.bean.Usuario;
import br.com.bookly.factory.PersistenceManager;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
        }
    }

    public Usuario getUsuarioById(Integer id) {
        Usuario usuario = new Usuario();
        try {
            usuario = entityManager.find(Usuario.class, id);
        } catch (Exception ex) {

        }
        return usuario;
    }

    public Usuario login(String email, String senha) {
        try {
            Query query = entityManager.createQuery("from Usuario where email = :email and senha = :senha");
            query.setParameter("email", email);
            query.setParameter("senha", senha);
            List<Usuario> list = query.getResultList();
            if(list.size() > 0) {
                Usuario usuario = list.get(0);
                usuario = getUsuarioById(usuario.getId());
                return usuario;
            } else {
                return new Usuario();
            }
        } catch (Exception ex) {
            return new Usuario();
        }
    }
}
