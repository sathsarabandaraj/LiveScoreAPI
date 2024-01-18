package lk.edu.sack.livescoreapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "match_official")
public class MatchOfficialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long officialId;

    private String firstName;

    private String lastName;

    private String role;

}
