package dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.Item;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ItemService;

@Service
class FileItemDao implements ItemDao {

    private final static String FILE_URL = "src\\main\\resources\\items.json";

    @Autowired
    private ItemService itemService;

    @Override
    public List<Item> get() {
        List<Item> items = new LinkedList();
        try (Reader reader = new FileReader(FILE_URL)) {
            items = new Gson().fromJson(reader, new TypeToken<List<Item>>() {
            }.getType());
        } catch (FileNotFoundException f) {
            createFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public void add(Item i) {
        List<Item> items = get();
        items.add(i);
        writeToFile(items);
    }

    @Override
    public void delete(String id) {
        List<Item> items = get();
        itemService.removeItemById(id, items);
        writeToFile(items);
    }

    @Override
    public void update(Item i) {
        List<Item> items = get();
        itemService.updateItem(items, i);
        writeToFile(items);
    }

    private void createFile() {
        try (FileWriter writer = new FileWriter(FILE_URL)) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile(List<Item> items) {
        try (FileWriter writer = new FileWriter(FILE_URL)) {
            new Gson().toJson(items, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
