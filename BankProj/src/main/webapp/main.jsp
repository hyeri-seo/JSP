<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String ipage = (String)request.getAttribute("page");
	%>
	<table style="width:100%">
		<thead>
			<tr>
				<td>
					<% pageContext.include("header.jsp"); %>
				</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
					<%
						if(ipage!=null) {
							pageContext.include(ipage+".jsp");
							// pageContext: jsp페이지에 대한 정보를 저장함
						}
					%>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>