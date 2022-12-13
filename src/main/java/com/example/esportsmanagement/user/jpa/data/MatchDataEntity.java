package com.example.esportsmanagement.user.jpa.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "match_statistics")
public class MatchDataEntity {

    @Id
    private Long id;

    @Column(name = "summonerName")
    private String summonerName;

    @Column(name = "matchId")
    @Getter
    private String matchId;

    @Column(name = "gameDuration")
    private String gameDuration;

    @Column(name = "championName")
    private String championName;

    @Column(name = "kills")
    private int kills;

    @Column(name = "deaths")
    private int deaths;

    @Column(name = "assists")
    private int assists;

    @Column(name = "firstBloodKill")
    private Boolean firstBloodKill;

    @Column(name = "goldEarned")
    private int goldEarned;

    @Column(name = "pentaKills")
    private int pentaKills;

    @Column(name = "timeCcingOthers")
    private int timeCCingOthers;

    @Column(name = "totalTimeCcDealt")
    private int totalTimeCCDealt;

    @Column(name = "totalDamageDealtToChampions")
    private int totalDamageDealtToChampions;

    @Column(name = "totalMinionsKilled")
    private int totalMinionsKilled;

    @Column(name = "visionScore")
    private int visionScore;

}
