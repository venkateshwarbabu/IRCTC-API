package com.irctc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irctc.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {

	public Ticket findByTicketPnr(String pnr);

}
