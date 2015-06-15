package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
public class EmpController {
	@Autowired
	private UserService us;
	@Autowired
	private Validator empValid;
	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value="emplist", method = RequestMethod.GET)
//	@RequestMapping(value="emplist.html", method = RequestMethod.GET)
//	public String emp1(Model model) {
	public String emp1() {
		//model.addAttribute("emp",new Emp());
		return "emplist";
	}
	@RequestMapping(value="emplist2", method = RequestMethod.GET)
	public String emp2() {
		return "emplist2";
	}

	@ModelAttribute
	public Emp empSet() {
		Emp emp = new Emp();
		MessageSourceAccessor msa = new MessageSourceAccessor(messageSource);
		emp.setEname(msa.getMessage("emp.ename.default"));
		return emp;
	}
	///-------------
	@InitBinder
	public void InitBinder(WebDataBinder wdb) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		df.setLenient(false);
		wdb.registerCustomEditor(Date.class, "hiredate", new CustomDateEditor(
				df, false));
	}
	@RequestMapping(value="emplist",  method=RequestMethod.POST)
	public ModelAndView onlistt(Emp emp, BindingResult br) {
		ModelAndView mav = new ModelAndView();
		empValid.validate(emp, br);
		if (br.hasErrors()) {
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		try {
			us.empin(emp);
			mav.addObject("emp",emp);
			mav.setViewName("empSuccess");
		}catch (DataIntegrityViolationException e) {
			br.reject("error.duplicate.emp");
			mav.getModel().putAll(br.getModel());
			
			return mav;
		}
		return mav;
		}
	@RequestMapping(value="emplist2", method=RequestMethod.POST) 
	public ModelAndView onSubmit2(Emp emp){
		ModelAndView mav = new ModelAndView();		
		try {
			us.empin(emp);
			mav.addObject("emp",emp);
			mav.setViewName("empSuccess");
		}catch (DataIntegrityViolationException e) {
			mav.addObject("log","이미 있는 데이터 인데");
			return mav;
		}
		return mav;
	}
}
