package com.springboot.excelapi.resources;


import com.springboot.excelapi.dto.TicketDTO;
import com.springboot.excelapi.services.ExcelService;
import com.springboot.excelapi.services.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Description(value = "Resource layer for handling REST requests.")
@RestController
@RequestMapping("api")
public class ExcelResource {
    private ExcelService excelService;
    @Autowired
    TicketService ticketService;

    /**
     * Constructor / dependency injector
     * @param excelService - service layer dependency.
     */
    public ExcelResource(ExcelService excelService) {
        this.excelService = excelService;
    }

    @PostMapping(value = "/known-cells", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TicketDTO>> mapExcelRowsToObject(@RequestParam("file") MultipartFile multipartFile) throws IOException
    {
        List<TicketDTO> ticketDTOList = this.excelService.readFromExcelWithKnownObject(multipartFile);
        ticketService.createTicket(ticketDTOList);
        return new ResponseEntity<>(ticketDTOList, HttpStatus.OK);
    }
}
