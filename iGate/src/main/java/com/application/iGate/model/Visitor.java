package com.application.iGate.model;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "visitors")
public class Visitor {
	
	public Visitor() {}
	
	public Visitor(String visitorPhoto, String visitorName, String visitorEmailId, String visitorPurpose,
			String visitorAddress, String meetingFlatNo, String visitingTime) {
		super();
		this.visitorPhoto = visitorPhoto;
		this.visitorName = visitorName;
		this.visitorEmailId = visitorEmailId;
		this.visitorPurpose = visitorPurpose;
		this.visitorAddress = visitorAddress;
		this.meetingFlatNo = meetingFlatNo;
		this.visitingTime = visitingTime;
	}
	
	@Id
	@Column(name = "visitor_id")
	private String visitorId;

	@Column(name = "photo")
	private String visitorPhoto = null;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "name")
	private String visitorName;
	
	@Column(name = "email")
	private String visitorEmailId;
	
	@Column(name = "purpose")
	private String visitorPurpose;
	
	@Column(name = "address")
	private String visitorAddress;
	
	@Column(name = "meeting_flat_no")
	private String meetingFlatNo;
	
	@Column(name = "visiting_time")
	private String visitingTime;
	
	public String getVisitorPhoto() {
		return visitorPhoto;
	}

	public void setVisitorPhoto(String visitorPhoto) {
		this.visitorPhoto = visitorPhoto;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getVisitorEmailId() {
		return visitorEmailId;
	}

	public void setVisitorEmailId(String visitorEmailId) {
		this.visitorEmailId = visitorEmailId;
	}

	public String getVisitorPurpose() {
		return visitorPurpose;
	}

	public void setVisitorPurpose(String visitorPurpose) {
		this.visitorPurpose = visitorPurpose;
	}

	public String getVisitorAddress() {
		return visitorAddress;
	}

	public void setVisitorAddress(String visitorAddress) {
		this.visitorAddress = visitorAddress;
	}

	public String getMeetingFlatNo() {
		return meetingFlatNo;
	}

	public void setMeetingFlatNo(String meetingFlatNo) {
		this.meetingFlatNo = meetingFlatNo;
	}

	public String getVisitingTime() {
		return visitingTime;
	}

	public void setVisitingTime(String visitingTime) {
		this.visitingTime = visitingTime;
	}

	public String getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(String visitorId) {
		this.visitorId = visitorId;
	}
}
