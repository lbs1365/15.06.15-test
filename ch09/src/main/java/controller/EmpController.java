package controller;
import java.util.List;

import model.Dept;
import model.Emp;
import model.EmpDept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.EmpService;
import service.Paging;
@Controller
public class EmpController {
	@Autowired
	private EmpService es;
	@RequestMapping(value="listEmp")
	public String listEmp(Model model) {
		EmpDept empDept = null;
		List<EmpDept> listEmp = es.listEmp(empDept);
		model.addAttribute("listEmp",listEmp);
		return "listEmp";
	}
	@RequestMapping(value="list")
	public String list(Emp emp, String currentPage, Model model) {
		int total = es.total();
		Paging pg = new Paging(total, currentPage); //페이지 정보를 만들어줌
		emp.setStart(pg.getStrat());
		emp.setEnd(pg.getEnd());
		List<Emp> list = es.list(emp);
		model.addAttribute("list",list);
		model.addAttribute("pg", pg);
		return "list";
	}
	@RequestMapping(value="detail")
	public String detail(int empno,Model model) {
		Emp emp = es.detail(empno);
		model.addAttribute("emp",emp);
		return "detail";
	}
	@RequestMapping(value="updateForm")
	public String updateForm(int empno,Model model) {
		Emp emp = es.detail(empno); //데이터 읽어오기
		model.addAttribute("emp",emp);
		return "updateForm";
	}
	@RequestMapping(value="delete")
	public String delete(int empno,Model model) {
		int result = es.delete(empno);
		if(result >0){
			model.addAttribute("msg","삭제완료");
			return "forward:list.do"; //redirect 면 값을 못가져가서 안됨
		}else{
			model.addAttribute("msg","삭제실패 확인바람");
			return "forward:detail";
		}
	}
	@RequestMapping(value="writeForm")
	public String writeForm(Model model) {
		Emp emp = null;
		List<Emp> list = es.list(emp);
		model.addAttribute("list", list);
		List<Dept> deptlist = es.select();
		model.addAttribute("deptlist", deptlist);
		return "writeForm";
	}
	@RequestMapping(value="confirm")
	public String confirm(int empno,Model model) {
		Emp emp = es.detail(empno);
		model.addAttribute("empno", empno);
		if(emp != null){
			model.addAttribute("msg", "있는 번호다 ㅡㅡ");
			return "forward:writeForm.do";
		}else{
			model.addAttribute("msg", "사용할 수 있음ㅋ");
			return "forward:writeForm.do";
		}
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(Emp emp,Model model) {
		es.update(emp);
		return "redirect:list.do";		
	}
	@RequestMapping(value="write",method=RequestMethod.POST)
	public String write(Emp emp,Model model) {
		Emp emp1 = es.detail(emp.getEmpno()); // 미리 있는 데이터인지 체크
		if(emp1 != null){
			model.addAttribute("msg", "존재하는 데이터 입니다.");
			return "forward:writeForm.do";		
		}
		int result = es.insert(emp);
		if(result >0) return "redirect:list.do";
		else{
			model.addAttribute("msg", "입력 실패 확인해 보세요");
			return "forward:writeForm.do";		
		}
	}
	@RequestMapping(value="insertEmp")
	public String insertEmp(Model model) {
		es.insertEmp();
		Emp emp = null;
		List<Emp> list = es.list(emp);
		model.addAttribute("list",list);
		return "list";
	}
}