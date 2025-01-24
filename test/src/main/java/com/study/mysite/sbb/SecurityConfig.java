package com.study.mysite.sbb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	// SecurityFilterChain : 모든 요청에 필터 써서 url별로 특별한 설정 가능
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests((autorizeHttpRequests)->autorizeHttpRequests.requestMatchers(new AntPathRequestMatcher("/**")) 
		.permitAll())	// AntPathRequestMatcher 매개변수로 들어온 url 다 허용
		.csrf((csrf)->csrf.ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**"))) // h2-console은 내 페이지가 아니라서 csrf 공격을 방어하는 로직을 무시
		.headers((headers)->headers.addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))); // Deny로 하면 내 웹을 가져올 때(IFrame) 못 가져오게 하는데 SAMEORIGIN으로 하면 걍 보여줌
		// 인증되지 않은 모든 페이지의 요청을 허락한다.
		return http.build();
	}
}
