package main.service;

import main.model.Player;
import main.model.Quest;
import main.web.dto.QuestCreateRequest;

import java.util.List;

public interface QuestService {
    List<Quest> getAllQuests();

    void createNewQuest(QuestCreateRequest questCreateRequest, Player player);
}
