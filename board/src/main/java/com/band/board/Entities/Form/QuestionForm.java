package com.band.board.Entities.Form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {
	
	@NotBlank(message = "제목은 빈 문자열이 허용되지 않습니다.")
	@Size(max = 100)
	private String subject;
	
	@NotBlank(message = "내용은 빈 문자열이 허용되지 않습니다.")
	private String content;
}