package com.fr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fr.model.Specialite;
import com.fr.service.SpecialiteService;

@Controller
@RequestMapping("/specialite")
public class SpecialiteController {

	@Autowired
	private SpecialiteService specialiteService;

	@GetMapping("/list")
	public String listSpecialites(Model model) {
		List<Specialite> listSpecialites = specialiteService.findAll();
		model.addAttribute("lalistespecialites", listSpecialites);
		return "list-specialites";
	}

	@PostMapping("/addSpecialite")
	public String addSpecialite(@ModelAttribute("uneSpecialite")Specialite specialite) {
		specialiteService.add(specialite);	
		return "redirect:/specialite/list";
	}
	
	@GetMapping("/deleteSpecialite")
    public String deleteSpecialite(@RequestParam("specialiteId")int id) {
		Specialite specialite = specialiteService.findById(id);
		specialiteService.delete(specialite);
		return "redirect:/specialite/list";		
	}
	
	@PostMapping("/updateSpecialite")
	public String updateSpecialite(@ModelAttribute("uneSpecialite") Specialite specialite) {	
		specialiteService.update(specialite);
		return"redirect:/specialite/list";
	}
	
	@GetMapping("/catchSpecialite")
	public String catchSpecialite(@RequestParam("specialiteId")int specialiteId, Model model) {
		List<Specialite> listeSpecialites = specialiteService.findAll();
		model.addAttribute("lalistespecialites", listeSpecialites);
		Specialite target = specialiteService.findById(specialiteId);
		model.addAttribute("target", target);
		return "list-specialites";
	}
}
