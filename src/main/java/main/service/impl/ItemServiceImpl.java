package main.service.impl;

import main.model.Item;
import main.model.Player;
import main.repository.ItemRepository;
import main.service.ItemService;
import main.web.dto.ItemCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAllItems() {
        return this.itemRepository.findAllByOrderByCreatedOnDescXpBonusMultiplierDesc();
    }

    @Override
    public void create(ItemCreateRequest itemCreateRequest, Player player) {
        Item item = Item.builder()
                .name(itemCreateRequest.getName())
                .type(itemCreateRequest.getType())
                .iconUrl(itemCreateRequest.getIconUrl())
                .xpBonusMultiplier(itemCreateRequest.getXpMultiplier())
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .createdBy(player.getNickname())
                .updatedBy(player.getNickname())
                .build();

        this.itemRepository.save(item);
    }
}
