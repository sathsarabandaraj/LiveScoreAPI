package lk.edu.sack.livescoreapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "player")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;

    private String firstName;

    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamEntity team;

    private String playerType;

    private String battingStyle;

    private String bowlingStyle;

    @OneToMany(mappedBy = "player")
    private List<MatchPlayerEntity> matchPlayerList;

}
