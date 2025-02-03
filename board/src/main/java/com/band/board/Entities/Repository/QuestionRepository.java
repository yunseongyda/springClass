package com.band.board.Entities.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.band.board.Entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
