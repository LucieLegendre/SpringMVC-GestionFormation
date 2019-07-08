package com.fr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fr.model.Specialite;

@EnableJpaRepositories
public interface SpecialiteRepository extends JpaRepository<Specialite, Long>{
	
	public Specialite findById(int searchInt);
	
	public List<Specialite> findByLibelle(String searchString);
	
	public void deleteById(int SearchInt);

}
