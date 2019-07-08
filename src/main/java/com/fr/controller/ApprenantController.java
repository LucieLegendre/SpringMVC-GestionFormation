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

import com.fr.model.Apprenant;
import com.fr.model.Session;
import com.fr.service.ApprenantService;
import com.fr.service.SessionService;

@Controller
@RequestMapping("/apprenant")
public class ApprenantController {

	@Autowired
	private ApprenantService apprenantService;

	@Autowired
	private SessionService sessionService;

	@GetMapping("/list")
	public String listApprenants(Model model) {
		List<Session> listeSession = sessionService.findAll();
		model.addAttribute("listSession", listeSession);
		List<Apprenant> listApprenants = apprenantService.findAll();
		model.addAttribute("lalisteapprenants", listApprenants);
		return "list-apprenants";
	}

	@PostMapping("/addApprenant")
	public String addApprenant(@ModelAttribute("unApprenant") Apprenant apprenant,
			@ModelAttribute("sessionId") int id) {
		Session sessionId = sessionService.findById(id);
		apprenant.setSession(sessionId);
		apprenantService.add(apprenant);
		return "redirect:/apprenant/list";
	}

	@GetMapping("/deleteApprenant")
	public String deleteApprenant(@RequestParam("apprennantId") int id) {
		Apprenant apprenant = apprenantService.findById(id);
		apprenantService.delete(apprenant);
		return "redirect:/apprenant/list";
	}

	@PostMapping("/updateApprenant")
	public String updateApprenant(@ModelAttribute("unApprenant") Apprenant apprenant,
			@ModelAttribute("sessionId") int id) {
		Session sessionId = sessionService.findById(id);
		apprenant.setSession(sessionId);
		apprenantService.update(apprenant);
		return "redirect:/apprenant/list";
	}

	@GetMapping("/catchApprenant")
	public String catchApprenant(@RequestParam("apprenantId") int apprenantId, Model model) {
		List<Session> listSession = sessionService.findAll();
		model.addAttribute("listSession", listSession);
		List<Apprenant> listeApprenants = apprenantService.findAll();
		model.addAttribute("lalisteapprenants", listeApprenants);
		Apprenant target = apprenantService.findById(apprenantId);
		model.addAttribute("target", target);
		return "list-apprenants";
	}
}
