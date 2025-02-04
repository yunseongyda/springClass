package com.study.mysite.sbb.user;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("/signUp")
	public String signUp(UserCreateForm userCreateForm) {
		return "signUp_form";
	}
	
	@PostMapping("/signUp")
	public String signUp(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "signUp_form";
		}
		if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
			bindingResult.rejectValue("password2", "passwordIncorrect", "The password does not match");
			return "signUp_form";
		}
		
		try {
			userService.create(userCreateForm.getUsername(), userCreateForm.getEmail(), userCreateForm.getPassword2());
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			bindingResult.reject("signupFaild", "이미 등록된 사용자입니다.");
			return "signUp_form";
		} catch (Exception e) {
			e.printStackTrace();
			bindingResult.reject("signupFaild", e.getMessage());
			return "signUp_form";
		}
		
		
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String signIn() {
		return "signIn_form";
	}
}
