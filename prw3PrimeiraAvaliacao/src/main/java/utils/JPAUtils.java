package utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtils {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco");

    public static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }
}
