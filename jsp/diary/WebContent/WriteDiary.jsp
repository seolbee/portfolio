<%@page import="VO.UserVO"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<%
	int diaryNo = 0;
	UserVO vo = (UserVO) request.getAttribute("user");
	int userNo = vo.getUserNO();
%>

<form action="WriteDiary.do">
	<input type="hidden" name="userNo" value="<%= userNo %>" />
	<input type="hidden" name="diaryNo" value="<%= diaryNo%>"/>
	<textarea name="diaryContent" cols="30" rows="10"></textarea>
	<button>저장</button>
</form>

<%@ include file="footer.jsp" %>