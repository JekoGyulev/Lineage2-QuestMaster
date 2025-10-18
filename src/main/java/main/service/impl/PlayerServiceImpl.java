package main.service.impl;

import main.model.Player;
import main.model.PlayerClass;
import main.model.PlayerRole;
import main.repository.PlayerRepository;
import main.service.PlayerService;
import main.web.dto.LoginRequest;
import main.web.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, PasswordEncoder passwordEncoder) {
        this.playerRepository = playerRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void createNewPlayer(RegisterRequest registerRequest) {
        Player player = Player.builder()
                .username(registerRequest.getUsername())
                .password(this.passwordEncoder.encode(registerRequest.getPassword()))
                .nickname(registerRequest.getNickname())
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();

        this.playerRepository.save(player);

    }

    @Override
    public Player loginPlayer(LoginRequest loginRequest) {

        Player player = this.playerRepository.findByUsername(loginRequest.getUsername()).orElseThrow(() -> new RuntimeException("User with username %s does not exist"
                .formatted(loginRequest.getUsername())));


        if (!passwordEncoder.matches(loginRequest.getPassword(), player.getPassword())) {
            throw new RuntimeException("Username or password are incorrect");
        }

        return player;
    }

    @Override
    public void selectRole(UUID userId, PlayerRole role) {
        Player player = getPlayer(userId);

        player.setRole(role);
        player.setUpdatedOn(LocalDateTime.now());

        if (player.getRole() == PlayerRole.ADVENTURER) {
            PlayerClass randomPlayerClass = getRandomPlayerClass();
            player.setPlayerClass(randomPlayerClass);
        }

        this.playerRepository.save(player);
    }

    @Override
    public Player getPlayer(UUID playerId) {
        return this.playerRepository.findById(playerId).orElseThrow(() -> new RuntimeException("User with id %s does not exist"
                .formatted(playerId)));
    }

    @Override
    public List<Player> getAllAdventurers() {
        return this.playerRepository.findAllByRoleOrderByXpDesc(PlayerRole.ADVENTURER);
    }

    @Override
    public void updatePlayer(Player player) {
        this.playerRepository.save(player);
    }

    private PlayerClass getRandomPlayerClass() {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, PlayerClass.values().length);
        return PlayerClass.values()[randomIndex];
    }
}
