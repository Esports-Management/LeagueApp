package com.example.esportsmanagement.web.controller.player;

import com.example.esportsmanagement.user.jpa.data.match.MatchDataEntity;
import com.example.esportsmanagement.user.jpa.data.match.MatchDataService;
import com.example.esportsmanagement.user.jpa.data.player.PlayerDataEntity;
import com.example.esportsmanagement.user.jpa.data.player.PlayerDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PlayerController {
    private PlayerDataService playerDataService;


    public PlayerController(PlayerDataService playerDataService) {
        this.playerDataService = playerDataService;
    }

    @GetMapping("/player-statistics")
    public String getMatchId(@RequestParam("username") String username, Model model) {
        PlayerDataEntity player = playerDataService.findByUsername(username);

        model.addAttribute("player", player);
        return "/player-statistics";
    }
}
