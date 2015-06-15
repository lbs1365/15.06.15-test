<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title></head><body>
<div align="center" class="body">
<h2>회원 등록</h2>
<form method="post" action="userEntry2.html">	
	<table>
		<tr height="40px"><td>유저ID</td>
			<td><input type="text" name="userId" maxlength="20" required="required"></td></tr>
												<!--20자가 넘지 않도록  -->
		<tr height="40px"><td>패스워드</td>
			<td><input type="password" name="password" maxlength="20" required="required"></td></tr>
		<tr height="40px" > <td>이름</td>
		<td><input type="text" name="userName" maxlength="" required="required"></td></tr>
		<tr height="40px"><td>우편번호</td>
			<td><input type="text" name="postCode" required="required"></td></tr>
		<tr height="40px"><td>주소</td>
			<td><input type="text" name="address" required="required"></td></tr>
		<tr height="40px"><td>E-MAIL</td>
			<td><input type="email" name="email" required="required"> </td> </tr>
		<tr height="40px"><td>직업</td>
			<td><select name="job">
				<option value="사회인" label="사회인">사회인</option>
				<option value="주부" label="주부" >주부</option>
				<option value="학생" label="학생" >학생</option>
				<option value="그외" label="그외" >그외</option>
				</select></td></tr>
		<tr height="40px"><td>생년월일</td>
			<td><input type="date" name="birthDay" required="required"/>
				</td></tr>
		</table>
		<table>	<tr>
			<td height="40px" align="center">
			<input type="submit"name="btnSubmit" value="등록"></td>
			<td height="40px" align="center">
			<input type="reset"	name="btnReset" value="리셋"></td>
		</tr></table>
</form></div></body></html>