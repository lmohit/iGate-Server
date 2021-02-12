package com.application.iGate.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.iGate.model.ResponseWrapper;
import com.application.iGate.model.Status;
import com.application.iGate.model.Visitor;
import com.application.iGate.service.VisitorService;

@RestController
@RequestMapping("/visitor")
public class VisitorController {

	@Autowired
	private VisitorService mVisitorService;

	@RequestMapping(method = RequestMethod.POST, value = "/saveVisitor")
	private ResponseWrapper<String> saveVisitor(@RequestBody Visitor visitor) {
		try {
			if (visitor == null) {
				return ResponseWrapper.getFailureResponse("Visitor is Null", 500);
			}
			UUID uuid = UUID.randomUUID();
			visitor.setVisitorId(uuid.toString());
			mVisitorService.addVisitor(visitor);
			return ResponseWrapper.getSuccessResponse();
		} catch (Exception e) {
			return ResponseWrapper.getFailureResponse("Error : " + e.getMessage(), 110);
		}
	}

}
