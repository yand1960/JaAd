package my.dbs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Product p1 = session.get(Product.class, 1);
        System.out.println(p1.getName());
        //p1.setName("Lala");
        Product p2 = new Product();
        p2.setName("Hoho"); p2.setPrice(123.45); p2.setCode("qqq");
        //session.save(p2);

        double min_price = 3000.0;
        String hql = "SELECT p FROM Product p WHERE p.price > :min_price";
        List<Product> products = session.createQuery(hql)
                                    .setParameter("min_price",min_price)
                                    .list();

        for(var p: products) {
            System.out.println(p.getName() + " - " + p.getPrice());
        }

        session.beginTransaction().commit(); //Ошибка прав, но sql хороший и для p1, и для p2
        session.close();

    }

}
