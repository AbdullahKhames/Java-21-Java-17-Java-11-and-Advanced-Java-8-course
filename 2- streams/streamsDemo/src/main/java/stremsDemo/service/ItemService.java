package stremsDemo.service;

import stremsDemo.models.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ItemService {
    public List<Item> getItems(){
        return new ArrayList<>(List.of(
                new Item(1, "Screw"),
                new Item(2, "Nail"),
                new Item(3, "Bolt")
        ));
    }

    public void streamItems(){
        List<Item> items = getItems();
        items.stream()
                .sorted(Comparator.comparing(Item::getName))
                .forEach(System.out::print);
    }
}
