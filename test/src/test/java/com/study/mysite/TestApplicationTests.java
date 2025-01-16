package com.study.mysite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

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
		assertEquals("spring", firstSubject);
	}

}
