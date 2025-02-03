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

	// ResponseBody는 html파일에 뭔가 띄우는 거
	// 그냥 GetMapping()만 하면 return하는 페이지로 가짐
	// 그냥 주소 뒤에 / 하면 index로 가지는데 GetMapping에 /만 넣고 return을 main을 주면 index 페이지(기본)가
	// main 페이지가 됨
	@GetMapping("/main")
	public String index() {
		return "main";
	}

	/*
	 * @GetMapping("/") public String root() { // return "redirect:/question/list";
	 * return "index"; }
	 */
}
