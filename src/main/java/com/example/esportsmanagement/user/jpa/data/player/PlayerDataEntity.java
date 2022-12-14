package com.example.esportsmanagement.user.jpa.data.player;
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
@Table(name = "player_statistics")
public class PlayerDataEntity {

    @Column(name = "username")
    @Id
    @Getter
    private String username;

    @Column(name = "gamesPlayed")
    private Integer gamesPlayed;

    @Column(name = "kills")
    private String kills;

    @Column(name = "assists")
    private Integer assists;

    @Column(name = "deaths")
    private Integer deaths;

    @Column(name = "kda")
    private Double kda;

    @Column(name = "first_blood_kill")
    private Integer first_blood_kill;

    @Column(name = "penta_kills")
    private Integer penta_kills;

}
