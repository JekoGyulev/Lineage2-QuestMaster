package main.web;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import main.model.Player;
import main.service.ItemService;
import main.service.PlayerService;
import main.service.QuestService;
import main.web.dto.QuestCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/quests")
public class QuestController {

    private final PlayerService playerService;
    private final QuestService questService;
    private final ItemService itemService;

    @Autowired
    public QuestController(PlayerService playerService, QuestService questService, ItemService itemService) {
        this.playerService = playerService;
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


    @PostMapping
    public ModelAndView createQuest(@Valid QuestCreateRequest questCreateRequest,
                                    BindingResult bindingResult,
                                    HttpSession session) {


        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("quests");
            modelAndView.addObject("quests", this.questService.getAllQuests());
            modelAndView.addObject("allItems", this.itemService.getAllItems());

            return modelAndView;
        }

        UUID userId = (UUID) session.getAttribute("user_id");
        Player player = this.playerService.getPlayer(userId);

        this.questService.createNewQuest(questCreateRequest, player);


        return new ModelAndView("redirect:/quests");
    }













}
