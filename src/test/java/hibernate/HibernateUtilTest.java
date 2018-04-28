package hibernate;

import entity.User;
import org.hibernate.Session;
import org.junit.Test;


public class HibernateUtilTest {

    @Test
    public void getSessionFactory() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        User u = User.builder().
                firstName("test").
                lastName("test").
                patronymic("test").
                login("test").
                password("test1").
                build();
        s.save(u);
        s.getTransaction().commit();
        s.close();
    }
}