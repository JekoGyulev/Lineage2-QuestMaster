package main.service;

import main.model.Item;
import main.model.Player;
import main.web.dto.ItemCreateRequest;

import java.util.List;


public interface ItemService {
    List<Item> getAllItems();

    void create(ItemCreateRequest itemCreateRequest, Player player);
}
