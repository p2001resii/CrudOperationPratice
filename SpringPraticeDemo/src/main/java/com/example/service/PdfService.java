package com.example.service;

import java.io.FileNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;
@Service
public interface PdfService {
	// ResponseEntity<byte[]> generatePatientPdf();

	byte[] generateInvoice() throws FileNotFoundException, DocumentException;
	}


