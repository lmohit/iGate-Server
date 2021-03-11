package com.application.iGate.service;

import java.util.List;

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
	
	public Visitor[] getVisitorsDetails() {
		List<Visitor> visitorsDetails = mVisitorRepository.findAll();
		int size = visitorsDetails.size();
		int index = 0;
		Visitor[] visitors = new Visitor[size];
		for (Visitor vis : visitorsDetails) {
			visitors[index++] = vis;
			System.out.println(vis);
		}
		return visitors;
	}
}
