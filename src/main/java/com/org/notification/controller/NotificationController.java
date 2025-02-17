package com.org.notification.controller;

import com.org.notification.model.OrderNotificationRequest;
import com.org.notification.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    private final EmailService emailService;

    @Autowired
    public NotificationController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/sendOrderConfirmation")
    public String sendOrderConfirmation(@RequestBody OrderNotificationRequest request) {
        emailService.sendOrderConfirmationEmail(request.getEmail(), request.getProductId());
        return "Order confirmation email sent successfully!";
    }
}
