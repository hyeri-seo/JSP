<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body { margin : auto; }
	div {
	width: 280px;
	margin: auto;
	}
	h1 {text-align : center;}
</style>
</head>
<body>
<div>
	<h1>회원정보</h1>
	<table border="1">
		<tr><th>회원명</th><td><%=request.getParameter("name") %></td></tr>
		<tr><th>주소</th><td><%=request.getParameter("address") %></td></tr>
		<tr><th>전화번호</th><td><%=request.getParameter("tel") %></td></tr>
		<tr><th>취미</th><td><%=request.getParameter("hobby") %></td></tr>
	</table>
</div>
</body>
</html>