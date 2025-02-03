package com.band.board.Entities.Service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.band.board.Entities.Answer;
import com.band.board.Entities.Question;
import com.band.board.Entities.Repository.AnswerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnswerService {
	private final AnswerRepository answerRepo;
	
	
	public void create(String content, Question question) {
		Answer a = new Answer();
		a.setContent(content);
		a.setCreateDate(LocalDateTime.now());
		a.setQuestion(question);
		this.answerRepo.save(a);
	}
}