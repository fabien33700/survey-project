package imie.survey.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import imie.survey.exceptions.errors.UnauthorizedException;
import imie.survey.exceptions.handler.ExceptionResponse;

@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName("SurveyApp");
		super.afterPropertiesSet();
	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        
        PrintWriter writer = response.getWriter();
        writer.print(getExceptionAsJson(authException));
	}

	private String getExceptionAsJson(AuthenticationException authEx) 
			throws JsonProcessingException {
		final ObjectMapper mapper = new ObjectMapper();
		
		UnauthorizedException ex = new UnauthorizedException(authEx);
		return mapper.writeValueAsString(new ExceptionResponse<>(ex));
	}
}
