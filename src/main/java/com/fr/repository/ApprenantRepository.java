package com.fr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.fr.model.Apprenant;

@Repository
@EnableJpaRepositories
public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {
	
//	public List<Apprenant> findById_pe(String searchString);
	
	public Apprenant findById(int searchInt);
	
	public List<Apprenant> findByNom(String searchString);
	
	public List<Apprenant> findAll();
	
	public Apprenant findBySession(int searchInt);
	
	public void deleteById(int SearchInt);
}
