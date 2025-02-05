package com.study.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.study.mysite.DataNotFoundException;
import com.study.mysite.sbb.user.SiteUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	
  private final QuestionRepository questionRepository;

  public List<Question> getList() {
    return this.questionRepository.findAll();
  }

  public Question getQuestion(Integer id) {
	  
    Optional<Question> question = this.questionRepository.findById(id);
    if (question.isPresent()) {
      return question.get();
    } else {
      throw new DataNotFoundException("Question not found");
    }
  }
  
  public void create(String subject, String content, SiteUser user) {
	  
	  Question q = new Question();
	  q.setSubject(subject);
	  q.setContent(content);
	  q.setCreateDate(LocalDateTime.now());
	  q.setAuthor(user);
	  this.questionRepository.save(q);
  }
}
