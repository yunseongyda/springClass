package com.study.mysite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.mysite.sbb.Question;
import com.study.mysite.sbb.QuestionRepository;

@SpringBootTest
class TestApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Test
	void testJpa() {
		/*
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
//		assertEquals("spring", firstSubject);
		
//		Optional : null이 와도 에러 안 냄
		Optional<Question> q = this.questionRepository.findById(13);
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
		*/
		
		
	}

}
