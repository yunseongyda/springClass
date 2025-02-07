package com.study.mysite.sbb.answer;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.study.mysite.DataNotFoundException;
import com.study.mysite.sbb.question.Question;
import com.study.mysite.sbb.user.SiteUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {
  private final AnswerRepository answerRepository;

  public void create(String content, Question question, SiteUser author) {
    Answer answer = new Answer();
    answer.setContent(content);
    answer.setCreateDate(LocalDateTime.now());
    answer.setQuestion(question);
    answer.setAuthor(author);
    this.answerRepository.save(answer);
  }
  
  // 답변 수정 전에 답변 조회 먼저
  public Answer getAnswer(Integer id) {
	  
	  Optional<Answer> answer = this.answerRepository.findById(id);
	  
	  if (answer.isPresent()) return answer.get();
	  else throw new DataNotFoundException("Answer not found");
  }
  
  public void modify(Answer a, String content) {
	  
	  a.setContent(content);
	  a.setModifyDate(LocalDateTime.now());
	  this.answerRepository.save(a);
  }
  
  public void delete(Answer answer) {
	  this.answerRepository.delete(answer);
  }
}
