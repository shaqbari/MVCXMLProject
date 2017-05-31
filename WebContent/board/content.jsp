<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="table.css">
	<script src="http://code.jquery.com/jquery.js"></script>
	<script>
		/*
			window.onload=function(){}
		*/
		/* var i=0;
		$(function(){
			$('#a_del').click(function(){
				if(i==0){
					$('#del').show();
					i=1;					
				}else{
					$('#del').hide();
					i=0;
				}
				
			});
			
		}); */
		var delFlag=false;
		$(function(){
			$('#a_del').click(function(){
				delFlag==false?$('#del').show():$('#del').hide();				
				delFlag=!delFlag;
			});			
		});
		
	</script>
</head>
<body>
	<center>
		<h3>내용보기</h3>
		<table id="table_content" width=500>
			<tr>
				<th width=20%>번호</th>
				<td width=30% align=center>${vo.no }</td>
				<th width=20%>작성일</th>
				<td width=30% align=center>${vo.day }</td>
			</tr>
			<tr>
				<th width=20%>이름</th>
				<td width=30% align=center>${vo.name}</td>
				<th width=20%>조회수</th>
				<td width=30% align=center>${vo.hit}</td>
			</tr>
			<tr>
				<th width=20%>제목</th>
				<td colspan="3" align=left>${vo.subject }</td>
			</tr>
			<tr>				
				<td colspan="4" align=left valign="top" height=200>${vo.content }</td>
			</tr>
		</table>
		<table id="table_content" width=500>
			<tr>
				<td align=right>
					<a href="reply.do?no=${vo.no}&page=${page}">답변</a>&nbsp;
					<a href="update.do?no=${vo.no}&page=${page}">수정</a>&nbsp;
					<a href="#" id="a_del">삭제</a>&nbsp;<!-- 삭제버튼 입력하면 비밀번호 입력하는 란 뜨게 한다. -->
					<a href="list.do?page=${page }">목록</a>&nbsp;
				</td>
			</tr>
			<tr id="del" style="display:none">
				<td align=right>
					비밀번호 : <input type="password" name="pwd" size=10 />
					<input type="button" value="삭제" />
				</td>
			</tr>
		</table>
	</center>
</body>
</html>