package dao;

import entity.Item;
import java.util.List;

public interface ItemDao {
    
    public List<Item> get();
       
    public void add(Item i);
    
    public void delete(String id);
    
    public void update(Item i);
}
