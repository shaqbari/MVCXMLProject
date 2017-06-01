<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="table.css">	
	<script>
	</script>
</head>
<body>
	<center>
		<h3>검색결과</h3>
		<c:if test="${length==0}">
			<table id="table_content" width=700>
				<tr>
					<td align=center>검색결과가 없습니다.</td>
				</tr>
			</table>
		</c:if>
		<c:if test="${length!=0}">
			<table id="table_content" width=700>
				<tr>
					<th width="10%">번호</th>
					<th width="45%">제목</th>
					<th width="15%">이름</th>
					<th width="20%">작성일</th>
					<th width="10%">조회수</th>
				</tr>
				<c:forEach var="vo" items="${list }">
					<tr>
						<td width="10%" align=center>${vo.no }</td>
						<td width="45%">${vo.subject }</td>
						<td width="15%" align=center>${vo.name }</td>
						<td width="20%" align=center>
							<fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/>
						</td>
						<td width="10%" align=center>${hit }</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</center>
</body>
</html>