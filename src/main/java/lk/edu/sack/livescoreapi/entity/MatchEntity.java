package lk.edu.sack.livescoreapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "`match`")
public class MatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchId;

    @ManyToOne
    @JoinColumn(name = "team1_id")
    private TeamEntity team1;

    @ManyToOne
    @JoinColumn(name = "team2_id")
    private TeamEntity team2;

    @Temporal(TemporalType.DATE)
    private Date matchDate;

    @ManyToOne
    @JoinColumn(name = "venue")
    private GroundEntity venue;

    private String status;

    private String format;

    @ManyToOne
    @JoinColumn(name = "result_id")
    private ResultEntity result;

    @ManyToOne
    @JoinColumn(name = "umpire1_id")
    private MatchOfficialEntity umpire1;

    @ManyToOne
    @JoinColumn(name = "umpire2_id")
    private MatchOfficialEntity umpire2;

    @ManyToOne
    @JoinColumn(name = "toss_winner_id")
    private TeamEntity tossWinner;

    private String tossDecision;

    @OneToMany(mappedBy = "match")
    private List<InningEntity> innings;

}
