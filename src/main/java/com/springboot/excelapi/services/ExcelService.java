package com.springboot.excelapi.services;

import com.springboot.excelapi.dto.TicketDTO;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Description;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Description(value = "Service layer responsible for processing data.")
@Service
public class ExcelService {

//    /**
//     * Method for reading from specific excel file when we know types and number of cells.
//     *
//     * @return list of mapped objects
//     * @throws IOException - throws IO exception.
//     */
//    public List<TicketDTO> readFromExcelWithKnownObject() throws IOException
//    {
//        // get file that needs to be mapped into object.
//        Resource resource = new ClassPathResource("documents/sample.xlsx");
//        FileInputStream inputStream = new FileInputStream(resource.getFile());
//
//        // get workbook and sheet
//        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
//        Sheet sheet = workbook.getSheetAt(0);
//
//        List<TicketDTO> ticketDTOList = new ArrayList<>();
//
//        // iterate through rows
//        Iterator<Row> iterator = sheet.iterator();
//        while (iterator.hasNext())
//        {
//            Row currentRow = iterator.next();
//
//            // skip heading row.
//            if (currentRow.getRowNum() == 0) {
//                continue;
//            }
//
//            // mapped to example object.
//            TicketDTO ticketDTO = new TicketDTO();
//            ticketDTO.setTicketId(currentRow.getCell(0).getStringCellValue());
//            ticketDTO.setCustomer(currentRow.getCell(1).getStringCellValue());
//            ticketDTO.setBrand(currentRow.getCell(2).getDateCellValue().toString());
//            ticketDTO.setCategory(currentRow.getCell(3).getStringCellValue());
//            ticketDTO.setModel(currentRow.getCell(4).getStringCellValue());
//
//            ticketDTOList.add(ticketDTO);
//        }
//        return ticketDTOList;
//    }
    
    /**
     * Method for reading from specific excel file when we know types and number of cells.
     *
     * @return list of mapped objects
     * @throws IOException - throws IO exception.
     */
    public List<TicketDTO> readFromExcelWithKnownObject(MultipartFile multipartFile) throws IOException
    {
        // get file that needs to be mapped into object.
    	    InputStream inputStream = new ByteArrayInputStream(multipartFile.getBytes());

        // get workbook and sheet
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        List<TicketDTO> ticketDTOList = new ArrayList<>();

        // iterate through rows
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext())
        {
            Row currentRow = iterator.next();

            // skip heading row.
            if (currentRow.getRowNum() == 0) {
                continue;
            }

    // mapped to example object.
    TicketDTO ticketDTO = new TicketDTO();
    ticketDTO.setTicketId(currentRow.getCell(0).getStringCellValue());
    ticketDTO.setDescription(currentRow.getCell(1).getStringCellValue());
    ticketDTO.setBrand(currentRow.getCell(2).getStringCellValue());
    ticketDTO.setCategory(currentRow.getCell(3).getStringCellValue());
    ticketDTO.setModel(currentRow.getCell(4).getStringCellValue());

            ticketDTOList.add(ticketDTO);
        }
        return ticketDTOList;
    }


}
