package com.band.board.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.band.board.Entities.Question;
import com.band.board.Entities.Form.AnswerForm;
import com.band.board.Entities.Form.QuestionForm;
import com.band.board.Entities.Service.AnswerService;
import com.band.board.Entities.Service.QuestionService;

import jakarta.validation.Valid;


@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

  private final AnswerService answerService;
	private final QuestionService questionService;

  @GetMapping("")
  public String main(Model model, AnswerForm answerForm, QuestionForm questionForm) {
		List<Question> list = this.questionService.getList();
		model.addAttribute("questions", list);
	 	return "index";
	}
	
	@PostMapping("/create")
	public String createQuestion(Model model, @Valid QuestionForm form, BindingResult result, AnswerForm answerForm, QuestionForm questionForm) {
		this.questionService.create(form.getSubject(), form.getContent());
		return MoveToIndex();
	}
	protected String MoveToIndex() {
		return "redirect:/question";
	}
  
}
