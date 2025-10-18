package main.service.impl;

import main.model.Player;
import main.model.Quest;
import main.repository.QuestRepository;
import main.service.ItemService;
import main.service.QuestService;
import main.web.dto.QuestCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuestServiceImpl implements QuestService {

    private final ItemService itemService;

    private final QuestRepository questRepository;

    @Autowired
    public QuestServiceImpl(ItemService itemService, QuestRepository questRepository) {
        this.itemService = itemService;
        this.questRepository = questRepository;
    }

    @Override
    public List<Quest> getAllQuests() {
        return this.questRepository.findAllByOrderByCreatedOnDescXpDesc();
    }

    @Override
    public void createNewQuest(QuestCreateRequest request, Player player) {
        Quest quest = Quest.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .xp(request.getXp())
                .bannerUrl(request.getBannerURL())
                .capturer(player)
                .eligibleClass(request.getEligibleClass())
                .rewardedItem(this.itemService.getById(request.getRewardItemId()))
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .createdBy(player.getNickname())
                .updatedBy(player.getNickname())
                .build();

        this.questRepository.save(quest);
    }


}
