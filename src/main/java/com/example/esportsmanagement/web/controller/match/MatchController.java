package com.example.esportsmanagement.web.controller.match;

import com.example.esportsmanagement.user.jpa.data.MatchDataEntity;
import com.example.esportsmanagement.user.jpa.data.MatchDataResponse;
import com.example.esportsmanagement.user.jpa.data.MatchDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

    @PostMapping("/find")
    public String findResults(
            @RequestParam("match_id") String match_id,
            @RequestParam("region") String region
            ) throws Exception {

            try {
                ProcessBuilder pb = new ProcessBuilder(configforpython.getConfig(),
                        "src\\main\\Python\\FetchApiData\\riotAPI.py", region, match_id
                );
                Process p = pb.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                BufferedReader errorReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                while ((line = errorReader.readLine()) != null) {
                    System.out.println(line);
                }
                System.out.println("All went well");
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

//    @GetMapping("/match-info/matchid=?{match}") // query db for this entry, return results
//    public ModelAndView getMatch(@PathVariable("match") String match) {
//        System.out.println(match);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/id=?" + match);
//        return modelAndView;
//    }
    @GetMapping("/match-statistics")
    public String getMatchId(@RequestParam("id") String match_id, Model model) {
        List all_players_in_match = matchDataService.findMatchByMatchId(match_id);
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

//    @PostMapping("/match-statistics")
//    public String postMatchId(@RequestParam("id") String match_id, Model model) {
//        List all_players_in_match = matchDataService.findMatchByMatchId(match_id);
//        List<MatchDataEntity> match_statistics = new ArrayList<MatchDataEntity>();
//        for (Object player : all_players_in_match) {
//            if (player instanceof MatchDataEntity) {
//                MatchDataEntity player_in_match = (MatchDataEntity) player;
//                match_statistics.add(player_in_match);
//            }
//        }
//
//        model.addAttribute("match_statistics", match_statistics);
//        return "/match-statistics";
//    }

}
