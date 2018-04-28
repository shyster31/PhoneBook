package dao;

import entity.User;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

@Service
public class UserDao extends DBDao{

    public User getByLogin(String login) {
        Session s = openSessionAndBeginTransaction();
        User out = (User) s.createQuery("FROM User WHERE login='" + login + "'").uniqueResult();
        commitTransactionAndCloseSession(s);
        return out;
    }

    public void add(User u) {
        Session s = openSessionAndBeginTransaction();
        s.save(u);
        commitTransactionAndCloseSession(s);
    }
}
