package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReplyModel implements Model {

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no=request.getParameter("no");
		String page=request.getParameter("page");
		
		request.setAttribute("no", no);
		request.setAttribute("page", page);
		
		return "board/reply.jsp";
	}

}
