package com.study.mysite;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HiSpring {
	
	@GetMapping("/hiSpring")
	@ResponseBody
	public String HiSpring() {
		return "hello I am junior in SWJB high school. I feel the Spring is good";
	}
}
