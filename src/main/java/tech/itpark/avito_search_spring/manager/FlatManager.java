package tech.itpark.avito_search_spring.manager;

import tech.itpark.avito_search_spring.model.Flat;

import java.util.ArrayList;
import java.util.List;

public class FlatManager {
    private List<Flat> items = new ArrayList<>();
    private int nextId = 1;

    public List<Flat> getAll(){
        return items;
    }

    public Flat getById(int id) {
        for (Flat item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Flat save(Flat item) {
        if (item.getId() == 0) {
            item.setId(nextId);
            nextId++;
            items.add(item);
            return item;
        }

        Flat saved = getById(item.getId());
        if (saved != null) {
            saved.setFloor(item.getFloor());
            saved.setDistrict(item.getDistrict());
            saved.setNumberOfRooms(item.getNumberOfRooms());
            saved.setPrice(item.getPrice());
        }
        return saved;

    }

    public List<Flat> search(List<String> districts, int minPrice, int maxPrice, int minRooms, int maxRooms, int checkFloor) {
        List<Flat> result = new ArrayList<>();
        for (Flat item : items) {
            if ((item.getPrice() < minPrice) || (item.getPrice() > maxPrice)) {
                continue;
            }
            if ((item.getNumberOfRooms() < minRooms) || (item.getNumberOfRooms() > maxRooms)) {
                continue;
            }
            if (item.getFloor() != checkFloor) {
                continue;
            }
            if (!districts.contains(item.getDistrict())) {
                continue;
            }
            result.add(item);
        }
        return result;
    }
    public void removeById(int id){
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id){
                items.remove(i);
                return;
            }

        }
    }
}
