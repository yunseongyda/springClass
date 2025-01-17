package com.study.mysite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.study.mysite.sbb.answer.Answer;
import com.study.mysite.sbb.answer.AnswerRepository;
import com.study.mysite.sbb.question.Question;
import com.study.mysite.sbb.question.QuestionRepository;

@SpringBootTest
class TestApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Transactional
	@Test
	void testJpa() {
		/*
	@Test
	void testJpa() {
		Question q1 = new Question();
		q1.setSubject("what is mean of name the Spring boot");
		q1.setContent("I wanna know how to use Spring boot");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);
		
		Question q2 = new Question();
		q2.setSubject("I love NMIXX");
		q2.setContent("I'm gonna cry if NMIXX disappear");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);

		Question q3 = new Question();
		q3.setSubject("What is JPA?");
		q3.setContent("how to use JPA");
		q3.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q3);
		
		List<Question> all = this.questionRepository.findAll();
//		assertEquals(5, all.size());
		
		String firstSubject = all.get(0).getSubject();
<<<<<<< HEAD
//		assertEquals("spring", firstSubject);
		
//		Optional : null이 와도 에러 안 냄
		Optional<Question> q = this.questionRepository.findById(13);
		// isPresent() : 값이 있으면 T, 없으면 F
		if (q.isPresent()) {
			Question qs = q.get();
			assertEquals("I love NMIXX", qs.getSubject());
		}
		
		// findBy- 하면 여러개가 들어오면 에러남
		Question q = this.questionRepository.findBySubject("spring"); 
//		assertEquals(4, q.getId());
		
		Question q = this.questionRepository.findBySubjectAndContent("spring", "I wanna know how to use Spring boot");
		assertEquals(4, q.getId());
		
		List<Question> qList = this.questionRepository.findBySubjectLike("%NMIXX");
		Question q = qList.get(0);
		assertEquals(7, q.getId());
		
		assertEquals(17, this.questionRepository.count());

		
		Optional<Question> q = this.questionRepository.findById(4);
		// assertTrue : 매개변수가 True라는 걸 단언
		assertTrue(q.isPresent());
		Question qs = q.get();
		// 제목 수정하기
		qs.setSubject("수정된 제목");
		this.questionRepository.save(qs);
		// 삭제하기
		this.questionRepository.delete(qs);
		assertEquals(16, this.questionRepository.count());
		
		Optional<Question> oq = this.questionRepository.findById(5);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		
		Answer a = new Answer();
		a.setContent("this is answer.");
		a.setQuestion(q);
		a.setCreateDate(LocalDateTime.now());
		this.answerRepository.save(a);
		
		// 답변 데이터로 답변 찾기
		Optional<Answer> oa = this.answerRepository.findById(1);
		assertTrue(oa.isPresent());
		Answer a = oa.get();
		assertEquals(5, a.getQuestion().getId());
		*/
		Optional<Question> oq = this.questionRepository.findById(5);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		
		List<Answer > answerList = q.getAnswerList();
		assertEquals(1, answerList.size());
		assertEquals("this is answer.", answerList.get(0).getContent());
		

	}

}
