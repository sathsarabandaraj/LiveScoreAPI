package lk.edu.sack.livescoreapi.service;

import lk.edu.sack.livescoreapi.entity.TossEntity;
import lk.edu.sack.livescoreapi.repository.TossRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TossService {
    private final TossRepository repository;

    public TossService(TossRepository repository) {
        this.repository = repository;
    }

    public TossEntity saveToss(TossEntity toss) {
        return repository.save(toss);
    }

    public List<TossEntity> getTosses() {
        return repository.findAll();
    }

    public TossEntity getTossById(long tossId) {
        return repository.findById(tossId).orElse(null);
    }

    public TossEntity updateToss(TossEntity toss) {
        TossEntity existingToss = repository.findById(toss.getTossId()).orElse(null);
        existingToss.setTossDecision(toss.getTossDecision());
        existingToss.setTossWinner(toss.getTossWinner());
        return repository.save(existingToss);
    }

    public String deleteToss(long tossId) {
        repository.deleteById(tossId);
        return String.format("Toss %d removed", tossId);
    }
}
