package com.org.notification.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringJUnitConfig
public class NotificationServiceTests {

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private EmailService notificationService;

    @Test
    public void sendOrderConfirmationEmail_ShouldSendEmail() {

        String email = "test@hcl.com";
        String productId = "12345";

        SimpleMailMessage expectedMessage = new SimpleMailMessage();
        expectedMessage.setTo(email);
        expectedMessage.setSubject("Order Confirmation");
        expectedMessage.setText("Your order for product " + productId + " has been placed successfully.");

        notificationService.sendOrderConfirmationEmail(email, productId);

        verify(mailSender, times(1)).send(expectedMessage);
    }
}
