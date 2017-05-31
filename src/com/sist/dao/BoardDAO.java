package com.sist.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.util.ArrayList;
//인스턴스의 초기화 블럭 {}
/**
 * @author user
 *	ibatis(opensource) / mybatis(google)
 */
import java.util.List;
import java.util.Map;
public class BoardDAO {
	
	private static SqlSessionFactory ssf;
	static{//초기화 블록 
		try {
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
					
		} catch (Exception e) {
			System.out.println("초기화블록에서"+e.getMessage());
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
	
	
	//총페이지
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
	
	//내용보기
	public static BoardVO boardContentData(int no) {
		BoardVO vo=new BoardVO();
		SqlSession session=null;
		try {
			session=ssf.openSession();
			session.update("boardHitIncrement", no);//먼저 조회수 증가
			session.commit();
			
			vo=session.selectOne("boardContentData", no);
			
		} catch (Exception e) {
			System.out.println("boardContentData : "+e.getMessage());
		} finally {
			session.close();
		}		
		
		return vo;
	}
	
	//새글
	public static void boardInsert(BoardVO vo) {//static으로 줘야 메모리 할당 없이 바로 쓸 수 있다.
		SqlSession session=null;
		
		try {
			session=ssf.openSession(true);//true하면 autocommit이 된다. session.commit()해도된다.
			session.insert("boardInsert", vo);
			
		} catch (Exception e) {
			System.out.println("boardInsert:"+e.getMessage());
		} finally {
			session.close();
		}
	}
	
	//답변
	public static void replyInsert(int pno, BoardVO vo) {
		//1. pno => gi, gs, gt
		//2. sql(*****)
		//3. insert
		//4. depth 증가
		
		/*             			gi	gs	gt
		 * aaaa					1	0	0
		 *  =>bbbbb				1	1	1
		 * 	 =>ccccc			1	2	2
		 *  =>ddddd				1	1	1   
		 * */
		
		/*             			gi	gs	gt
		 * aaaa					1	0	0
		 *  =>ddddd				1	1	1   최신 댓글을 가장 위로 gs max이용하면 가장 밑으로 가게 한다. 나머지 gs1씩증가하면 가장위로 올라간다.	
		 *  =>bbbbb				1	2	1
		 *  	=>ccccc			1	3	2
		 * */
	
		SqlSession session=null;				
		try {
			session=ssf.openSession(); //맨마지막에 commit을 해야 한다.
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
	
	//수정
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
	
	//삭제
	
	//찾기
	
}
