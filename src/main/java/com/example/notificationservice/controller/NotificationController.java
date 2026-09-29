package com.example.notificationservice.controller;

import com.example.notificationservice.dto.NotificationResponse;
import com.example.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping
    public ResponseEntity<List<NotificationResponse>> getAll() {
        return ResponseEntity.ok(notificationService.getAllNotifications());
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<List<NotificationResponse>> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(notificationService.getByUserEmail(email));
    }
}