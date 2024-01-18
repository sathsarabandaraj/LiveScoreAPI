package lk.edu.sack.livescoreapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "match_player")
public class MatchPlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_player_id")
    private Long matchPlayerId;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private MatchEntity match;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private PlayerEntity player;

    @Column(name = "role")
    private String role;

    @Column(name = "batting_position")
    private Integer battingPosition;

    @Column(name = "bowling_order")
    private Integer bowlingOrder;

}
