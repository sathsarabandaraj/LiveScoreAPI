package lk.edu.sack.livescoreapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "toss")
public class TossEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tossId;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private MatchEntity match;

    @ManyToOne
    @JoinColumn(name = "toss_winner_id")
    private TeamEntity tossWinner;

    private String tossDecision;

}
