package com.example.esportsmanagement.web.controller.match;

import com.example.esportsmanagement.user.jpa.data.MatchDataEntity;
import com.example.esportsmanagement.user.jpa.data.MatchDataResponse;
import com.example.esportsmanagement.user.jpa.data.MatchDataService;
import com.merakianalytics.orianna.types.data.match.MatchList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class MatchListOutputController {

    private MatchDataService matchDataService;


    public MatchListOutputController(MatchDataService matchDataService) {
        this.matchDataService = matchDataService;
    }


//    @GetMapping(path = "/matchlist")
//    public String showAllMatches(Model model) {
//        Set<MatchDataEntity> match_id_set = new HashSet<MatchDataEntity>();
//        List allMatches = matchDataService.findAllMatches();
//        for (Object match : allMatches) {
//            if (match instanceof MatchDataEntity) {
//                MatchDataEntity match_entity = (MatchDataEntity) match;
//                match_id_set.add(match_entity);
//            }
//        }
//
//        model.addAttribute("match_statistics", match_id_set);
//        return "/matchlist";
//    }
//    @GetMapping(path = "/matchlist1")
//    public Set<String> getAllMatches() {
//    //public MatchDataResponse<MatchDataEntity> getAllMatches() {
//        Set<String> match_id_set = new HashSet<String>();
//        List allMatches = matchDataService.findAllMatches();
//        for (Object match : allMatches) {
//            if (match instanceof MatchDataEntity) {
//                MatchDataEntity match_entity = (MatchDataEntity) match;
//                match_id_set.add(match_entity.getMatchId());
//            }
//        }
//        return match_id_set;
//        return MatchDataResponse.<MatchDataEntity>builder()
//                .data(matchDataService.findAllMatches())
//                .build();
//    }

    @GetMapping(path = "/getMatchId")
    public MatchDataResponse<MatchDataEntity> getMatchId(@RequestParam("match_id") String match_id) {
        List all_players_in_match = matchDataService.findMatchByMatchId(match_id);
        for (Object element : all_players_in_match) {
            if (element instanceof MatchDataEntity) {
                MatchDataEntity elementD = (MatchDataEntity) element;
                System.out.println(elementD.getMatchId());
            }
        }
        return MatchDataResponse.<MatchDataEntity>builder()
                .data(matchDataService.findMatchByMatchId(match_id))
                .build();
    }

}
