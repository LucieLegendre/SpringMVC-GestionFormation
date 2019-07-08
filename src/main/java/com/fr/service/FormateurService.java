package com.fr.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fr.model.Formateur;
import com.fr.repository.FormateurRepository;

@Component
public class FormateurService {

	@Autowired
	private FormateurRepository formateurRepository;
	
	@Transactional
	public void add(Formateur formateur) {
		formateurRepository.save(formateur);
	}

	@Transactional
	public void update(Formateur formateur) {
		formateurRepository.save(formateur);
	}

	@Transactional
	public void delete(Formateur formateur) {
		formateurRepository.delete(formateur);
	}
	
	@Transactional(readOnly = true)
	public void deleteById(int id) {
		formateurRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public List<Formateur> findAll() {
		return formateurRepository.findAll();
	}

	@Transactional
	public void addAll(Collection<Formateur> formateurs) {
		for (Formateur formateur: formateurs)
			formateurRepository.save(formateur);
	}

	@Transactional(readOnly = true)
	public List<Formateur> findByNom(String nom) {
		return formateurRepository.findByNom(nom);
	}
	
	@Transactional(readOnly = true)
	public Formateur finById(int id){
		return formateurRepository.findById(id);
	}
}
