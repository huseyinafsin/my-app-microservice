package com.lica.notification;

import com.lica.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest){
        notificationRepository.save(
          Notification.builder()
                  .toCustomerId(notificationRequest.getToCustomerId())
                  .toCustomerEmail(notificationRequest.getToCustomerEmail())
                  .sender("Lica Net")
                  .message(notificationRequest.getMessage())
                  .sentAt(notificationRequest.getSentAt())
                  .build()
        );
    }
}
