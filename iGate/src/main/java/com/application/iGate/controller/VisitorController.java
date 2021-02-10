package com.application.iGate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.iGate.model.ResponseWrapper;
import com.application.iGate.model.Status;
import com.application.iGate.model.Visitor;
import com.application.iGate.service.VisitorService;

@RestController
@RequestMapping("visitor")
public class VisitorController {

	@Autowired
	private VisitorService mVisitorService;
	
	@RequestMapping("/saveVisitor")
	private ResponseWrapper<String> saveVisitor(@RequestBody Visitor visitor) {
		try {
			mVisitorService.addVisitor(visitor);
			return ResponseWrapper.getSuccessResponse();
		} catch (Exception e) {
			return ResponseWrapper.getFailureResponse(Status.DB_EXCEPTION);
		}
	}
	
}
