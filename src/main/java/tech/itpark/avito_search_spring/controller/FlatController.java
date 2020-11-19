package tech.itpark.avito_search_spring.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.itpark.avito_search_spring.manager.FlatManager;
import tech.itpark.avito_search_spring.model.Flat;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/flats")

public class FlatController {
    private FlatManager manager = new FlatManager();

    @RequestMapping
    public List<Flat> getAll(){
        return manager.getAll();
    }

    @RequestMapping("/{id}")
    public Flat getById(@PathVariable int id) {
        return manager.getById(id);
    }

    @RequestMapping("/{id}/save")
    public Flat save(@PathVariable int id, @RequestParam String district, int price, int floor, int numberOfRooms){
        return manager.save(new Flat(id, district, price, floor, numberOfRooms));
    }

    @RequestMapping("/{id}/remove")
    public void removeById(@PathVariable int id){
        manager.removeById(id);
    }

    @RequestMapping("/search")
    public List<Flat> search(@RequestParam("districts")List<String> districts, @RequestParam("minPrice") int minPrice, @RequestParam("maxPrice") int maxPrice, @RequestParam("minRooms") int minRooms, @RequestParam("maxRooms") int maxRooms, @RequestParam("checkFloor") int checkFloor){
        return manager.search(districts, minPrice, maxPrice, minRooms, maxRooms, checkFloor);

    }


}
