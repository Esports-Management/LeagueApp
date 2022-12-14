package com.example.esportsmanagement.user.jpa.data.match;

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
    private Integer kills;

    @Column(name = "deaths")
    private Integer deaths;

    @Column(name = "assists")
    private Integer assists;

    @Column(name = "firstBloodKill")
    private Boolean firstBloodKill;

    @Column(name = "goldEarned")
    private Integer goldEarned;

    @Column(name = "pentaKills")
    private Integer pentaKills;

    @Column(name = "timeCcingOthers")
    private Integer timeCCingOthers;

    @Column(name = "totalTimeCcDealt")
    private Integer totalTimeCCDealt;

    @Column(name = "totalDamageDealtToChampions")
    private Integer totalDamageDealtToChampions;

    @Column(name = "totalMinionsKilled")
    private Integer totalMinionsKilled;

    @Column(name = "visionScore")
    private Integer visionScore;

}
