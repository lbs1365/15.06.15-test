package service;

import model.User;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValid implements Validator{
	public boolean supports(Class<?> arg0) {
		return false;
	}

	public void validate(Object command, Errors errors){
		User user = (User) command;
		//입력 안했을 때
		if (!StringUtils.hasLength(user.getUserId())) {
		errors.rejectValue("userId", "error.required"); }
		if (!StringUtils.hasLength(user.getPassword())) { 
		errors.rejectValue("password", "error.required"); }
		if (!StringUtils.hasLength(user.getUserName())) {
		errors.rejectValue("userName", "error.required"); }
		
		//틀렸을 때
		if (!StringUtils.hasText(user.getPostCode())) {
		errors.rejectValue("postCode", "error.required"); }
		if (!StringUtils.hasText(user.getAddress())) {
		errors.rejectValue("address", "error.required"); }
		if (!StringUtils.hasText(user.getEmail())) {
		errors.rejectValue("email", "error.required"); }
		if (errors.hasErrors()) { errors.reject("error.input.user"); }
		
	}

}
