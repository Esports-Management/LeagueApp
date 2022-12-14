package com.example.esportsmanagement.user.jpa.repository;

import com.example.esportsmanagement.user.jpa.data.match.MatchDataEntity;
import com.example.esportsmanagement.user.jpa.data.player.PlayerDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface PlayerDataRepository extends JpaRepository<PlayerDataEntity, String>{
    PlayerDataEntity findByUsername(String username);
}
