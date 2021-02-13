package com.application.iGate.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.application.iGate.model.ResponseWrapper;
import com.application.iGate.model.Status;
import com.application.iGate.model.Visitor;
import com.application.iGate.service.VisitorService;

@RestController
@RequestMapping("/visitor")
public class VisitorController {

	@Autowired
	private VisitorService mVisitorService;

	@RequestMapping(method = RequestMethod.POST, value = "/saveVisitor", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	private ResponseWrapper<String> saveVisitor(
			@RequestParam("visitorName") String visitorName,
			@RequestParam("phoneNumber") String phoneNumber, 
			@RequestParam("visitorEmailId") String visitorEmailId,
			@RequestParam("visitorPurpose") String visitorPurpose,
			@RequestParam("visitorAddress") String visitorAddress, 
			@RequestParam("meetingFlatNo") String meetingFlatNo,
			@RequestParam("visitingTime") String visitingTime, 
			@RequestParam("visitorPhoto") MultipartFile file) {
		try {
			UUID uuid = UUID.randomUUID();
			Visitor visitor = new Visitor(file.getBytes(), visitorName, visitorEmailId, visitorPurpose, visitorAddress,
					meetingFlatNo, visitingTime);
			visitor.setVisitorId(uuid.toString());
			mVisitorService.addVisitor(visitor);
			return ResponseWrapper.getSuccessResponse();
		} catch (Exception e) {
			return ResponseWrapper.getFailureResponse("Error : " + e.getMessage(), 110);
		}
	}

}
