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
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Institution;

@Controller
public class InstitutionController {
	
	@Autowired
	private InstitutionRepository institutionRepository;
	
	@GetMapping("/institutions")
	public String institution(Model model) {
		
		
		List<Institution> institutions = institutionRepository.findAll();
		model.addAttribute("institutions", institutions);
		return "index";
	}
	
	@GetMapping("/institutions/form")
	public String userForm(@ModelAttribute("institution") Institution institution) {
		
		
		return "institution_form";
	}
	
	@PostMapping("/institutions/new")
	public String institutionNew(@Valid 
								 @ModelAttribute("institution") 
								 Institution institution,
								 BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()){
			return "institution_form";
		}
		
		institutionRepository.save(institution);
		
		return"redirect:/institutions";
	}
	
	@GetMapping("/institutions/update/{id}")
	public String institutionUpdate(@PathVariable("id") Integer id, Model model)
	{
		
		Optional<Institution> optInstitution = institutionRepository.findById(id);
		if(!optInstitution.isPresent())
		{
			//Gerar erro
		}
		
		Institution institution = optInstitution.get();
		
		model.addAttribute("institution", institution);
		
		return"institution_form";
	}
	
	@GetMapping("/institutions/delete/{id}")
	public String institutionUpdate(@PathVariable("id") Integer id)
	{
		
		Optional<Institution> optInstitution = institutionRepository.findById(id);
		if(!optInstitution.isPresent())
		{
			//Gerar erro
		}
		
		Institution institution = optInstitution.get();
		
		institutionRepository.delete(institution);
		
		return"redirect:/institutions";
	}
}
