package com.fr.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fr.model.Session;
import com.fr.repository.SessionRepository;

@Component
public class SessionService {
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Transactional
	public void add(Session session) {
		sessionRepository.save(session);
	}

	@Transactional
	public void update(Session session) {
		sessionRepository.save(session);
	}

	@Transactional
	public void delete(Session session) {
		sessionRepository.delete(session);
	}
	
	@Transactional(readOnly = true)
	public void deleteById(int id) {
		sessionRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public List<Session> findAll() {
		return sessionRepository.findAll();
	}

	@Transactional
	public void addAll(Collection<Session> sessions) {
		for (Session session : sessions)
			sessionRepository.save(session);
	}

	@Transactional(readOnly = true)
	public Session findById(int id) {
		return sessionRepository.findById(id);
	}

}
