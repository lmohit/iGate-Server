package com.application.iGate.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import com.application.iGate.model.Visitor;
import com.application.iGate.service.VisitorService;

@RestController
@RequestMapping("/visitor")
public class VisitorController {

	private String mUploadDirectory = "D:\\Spring Boot Workspace\\VisitorImages";
			
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
			// Uploading Visitor Image to FTP Server
			Path fileUploadPath = uploadVisitorImage(file, visitorName.substring(1, visitorName.length()-1));
			Visitor visitor = new Visitor(fileUploadPath.toString(), visitorName, visitorEmailId, visitorPurpose, visitorAddress,
					meetingFlatNo, visitingTime);
			visitor.setVisitorId(uuid.toString());
			
			// Printing the Request. Need to use Logging Class
			printRequest(visitor);
			
			// Adding Visitor in DB
			mVisitorService.addVisitor(visitor);
			return ResponseWrapper.getSuccessResponse();
		} catch (IOException e) {
			return ResponseWrapper.getFailureResponse("Error : " + e.getMessage(), 110);
		}
	}
	
	private void printRequest(Visitor visitor) {
		System.out.println("Visitor : " + "name : " + visitor.getVisitorName() + " email : " + visitor.getVisitorEmailId());
	}
	
	private Path uploadVisitorImage(MultipartFile file, String visitorName) throws IOException {
		Path filePath = Paths.get(mUploadDirectory, visitorName);
		System.out.println("Image Upload Path : " + filePath);
		Files.write(filePath, file.getBytes());
		return filePath;
	}
	
	@RequestMapping(value = "/getVisitDetails")
	private ResponseWrapper<Visitor[]> getVisitorsDetails() {
		Visitor[] visitors = mVisitorService.getVisitorsDetails();
		for (Visitor vis : visitors) {
			System.out.println("Visitor : " + "name : " + vis.getVisitorName() + " email : " + vis.getPhoneNumber() + " purpose : " + vis.getVisitorPurpose());
		}
		return new ResponseWrapper<Visitor[]>(visitors, "Visitors Details Fetched Successfully", 200);
	}

}
