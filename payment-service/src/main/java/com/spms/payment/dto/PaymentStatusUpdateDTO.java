package com.spms.payment.dto;

import com.spms.payment.model.Payment.PaymentStatus;
import lombok.Data;

@Data
public class PaymentStatusUpdateDTO {
    private PaymentStatus status;
    private String transactionId;
    private String failureReason;
}