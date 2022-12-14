package com.lica.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("notification")
public interface NotificationClient {
    @PostMapping("api/v1/notification")
    public void sendNotification(NotificationRequest notificationRequest);
}
