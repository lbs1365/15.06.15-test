<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title></head><body>
<h2>사원가입 결과</h2>
사원번호 : ${emp.empno} <p>
사원이름 : ${emp.ename} <p>
급여 : ${emp.sal} <p>
직업 : ${emp.job} <p>
상사 : ${emp.mgr} <p>
입사일 : <fmt:formatDate pattern="yyyy/MM/dd" 
	value="${emp.hiredate}" /> <p>
부서코드 : ${emp.deptno} <p>
보너스 : ${emp.comm} <p>
</body>
</html>