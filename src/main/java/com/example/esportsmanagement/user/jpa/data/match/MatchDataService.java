package com.example.esportsmanagement.user.jpa.data.match;

import com.example.esportsmanagement.user.jpa.repository.MatchDataRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MatchDataService {

    private MatchDataRepository matchDataRepository;

    public MatchDataService(MatchDataRepository matchDataRepository) {
        this.matchDataRepository = matchDataRepository;
    }

    public List<MatchDataEntity> findMatchByMatchId(String match_id) {
        return matchDataRepository.findMatchByMatchId(match_id);
    }

    public MatchDataEntity findBySummonerName(String summonerName) {
        return matchDataRepository.findBySummonerName(summonerName);
    }

    public List<MatchDataEntity> findAllMatches() {
        return matchDataRepository.findAll();
    }

}
