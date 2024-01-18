package lk.edu.sack.livescoreapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "delivery")
public class DeliveryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId;

    @ManyToOne
    @JoinColumn(name = "inning_id")
    private InningEntity inning;

    private int overNumber;

    private int ballNumber;

    @ManyToOne
    @JoinColumn(name = "batsman_id")
    private PlayerEntity batsman;

    @ManyToOne
    @JoinColumn(name = "bowler_id")
    private PlayerEntity bowler;

    @ManyToOne
    @JoinColumn(name = "fielder_id")
    private PlayerEntity fielder;

    private int runsScored;

    private boolean isWicket;

    private boolean isNoBall;

    private boolean isWide;

    private boolean isBye;

    private boolean isLegBye;

    private boolean isFreeHit;

    private int ballSpeed;

    private int extras;
}
