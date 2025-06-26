package com.spms.payment.util;

import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.TextAlignment;
import com.spms.payment.dto.ReceiptDTO;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;

/**
 * Component responsible for generating PDF receipts for parking payments.
 * Uses iText library to create professional-looking receipts with payment details.
 */
@Component
public class ReceiptGenerator {

    /**
     * Generates a PDF receipt with the provided payment details.
     * 
     * @param receipt DTO containing all necessary receipt information
     * @return byte array representing the generated PDF document
     * @throws if there's an error creating the PDF
     * @throws if there's an error in PDF generation
     */
    public byte[] generatePdf(ReceiptDTO receipt) {
        // Initialize PDF document and output stream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(outputStream);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        // Add receipt header
        document.add(new Paragraph("Parking Payment Receipt")
                .setBold()
                .setFontSize(18)
                .setTextAlignment(TextAlignment.CENTER));

        // Add receipt details section
        document.add(new Paragraph("Receipt Number: " + receipt.getReceiptNumber()));
        document.add(new Paragraph("Issued At: " + receipt.getIssuedAt()));
        document.add(new Paragraph("User ID: " + receipt.getUserId()));
        document.add(new Paragraph("Parking Space ID: " + receipt.getParkingSpaceId()));
        document.add(new Paragraph("Vehicle ID: " + receipt.getVehicleId()));
        document.add(new Paragraph("Amount: $" + receipt.getAmount()));
        document.add(new Paragraph("Payment Method: " + receipt.getMethod()));
        document.add(new Paragraph("Card Last 4 Digits: " + receipt.getCardLastFour()));
        document.add(new Paragraph("Transaction ID: " + receipt.getTransactionId()));
        document.add(new Paragraph("Description: " + receipt.getDescription()));
        document.add(new Paragraph("Status: " + receipt.getStatus()));

        // Add optional receipt note if present
        if (receipt.getReceiptNote() != null) {
            document.add(new Paragraph("Note: " + receipt.getReceiptNote()).setItalic());
        }

        // Add merchant information section
        document.add(new Paragraph(" "));  // Add empty line for separation
        document.add(new Paragraph("Merchant: " + receipt.getMerchantName()));
        document.add(new Paragraph("Address: " + receipt.getMerchantAddress()));
        document.add(new Paragraph("Tax ID: " + receipt.getMerchantTaxId()));

        // Finalize document and return the generated PDF as byte array
        document.close();
        return outputStream.toByteArray();
    }
}

