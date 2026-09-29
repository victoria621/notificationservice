package com.example.notificationservice.entity;

import lombok.Getter;

@Getter
public enum TaskStatus {
    TODO("To Do"),
    IN_PROGRESS("In Progress"),
    DONE("Done"),
    CANCELLED("Cancelled");

    private final String displayName;

    TaskStatus(String displayName) {
        this.displayName = displayName;
    }
}
