package service;

import dao.ItemCache;
import entity.Item;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import verification.Verification;

@Service
public class ItemService {

    @Autowired
    private ItemCache itemCache;
    @Autowired
    private Verification verification;

    public boolean edit(Item item,
            String firstName,
            String lastName,
            String patronymic,
            String phone,
            String homePhone,
            String email,
            String adress) {

        if (verification.isCorrectItemsData(firstName, lastName, patronymic, phone, email)) {
            item.setFirstName(firstName);
            item.setLastName(lastName);
            item.setPatronymic(patronymic);
            item.setPhone(phone);
            item.setHomePhone(homePhone);
            item.setEmail(email);
            item.setAdress(adress);
            itemCache.update(item);
            return true;
        }
        return false;
    }

    public boolean add(String firstName,
            String lastName,
            String patronymic,
            String phone,
            String homePhone,
            String email,
            String adress,
            String login) {

        if (verification.isCorrectItemsData(firstName, lastName, patronymic, phone, email)) {
            Item item = Item.builder().
                    firstName(firstName).
                    lastName(lastName).
                    patronymic(patronymic).
                    phone(phone).
                    homePhone(homePhone).
                    email(email).
                    adress(adress).
                    login(login).build();
            itemCache.add(item);
            return true;
        }
        return false;
    }

    public void updateItem(List<Item> items, Item i) {
        for (Item item : items) {
            if (i.getId().equals(item.getId())) {
                item.setFirstName(i.getFirstName());
                item.setLastName(i.getLastName());
                item.setPatronymic(i.getPatronymic());
                item.setPhone(i.getPhone());
                item.setHomePhone(i.getHomePhone());
                item.setEmail(i.getEmail());
                item.setAdress(i.getAdress());
                break;
            }
        }
    }

    public void removeItemById(String id, List<Item> items) {
        Iterator iterator = items.iterator();
        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();
            if (id.equals(item.getId())) {
                iterator.remove();
                break;
            }
        }
    }
}
