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

import com.fr.model.Session;
import com.fr.model.Specialite;
import com.fr.service.SessionService;
import com.fr.service.SpecialiteService;

@Controller
@RequestMapping("/session")
public class SessionController {

	@Autowired
	private SessionService sessionService;

	@Autowired
	private SpecialiteService SpecialiteService;
	
	@GetMapping("/list")
	public String listSessions(Model model) {
		List<Specialite> listSpecialite = SpecialiteService.findAll();
		model.addAttribute("listSpecialite", listSpecialite);
		List<Session> listSessions = sessionService.findAll();
		model.addAttribute("lalistesessions", listSessions);
		return "list-sessions";
	}
	
	@PostMapping("/addSession")
	public String addSession(@ModelAttribute("uneSession") Session session,
			@ModelAttribute("specialiteId") int idspe) {
		Specialite specialiteId = SpecialiteService.findById(idspe);
		session.setSpecialite(specialiteId);		
		sessionService.add(session);
		return "redirect:/session/list";
	}
	
	@GetMapping("/deleteSession")
    public String deleteSession(@RequestParam("sessionId")int id) {
		Session session = (Session) sessionService.findById(id);
		sessionService.delete(session);
		return "redirect:/session/list";		
	}
	
	@PostMapping("/updateSession")
	public String updateSession(@ModelAttribute("uneSession") Session session,@ModelAttribute("specialiteId") int idspe) {	
		Specialite specialiteId = SpecialiteService.findById(idspe);
		session.setSpecialite(specialiteId);	
		sessionService.update(session);
		return"redirect:/session/list";
	}
	
	@GetMapping("/catchSession")
	public String catchSession(@RequestParam("sessionId")int sessionId, Model model) {
		List<Specialite> listSpecialite = SpecialiteService.findAll();
		model.addAttribute("listSpecialite",listSpecialite);
		List<Session> listeSessions = sessionService.findAll();
		model.addAttribute("lalistesessions", listeSessions);
		Session target = sessionService.findById(sessionId);
		model.addAttribute("target", target);
		return "list-sessions";
	}
}
