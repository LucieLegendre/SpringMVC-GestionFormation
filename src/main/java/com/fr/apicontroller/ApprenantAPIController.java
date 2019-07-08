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

import com.fr.model.Apprenant;
import com.fr.model.Session;
import com.fr.service.ApprenantService;

@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
@RestController
@RequestMapping("api/apprenants")
public class ApprenantAPIController {
	
	@Autowired
	private ApprenantService apprenantService;
	
	@GetMapping("/list")
	public List<Apprenant> getApprenants() {
		return apprenantService.findAll();		
	}
	@GetMapping("/unapprenant/{id}")
	public Apprenant getApprenantId(@PathVariable("id") int id) {
		return apprenantService.findById(id);
	}
	

	@PostMapping(value="/addapprenant")
	public ResponseEntity<Apprenant> addApprenant(@RequestBody Apprenant apprenant) {
		apprenantService.add(apprenant);	
		return new ResponseEntity<Apprenant>(apprenant, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteapp/{id}")
	public ResponseEntity<Boolean> deleteApprenant(@PathVariable("id") int id) {
		Apprenant app = apprenantService.findById(id);
		apprenantService.delete(app);
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}
		
//	@DeleteMapping(value="/deleteapprenant/{id}")
//	public void deleteByIdApp(@PathVariable("id")int id) {
//		apprenantService.deleteById(id);
//	}
	
	@PutMapping(value="/updateapprenant")
	public ResponseEntity<Apprenant> updateApprenant(@RequestBody Apprenant apprenant) {		
		apprenantService.update(apprenant);
		return new ResponseEntity<Apprenant>(apprenant, HttpStatus.OK);
	}
	
		
	@PutMapping(value="/session/{appid}")
	public ResponseEntity<Apprenant> linkSessionApprenant( @PathVariable("appid") int appid, @RequestBody Session session) {		
		Apprenant apprenantId = apprenantService.findById(appid);
		apprenantId.setSession(session);
		apprenantService.update(apprenantId);
		return new ResponseEntity<Apprenant>(HttpStatus.OK);
	}
}
