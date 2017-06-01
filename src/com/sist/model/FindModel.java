package com.sist.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;
import com.sist.dao.BoardVO;

public class FindModel implements Model {

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String fs=request.getParameter("fs");
		String ss=request.getParameter("ss");
		
		Map map=new HashMap();
		map.put("ss", ss);
		map.put("fs", fs);
		
		List<BoardVO> list=BoardDAO.boardFindData(map);
		request.setAttribute("list", list);
		request.setAttribute("length", list.size());
		//원래는 count를 써서 가져와야 한다.
				
		return "board/find.jsp";
	}

}
