package com.example.backen_springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetails {
    private String paymentMethod;

    private String status;

    private String paymentld;

    private String razorpayPaymentLinkId;

    private String razorpayPaymentLinkReferenceld;

    private String razorpayPaymentLinkStatus;

    private String razorpayPaymentld;
}
