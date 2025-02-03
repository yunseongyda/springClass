package com.study.mysite.sbb.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
	
	@Size(min=3, max=25)
	@NotBlank(message="username is necesarry")
	private String username;
	
	@NotBlank(message="email is necesarry")
	@Email
	private String email;
	
	@NotBlank(message="password is necesarry")
	private String password1;
	
	@NotBlank(message="you should check your password")
	private String password2;
	
}
