package laboratory.servlet.mvc.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import laboratory.servlet.core.bean.JsonResponseObject;
import laboratory.servlet.core.finder.UrlMapping;
import laboratory.servlet.core.view.View;
import laboratory.util.request.RequestParameter;
import laboratory.util.request.RequestUtil;

public class UncategorizedTestController {
	private static final Logger logger = LoggerFactory.getLogger(UncategorizedTestController.class);
	
	/**
	 * 유니코드 문자 전송 테스트 화면.
	 * UTF-8 인코딩 사용.
	 */
	@UrlMapping("/test/uncategorized/submission-charset/sender-test.view")
	public View drawSenderTest(HttpServletRequest request, HttpServletResponse response) {
		return new View(request);
	}
	
	@UrlMapping("/test/uncategorized/submission-charset/sender-euc-kr-test.view")
	public View drawSenderEucKrTest(HttpServletRequest request, HttpServletResponse response) {
		logger.debug(RequestUtil.getRequestParameter(request).toString());
		return new View("/test/uncategorized/submission-charset/sender-euc-kr-test");
	}
	
	@UrlMapping("/test/uncategorized/submission-charset/sender-iso-8859-1-test.view")
	public View drawSenderIso88591Test(HttpServletRequest request, HttpServletResponse response) {
		logger.debug(RequestUtil.getRequestParameter(request).toString());
		return new View(request);
	}
	
	/**
	 * 유니코드 문자 전송 결과 화면
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @author fixalot
	 */
	@UrlMapping("/test/uncategorized/submission-charset/receiver-test.view")
	public View drawReceiverTest(HttpServletRequest request, HttpServletResponse response) {
		logger.debug(RequestUtil.getRequestParameter(request).toString());
		return new View(request);
	}
	
	/**
	 * 쿼리스트링 읽기
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @author fixalot
	 * @throws IOException 
	 */
	@UrlMapping("/test/uncategorized/read-querystring.data")
	public JsonResponseObject readQuerystring(HttpServletRequest request, HttpServletResponse response) throws IOException {
		final RequestParameter params = RequestUtil.getRequestParameter(request);
		logger.debug(params.toString());
		JsonResponseObject responseJSON = new JsonResponseObject();
		responseJSON.setSuccess(true);
		responseJSON.setMessage(params.toString());
		return responseJSON;
	}
	
	/**
	 * 쿼리스트링 + 바디 읽기
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @author fixalot
	 * @throws IOException 
	 */
	@UrlMapping("/test/uncategorized/read-body.data")
	public Map<String, Object> readBody(HttpServletRequest request, HttpServletResponse response) throws IOException {
		final RequestParameter params = RequestUtil.getRequestParameter(request);
		final String body = RequestUtil.readBody(request);
		logger.debug("formal parameter: " + params.toString());
		logger.debug("payload body: " + body);
		
//		logger.debug("헤더 목록:");
//		RequestUtil.printHeaders(request);
//		logger.debug("-------------------------- 헤더 끗.");
		
//		HashMap<String, String> headersMap = RequestUtil.getHeadersMap(request);
//		logger.debug(headersMap.toString());
		
		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("success", true);
		responseMap.put("header", params.toString());
		responseMap.put("body", body.toString());
		return responseMap;
	}
	
	/**
	 * parent
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @author fixalot
	 */
	@UrlMapping("/test/uncategorized/customtag/parent-test.view")
	public View drawParentTest(HttpServletRequest request, HttpServletResponse response) {
		return new View(request);
	}
	
	/**
	 * parseNumberFromString
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @author fixalot
	 */
	@UrlMapping("/test/uncategorized/jstl/parse-number-from-string-test.view")
	public View drawParseNumberFromStringTest(HttpServletRequest request, HttpServletResponse response) {
		return new View(request);
	}
	
	@UrlMapping("/test/uncategorized/include/include-with-jsp-test.view")
	public View drawIncludeWithJspTest(HttpServletRequest request, HttpServletResponse response) {
		return new View(request);
	}
	
	@UrlMapping("/test/uncategorized/include/include-with-html-test.view")
	public View drawIncludeWithHtmlTest(HttpServletRequest request, HttpServletResponse response) {
		return new View(request);
	}
	
	@UrlMapping("/test/uncategorized/jstl/el-scope-test.view")
	public View drawElScopeTest(HttpServletRequest request, HttpServletResponse response) {
		return new View(request);
	}
	
