<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title></head><body>
<div align="center" class="body">
<h2>사원 등록</h2>
<c:if test="${log !=null }">${log }<p></c:if>
<form method="post" action="emplist2.html">	
	<table>
		<tr height="40px"><td>사번</td>
			<td><input type="number" name="empno" 
				required="required" />	</td> </tr>
		<tr height="40px"><td>이름</td>
			<td><input type="text" name="ename" 
				required="required" /></td></tr>
		<tr height="40px"> <td>업무</td>
			<td><input type="text" name="job"
				required="required" /></td></tr>
		<tr height="40px"><td>관리자</td>
			<td><select name="mgr">
				<option value="7839">7839</option>
				<option value="7782">7782</option>
				<option value="7698">7698</option>
				<option value="7902">7902</option>
				<option value="7566">7566</option>
				<option value="7788">7788</option>				
			</select> </td> </tr>
		<tr height="40px"><td>입사일</td>
			<td><input type="date" name="hiredate" 
				required="required" /></td></tr>
		<tr height="40px"><td>급여</td>
			<td><input type="number" name="sal"
				required="required" /></td></tr>
		<tr height="40px"><td>보너스</td>
			<td><input type="number"  name="comm" /></td></tr>
		<tr height="40px"><td>부서코드</td>
			<td><select name="deptno">
					<option value="10">10</option>
					<option value="20">20</option>
					<option value="30">30</option>
					<option value="40">40</option>
				</select></td></tr>
		</table>
		<table>	<tr>
			<td height="40px" align="center">
			<input type="submit"name="btnSubmit" value="등록"></td>
			<td height="40px" align="center">
			<input type="reset"	name="btnReset" value="리셋"></td>
		</tr></table>
</form>
</div>
</body>
</html>