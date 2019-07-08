package com.fr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fr.model.Formateur;

@EnableJpaRepositories
public interface FormateurRepository extends JpaRepository<Formateur, Long>{
	
	public List<Formateur> findByIdentifiant(String searchString);
	
	public List<Formateur> findByNom(String searchString);
	
	public Formateur findById(int searchInt);
	
	public void deleteById(int SearchInt);
	

}
