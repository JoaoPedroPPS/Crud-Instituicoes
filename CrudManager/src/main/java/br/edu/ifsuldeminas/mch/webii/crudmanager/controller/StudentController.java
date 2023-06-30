package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.InstitutionRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.StudentRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Institution;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Student;

@Controller
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private InstitutionRepository institutionRepository;
	
	@GetMapping("/students")
	public String students(Model model) {
		List<Student> students = studentRepository.findAll();
		model.addAttribute("students", students);
		return "students_index"; // students_index.html
	}
	
	@GetMapping("/students/form")
	public String studentForm(Model model, @ModelAttribute("student") Student student) {
		List<Institution> institutions = institutionRepository.findAll();
		model.addAttribute("institutions", institutions);
		return "student_form"; // student_form.html
	}
	
	@PostMapping("/students/new")
	public String studentNew(@Valid
							 @ModelAttribute("student") 
							 Student student,
							 BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()){
			List<Institution> institutions = institutionRepository.findAll();
			model.addAttribute("institutions", institutions);
			return "student_form";
		}
		
		studentRepository.save(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/update/{id}")
	public String studentUpdate(@PathVariable("id") Integer id, Model model) {
		Optional<Student> optStudent = studentRepository.findById(id);
		if(!optStudent.isPresent()) {
			//Gerar erro
		}
		Student student = optStudent.get();
		model.addAttribute("student", student);

		List<Institution> institutions = institutionRepository.findAll();
		model.addAttribute("institutions", institutions);

		return "student_form";
	}
	
	@GetMapping("/students/delete/{id}")
	public String studentDelete(@PathVariable("id") Integer id) {
		Optional<Student> optStudent = studentRepository.findById(id);
		if(!optStudent.isPresent()) {
			//Gerar erro
		}
		Student student = optStudent.get();
		studentRepository.delete(student);
		return "redirect:/students";
	}
}
