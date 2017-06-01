package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;

public class DeleteModel implements Model {

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pwd=request.getParameter("pwd");		
		String no=request.getParameter("no");
		String page=request.getParameter("page");
		
		//DAO¿¬°á		
		boolean bCheck=BoardDAO.boardDelete(Integer.parseInt(no), pwd);
		request.setAttribute("bCheck", bCheck);
		request.setAttribute("page", page);		
		
		return "board/delete.jsp";
	}

}
