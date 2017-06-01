package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.util.*;
import com.sist.dao.*;
public class ListModel implements Model {
	
	
	/* (non-Javadoc)
	 * @see com.sist.model.Model#handlerRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 *		
	 *		   request
	 * list.do ==> DispatcherServlet
	 * 				service(request)
	 * 				==>ListModel
	 * 					handlerRequest(request)
	 * 					==>��ûó��
	 * 					==>������� ����
	 * 						request.setAttribute()
	 */	
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
		
		request.setAttribute("curpage", curpage);
				
		int totalpage=dao.boardTotalPage();
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));//���ó�¥ �ѱ��.
		request.setAttribute("msg", "�����ڰ� ������ �Խù��Դϴ�.");
		
		return "board/list.jsp";
	}

}
