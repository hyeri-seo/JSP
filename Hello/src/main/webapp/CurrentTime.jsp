<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>현재 시간</title>
<script>
	/* var x=10; */
</script>

<%-- <%
	String str = "test";
	%>
--%>
<%!
	Calendar c= Calendar.getInstance(); //변수, 함수 선언할 때 씀. 클래스 안에 들어감. 인스턴스 변수
%>
<%
	int hour = c.get(Calendar.HOUR_OF_DAY); //자바 코드. 명령어. 서비스의 지역 변수로 들어감
%>


</head>
<body>
<h1>현재 시간은 <%=request.getAttribute("hour") %>시 <%=request.getAttribute("minute")%>분 <%=request.getAttribute("second")%>초 입니다.</h1>
<!-- 얘는 출력문임 -->
</body>
</html>