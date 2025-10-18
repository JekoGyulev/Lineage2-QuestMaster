package main.web;

import main.service.ItemService;
import main.service.QuestService;
import main.web.dto.QuestCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/quests")
public class QuestController {

    private final QuestService questService;
    private final ItemService itemService;

    @Autowired
    public QuestController(QuestService questService, ItemService itemService) {
        this.questService = questService;
        this.itemService = itemService;
    }

    @GetMapping
    public ModelAndView getQuestsPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("quests");
        modelAndView.addObject("questCreateRequest", new QuestCreateRequest());
        modelAndView.addObject("quests", this.questService.getAllQuests());
        modelAndView.addObject("allItems", this.itemService.getAllItems());
        return modelAndView;
    }













}
