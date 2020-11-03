<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="./login.css" />
</head>
<body>
	<div class="login_box">
		<p>login</p>
		<form action="login.do" method="post">
			<input type="text" name="id" placeholder="아이디를 입력하세요"/>
			<input type="password" name="password" placeholder="비밀번호를 입력하세요" />
			<button>로그인</button>
		</form>
	</div>
</body>
</html>