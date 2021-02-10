package com.application.iGate.model;

import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Visitor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "visitor_id")
	private int visitorId;
	
	@Lob
	@Column(name = "photo")
	private Blob visitorPhoto;
	
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
	private Timestamp visitingTime;
}
