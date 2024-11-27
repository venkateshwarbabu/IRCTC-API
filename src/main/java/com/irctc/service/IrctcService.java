package com.irctc.service;

import java.util.List;

import com.irctc.model.PassengerModel;
import com.irctc.model.TicketModel;

public interface IrctcService {

	public TicketModel bookTicket(PassengerModel passengerModel);

	public TicketModel getTicketByPnr(String ticketPnr);

	public TicketModel getTicketById(Integer ticketId);

	public List<TicketModel> getAllTickets();

	public TicketModel updateTicket(PassengerModel passengerModel, Integer ticketId);

	public boolean deleteTicketByTicketId(Integer ticketID);

	public boolean deleteAllTicket();

}
