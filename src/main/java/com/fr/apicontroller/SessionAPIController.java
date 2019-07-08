package com.fr.apicontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fr.model.Session;
import com.fr.model.Specialite;
import com.fr.service.SessionService;

@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
@RestController
@RequestMapping("api/session")
public class SessionAPIController {
	
	@Autowired
	private SessionService sessionService;
	
	@GetMapping("/list")
	public List<Session> getSessions(){
		return sessionService.findAll();
	}
	
	@GetMapping("/unesession/{id}")
	public Session getSessionId(@PathVariable("id") int id) {
		return sessionService.findById(id);
	}
	
	@PostMapping(value="/addsession")
	public ResponseEntity<Session> addSession(@RequestBody Session session) {
		sessionService.add(session);	
		return new ResponseEntity<Session>(session, HttpStatus.OK);
	}
		
	@DeleteMapping(value="/deletesession/{id}")
	public ResponseEntity<Boolean> deleteSession(@PathVariable("id") int id) {
		Session sess = sessionService.findById(id);
		sessionService.delete(sess);
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}
	
	@PutMapping(value="/updatesession")
	public ResponseEntity<Session> updateSession(@RequestBody Session session) {		
		sessionService.update(session);
		return new ResponseEntity<Session>(session, HttpStatus.OK);
	}

	@PutMapping(value="/specialite/{sessid}")
	public ResponseEntity<Session> linkSpeSession(@PathVariable int sessid, @RequestBody Specialite specialite){
		Session sessionId = sessionService.findById(sessid);
		sessionId.setSpecialite(specialite);
		sessionService.update(sessionId);
		return new ResponseEntity<Session>(HttpStatus.OK);
	}
}
