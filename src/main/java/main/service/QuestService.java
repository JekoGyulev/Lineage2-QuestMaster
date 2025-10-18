package main.service;

import main.model.Player;
import main.model.PlayerClass;
import main.model.Quest;
import main.web.dto.QuestCreateRequest;

import java.util.List;
import java.util.UUID;

public interface QuestService {
    List<Quest> getAllQuests();

    List<Quest> getAllQuestsByPlayerClass(PlayerClass playerClass);

    void createNewQuest(QuestCreateRequest questCreateRequest, Player player);

    void captureQuest(UUID id, Player player);
}
