<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% session.setAttribute("test","Session Test"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form  action="el_test2.jsp" method="post">
		<table border="1">
			<tr>
				<td>이름 : </td>
				<td><input type="text" name="name" value="홍길동"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="입력"/></td>
			</tr>				
		</table>
	</form>
</body>
</html>