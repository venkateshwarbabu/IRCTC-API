package com.irctc.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

public class PassengerModel {

	private String name;
	
	private String gender;

	private String source;

	private String destination;

	private LocalDate journeyDate;

	@Size(min = 5, max = 5, message = "entered ticket number must have 5 digits")
	private Integer trainNum;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}

	public Integer getTrainNum() {
		return trainNum;
	}

	public void setTrainNum(Integer trainNum) {
		this.trainNum = trainNum;
	}

}
