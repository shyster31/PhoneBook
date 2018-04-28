package dao;

import entity.Item;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ItemService;

@Service
public class ItemCache implements ItemDao {

    private static final int TWO_MINUTES = 120000;

    @Autowired
    private ItemService itemService;
    @Autowired
    private FileItemDao fileItemDao;

    private DBItemDao dBItemDao = new DBItemDao();

    private List<Item> items = dBItemDao.get();

    public ItemCache() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(TWO_MINUTES);
                    items = dBItemDao.get();
                } catch (InterruptedException ex) {
                }
            }
        }).start();
    }

    @Override
    public List<Item> get() {
        return items;
    }

    public Item getById(String id) {
        for (Item item : items) {
            if (id.equals(item.getId())) {
                return item;
            }
        }
        return null;
    }

    public List<Item> getByLogin(String login) {
        List<Item> out = new LinkedList<>();
        for (Item item : items) {
            if (login.equals(item.getLogin())) {
                out.add(item);
            }
        }
        return out;
    }

    @Override
    public void add(Item i) {
        items.add(i);
//        fileItemDao.add(i);
        dBItemDao.add(i);
    }

    @Override
    public void delete(String id) {
        itemService.removeItemById(id, items);
//        fileItemDao.delete(id);
        dBItemDao.delete(id);
    }

    @Override
    public void update(Item i) {
        itemService.updateItem(items, i);
//        fileItemDao.update(i);
        dBItemDao.update(i);
    }

}
