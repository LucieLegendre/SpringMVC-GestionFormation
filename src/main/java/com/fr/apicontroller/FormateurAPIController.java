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

import com.fr.model.Formateur;
import com.fr.model.Session;
import com.fr.model.Specialite;
import com.fr.service.FormateurService;

@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
@RestController
@RequestMapping("api/formateur")
public class FormateurAPIController {
	
	@Autowired
	private FormateurService formateurService;
	
	@GetMapping(value="/listformateur")
	public List<Formateur> getFormateurs(){
		return formateurService.findAll();
	}
	
	@GetMapping("/unformateur/{id}")
	public Formateur getFormateurId(@PathVariable("id") int id) {
		return formateurService.finById(id);
	}
	
	@PostMapping(value="/addformateur")
	public ResponseEntity<Formateur> addFormateur(@RequestBody Formateur formateur) {
		formateurService.add(formateur);	
		return new ResponseEntity<Formateur>(formateur, HttpStatus.OK);
	}
		
	@DeleteMapping(value="/deleteformateur/{id}")
	public ResponseEntity<Boolean> deleteFormateur(@PathVariable("id")int id){
		Formateur form = formateurService.finById(id);
		formateurService.delete(form);
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}
	
	@PutMapping(value="/updateformateur")
	public ResponseEntity<Formateur> updateFormateur(@RequestBody Formateur formateur) {		
		formateurService.update(formateur);
		return new ResponseEntity<Formateur>(formateur, HttpStatus.OK);
	}
	
	@PutMapping(value="/session/{formid}")
	public ResponseEntity<Formateur> linkSessionFormateur(@PathVariable int formid, @RequestBody Session session){
		Formateur formateurId = formateurService.finById(formid);
		formateurId.setSession(session);
		formateurService.update(formateurId);
		return new ResponseEntity<Formateur>(HttpStatus.OK);
	}
	
	@PutMapping(value="/specialite/{formid}")
	public ResponseEntity<Formateur> linkSpeFormateur(@PathVariable int formid, @RequestBody Specialite specialite){
		Formateur formateurId = formateurService.finById(formid);
		formateurId.setSpecialite(specialite);
		formateurService.update(formateurId);
		return new ResponseEntity<Formateur>(HttpStatus.OK);
	}
}

