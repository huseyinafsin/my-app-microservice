package com.lica.notification;

import com.lica.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notification")
@Slf4j
@RequiredArgsConstructor
public class NotificationController {

    private final  NotificationService  notificationService;
    @PostMapping
    public void sendNotification( NotificationRequest notificationRequest){
        log.info("New notification.. {}", notificationRequest);
        notificationService.send(notificationRequest);

    }
}