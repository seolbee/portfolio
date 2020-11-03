<%@page import="VO.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<%
	int todoNo = 0;
	UserVO vo = (UserVO) request.getAttribute("user");
	int userNo = vo.getUserNO();
%>

<form action="AddTodo.do" method="post">
	<input type="hidden" name="todoNo" value="<%= userNo%>"/>
	<input type="hidden" value="<%=todoNo %>"/>
	<input type="text" name="todo" placeholder="할 일을 적으시오" />
	<button>저장</button>
</form>

<button>추가</button>


<%@ include file="footer.jsp" %>