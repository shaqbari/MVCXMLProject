package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertModel implements Model {

	/* (non-Javadoc)
	 * @see com.sist.model.Model#handlerRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 *	
	 *	jsp => .do��û
	 *	~model
	 *	�� ==> jsp
	 *	�����Ͱ� ==> DAO ==> jsp
	 *
	 */
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//return redirect:list.to spring������  startsWith()�޼ҵ�� redirect forward ����,
		//�˻��Ҷ��� autocomplete��ɱ����Ҷ� �� �޼ҵ� ���� �̿� endsWith()�� ���� �̿��Ѵ�.
		return "board/insert.jsp";
	}

}
