package lk.edu.sack.livescoreapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "extras")
public class ExtrasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long extrasId;

    @ManyToOne
    @JoinColumn(name = "inning_id")
    private InningEntity inning;

    private int byes;

    private int legByes;

    private int wides;

    private int noBalls;

    private int penaltyRuns;

}
