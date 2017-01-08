import com.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.sql.Date;
import java.util.List;

public class App {

    public static void main(final String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        System.out.println("1 " + sessionFactory.hashCode());
        System.out.println("2 " + sessionFactory.hashCode());

        Session session = sessionFactory.openSession();
       // Session session2 = sessionFactory.openSession();

        Customer customer = new Customer();
        Customer customer2 = new Customer();
        customer.setFirstName("michael");
        customer.setLastName("mayer");
        Date date = new Date(1990-10-10);
        date.setTime(System.currentTimeMillis());
        customer.setBirthDate(date);

        session.save(customer);
        session.save(customer2);

        Query query = session.createQuery("select c.firstName from Customer c");
        List result = query.list();

        session.beginTransaction();
        session.beginTransaction();
      //  session2.beginTransaction();
        session.getTransaction().commit();
        session.getTransaction().commit();
      //  session2.getTransaction().commit();
        session.close();
      //  session2.close();
    }
}