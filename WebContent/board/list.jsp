<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="table.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h3>게시판 목록</h3>
		<table id="table_content" width=700>
			<tr>
				<td><a href="insert.do">새글</a></td>				
			</tr>
		</table>
		<table id="table_content" width=700>
			<tr>
				<th width="10%">번호</th>
				<th width="45%">제목</th>
				<th width="15%">이름</th>
				<th width="20%">작성일</th>
				<th width="10%">조회수</th>				
			</tr>
			<c:forEach var="vo" items="${list}">
				<tr class="dataTr">
					<td width="10%" align=center>${vo.no}</td>
					<td width="45%" align=center>
						<c:if test="${vo.group_tab>0}"><!--답변이라면   -->
							<c:forEach var="i" begin="1" end="${vo.group_tab}">
								&nbsp;&nbsp;
							</c:forEach>
							<img src="image/icon_reply.gif" />
						</c:if>
						<c:if test="${vo.subject!=msg}">
						<a href="content.do?no=${vo.no}&page=${curpage}">${vo.subject}</a><!--보고있던 page로 돌아오기 위해 현재 page도 보내준다. -->
						</c:if>
						<c:if test="${vo.subject==msg}">
						<span style="color:gray">${vo.subject}<!--삭제된 게시물 --></span>
						</c:if>
						<!-- no =parameter =전에 공백을 남기면 안된다. -->
						<c:if test="${today==vo.day}">
							<sup><img src="image/new.gif"/></sup>
						</c:if>
					</td>
					<td width="15%" align=center>${vo.name}</td>
					<td width="20%" align=center>
						<fmt:formatDate value="${vo.regdate}" pattern="yyyy-MM-dd"/>
					</td>
					<td width="10%" align=center>${vo.hit}</td>	
				</tr>
			</c:forEach>
		</table>
		<table>
			<tr>
				<td align="left">
					<form action="find.do" method="post">
						Search: 
						<select name="fs" ><!-- feild statement -->
							<option value="name">이름</option>
							<option value="subject">제목</option>
							<option value="content">내용</option>
						</select>
						<input type="text" name="ss" size="10"/>
						<input type="submit" value="검색" />
					</form>
				</td>
				<td align=right>
					<a href="list.do?page=${curpage>1?curpage-1:curpage }"><img src="image/prev_a.gif"></a>&nbsp;
					<a href="list.do?page=${curpage<totalpage?curpage+1:curpage }"><img src="image/next_a.gif"></a>&nbsp;&nbsp;
					${curpage} page/${totalpage}pages
				</td>
			</tr>
		</table>
	</center>	
</body>
</html>