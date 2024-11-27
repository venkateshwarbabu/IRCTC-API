package com.irctc.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.model.PassengerModel;
import com.irctc.model.TicketModel;
import com.irctc.service.IrctcService;

@RestController
@RequestMapping("/irctc")
@Validated
public class MainController {

	
	private IrctcService irctcService;
	
	
	public MainController(IrctcService irctcService) {
		
		this.irctcService = irctcService;
	}

	@PostMapping("/bookTicket")
	public ResponseEntity<TicketModel> bookTicket(@RequestBody PassengerModel passengerModel) {

		TicketModel data= irctcService.bookTicket(passengerModel);
		return new ResponseEntity<TicketModel>(data, HttpStatus.CREATED);

	}

	@GetMapping("/ticket/pnr/{ticketPnr}")
	public ResponseEntity<TicketModel> getTicketByPnr(@PathVariable String ticketPnr) {
		TicketModel response = irctcService.getTicketByPnr(ticketPnr);
		if (response != null) {
			return new ResponseEntity<TicketModel>(response, HttpStatus.OK);

		} else {
			return new ResponseEntity<TicketModel>(response, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/ticket/id/{ticketId}")
	public ResponseEntity<TicketModel> getTicketById(@PathVariable Integer ticketId) {
		TicketModel ticketById = irctcService.getTicketById(ticketId);
		if (ticketById != null) {
			return new ResponseEntity<TicketModel>(ticketById, HttpStatus.OK);

		} else {
			return new ResponseEntity<TicketModel>(ticketById, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/ticket/allTickets")
	public ResponseEntity<List<TicketModel>> getAllTickets() {
		List<TicketModel> allTickets = irctcService.getAllTickets();
		if (allTickets != null) {
			return new ResponseEntity<List<TicketModel>>(allTickets, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<TicketModel>>(allTickets, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/ticket/update/id/{ticketId}")
	public ResponseEntity<TicketModel> updateTicket(@RequestBody PassengerModel passengerModel,@PathVariable Integer ticketId){
		
		TicketModel updateTicket = irctcService.updateTicket(passengerModel, ticketId);
		if(updateTicket!=null) {
			return new ResponseEntity<TicketModel>(updateTicket,HttpStatus.OK);
		}else {
			return new ResponseEntity<TicketModel>(updateTicket,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/ticket/delete/id/{ticketId}")
	public ResponseEntity<String> deleteTicketByTicketId(@PathVariable Integer ticketID) {
		boolean results= irctcService.deleteTicketByTicketId(ticketID);
		if(results==true) {
			return new ResponseEntity<String>("data delete successfully",HttpStatus.OK);
			
		}else {
			return new ResponseEntity<String>("data delete successfully",HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/ticket/deleteAllTickets")
	public ResponseEntity<String> deleteAllTicket(){
		boolean results= irctcService.deleteAllTicket();
		if(results==true) {
			return new ResponseEntity<String>("all data vanished",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("already deleted",HttpStatus.OK);
		}
		
	}

}
