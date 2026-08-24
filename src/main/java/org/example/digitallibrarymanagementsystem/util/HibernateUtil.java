package org.example.digitallibrarymanagementsystem.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.function.Function;

public class HibernateUtil {
    private static final String PERSISTENCE_UNIT = "Digital_Library";

    private static EntityManagerFactory emf;

    private HibernateUtil() {

    }

    public static EntityManagerFactory getEmf() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return emf;
    }

    public static EntityManager getEm() {
        return getEmf().createEntityManager();
    }

    public static <T> T inTxReturn(Function<EntityManager, T> function) {
        EntityManager em = getEm();
        EntityTransaction tx=em.getTransaction();
        try{
            tx.begin();
            T result = function.apply(em);
            tx.commit();
            return result;
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }finally {
            em.close();
        }
    }
}
