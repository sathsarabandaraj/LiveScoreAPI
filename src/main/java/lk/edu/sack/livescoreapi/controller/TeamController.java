package lk.edu.sack.livescoreapi.controller;

import lk.edu.sack.livescoreapi.entity.TeamEntity;
import lk.edu.sack.livescoreapi.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/create")
    public ResponseEntity<TeamEntity> createTeam(@RequestBody TeamEntity team) {
        TeamEntity createdTeam = teamService.saveTeam(team);
        return new ResponseEntity<>(createdTeam, HttpStatus.CREATED);
    }

    @PostMapping("/create-multiple")
    public ResponseEntity<List<TeamEntity>> createTeams(@RequestBody List<TeamEntity> teams) {
        List<TeamEntity> createdTeams = teamService.saveTeams(teams);
        return new ResponseEntity<>(createdTeams, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TeamEntity>> getAllTeams() {
        List<TeamEntity> teams = teamService.getTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @GetMapping("/get/{teamId}")
    public ResponseEntity<TeamEntity> getTeamById(@PathVariable long teamId) {
        TeamEntity team = teamService.getTeamById(teamId);
        if (team != null) {
            return new ResponseEntity<>(team, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getByName/{teamName}")
    public ResponseEntity<List<TeamEntity>> getTeamByName(@PathVariable String teamName) {
        List<TeamEntity> teams = teamService.getTeamByName(teamName);
        if (teams != null) {
            return new ResponseEntity<>(teams, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<TeamEntity> updateTeam(@RequestBody TeamEntity team) {
        TeamEntity updatedTeam = teamService.updateTeam(team);
        return new ResponseEntity<>(updatedTeam, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{teamId}")
    public ResponseEntity<String> deleteTeam(@PathVariable long teamId) {
        String response = teamService.deleteTeam(teamId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
