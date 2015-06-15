<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title></head><body>
<div align="center" class="body">
<h2>사원 등록</h2>
<form:form modelAttribute="emp" method="post" action="emplist.html">
	<spring:hasBindErrors name="emp"><font color="red">
		<c:forEach items="${errors.globalErrors}" var="error">
			<spring:message code="${error.code}" />
		</c:forEach> </font>
	</spring:hasBindErrors>
	<table>
		<tr height="40px"><td>사원 번호</td>
			<td><form:input path="empno" maxlength="20" 
				cssClass="empno" />
				<font color="red"><form:errors path="empno" /></font></td> </tr>
		<tr height="40px"><td>사원 이름</td>
			<td><form:input path="ename" maxlength="20" cssClass="ename" /> <font color="red">
				<form:errors path="ename" /></font></td> </tr>
		<tr height="40px"> <td>급여</td>
			<td><form:input path="sal" maxlength="50" cssClass="sal" /><font color="red"><form:errors path="sal" /></font></td></tr>
		<tr height="40px"><td>직업</td>
			<td><form:input path="job" maxlength="50" cssClass="job" />
				<font color="red"><form:errors path="job" /></font></td> </tr>
		<tr height="40px"> <td>상사</td>
			<td><form:input path="mgr" maxlength="50" cssClass="mgr" />
				<font color="red"><form:errors path="mgr" /></font></td> </tr>
		<tr height="40px"><td>입사일</td>
			<td><form:input path="hiredate" maxlength="10" cssClass="hiredate" />
				<font color="red"><form:errors path="hiredate" /></font></td> </tr>
		<tr height="40px"><td>부서코드</td>
			<td><form:select path="deptno" cssClass="deptno">
					<form:option value="10" label="10" />
					<form:option value="20" label="20" />
					<form:option value="30" label="30" />
					<form:option value="40" label="40" />
		<tr height="40px"><td>보너스</td>
			<td><form:input path="comm" maxlength="50" cssClass="comm" />
				<font color="red"><form:errors path="comm" /></font></td></tr>
				</form:select></td></tr>
		</table>
		<table>	<tr>
			<td height="40px" align="center">
			<input type="submit"name="btnSubmit" value="등록"></td>
			<td height="40px" align="center">
			<input type="reset"	name="btnReset" value="리셋"></td>
		</tr></table>
</form:form>
</div>
</body>
</html>