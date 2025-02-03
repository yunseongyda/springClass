package com.band.board.Entities.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.band.board.Entities.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

}
