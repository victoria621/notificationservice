package com.example.notificationservice.service;

import com.example.notificationservice.dto.TaskEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskEventConsumer {

    private final NotificationService notificationService;

    @KafkaListener(topics = "task-events", groupId = "notification-group")
    public void consumeTaskEvent(TaskEvent event) {
        log.info("📥 Received event: {}", event);

        switch (event.eventType()) {
            case "TASK_CREATED" -> notificationService.createNotification(
                    event.eventType(),
                    event.taskId(),
                    event.userId(),
                    event.userEmail(),
                    "Task Created",
                    "Your task '" + event.title() + "' has been created"
            );

            case "TASK_COMPLETED" -> notificationService.createNotification(
                    event.eventType(),
                    event.taskId(),
                    event.userId(),
                    event.userEmail(),
                    "Task Completed",
                    "Congratulations! You completed '" + event.title() + "'"
            );

            case "TASK_DELETED" -> notificationService.createNotification(
                    event.eventType(),
                    event.taskId(),
                    event.userId(),
                    event.userEmail(),
                    "Task Deleted",
                    "Task '" + event.title() + "' was deleted"
            );

            default -> log.warn("Unknown event type: {}", event.eventType());
        }
    }
}