	@UrlMapping("/test/uncategorized/jstl/jstl-test.view")
	public View drawJstlTest(HttpServletRequest request, HttpServletResponse response) {
		return new View(request);
	}
	
	@UrlMapping("/test/uncategorized/jstl/el-operator-test.view")
	public View drawElOperatorTest(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("longZero", 0L);
		request.setAttribute("longOne", 1L);
		request.setAttribute("longHundred", 100L);
		request.setAttribute("mustBeNull", null);
		HashMap<String, Long> map = new HashMap<String, Long>();
		map.put("longThousand", 1000L);
		request.setAttribute("map", map);
		return new View(request);
	}
	
	@UrlMapping("/test/uncategorized/scope/test-set-attributes.data")
	public JsonResponseObject testSetAttributes(HttpServletRequest request, HttpServletResponse response) {
		JsonResponseObject json = new JsonResponseObject();
		
//		request.setAttribute("a", 1);
		request.setAttribute("b", 2);
		request.getSession().setAttribute("c", 3);
		request.getSession().getServletContext().setAttribute("d", 4);
		
		json.setSuccess(true);
		return json;
	}
	
	@UrlMapping("/test/uncategorized/what-is-payload-body-test.view")
	public View drawWhatIsPayloadBodyTest(HttpServletRequest request, HttpServletResponse response) {
		return new View(request);
	}
	
	@UrlMapping("/test/uncategorized/session-invalidate-test.view")
	public View drawSessionInvalidateTest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		logger.debug("session id: {}", session.getId());
		
		session.setAttribute("a", 123);
		int a = (int) session.getAttribute("a");
		logger.debug(String.valueOf(a == 123));
		
		session.invalidate(); // 세션 무효화
		
		// 아이디는 아직 그대로
		logger.debug("session id after invalidate: {}", session.getId());
		
		// invalidate() 호출 후에는 set이나 get을 할 수 없음.
//		ss.setAttribute("b", 456); // IllegalStateException: setAttribute: Session has already been invalidated
//		ss.getAttribute("b"); // IllegalStateException: getAttribute: Session already invalidated

		return new View(request);
	}
	
	@UrlMapping("/test/uncategorized/response-not-found-error-test.view")
	public void drawResponseNotFoundErrorTest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8"); // 얘는 왜 안해주면 ISO-8859-1로 인식하는지 모르겠구만. 메타 태그 있는디...
		response.sendError(404);
	}
	
	@UrlMapping("/test/uncategorized/make-some-error-test.view")
	public View drawMakeSomeErrorTest(HttpServletRequest request, HttpServletResponse response) {
		@SuppressWarnings("unused")
		int nan = 1 / 0;
		return null; 
	}
	
	@UrlMapping("/test/uncategorized/test-reponse-character-set.data")
	public void testReponseCharacterSet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.debug(System.getProperty("file.encoding"));
	
		/**
		 * response의 케릭터셋을 지정하지 않는 경우 응답의 케릭터셋은 요청과 같으며,
		 * 브라우저의 기본 요청 케릭터셋은 ISO-8859-1 일껄? (...)
		 */
		
		// response.setCharacterEncoding()을 호출하지 않으면 요청과 같은 케릭터셋으로 응답 문자가 인코딩된다.
		response.setCharacterEncoding("utf-8");
		
		// Content-type을 지정하지 않으면 브라우저 지 맘대로 케릭터셋을 지정함.
		response.setContentType("text/html; charset=utf-8");
		
		/*
		 * Content-type 지정은 매우 중요한데, 요청 시 전달하는 form data나 payload의 인코딩 케릭터셋은 페이지의 케릭터셋을 따른다. 
		 * 가령 응답헤더에 'Content-Type: text/html;charset=euc-kr'가 있는 페이지에선 
		 * '다다다'라는 한글을 form data로 전달할 때 euc-kr 케릭터셋인 '%B4%D9%B4%D9%B4%D9'으로 바뀐다.
		 * 정황상 브라우저가 케릭터셋을 결정할 때 HTML의 meta 태그보다 응답 헤더를 우선시 한다고 추정할 수 있다.
		 */
		
		PrintWriter writer = response.getWriter();
		writer.write("a한글a");
		writer.close();
	}
}