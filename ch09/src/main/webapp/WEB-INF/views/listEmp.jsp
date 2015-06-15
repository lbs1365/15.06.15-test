<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title></head><body>
<h2>회원 정보</h2>
<table>
	<tr><th>사번</th><th>이름</th><th>업무</th>
		<th>부서명</th><th>근무지</th></tr>
<c:forEach var="empDept" items="${listEmp}">
	<tr><td>${empDept.empno }</td><td>${empDept.ename }</td>
		<td>${empDept.job }</td><td>${empDept.dname }</td>
		<td>${empDept.loc }</td></tr>
</c:forEach>
</table>
</body>
</html>