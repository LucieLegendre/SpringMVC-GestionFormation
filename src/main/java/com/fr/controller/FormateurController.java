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

import com.fr.model.Formateur;
import com.fr.model.Session;
import com.fr.model.Specialite;
import com.fr.service.FormateurService;
import com.fr.service.SessionService;
import com.fr.service.SpecialiteService;

@Controller
@RequestMapping("/formateur")
public class FormateurController {

	@Autowired
	private FormateurService formateurService;
	
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private SpecialiteService SpecialiteService;

	@GetMapping("/list")
	public String listFormateurs(Model model) {
		List<Session> listSession = sessionService.findAll();
		model.addAttribute("listSession", listSession);
		List<Specialite> listSpecialite = SpecialiteService.findAll();
		model.addAttribute("listSpecialite", listSpecialite);
		List<Formateur> listFormateurs = formateurService.findAll();
		model.addAttribute("lalisteformateurs", listFormateurs);
		return "list-formateurs";
	}

	@PostMapping("/addFormateur")
	public String addFormateur(@ModelAttribute("unFormateur") Formateur formateur, @ModelAttribute("sessionId") int idsess,
			@ModelAttribute("specialiteId") int idspe) {
		Session sessionId = sessionService.findById(idsess);
		formateur.setSession(sessionId);
		Specialite specialiteId = SpecialiteService.findById(idspe);
		formateur.setSpecialite(specialiteId);
		formateurService.add(formateur);
		return "redirect:/formateur/list";
	}

	@GetMapping("/deleteFormateur")
	public String deleteFormateur(@RequestParam("formateurId") int id) {
		Formateur formateur = formateurService.finById(id);
		formateurService.delete(formateur);
		return "redirect:/formateur/list";
	}

	@PostMapping("/updateFormateur")
	public String updateFormateur(@ModelAttribute("unformateur") Formateur formateur,  @ModelAttribute("sessionId") int idsess,
			@ModelAttribute("specialiteId") int idspe) {
		Session sessionId = sessionService.findById(idsess);
		formateur.setSession(sessionId);
		Specialite specialiteId = SpecialiteService.findById(idspe);
		formateur.setSpecialite(specialiteId);
		formateurService.update(formateur);
		return "redirect:/formateur/list";
	}

	@GetMapping("/catchFormateur")
	public String catchFormateur(@RequestParam("formateurId") int formateurId, Model model) {
		List<Session> listSession = sessionService.findAll();
		model.addAttribute("listSession", listSession);
		List<Specialite> listSpecialite = SpecialiteService.findAll();
		model.addAttribute("listSpecialite",listSpecialite);		
		List<Formateur> listeFormateurs = formateurService.findAll();
		model.addAttribute("lalisteformateurs", listeFormateurs);
		Formateur target = formateurService.finById(formateurId);
		model.addAttribute("target", target);
		return "list-formateurs";
	}

}
