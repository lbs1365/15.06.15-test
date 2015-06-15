<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title></head><body>
<h2>직원정보</h2>
<form action="update.do" method="post">
<input type="hidden" name="empno" value="${emp.empno }"><!--데이터를 넘기기위해  -->
<table>
	<tr><th>사번</th><td>${emp.empno }</td></tr>
	<tr><th>이름</th><td><input type="text" name="ename" value="${emp.ename}" required="required"></td></tr>
	<tr><th>업무</th><td><input type="text" name="job" value="${emp.job }" required="required"></td></tr>
	<tr><th>급여</th><td><input type="number" name="sal" value="${emp.sal }" required="required"></td></tr>
	<tr><th>입사일</th><td><input type="date" name="hiredate" value="${emp.hiredate }" ></td></tr>
	<tr><th>보너스</th><td><input type="number" name="comm" value="${emp.comm }" ></td></tr>
	<tr><th>관리자사번</th><td><input type="number" name="mgr" value="${emp.mgr }" ></td></tr>
	<tr><th>부서코드</th><td><input type="number" name="deptno" value="${emp.deptno }" required="required"></td></tr>
	<tr><td colspan="2"><input type="submit" value="확인" >
		<input type="button" value="목록" onclick="location.href='list.do'">
		</td>
	</tr>
</table>
</form>
	<c:if test="${msg !=null }">
		<h2>${msg }</h2>
	</c:if>
</body>
</html>