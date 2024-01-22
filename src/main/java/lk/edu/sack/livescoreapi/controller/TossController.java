package lk.edu.sack.livescoreapi.controller;

import lk.edu.sack.livescoreapi.entity.TossEntity;
import lk.edu.sack.livescoreapi.service.TossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toss")
public class TossController {

    private final TossService tossService;

    @Autowired
    public TossController(TossService tossService) {
        this.tossService = tossService;
    }

    @PostMapping("/create")
    public ResponseEntity<TossEntity> saveToss(@RequestBody TossEntity toss) {
        TossEntity createdToss = tossService.saveToss(toss);
        return new ResponseEntity<>(createdToss, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TossEntity>> getAllTosses() {
        List<TossEntity> tosses = tossService.getTosses();
        return new ResponseEntity<>(tosses, HttpStatus.OK);
    }

    @GetMapping("/get/{tossId}")
    public ResponseEntity<TossEntity> getTossById(@PathVariable long tossId) {
        TossEntity toss = tossService.getTossById(tossId);
        if (toss != null) {
            return new ResponseEntity<>(toss, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<TossEntity> updateToss(@RequestBody TossEntity toss) {
        TossEntity updatedToss = tossService.updateToss(toss);
        return new ResponseEntity<>(updatedToss, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{tossId}")
    public ResponseEntity<String> deleteToss(@PathVariable long tossId) {
        String response = tossService.deleteToss(tossId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
