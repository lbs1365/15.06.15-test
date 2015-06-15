package service;

import model.Emp;

import org.springframework.stereotype.Component;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("empValid")
public class EmpValid implements Validator{
	public boolean supports(Class<?> arg0) {
		return false;
	}

	public void validate(Object command, Errors errors){
		Emp emp = (Emp) command;
		//입력 안했을 때
		if (StringUtils.isEmpty(emp.getEmpno())) {
		errors.rejectValue("empno", "error.required"); }
		if (!StringUtils.hasLength(emp.getEname())) { 
		errors.rejectValue("ename", "error.required"); }
		if (StringUtils.isEmpty(emp.getSal())) {
			errors.rejectValue("sal", "error.required"); }
		if (!StringUtils.hasLength(emp.getJob())) {
			errors.rejectValue("job", "error.required"); }
		if (errors.hasErrors()) { 
			errors.reject("error.input.emp"); 
		}
		
	}

}
