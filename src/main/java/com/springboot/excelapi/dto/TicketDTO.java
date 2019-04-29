package com.springboot.excelapi.dto;

import org.springframework.context.annotation.Description;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Description(value = "DTO example class for demo purpose.")
@Document(collection = "Ticket_details")
@Getter
@Setter
@RequiredArgsConstructor
public class TicketDTO {
  	private String ticketId;
  	private String description;
  	private String customerName;
    private String brand;
    private String category;
    private String model;
}
