package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertModel implements Model {

	/* (non-Javadoc)
	 * @see com.sist.model.Model#handlerRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 *	
	 *	jsp => .do요청
	 *	~model
	 *	폼 ==> jsp
	 *	데이터값 ==> DAO ==> jsp
	 *
	 */
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//return redirect:list.to spring에서는  startsWith()메소드로 redirect forward 구분,
		//검색할때도 autocomplete기능구현할때 이 메소드 많이 이용 endsWith()도 많이 이용한다.
		return "board/insert.jsp";
	}

}
