package com.study.mysite;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	@ResponseBody
	public String helle() {
		return "hihihihihi";
	}
	
	@GetMapping("/main")
	public String index() {
		return "index";
	}
	
}
