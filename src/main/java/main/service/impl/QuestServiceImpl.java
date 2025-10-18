package main.service.impl;

import main.model.Quest;
import main.repository.QuestRepository;
import main.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestServiceImpl implements QuestService {

    private final QuestRepository questRepository;

    @Autowired
    public QuestServiceImpl(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }

    @Override
    public List<Quest> getAllQuests() {
        return this.questRepository.findAllByOrderByCreatedOnDescXpDesc();
    }






}
