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
    private JavaMailSender mailSender;  // Mocking the JavaMailSender

    @InjectMocks
    private EmailService notificationService;  // Inject the mock into your service

    @Test
    public void sendOrderConfirmationEmail_ShouldSendEmail() {
        // Given
        String email = "test@hcl.com";
        String productId = "12345";

        // Create the message that should be sent
        SimpleMailMessage expectedMessage = new SimpleMailMessage();
        expectedMessage.setTo(email);
        expectedMessage.setSubject("Order Confirmation");
        expectedMessage.setText("Your order for product " + productId + " has been placed successfully.");

        // When: Call the method you want to test
        notificationService.sendOrderConfirmationEmail(email, productId);

        // Then: Verify that mailSender.send() was called with the expected message
        verify(mailSender, times(1)).send(expectedMessage);  // Verifying that send() was called
    }
}
