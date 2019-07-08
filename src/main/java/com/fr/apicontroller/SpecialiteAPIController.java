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

import com.fr.model.Specialite;
import com.fr.service.SpecialiteService;

@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
@RestController
@RequestMapping("api/specialite")
public class SpecialiteAPIController {
	
	@Autowired
	private SpecialiteService specialiteService;
		
	@GetMapping(value="/listspe")
	public List<Specialite> getSpecialites(){
		return specialiteService.findAll();
	}
	
	@GetMapping("/unespecialite/{id}")
	public Specialite getSpecialiteId(@PathVariable("id") int id) {
		return specialiteService.findById(id);
	}
	
	@PostMapping(value="/addspecialite")
	public ResponseEntity<Specialite> addSpecialite(@RequestBody Specialite specialite) {
		specialiteService.add(specialite);
		return new ResponseEntity<Specialite>(specialite, HttpStatus.OK);
	}
		
	@DeleteMapping(value="/deletespecialite/{id}")
	public ResponseEntity<Boolean> deleteSpe(@PathVariable("id") int id) {
		Specialite spe = specialiteService.findById(id);
		specialiteService.delete(spe);
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}
	
	@PutMapping(value="/updatespecialite")
	public ResponseEntity<Specialite> updateSpecialite(@RequestBody Specialite specialite) {		
		specialiteService.update(specialite);
		return new ResponseEntity<Specialite>(specialite, HttpStatus.OK);
	}

}
