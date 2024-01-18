package lk.edu.sack.livescoreapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "wicket")
public class WicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wicketId;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private DeliveryEntity delivery;

    private String dismissalType;

    @ManyToOne
    @JoinColumn(name = "player_out_id")
    private PlayerEntity playerOut;

    @ManyToOne
    @JoinColumn(name = "fielder_id")
    private PlayerEntity fielder;

    @ManyToOne
    @JoinColumn(name = "bowler_id")
    private PlayerEntity bowler;

}
