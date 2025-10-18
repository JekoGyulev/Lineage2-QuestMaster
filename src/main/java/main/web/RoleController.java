package main.web;

import jakarta.servlet.http.HttpSession;
import main.model.PlayerRole;
import main.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
public class RoleController {

    private final PlayerService playerService;

    @Autowired
    public RoleController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @GetMapping("/roles")
    public ModelAndView getRoleSelectionPage() {
        return new ModelAndView("role-select");
    }

    @PatchMapping("/players/me/role")
    public String selectRole(@RequestParam(name = "role") PlayerRole role, HttpSession session) {
        UUID userId = (UUID) session.getAttribute("user_id");
        this.playerService.selectRole(userId, role);
        return "redirect:/home";
    }

}
