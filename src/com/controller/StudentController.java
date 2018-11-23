package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Student;
import com.services.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listStudent(ModelMap map) {
		map.addAttribute("student", new Student());
		map.addAttribute("studentList", studentService.getAllStudent());
		return "mainform";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute(value = "student") Student student, BindingResult result) {
		studentService.saveStudent(student);
		return "redirect:/";
	}

	@RequestMapping("/edit/{studentId}")
	public String editStudent(ModelMap map, @PathVariable("studentId") int studentId) {
		map.addAttribute("student", this.studentService.getStudentById(studentId));
		map.addAttribute("studentList", this.studentService.getAllStudent());
		return "mainformedit";
	}

	@RequestMapping(value = "/edit/update", method = RequestMethod.POST)
	public String updateStudent(@ModelAttribute(value = "student") Student student, BindingResult result,
			ModelMap map) {

		if (result.hasErrors()) {
			System.out.println("--------|hasErrors|--------");
			this.studentService.updateStudent(student);
			return "mainformedit";
		}
		this.studentService.updateStudent(student);
		map.addAttribute("studentList", this.studentService.getAllStudent());
		return "mainformedit";
	}

	@RequestMapping("/delete/{studentId}")
	public String deleteStudent(@PathVariable("studentId") int studentId) {
		studentService.deleteStudent(studentId);
		return "redirect:/";
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
}
