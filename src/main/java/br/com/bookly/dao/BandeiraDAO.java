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

        } finally {
            try {
                entityManager.close();
            } catch (Exception ex) {

            }
        }
        return bandeiras;
    }

    public void save(Bandeira bandeira) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(bandeira);
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
