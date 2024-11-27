package com.irctc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.irctc.entity.Passenger;
import com.irctc.entity.Ticket;
import com.irctc.model.PassengerModel;
import com.irctc.model.TicketModel;
import com.irctc.repository.PassengerRepo;
import com.irctc.repository.TicketRepo;

@Service
public class ServiceImpl implements IrctcService {

	
	private PassengerRepo passengerRepo;

	
	private TicketRepo ticketRepo;
	
	public ServiceImpl(PassengerRepo passengerRepo, TicketRepo ticketRepo) {
		
		this.passengerRepo = passengerRepo;
		this.ticketRepo = ticketRepo;
	}

	@Override
	public TicketModel bookTicket(PassengerModel passengerModel) {
		Ticket t = new Ticket();
		String pnr = "";
		String seatNo = "D";
		
		for (int i = 1; i < 10; i++) {
			pnr = pnr + (int) (Math.random() * 10);
			if (i == 1) {
				seatNo = seatNo + (int) (Math.random() * 10);
			}
		}
		

		t.setTicketPnr(pnr);
		t.setSeatNo(seatNo);
		t.setTicketStatus("Confirmed");
		BeanUtils.copyProperties(passengerModel, t);
		ticketRepo.save(t);
		Passenger pass = new Passenger();
		BeanUtils.copyProperties(passengerModel, pass);
		passengerRepo.save(pass);

		TicketModel tm = new TicketModel();
		BeanUtils.copyProperties(t, tm);

		return tm;
	}

	@Override
	public TicketModel getTicketByPnr(String ticketPnr) {
		Ticket byTicketPnr = ticketRepo.findByTicketPnr(ticketPnr);
		TicketModel ticketModel = new TicketModel();
		BeanUtils.copyProperties(byTicketPnr, ticketModel);

		return ticketModel;
	}

	@Override
	public TicketModel getTicketById(Integer ticketId) {
		Optional<Ticket> ticketis = ticketRepo.findById(ticketId);
		TicketModel tm = new TicketModel();
		if (ticketis.isPresent()) {
			Ticket ticket = ticketis.get();
			BeanUtils.copyProperties(ticket, tm);
		}

		return tm;
	}

	@Override
	public List<TicketModel> getAllTickets() {
		List<Ticket> all = ticketRepo.findAll();
		List<TicketModel> listIs = new ArrayList<>();
		for (Ticket t : all) {
			TicketModel tm = new TicketModel();
			BeanUtils.copyProperties(t, tm);
			listIs.add(tm);
		}
		return listIs;
	}

	@Override
	public TicketModel updateTicket(PassengerModel passengerModel, Integer ticketId) {
		Optional<Ticket> results = ticketRepo.findById(ticketId);

		TicketModel tm = new TicketModel();
		if (results.isPresent()) {
			Ticket ticket = results.get();
			if (passengerModel.getName() != null) {
				ticket.setName(passengerModel.getName());
			}if(passengerModel.getGender()!=null) {
				ticket.setGender(passengerModel.getGender());
			}
			if (passengerModel.getSource() != null) {
				ticket.setSource(passengerModel.getSource());
			}
			if (passengerModel.getDestination() != null) {
				ticket.setDestination(passengerModel.getDestination());
			}
			if (passengerModel.getJourneyDate() != null) {
				ticket.setJourneyDate(passengerModel.getJourneyDate());
			}
			if (passengerModel.getTrainNum() != null) {
				ticket.setTrainNum(passengerModel.getTrainNum());
			}
			ticketRepo.save(ticket);
			BeanUtils.copyProperties(ticket, tm);
			Optional<Passenger> passResults = passengerRepo.findById(ticketId);
			if (passResults.isPresent()) {
				Passenger pass = passResults.get();
				if (passengerModel.getName() != null) {
					pass.setName(passengerModel.getName());
				}if(passengerModel.getGender()!=null) {
					pass.setGender(passengerModel.getGender());
				}
				if (passengerModel.getSource() != null) {
					pass.setSource(passengerModel.getSource());
				}
				if (passengerModel.getDestination() != null) {
					pass.setDestination(passengerModel.getDestination());
				}
				if (passengerModel.getJourneyDate() != null) {
					pass.setJourneyDate(passengerModel.getJourneyDate());
				}
				if (passengerModel.getTrainNum() != null) {
					pass.setTrainNum(passengerModel.getTrainNum());
				}
				passengerRepo.save(pass);

			}

		}

		return tm;
	}

	@Override
	public boolean deleteTicketByTicketId(Integer ticketID) {
		Optional<Ticket> results = ticketRepo.findById(ticketID);
		if (results.isPresent()) {
			ticketRepo.deleteById(ticketID);
			return true;
		}

		return false;
	}

	@Override
	public boolean deleteAllTicket() {
		List<Ticket> all = ticketRepo.findAll();
		for (Ticket t : all) {
			ticketRepo.delete(t);

		}

		return true;
	}

}
