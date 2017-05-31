package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;
import com.sist.dao.BoardVO;

public class UpdateModel implements Model {

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no=request.getParameter("no");
		String page=request.getParameter("page");
		
		BoardVO vo=BoardDAO.updateData(Integer.parseInt(no));
		request.setAttribute("vo", vo);
		request.setAttribute("page", page);
		
		return "/board/update.jsp";
	}

}
