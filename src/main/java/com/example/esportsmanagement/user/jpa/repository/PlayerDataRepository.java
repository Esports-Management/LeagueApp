package com.example.esportsmanagement.user.jpa.repository;

import com.example.esportsmanagement.user.jpa.data.player.PlayerDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerDataRepository extends JpaRepository<PlayerDataEntity, String>{
    PlayerDataEntity findByUsername(String username);
}
