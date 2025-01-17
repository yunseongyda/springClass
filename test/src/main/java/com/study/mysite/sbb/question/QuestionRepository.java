package com.study.mysite.sbb.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
	// 원래 JpaRepo에는 findBySubject는 없는데 걍 이렇게 쓰면 Spring이 알아서 만들어줌
	// 매개변수에는 열 이름
	Question findBySubject(String subject);
	Question findBySubjectAndContent(String subject, String content);
	List<Question> findBySubjectLike(String subject);
}
