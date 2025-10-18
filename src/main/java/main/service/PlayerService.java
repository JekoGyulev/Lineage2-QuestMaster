package main.service;

import main.model.Player;
import main.model.PlayerRole;
import main.web.dto.LoginRequest;
import main.web.dto.RegisterRequest;

import java.util.List;
import java.util.UUID;

public interface PlayerService {

    void createNewPlayer(RegisterRequest registerRequest);

    Player loginPlayer(LoginRequest loginRequest);

    void selectRole(UUID userId, PlayerRole role);

    Player getPlayer(UUID playerId);

    List<Player> getAllAdventurers();

    void updatePlayer(Player player);
}
