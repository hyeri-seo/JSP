<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {margin: 0 auto;}
body {
	position: relative;
	height: 800px;
}
.content {
	position: absolute;
	width:100%;
	left:0; top:100px;
}
.footer {
	position: absolute;
	width: 100%
	right:0; bottom:0;
}
</style>
</head>
<body>
<%
	String ipage = (String)request.getAttribute("page");	
%>
<table style="width:100%">
	<thead>
		<tr>
			<td>
				<%-- <% pageContext.include("header.jsp");%> --%>
				<jsp:include page="header.jsp"/>
			</td>
		</tr>
	</thead>
	<%if(ipage!=null) { %>
	<tbody>
		<tr>
			<td>
				<jsp:include page='<%=ipage+".jsp"%>'/>
				<%-- <%
					if(ipage!=null) {
						pageContext.include(ipage+".jsp");
					}
				%>--%>
			</td>
		</tr>
	</tbody>
	<%} %>
</table>
</body>
<jsp:include page="footer.jsp"/>
</html>