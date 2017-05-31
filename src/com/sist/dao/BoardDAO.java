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
	
	
	//��������
	public int boardTotalPage() {
		int total=0;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			total=session.selectOne("boardTotalPage");
			
		} catch (Exception e) {
			System.out.println("boardTotalPage : "+e.getMessage());
		} finally {
			session.close();
		}
		
		return total;
	}
	
	//���뺸��
	public static BoardVO boardContentData(int no) {
		BoardVO vo=new BoardVO();
		SqlSession session=null;
		try {
			session=ssf.openSession();
			session.update("boardHitIncrement", no);//���� ��ȸ�� ����
			session.commit();
			
			vo=session.selectOne("boardContentData", no);
			
		} catch (Exception e) {
			System.out.println("boardContentData : "+e.getMessage());
		} finally {
			session.close();
		}		
		
		return vo;
	}
	
	//����
	public static void boardInsert(BoardVO vo) {//static���� ��� �޸� �Ҵ� ���� �ٷ� �� �� �ִ�.
		SqlSession session=null;
		
		try {
			session=ssf.openSession(true);//true�ϸ� autocommit�� �ȴ�. session.commit()�ص��ȴ�.
			session.insert("boardInsert", vo);
			
		} catch (Exception e) {
			System.out.println("boardInsert:"+e.getMessage());
		} finally {
			session.close();
		}
	}
	
	//�亯
	public static void replyInsert(int pno, BoardVO vo) {
		//1. pno => gi, gs, gt
		//2. sql(*****)
		//3. insert
		//4. depth ����
		
		/*             			gi	gs	gt
		 * aaaa					1	0	0
		 *  =>bbbbb				1	1	1
		 * 	 =>ccccc			1	2	2
		 *  =>ddddd				1	1	1   
		 * */
		
		/*             			gi	gs	gt
		 * aaaa					1	0	0
		 *  =>ddddd				1	1	1   �ֽ� ����� ���� ���� gs max�̿��ϸ� ���� ������ ���� �Ѵ�. ������ gs1�������ϸ� �������� �ö󰣴�.	
		 *  =>bbbbb				1	2	1
		 *  	=>ccccc			1	3	2
		 * */
	
		SqlSession session=null;				
		try {
			session=ssf.openSession(); //�Ǹ������� commit�� �ؾ� �Ѵ�.
			BoardVO pvo=session.selectOne("boardGroupInfoData", pno);
			
			session.update("boardGroupStepIncrement", pvo);
			
			vo.setGroup_id(pvo.getGroup_id());
			vo.setGroup_step(pvo.getGroup_step()+1);
			vo.setGroup_tab(pvo.getGroup_tab()+1);
			vo.setRoot(pno);
			session.insert("boardReplyInsert", vo);
			
			session.update("baordDepthIncrement", pno);
			
			session.commit();
			
		} catch (Exception e) {
			System.out.println("replyInsert"+e.getMessage());
		} finally {
			session.close();
		}
	
	}
	
	//����
	public static BoardVO updateData(int no) {
		BoardVO vo=new BoardVO();
		SqlSession session=null;
		try {
			session=ssf.openSession();
			vo=session.selectOne("boardContentData", no);
			
		} catch (Exception e) {
			System.out.println("boardContentData : "+e.getMessage());
		} finally {
			session.close();
		}		
		
		return vo;
	}
	public static boolean boardUpdate(BoardVO vo) {
		boolean bCheck=false;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			String db_pwd=session.selectOne("boardGetPwd", vo.getNo());
			
			if (db_pwd.equals(vo.getPwd())) {
				bCheck=true;
				session.update("boardUpdate", vo);
				session.commit();
			
			}			
			
		} catch (Exception e) {
			System.out.println("boardUpdate() : "+e.getMessage());
		} finally {
			session.close();
		}
		
		return bCheck;
	}
	
	//����
	
	//ã��
	
}
