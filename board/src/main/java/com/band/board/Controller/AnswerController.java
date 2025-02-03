package com.band.board.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.band.board.Entities.Question;
import com.band.board.Entities.Form.AnswerForm;
import com.band.board.Entities.Form.QuestionForm;
import com.band.board.Entities.Service.AnswerService;
import com.band.board.Entities.Service.QuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerController {
private final AnswerService answerService;
	private final QuestionService questionService;
	
	@PostMapping("/create/{q_id}")
	public String craeteAnswer(Model model,
			@PathVariable("q_id") Integer id,
			@Valid AnswerForm form, BindingResult result, AnswerForm answerForm, QuestionForm questionForm) {
		if (result.hasErrors()) {
			return MoveToIndex(model);
		}
		else {
			Question q = this.questionService.getQuestion(id);
			this.answerService.create(form.getContent(), q);
			return MoveToIndex(model);
		}
	}
	
	protected String MoveToIndex(Model model) {
		List<Question> list = this.questionService.getList();
		model.addAttribute("questions", list);
		return "redirect:/question";
	}
}
