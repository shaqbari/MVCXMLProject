<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h3>수정하기</h3>
		<form method="post" action="update_ok.do">
			<table id="table_content" width=500>
				<tr>
					<td width=15%>이름</td>
					<td width=85%>
						<input type="text" name="name" size=12 value="${vo.name }"/>
						<input type="hidden" name="no" value="${vo.no }" />
						<input type="hidden" name="page" value="${page}" />
					</td>				
				</tr>
				<tr>
					<td width=15%>제목</td>
					<td width=85%>
						<input type="text" name="subject" size=50 value="${vo.subject }"/><!--공백있으면 ""를 붙여야 한다.  -->
					</td>				
				</tr>
				<tr>
					<td width=15%>내용</td>
					<td width=85%>
						<textarea name="content" cols="55" rows="10" >${vo.content }</textarea><!--textarea는 태그사이에 값이 와야 한다.  -->
					</td>				
				</tr>
				<tr>
					<td width=15%>비밀번호</td>
					<td width=85%>
						<input type="password" name="pwd" size=10 "/>
					</td>				
				</tr>
				<tr>
					<td colspan=2 align="center">				
						<input type="submit" value="수정" /><!-- html에서 공백이 들어가면 무조건 ""를 붙여야 한다. -->
						<input type="button" value="취소" onclick="javascript:history.back()"/>					
					</td>				
				</tr>
			</table>
		</form>		
	</center>
</body>
</html>