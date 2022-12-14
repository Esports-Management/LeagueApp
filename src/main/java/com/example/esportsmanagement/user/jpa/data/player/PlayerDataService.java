package com.example.esportsmanagement.user.jpa.data.player;

import com.example.esportsmanagement.user.jpa.repository.PlayerDataRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerDataService {

    private PlayerDataRepository playerDataRepository;

    public PlayerDataService(PlayerDataRepository playerDataRepository) {
        this.playerDataRepository = playerDataRepository;
    }

    public PlayerDataEntity findByUsername(String username) {
        return playerDataRepository.findByUsername(username);
    }
}
