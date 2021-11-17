package my.dbs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JPADemo {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my_unit");
        EntityManager em = factory.createEntityManager();

        List<Product> products = em.createQuery("SELECT p FROM Product p WHERE p.price > 3000").getResultList();
        products.forEach(p -> {
            System.out.println(p.getName() + " - " + p.getPrice());
        });
        em.close();
    }
}
