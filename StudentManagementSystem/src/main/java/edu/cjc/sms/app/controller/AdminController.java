package edu.cjc.sms.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cjc.sms.app.model.Student;
import edu.cjc.sms.app.service.StudentService;

@Controller
public class AdminController {
	@Autowired
	StudentService ss;
	@RequestMapping("/")
	public String preLogin() {
		return "login";
		
	}
	@RequestMapping("/login")
	public String onlogin(@RequestParam String username,@RequestParam String password,Model m) {
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			List<Student> student=ss.getAllStudent();
			m.addAttribute("data", student);
			return "adminscreen";
		}
		else {
			m.addAttribute("login_fail","Enter vaild login details.");
		
		return "login" ;
		}
	}
	@RequestMapping("enroll_student")
	public String saveStudent(@ModelAttribute Student student ,Model m) {
		ss.saveStudentDatails(student);
		List<Student> students=ss.getAllStudent();
		m.addAttribute("data", students);
		return "adminscreen";
		
	}
	@RequestMapping("/remove")
	public String removeStudent(@RequestParam("rollno") int rollno,Model m) {
		ss.deleteStudent(rollno);
		List<Student> students=ss.getAllStudent();
		m.addAttribute("data", students);
		return "adminscreen";

		
	}
	@RequestMapping("/search")
	public String getStudentBatch(@RequestParam("batchNumber") String batchNumber,@RequestParam("batchMode") String batchMode,Model m)
	{
		List<Student> result=ss.searchStudentByBatch(batchNumber,batchMode);
		if(result.size()>0) {
			m.addAttribute("data",result);
		}
		else {
			
			List<Student> list=ss.getAllStudent();
			m.addAttribute("data", list);
			m.addAttribute("message", "No record found for that batch");
			
		}
		return"adminscreen";
	}
	@RequestMapping("/fees")
	public String onFees(@RequestParam int id,Model m) {
		Student st=ss.getSingleStudent(id);
		m.addAttribute("st",st);
		return "fees";
		}
	@RequestMapping("/payfees")
public String payFees(@RequestParam("studentid") int studentid,@RequestParam("ammount") double ammount,Model m) {
	ss.updateStudentFees(studentid,ammount);
	List<Student> students=ss.getAllStudent();
	m.addAttribute("data", students);
	return "adminscreen";

}
	@RequestMapping("/batch")
	public String onBatch(@RequestParam int id,Model m) {
		Student st=ss.getSingleStudent(id);
		m.addAttribute("st",st);
		return "batch";
		}
	@RequestMapping("/updatebatch")
public String updateBatch(@RequestParam("studentid") int studentid,@RequestParam("batchNumber") String batchNumber,Model m) {
	ss.updateBatch(studentid,batchNumber);
	List<Student> students=ss.getAllStudent();
	m.addAttribute("data", students);
	return "adminscreen";

}
}
