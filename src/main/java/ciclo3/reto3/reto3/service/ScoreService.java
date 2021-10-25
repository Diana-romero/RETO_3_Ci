/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3.reto3.reto3.service;

import ciclo3.reto3.reto3.model.Score;
import ciclo3.reto3.reto3.repositor.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diana Romero
 */
@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.getAll();

    }

    public Optional<Score> getScore(int idScore) {
        return scoreRepository.getScore(idScore);
    }

    public Score save(Score score) {
        if (score.getId() == null) {
            return scoreRepository.save(score);
        } else {
            Optional<Score> caux = scoreRepository.getScore(score.getId());
            if (caux.isEmpty()) {
                return scoreRepository.save(score);
            } else {
                return score;
            }
        }
    }

    public Score update(Score score) {
        if (score.getId() != null) {
            Optional<Score> scaux = scoreRepository.getScore(score.getId());
            if (!scaux.isEmpty()) {
                if (score.getQualification() != null) {
                    scaux.get().setQualification(score.getQualification());
                }
                if (score.getMessage() != null) {
                    scaux.get().setMessage(score.getMessage());
                }
            } else {
                return score;
            }
        }
        return null;
    }
}
