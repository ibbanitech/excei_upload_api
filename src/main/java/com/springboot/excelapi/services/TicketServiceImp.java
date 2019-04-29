package com.springboot.excelapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.excelapi.dto.TicketDTO;
import com.springboot.excelapi.repository.TicketRepository;

@Service
@Transactional
public class TicketServiceImp implements TicketService {
	@Autowired
	TicketRepository ticketRepository;

	@Override
	public void createTicket(List<TicketDTO> ticket) {
		// TODO Auto-generated method stub
		ticketRepository.save(ticket);
	}
}
