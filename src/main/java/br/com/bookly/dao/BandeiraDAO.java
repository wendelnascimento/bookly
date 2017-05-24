package br.com.bookly.dao;

import br.com.bookly.bean.Bandeira;
import br.com.bookly.factory.PersistenceManager;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by wendelnascimento on 21/05/17.
 */
public class BandeiraDAO {
    private static BandeiraDAO instance;
    protected EntityManager entityManager;

    public static BandeiraDAO getInstance() {
        if(instance == null) {
            instance = new BandeiraDAO();
        }
        return instance;
    }

    public BandeiraDAO() {
        entityManager = PersistenceManager.INSTANCE.getEntityManager();
    }

    @SuppressWarnings("unchecked")
    public List<Bandeira> bandeiraList() {
        List<Bandeira> bandeiras = null;
        try {
            bandeiras = entityManager.createQuery("from Bandeira").getResultList();
        } catch (Exception ex) {

        }
        return bandeiras;
    }

    public Bandeira getBandeiraById(Integer id) {
        Bandeira bandeira = null;
        try {
            bandeira = entityManager.find(Bandeira.class, id);
        } catch (Exception ex) {

        }
        return bandeira;
    }

    public void save(Bandeira bandeira) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(bandeira);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }

    public void update(Bandeira bandeira) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(bandeira);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }

    public void delete(Integer id) {
        Bandeira bandeira;
        try {
            entityManager.getTransaction().begin();
            bandeira = entityManager.find(Bandeira.class, id);
            entityManager.remove(bandeira);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }
}
