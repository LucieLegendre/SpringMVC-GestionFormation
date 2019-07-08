package com.fr.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fr.model.Specialite;
import com.fr.repository.SpecialiteRepository;

@Component
public class SpecialiteService {

	@Autowired
	private SpecialiteRepository specialiteRepository;
	
	@Transactional
	public void add(Specialite compte) {
		specialiteRepository.save(compte);
	}

	@Transactional
	public void update(Specialite compte) {
		specialiteRepository.save(compte);
	}

	@Transactional
	public void delete(Specialite compte) {
		specialiteRepository.delete(compte);
	}
	
	@Transactional(readOnly = true)
	public void deleteById(int id) {
		specialiteRepository.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public List<Specialite> findAll() {
		return specialiteRepository.findAll();
	}

	@Transactional
	public void addAll(Collection<Specialite> specialites) {
		for (Specialite specialite : specialites)
			specialiteRepository.save(specialite);
	}
	
	@Transactional(readOnly = true)
	public List<Specialite> findByLibelle(String libelle){
		return specialiteRepository.findByLibelle(libelle);
	}
	
	@Transactional(readOnly = true)
	public Specialite findById(int id) {
		return specialiteRepository.findById(id);
	}
}


