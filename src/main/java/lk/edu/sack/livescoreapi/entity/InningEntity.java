package lk.edu.sack.livescoreapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "inning")
public class InningEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inningId;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private MatchEntity match;

    @ManyToOne
    @JoinColumn(name = "batting_team_id")
    private TeamEntity battingTeam;

    @ManyToOne
    @JoinColumn(name = "bowling_team_id")
    private TeamEntity bowlingTeam;

    private int runsScored;

    private int wicketsLost;

    private int oversPlayed;

    private int target;

    private int extras;

    @OneToMany(mappedBy = "inning")
    private List<DeliveryEntity> deliveries;

}
