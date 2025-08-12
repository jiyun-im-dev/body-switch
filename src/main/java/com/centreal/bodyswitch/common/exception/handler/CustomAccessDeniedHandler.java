package com.centreal.bodyswitch.common.exception.handler;

import com.centreal.bodyswitch.common.response.CommonResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	private final ObjectMapper objectMapper;

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
		AccessDeniedException accessDeniedException) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);

		CommonResponse<?> errorResponse = CommonResponse.of("ACCESS_DENIED", "접근 권한이 없습니다.");

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
	}
}
