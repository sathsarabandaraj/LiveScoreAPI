package lk.edu.sack.livescoreapi.entity;

import jakarta.persistence.*;
import lk.edu.sack.livescoreapi.enums.TossDecisionEnum;
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

    @Enumerated(EnumType.STRING)
    private TossDecisionEnum tossDecision = null;

}
