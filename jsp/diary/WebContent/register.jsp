<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="./css/register.css" />
</head>
<body>
	<div class="register_box">
		<p>회원가입</p>
		<form action="registe.do" method="post">
			<input type="text" name="id" placeholder="아이디를 입력하세요"/>
			<input type="password" name="password" placeholder="비밀번호를 입력하세요" />
			<input type="text" name="nickname" placeholder="사용자이름을 입력하세요" />
			<input type="date" name="birth" placeholder="생년 월일을 선택하세요" />
			<button>회원가입</button>
		</form>
	</div>
</body>
</html>