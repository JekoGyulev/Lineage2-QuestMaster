package main.service.impl;

import main.model.Player;
import main.model.PlayerClass;
import main.model.Quest;
import main.repository.QuestRepository;
import main.service.ItemService;
import main.service.PlayerService;
import main.service.QuestService;
import main.web.dto.QuestCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class QuestServiceImpl implements QuestService {

    private final ItemService itemService;
    private final PlayerService playerService;

    private final QuestRepository questRepository;

    @Autowired
    public QuestServiceImpl(ItemService itemService, PlayerService playerService, QuestRepository questRepository) {
        this.itemService = itemService;
        this.playerService = playerService;
        this.questRepository = questRepository;
    }

    @Override
    public List<Quest> getAllQuests() {
        return this.questRepository.findAllByOrderByCreatedOnDescXpDesc();
    }

    @Override
    public List<Quest> getAllQuestsByPlayerClass(PlayerClass playerClass) {
        return this.questRepository.findAllByEligibleClassOrderByCreatedOnDesc(playerClass);
    }

    @Override
    public void createNewQuest(QuestCreateRequest request, Player player) {
        Quest quest = Quest.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .xp(request.getXp())
                .bannerUrl(request.getBannerURL())
                .eligibleClass(request.getEligibleClass())
                .rewardedItem(this.itemService.getById(request.getRewardItemId()))
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .createdBy(player.getNickname())
                .updatedBy(player.getNickname())
                .build();

        this.questRepository.save(quest);
    }

    @Override
    @Transactional
    public void captureQuest(UUID id, Player player) {
        Quest quest = this.questRepository.findById(id).orElseThrow(() -> new RuntimeException("Quest not found"));

        if (quest.getCapturer() != null) {
            throw new RuntimeException("This quest is already captured");
        }

        quest.setCapturer(player);

        double xpFromThisQuest = quest.getXp() + quest.getRewardedItem().getXpBonusMultiplier();

        player.setXp(player.getXp() + xpFromThisQuest);

        this.questRepository.save(quest);

        this.playerService.updatePlayer(player);
    }


}
