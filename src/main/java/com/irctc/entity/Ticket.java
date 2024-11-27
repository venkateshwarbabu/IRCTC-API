package com.irctc.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ticket {

	@Id
	@Column(name = "Ticket_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ticketId;

	@Column(name = "Passenger_name")
	private String name;
	
	@Column(name="Passenger_Gender")
	private String gender;

	@Column(name = "Passenger_Source")
	private String source;

	@Column(name = "Passenger_destination")
	private String destination;

	@Column(name = "Passenger_Jdate")
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate journeyDate;

	@Column(name = "Train_Num")
	private Integer trainNum;

	@Column(name = "Ticket_Pnr")
	private String ticketPnr;

	@Column(name = "Seat_number")
	private String seatNo;

	@Column(name = "Ticket_Status")
	private String ticketStatus;

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

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

	public String getTicketPnr() {
		return ticketPnr;
	}

	public void setTicketPnr(String ticketPnr) {
		this.ticketPnr = ticketPnr;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

}
