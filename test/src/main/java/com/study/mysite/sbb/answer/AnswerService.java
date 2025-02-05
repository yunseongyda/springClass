package com.study.mysite.sbb.answer;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

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
}
