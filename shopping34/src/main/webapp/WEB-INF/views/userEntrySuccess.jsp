<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title></head><body>
<h2>회원가입 결과</h2>
아이디 : ${user.userId} <p>
이름 : ${user.userName} <p>
암호 : ${user.password} <p>
우편번호 : ${user.postCode} <p>
주소 : ${user.address} <p>
메일 : ${user.email} <p>
업무 : ${user.job} <p>
생일 : <fmt:formatDate pattern="yyyy/MM/dd" 
	value="${user.birthday}" /> 
</body>
</html>