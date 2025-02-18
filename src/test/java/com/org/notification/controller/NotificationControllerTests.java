package com.org.notification.controller;

import com.org.notification.model.OrderNotificationRequest;
import com.org.notification.service.EmailService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class NotificationControllerTests {
    @Mock
    private EmailService emailService;

    @InjectMocks
    private NotificationController notificationController;

    @Test
    public void sendOrderConfirmation_ShouldReturnSuccessMessage() {
        String email = "test@hcl.com";
        String productId = "12345";
        OrderNotificationRequest request = new OrderNotificationRequest();
        request.setEmail(email);
        request.setProductId(productId);

        String result = notificationController.sendOrderConfirmation(request);

        assertEquals("Order confirmation email sent successfully!", result);
        verify(emailService).sendOrderConfirmationEmail(email, productId);
    }
}
