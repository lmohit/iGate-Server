package com.application.iGate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.iGate.model.Visitor;
import com.application.iGate.repository.VisitorRepository;

@Service
public class VisitorService {
	
	@Autowired
	private VisitorRepository mVisitorRepository;
	
	public void addVisitor(Visitor visitor) {
		mVisitorRepository.save(visitor);
	}
}
