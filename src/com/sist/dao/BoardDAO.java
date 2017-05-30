package com.sist.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.util.ArrayList;
//�ν��Ͻ��� �ʱ�ȭ �� {}
/**
 * @author user
 *	ibatis(opensource) / mybatis(google)
 */
import java.util.List;
import java.util.Map;
public class BoardDAO {
	
	private static SqlSessionFactory ssf;
	static{//�ʱ�ȭ ��� 
		try {
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
					
		} catch (Exception e) {
			System.out.println("�ʱ�ȭ��Ͽ���"+e.getMessage());
		}
		
	}
	
	public static List<BoardVO> boardListData(Map map){
		List<BoardVO> list=new ArrayList<BoardVO>();
		SqlSession session=null;
		
		try {
			session=ssf.openSession();
			list=session.selectList("boardListData", map);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			session.close();
		}
		
		return list;
	}
	
}
