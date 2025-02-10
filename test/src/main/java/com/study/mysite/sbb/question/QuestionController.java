package com.study.mysite.sbb.question;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.study.mysite.sbb.user.SiteUser;
import com.study.mysite.sbb.user.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/question") // 이 컨트롤러의 모든 매핑은 /question으로 시작
@RequiredArgsConstructor
@Controller
public class QuestionController {
	
	private final QuestionRepository questionRepository;
	private final QuestionService questionService;
	private final UserService userService;
	
	// 게시판 리스트로 이동
	@GetMapping("/list")
	public String getQuestionList(Model model, @RequestParam(value ="page", defaultValue = "0") int page, @RequestParam(value = "kw" , defaultValue = "")String kw){
	Page<Question> paging = this.questionService.getList(page, kw);
	model.addAttribute("kw", kw);
	model.addAttribute("page", page);
	model.addAttribute("paging", paging);
	return "question_list";
	}

	// 상세페이지로 이동
	@GetMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) { // @PathVariable : url에 있는 값을 가져옴
		Question question = this.questionService.getQuestion(id);					// Integer타입의 id 컬럼값과 연결하여 @PathVariable("변수명")으로 변경한다. => 사용자 요청 url의 변수명으로 사용 가능
		model.addAttribute("question", question);
		return "question_detail";
	}

	/*
	 * // 질문 등록 페이지로 이동
	 * 
	 * @GetMapping("/form") public String create() { return "question_form"; }
	 */
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/form")
	public String createQuestion(QuestionForm questionForm) {
		return "question_form";
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/form")
	public String createQuestion(@Valid QuestionForm questionForm,  BindingResult bindingResult, Principal principal) {
		
		if (bindingResult.hasErrors()) return "question_form";
		
		SiteUser siteUser = this.userService.getUser(principal.getName());
		
		this.questionService.create(questionForm.getSubject(), questionForm.getContent(), siteUser);
		return "redirect:/question/list";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/modify/{id}")
	public String modifyQuestion(QuestionForm questionForm, Principal principal, @PathVariable("id") Integer id) {
		
		Question question = this.questionService.getQuestion(id);
		if (!question.getAuthor().getUsername().equals(principal.getName())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You don't have permission for Edit.");
		
		questionForm.setSubject(question.getSubject());
		questionForm.setContent(question.getContent());
		return "question_form";
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/modify/{id}")
	public String modifyQuestion(@Valid QuestionForm questionForm, BindingResult bindingResult, Principal principal, @PathVariable("id") Integer id) {
		
		if (bindingResult.hasErrors()) return "question_form";
		
		Question question = this.questionService.getQuestion(id);
		if (!question.getAuthor().getUsername().equals(principal.getName())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You don't have permission for Edit.");
		
		this.questionService.modify(question, questionForm.getSubject(), questionForm.getContent());
		
		return String.format("redirect:/question/detail/%s", id);
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/delete/{id}")
	public String deletePost(Principal principal, @PathVariable("id") Integer id) {
		
		Question question = this.questionService.getQuestion(id);
		if (!question.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You don't have permission for delete");
		}
		this.questionService.delete(question);
		
		return "redirect:/question/list";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("vote/{id}")
	public String votePost(Principal principal, @PathVariable("id") Integer id) {
		
		Question question = this.questionService.getQuestion(id);
		SiteUser siteUser = this.userService.getUser(principal.getName());
		this.questionService.vote(question, siteUser);
		
		return String.format("redirect:/question/detail/%s", id);
	}
}
