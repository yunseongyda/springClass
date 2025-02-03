package band.board;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.band.board.BoardApplication;
import com.band.board.Entities.Answer;
import com.band.board.Entities.Question;
import com.band.board.Entities.Repository.AnswerRepository;
import com.band.board.Entities.Repository.QuestionRepository;

@SpringBootTest(classes = BoardApplication.class)
class BoardApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Test
	void contextLoads() {
		Question q = new Question();
		q.setSubject("when is NMIXX's next comeback?");
		q.setContent("I'm so excited for NMIXX's next comeback! When is it?");
		q.setCreateDate(LocalDateTime.now());

		questionRepository.save(q);

		Answer a = new Answer();
		a.setContent("It's this March!");
		a.setCreateDate(LocalDateTime.now());
		a.setQuestion(q);
		
		answerRepository.save(a);
	}

}
