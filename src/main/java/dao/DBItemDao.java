package dao;

import entity.Item;
import org.hibernate.Session;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
class DBItemDao extends DBDao implements ItemDao{

    @Override
    public List<Item> get() {
        Session s = openSessionAndBeginTransaction();
        List<Item> out = s.createCriteria(Item.class).list();
        commitTransactionAndCloseSession(s);
        return out;
    }

    @Override
    public void add(Item i) {
        Session s = openSessionAndBeginTransaction();
        s.save(i);
        commitTransactionAndCloseSession(s);
    }

    @Override
    public void delete(String id) {
        Session s = openSessionAndBeginTransaction();
        s.createQuery("DELETE FROM Item WHERE id LIKE '" + id + "'").executeUpdate();
        commitTransactionAndCloseSession(s);
    }
   
    @Override
    public void update(Item i){
        Session s = openSessionAndBeginTransaction();
        s.update(i);
        commitTransactionAndCloseSession(s);
    }
    
}
