package com.example.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.PdfService;

@RestController

public class PdfController {
	 @Autowired
	    private PdfService pdfService;

//	    @GetMapping("/generate-patient-pdf")
//	    public ResponseEntity<byte[]> generatePatientPdf() {
//	        return pdfService.generatePatientPdf();
//	    }
	    @PostMapping("/generateInvoice")
		public ResponseEntity<byte[]> generateInvoice() throws FileNotFoundException {
			byte[] pdfBytes = pdfService.generateInvoice();
			return new ResponseEntity<byte[]>(pdfBytes, HttpStatus.OK);
		}
	}



