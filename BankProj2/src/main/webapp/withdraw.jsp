<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        body {
            margin: 0 auto;
            
        }

        .container {
            padding: 10px;
            border: 1px solid;
            width: 280px;
        }

        .header {
            height: 40px;
        }

        .row {
            height: 30px;
        }

        .title {
            width: 70px;
            float: left;
            font-weight: bold;
        }

        .input {
            float: left;
        }

        input[type='submit'] {
            font-weight: bold;
            width: 120px;
            background-color: lightgrey;
        }
    </style>
</head>
<body>
<% pageContext.include("header.jsp"); %>
   <center>
        <div class="header">
            <h3>ì¶ ê¸</h3>
        </div>
        <div class="container" id='withdraw'>
            <form id='form' action="withdraw" method="post">
                <div class="row">
                    <div class="title">ê³ì¢ë²í¸</div>
                    <div class="input"><input type="text" name="id"></div>
                </div>
                <div class="row">
                    <div class="title">ì¶ê¸ì¡</div>
                    <div class="input"><input type="text" name="money"></div>
                </div>
                <div class="button">
                    <input type="submit" value="ì¶ ê¸">
                </div>
            </form>
        </div>

    </center>
</body>
</html>