package com.example.service;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;

import org.springframework.stereotype.Service;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class PdfServiceImp  implements PdfService {

//	@Override
//	public ResponseEntity<byte[]> generatePatientPdf() {
//		try {
//            PDDocument document = new PDDocument();
//            PDPage page = new PDPage();
//            document.addPage(page);
//            PDPageContentStream contentStream = new PDPageContentStream(document, page);
//                                                   // Add patient details
//            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
//            contentStream.beginText();
//            contentStream.newLineAtOffset(50, 700);
//            contentStream.showText("Patient Details:");
//            contentStream.endText();
//            String patientName = "prasanna";
//            String patientId = "12345";
//            String dateOfBirth = "07/25/2001";
//            contentStream.setFont(PDType1Font.HELVETICA, 12);
//            contentStream.beginText();
//            contentStream.newLineAtOffset(50, 680);
//            contentStream.showText("Name: " + patientName);
//            contentStream.newLineAtOffset(0, -20);
//            contentStream.showText("ID: " + patientId);
//            contentStream.newLineAtOffset(0, -20);
//            contentStream.showText("Date of Birth: " + dateOfBirth);
//            contentStream.endText();
//
//                                                            // Add additional data
//            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
//            contentStream.beginText();
//            contentStream.newLineAtOffset(40, 620);
//            contentStream.showText("Additional Data for patient :");
//            contentStream.endText();
//
//           
//            String additionalData = "This is  data for the patient.";
//
//            contentStream.setFont(PDType1Font.HELVETICA, 12);
//            contentStream.beginText();
//            contentStream.newLineAtOffset(40, 600);
//            contentStream.showText(additionalData);
//            contentStream.endText();
//           
//            contentStream.close();
//
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            document.save(byteArrayOutputStream);
//            document.close();
//	           
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_PDF);
//            headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=patient-data.pdf");
//  
//            return new ResponseEntity<>(byteArrayOutputStream.toByteArray(), headers, org.springframework.http.HttpStatus.OK);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//   }

//	@Override
//	public byte[] generateInvoice() {
//		
			@Override
			public byte[] generateInvoice() throws FileNotFoundException, DocumentException {
				Document document = new Document(PageSize.A4);

				ByteArrayOutputStream out = new ByteArrayOutputStream();

				PdfWriter writer = PdfWriter.getInstance(document, out);

				document.open();

				Font f = FontFactory.getFont("c:/windows/fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 14.00f);

				f.setStyle(Font.BOLD);

				PdfContentByte para = writer.getDirectContent();

				para.rectangle(document.left(), document.bottom(), document.right() - document.left(),

				document.top() - document.bottom());

				para.stroke();

				PdfPTable table = new PdfPTable(2);

				Paragraph paraForOrgDetails = new Paragraph();

				paraForOrgDetails.setAlignment(Element.ALIGN_LEFT);

				paraForOrgDetails.add(new Phrase("Mamatha Hospital", f));

				paraForOrgDetails.add(Chunk.NEWLINE);

				paraForOrgDetails.add(new Phrase("plot 2-37/1,Madhapur"));

				paraForOrgDetails.add(Chunk.NEWLINE);

				paraForOrgDetails.add(new Phrase("Hyderabad Telangana India-500025"));

				paraForOrgDetails.add(Chunk.NEWLINE);

				paraForOrgDetails.add(new Phrase("Contact No : 8374241485"));

				paraForOrgDetails.add(Chunk.NEWLINE);

				paraForOrgDetails.add(new Phrase("GST : 32APTGT1752B277"));

				Paragraph paraForPatientDetails = new Paragraph();

				paraForPatientDetails.setAlignment(Element.ALIGN_LEFT);

				paraForPatientDetails.add(new Phrase("Bill To : ", f));

				paraForPatientDetails.add(Chunk.NEWLINE);

				paraForPatientDetails.add(new Phrase("Ms.prasanna | 23 Years | female", f));

				paraForPatientDetails.add(Chunk.NEWLINE);

				paraForPatientDetails.add(new Phrase("UHID : P00003725", f));

				paraForPatientDetails.add(Chunk.NEWLINE);

				paraForPatientDetails.add(new Phrase("Address :", f));

				paraForPatientDetails.add(Chunk.NEWLINE);

				paraForPatientDetails.add(new Phrase("vinukonda AP 506006"));

				PdfPCell cellForOrg = new PdfPCell();

				cellForOrg.addElement(paraForOrgDetails);

				PdfPCell cellForPatient = new PdfPCell();

				cellForPatient.addElement(paraForPatientDetails);

				table.addCell(cellForOrg);

				table.addCell(cellForPatient);

				table.setTotalWidth(document.getPageSize().getWidth() - 70);

				table.writeSelectedRows(0, -1, document.left() - 1, document.top() - 35, para);

				PdfPTable table1 = new PdfPTable(4);

				PdfPCell departmentCell = new PdfPCell(new Phrase("Department", f));

				PdfPCell serviceNameCell = new PdfPCell(new Phrase("Service Name", f));

				PdfPCell quantityCell = new PdfPCell(new Phrase("Qty", f));

				PdfPCell serviceAmtCell = new PdfPCell(new Phrase("Service Amt", f));

				table1.addCell(departmentCell);

				table1.addCell(serviceNameCell);

				table1.addCell(quantityCell);

				table1.addCell(serviceAmtCell);

				table1.setHeaderRows(4);

				table1.setTotalWidth(document.getPageSize().getWidth() - 70);

				table1.writeSelectedRows(0, -1, document.left() - 1, document.top() - table.getTotalHeight() - 45, para);

				document.close();

				return out.toByteArray();
			}
		}
	
