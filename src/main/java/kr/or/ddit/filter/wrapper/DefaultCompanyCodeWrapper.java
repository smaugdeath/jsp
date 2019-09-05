package kr.or.ddit.filter.wrapper;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class DefaultCompanyCodeWrapper extends HttpServletRequestWrapper{

	private Map<String, String[]> requestMap;
	
	public DefaultCompanyCodeWrapper(HttpServletRequest request) {
		super(request);
		
		requestMap = new HashMap<String, String[]>(request.getParameterMap());
		
		String unt_cd = request.getParameter("unt_cd");
		//unt_cd 파라미터가 null이거나  "" 이면 기본값 DDIT로 파라미터 값이 설정되게끔 수정
		
		if(unt_cd == null || unt_cd.contentEquals("")) {
			unt_cd="DDIT";
		}
		
		//unt_cd = unt_cd == null ? "DDIT" : unt_cd;
		requestMap.put("unt_cd", new String[] {unt_cd});
		
		
	}
	
	//parameter 관련 메소드를 재정의
	// String getParameterValues(String parameter)
	// String[] getParameterValues(String parameter)
	// Enumeration<String> getParameterNames()
	// Map<String, String[]> getParameterMap()
	
	@Override
	public String getParameter(String name) {
		String[] values = requestMap.get(name);
		
		if(values == null)
			return null;
		else
			return values.length > 0 ? values[0] : null;
				
	}
	
	@Override
	public String[] getParameterValues(String name) {
		return requestMap.get(name);
	}
	
	@Override
	public Enumeration<String> getParameterNames() {
		return Collections.enumeration(requestMap.keySet());
	}
	

}
