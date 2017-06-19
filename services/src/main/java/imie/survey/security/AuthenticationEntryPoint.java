package imie.survey.security;

// @Component
// public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

//	@Override
//	public void afterPropertiesSet() throws Exception {
//		setRealmName("SurveyApp");
//		super.afterPropertiesSet();
//	}
//
//	@Override
//	public void commence(HttpServletRequest request, HttpServletResponse response,
//			AuthenticationException authException) throws IOException, ServletException {
//		response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        
//        PrintWriter writer = response.getWriter();
//        writer.print(getExceptionAsJson(authException));
//	}
//
//	private String getExceptionAsJson(AuthenticationException authEx) 
//			throws JsonProcessingException {
//		final ObjectMapper mapper = new ObjectMapper();
//		
//		UnauthorizedException ex = new UnauthorizedException(authEx);
//		return mapper.writeValueAsString(new ExceptionResponse<>(ex));
//	}
// }
