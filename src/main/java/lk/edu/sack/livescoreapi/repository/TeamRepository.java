package lk.edu.sack.livescoreapi.repository;

import lk.edu.sack.livescoreapi.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<TeamEntity, Long> {

    List<TeamEntity> findByTeamName(String teamName);
}
