package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;
public class ListModel implements Model {
	
	
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String page=request.getParameter("page");
		if (page==null) {
			page="1";
			
		}
		int curpage=Integer.parseInt(page);
		int rowSize=10;
		int start=(curpage*rowSize)-(rowSize-1);//1
		int end=curpage*rowSize;//10
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		BoardDAO dao=new BoardDAO();
		List<BoardVO> list=dao.boardListData(map);
		request.setAttribute("list", list);
		
		return "board/list.jsp";
	}

}
