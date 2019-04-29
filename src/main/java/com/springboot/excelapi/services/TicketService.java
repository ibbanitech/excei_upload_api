package com.springboot.excelapi.services;

import java.util.List;

import com.springboot.excelapi.dto.TicketDTO;

public interface TicketService {
	public void createTicket(List<TicketDTO> ticket);
}
