package com.example.esportsmanagement.user.jpa.repository;

import com.example.esportsmanagement.user.jpa.data.MatchDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchDataRepository extends JpaRepository<MatchDataEntity, String>  {
    MatchDataEntity findBySummonerName(String summonerName);

    List<MatchDataEntity> findMatchByMatchId(String match_id);
}
