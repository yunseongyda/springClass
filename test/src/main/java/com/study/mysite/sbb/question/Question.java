// simple black board 질의응답 게시판
package com.study.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;

import com.study.mysite.sbb.answer.Answer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question { // question entity 질문 개체(테이블)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 자동 생성, IDENTITY로 하면 1씩 자동 증가
	private Integer id;
	
	@Column(length=40) // 열 세부 설정: 길이 40자 제한
	private String subject;
	
	@Column(columnDefinition = "TEXT") // 글자 수 제한 없이 문자열로 넣기 
	private String content;
	
	private LocalDateTime createDate;
	
	@OneToMany(mappedBy="question", cascade=CascadeType.REMOVE) // 1:N (외래키), question에 의해 참조됨, 질문이 지워지면 cascade해서 답변도 지움
	private List<Answer> answerList;
}