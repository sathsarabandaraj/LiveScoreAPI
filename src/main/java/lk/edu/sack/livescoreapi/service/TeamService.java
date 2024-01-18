package lk.edu.sack.livescoreapi.service;

import lk.edu.sack.livescoreapi.entity.TeamEntity;
import lk.edu.sack.livescoreapi.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepository repository;

    public TeamService(TeamRepository repository) {
        this.repository = repository;
    }

    public TeamEntity saveTeam(TeamEntity team) {
        return repository.save(team);
    }

    public List<TeamEntity> saveTeams(List<TeamEntity> teams) {
        return repository.saveAll(teams);
    }

    public List<TeamEntity> getTeams() {
        return repository.findAll();
    }

    public TeamEntity getTeamById(long teamId) {
        return repository.findById(teamId).orElse(null);
    }

    public List<TeamEntity> getTeamByName(String teamName) {
        return repository.findByTeamName(teamName);
    }

    public TeamEntity updateTeam(TeamEntity team) {
        TeamEntity existingTeam = repository.findById(team.getTeamId()).orElse(null);
        existingTeam.setTeamName(team.getTeamName());
        existingTeam.setPlayers(team.getPlayers());
        return repository.save(existingTeam);
    }

    public String deleteTeam(long teamId) {
        repository.deleteById(teamId);
        return String.format("Team %d removed", teamId);
    }
}
