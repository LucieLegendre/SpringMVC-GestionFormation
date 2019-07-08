package com.fr.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fr.model.Session;

@EnableJpaRepositories
public interface SessionRepository extends JpaRepository<Session, Long> {
	
	public Session findById(int searchInt);
	
	public void deleteById(int SearchInt);

}
