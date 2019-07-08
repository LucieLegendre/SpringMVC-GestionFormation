package com.fr.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fr.model.Apprenant;
import com.fr.repository.ApprenantRepository;

@Component
public class ApprenantService {

	@Autowired
	private ApprenantRepository apprenantRepository;

	@Transactional
	public void add(Apprenant apprenant) {
		apprenantRepository.save(apprenant);
	}

	@Transactional
	public void update(Apprenant apprenant) {
		apprenantRepository.save(apprenant);
	}

	@Transactional
	public void delete(Apprenant apprenant) {
		apprenantRepository.delete(apprenant);

	}
	
	@Transactional(readOnly = true)
	public void deleteById(int id) {
		apprenantRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public List<Apprenant> findAll() {
		return apprenantRepository.findAll();
	}

	@Transactional
	public void addAll(Collection<Apprenant> apprenants) {
		for (Apprenant apprenant : apprenants)
			apprenantRepository.save(apprenant);
	}

	@Transactional(readOnly = true)
	public List<Apprenant> findByNom(String nom) {
		return apprenantRepository.findByNom(nom);
	}

	@Transactional(readOnly = true)
	public Apprenant findById(int id) {
		return apprenantRepository.findById(id);
	}
	
	@Transactional(readOnly = true)
	public Apprenant findBySession(int session) {
		return apprenantRepository.findBySession(session);
	}
}
