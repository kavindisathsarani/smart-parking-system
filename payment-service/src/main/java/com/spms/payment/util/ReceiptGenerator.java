package com.spms.payment.util;

import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.TextAlignment;
import com.spms.payment.dto.ReceiptDTO;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;

@Component
public class ReceiptGenerator {

    public byte[] generatePdf(ReceiptDTO receipt) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(outputStream);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        document.add(new Paragraph("Parking Payment Receipt")
                .setBold()
                .setFontSize(18)
                .setTextAlignment(TextAlignment.CENTER));

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

        if (receipt.getReceiptNote() != null) {
            document.add(new Paragraph("Note: " + receipt.getReceiptNote()).setItalic());
        }

        document.add(new Paragraph(" "));
        document.add(new Paragraph("Merchant: " + receipt.getMerchantName()));
        document.add(new Paragraph("Address: " + receipt.getMerchantAddress()));
        document.add(new Paragraph("Tax ID: " + receipt.getMerchantTaxId()));

        document.close();
        return outputStream.toByteArray();
    }
}

