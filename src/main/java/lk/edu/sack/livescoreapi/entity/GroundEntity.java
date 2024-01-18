package lk.edu.sack.livescoreapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ground")
public class GroundEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groundId;

    private String groundName;

    private String location;

    private int capacity;

    private int establishedYear;

    @ManyToOne
    @JoinColumn(name = "home_team_id")
    private TeamEntity homeTeam;

    private String pitchEnds;

}
