<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title></head><body>
<div align="center" class="body">
<h2>회원 등록</h2>
<form:form modelAttribute="user" method="post" action="userEntry.html">
	<spring:hasBindErrors name="user"><font color="red">
		<c:forEach items="${errors.globalErrors}" var="error">
			<spring:message code="${error.code}" />
		</c:forEach> </font>
	</spring:hasBindErrors>
	<table>
		<tr height="40px"><td>유저ID</td>
			<td><form:input path="userId" maxlength="20" 
				cssClass="userId" />
				<font color="red"><form:errors path="userId" /></font></td> </tr>
		<tr height="40px"><td>패스워드</td>
			<td><form:password path="password" maxlength="20" cssClass="password" /> <font color="red">
				<form:errors path="password" /></font></td> </tr>
		<tr height="40px"> <td>이름</td>
			<td><form:input path="userName" maxlength="20" cssClass="userName" /><font color="red"><form:errors path="userName" /></font></td></tr>
		<tr height="40px"><td>우편번호</td>
			<td><form:input path="postCode" maxlength="8" cssClass="postCode" />
				<font color="red"><form:errors path="postCode" /></font></td> </tr>
		<tr height="40px"> <td>주소</td>
			<td><form:input path="address" maxlength="50" cssClass="address" />
				<font color="red"><form:errors path="address" /></font></td> </tr>
		<tr height="40px"><td>E-MAIL</td>
			<td><form:input path="email" maxlength="50" cssClass="email" />
				<font color="red"><form:errors path="email" /></font></td> </tr>
		<tr height="40px"><td>직업</td>
			<td><form:select path="job" cssClass="jobs">
					<form:option value="사회인" label="사회인" />
					<form:option value="주부" label="주부" />
					<form:option value="학생" label="학생" />
					<form:option value="그외" label="그외" />
				</form:select></td></tr>
		<tr height="40px"><td>생년월일</td>
			<td><form:input path="birthday" maxlength="10" cssClass="birthday" />
				<font color="red"><form:errors path="birthday" /></font></td></tr>
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