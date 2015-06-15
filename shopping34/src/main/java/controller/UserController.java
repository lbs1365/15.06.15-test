package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService us;
	@Autowired
	private Validator userValid;
	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value="userEntry", method = RequestMethod.GET)
	public String userEn() {
		return "userEntry";
	}
	@RequestMapping(value="userEntry2", method = RequestMethod.GET)
	public String userEn2() {
		return "userEntry2";
	}

	@ModelAttribute
	public User userSet() {
		User user = new User();
		MessageSourceAccessor msa = new MessageSourceAccessor(messageSource);
		user.setUserId(msa.getMessage("user.userId.default"));
		// messages.properties 여기에 있는 메세지
		user.setUserName(msa.getMessage("user.userName.default"));
		return user;
	}
	///-------------
	@InitBinder
	public void InitBinder(WebDataBinder wdb) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		df.setLenient(false);
		wdb.registerCustomEditor(Date.class, "birthday", new CustomDateEditor(
				df, false));
	}
	@RequestMapping(value="userEntry",  method=RequestMethod.POST)
	public ModelAndView onsubmit(User user, BindingResult br) {
		ModelAndView mav = new ModelAndView();
		userValid.validate(user, br);
		if (br.hasErrors()) {
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		try {
			us.insert(user);
			mav.addObject("user",user);
			mav.setViewName("userEntrySuccess");
		}catch (DataIntegrityViolationException e) {
			br.reject("error.duplicate.user");
			mav.getModel().putAll(br.getModel());
			
			return mav;
		}
		return mav;
		}
	//-------------------여기까지 html5일땐 사용하지 않는다
	@RequestMapping(value="userEntry2", method=RequestMethod.POST)
	public ModelAndView onsubmit2(User user) { 
					// (@ModelAttribute User user) @ModelAttribute 가 생략되어 있다 
		ModelAndView mav = new ModelAndView();
		try {
			us.insert(user);
			mav.addObject("user",user);
			mav.setViewName("userEntrySuccess");
		}catch (DataIntegrityViolationException e) {
			mav.addObject("msg", "없는데"); 
			return mav;
		}
		return mav;
	}
}
