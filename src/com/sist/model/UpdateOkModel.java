package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;
import com.sist.dao.BoardVO;

public class UpdateOkModel implements Model {

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		String pwd=request.getParameter("pwd");
		String no=request.getParameter("no");
		String page=request.getParameter("page");
		
		BoardVO vo=new BoardVO();
		vo.setNo(Integer.parseInt(no));
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		//DAO����
		
		boolean bCheck=BoardDAO.boardUpdate(vo);
		request.setAttribute("bCheck", bCheck);
		request.setAttribute("no", no);
		request.setAttribute("page", page);
		
		return "board/update_ok.jsp"; //��й�ȣ Ȯ���ؾ� �ϹǷ� .do�� �ٷ� �̵�x
	}

}
