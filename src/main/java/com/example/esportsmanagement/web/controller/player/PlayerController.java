package com.example.esportsmanagement.web.controller.player;

import com.example.esportsmanagement.user.jpa.data.player.PlayerDataEntity;
import com.example.esportsmanagement.user.jpa.data.player.PlayerDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class PlayerController {
    private PlayerDataService playerDataService;


    public PlayerController(PlayerDataService playerDataService) {
        this.playerDataService = playerDataService;
    }

    @GetMapping("/player-statistics")
    public String getMatchId(@RequestParam("username") String username, Model model) {
        PlayerDataEntity player = playerDataService.findByUsername(username);
        if (player == null) {
            return "/player-not-found";
        }

        model.addAttribute("player", player);
        return "/player-statistics";
    }

    @GetMapping(path = "/players")
    public String showAllPlayers(Model model) {
        Set<String> player_set = new HashSet<String>();
        List allPlayers = playerDataService.findAllPlayers();
        for (Object player : allPlayers) {
            if (player instanceof PlayerDataEntity) {
                PlayerDataEntity player_entity = (PlayerDataEntity) player;
                player_set.add(player_entity.getUsername());
            }
        }
        if (player_set.isEmpty()) {
            return "/player-not-found";
        }

        model.addAttribute("player_list", player_set);
        return "/players";
    }

}
