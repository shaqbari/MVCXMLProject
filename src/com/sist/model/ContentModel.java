package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;
import com.sist.dao.BoardVO;

public class ContentModel implements Model {

	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String no=request.getParameter("no");
		String page=request.getParameter("page");
		//DAO연결 ==> VO
		BoardVO vo=BoardDAO.boardContentData(Integer.parseInt(no));
			
		request.setAttribute("vo", vo);
		request.setAttribute("page", page);
		//중간 내용화면만 바뀌는 경우 include위해 바뀌는 jsp도 보내줘야 한다.
		
		return "board/content.jsp";
	}

}
