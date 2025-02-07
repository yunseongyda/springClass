// simple black board 질의응답 게시판
package com.study.mysite.sbb.answer;

import java.time.LocalDateTime;
import java.util.Set;

import com.study.mysite.sbb.question.Question;
import com.study.mysite.sbb.user.SiteUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer { // answer entity 답변 개체(테이블)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 자동 생성, IDENTITY로 하면 1씩 자동 증가
	private Integer id;
	
	@Column(columnDefinition = "TEXT") // 글자 수 제한 없이 문자열로 넣기 
	private String content;
	
	private LocalDateTime createDate;
	
	@ManyToOne // N:1 (외래키)
	private Question question;
	
	@ManyToOne
	private SiteUser author;
	
	private LocalDateTime modifyDate;
	
	@ManyToMany
	Set<SiteUser> voter;
}
