package com.example.notificationservice.dto;

import com.example.notificationservice.entity.TaskStatus;

import java.time.LocalDateTime;

public record TaskEvent(
        String eventType,
        Long taskId,
        String title,
        TaskStatus status,
        Long userId,
        String userEmail,
        LocalDateTime timestamp
) {
}