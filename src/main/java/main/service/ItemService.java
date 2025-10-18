package main.service;

import main.model.Item;
import main.model.Player;
import main.web.dto.ItemCreateRequest;

import java.util.List;
import java.util.UUID;


public interface ItemService {
    List<Item> getAllItems();

    void create(ItemCreateRequest itemCreateRequest, Player player);

    Item getById(UUID id);
}
