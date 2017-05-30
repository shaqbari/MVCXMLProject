package com.sist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.Model;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HandlerMapping hm;
	
	public void init(ServletConfig config) throws ServletException {
		//config => web.xml제어
		String path=config.getInitParameter("xmlPath");//공백주면 여러개 읽을수도 있다.
		hm=new HandlerMapping(path);
		
		//System.out.println(path);
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//http://localhost:9090/MVCXMLProject/list.do
			//                     **********************(URI)
			//					   ***************(contextPath)	
			String cmd=request.getRequestURI();
			cmd=cmd.substring(request.getContextPath().length()+1, cmd.lastIndexOf("."));
			System.out.println(cmd);
			Model model=hm.getBean(cmd);
			//요청 처리 클래스 찾기
			String jsp=model.handlerRequest(request, response);
			// 요청에 대한 처리 ==> 결과값은 request에 담는다.
			
			//포워딩
			RequestDispatcher rd=request.getRequestDispatcher(jsp);
			rd.forward(request, response);
			
			
		} catch (Exception e) {
			System.out.println("service에서 "+e.getMessage());
		}
	}

}
