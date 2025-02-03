package com.band.board.Entities.Form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {
	@NotBlank(message = "빈 문자열은 허용되지 않습니다.")
	private String content;
}