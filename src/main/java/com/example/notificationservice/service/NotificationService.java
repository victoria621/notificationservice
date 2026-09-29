package com.example.notificationservice.service;

import com.example.notificationservice.dto.NotificationResponse;
import com.example.notificationservice.entity.Notification;
import com.example.notificationservice.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Transactional
    public void createNotification(String eventType, Long taskId, Long userId,
                                   String userEmail, String subject, String message) {
        Notification notification = new Notification();
        notification.setEventType(eventType);
        notification.setTaskId(taskId);
        notification.setUserId(userId);
        notification.setUserEmail(userEmail);
        notification.setSubject(subject);
        notification.setMessage(message);
        notification.setSentAt(LocalDateTime.now());
        notification.setDelivered(true);

        notificationRepository.save(notification);

        log.info("EMAIL sent to {}: [{}] {}", userEmail, subject, message);
        log.info("Notification saved with id: {}", notification.getId());
    }

    public List<NotificationResponse> getAllNotifications() {
        return notificationRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    public List<NotificationResponse> getByUserEmail(String email) {
        return notificationRepository.findByUserEmailOrderBySentAtDesc(email).stream()
                .map(this::toDto)
                .toList();
    }

    private NotificationResponse toDto(Notification n) {
        return new NotificationResponse(
                n.getId(), n.getEventType(), n.getTaskId(), n.getUserId(),
                n.getUserEmail(), n.getSubject(), n.getMessage(),
                n.getSentAt(), n.getDelivered()
        );
    }
}