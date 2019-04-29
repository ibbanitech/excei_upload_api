package com.springboot.excelapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.excelapi.dto.TicketDTO;
public interface TicketRepository extends CrudRepository<TicketDTO, String>{

}


