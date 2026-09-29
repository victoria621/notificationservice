package com.example.notificationservice.dto;

import java.time.LocalDateTime;

public record NotificationResponse(
        Long id,
        String eventType,
        Long taskId,
        Long userId,
        String userEmail,
        String subject,
        String message,
        LocalDateTime sentAt,
        Boolean delivered
) {
}