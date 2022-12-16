package com.example.esportsmanagement.web.controller.match;

import com.example.esportsmanagement.user.jpa.data.match.MatchDataEntity;
import com.example.esportsmanagement.user.jpa.data.match.MatchDataService;
import com.example.esportsmanagement.user.jpa.data.UpdateDatabaseWithMatches;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.esportsmanagement.user.jpa.data.ManageDatabase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MatchController {

    @GetMapping("/find")
    public String find(){
        return "/find";
    }

    @RequestMapping(value="/find", method= RequestMethod.POST, params = "submit")
    public String addMatchesById(
            @RequestParam("match_id") String match_id,
            @RequestParam("region") String region
            ) throws Exception {

        UpdateDatabaseWithMatches.updateDatabaseWithMatches(region, match_id);

        return "/find";
    }

    @RequestMapping(value="/find", method= RequestMethod.POST, params = "update player stats")
    public String updatePlayerTable() throws Exception {
        try {
            ManageDatabase.createPlayerTable();
        } catch (Exception e) {
            System.out.println(e);
        }

        return "/find";
    }

    private MatchDataService matchDataService;

    public MatchController(MatchDataService matchDataService) {
        this.matchDataService = matchDataService;
    }


    @GetMapping(path = "/matchlist")
    public String showAllMatches(Model model) {
        Set<String> match_id_set = new HashSet<String>();
        List allMatches = matchDataService.findAllMatches();
        for (Object match : allMatches) {
            if (match instanceof MatchDataEntity) {
                MatchDataEntity match_entity = (MatchDataEntity) match;
                // we can put the whole match object with all stats here,
                // just need change set from Set<String> to Set<MatchDataEntity>
                // and change template to output necessary match info
                match_id_set.add(match_entity.getMatchId());
            }
        }


        model.addAttribute("match_list", match_id_set);
        return "/matchlist";
    }

    @GetMapping("/match-statistics")
    public String getMatchId(@RequestParam("id") String match_id, Model model) {

        List all_players_in_match = matchDataService.findMatchByMatchId(match_id);

        if (all_players_in_match.isEmpty()) {
            return "/match-not-found";
        }

        List<MatchDataEntity> match_statistics = new ArrayList<MatchDataEntity>();
        for (Object player : all_players_in_match) {
            if (player instanceof MatchDataEntity) {
                MatchDataEntity player_in_match = (MatchDataEntity) player;
                match_statistics.add(player_in_match);
            }
        }
        model.addAttribute("match_statistics", match_statistics);
        return "/match-statistics";
    }
}
