package com.example.notificationservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Getter
@Setter
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_type", nullable = false, length = 50)
    private String eventType;

    @Column(name = "task_id", nullable = false)
    private Long taskId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "user_email", nullable = false, length = 100)
    private String userEmail;

    @Column(name = "subject", nullable = false, length = 200)
    private String subject;

    @Column(name = "message", nullable = false, length = 500)
    private String message;

    @Column(name = "sent_at", nullable = false)
    private LocalDateTime sentAt;

    @Column(name = "delivered")
    private Boolean delivered = true;
}