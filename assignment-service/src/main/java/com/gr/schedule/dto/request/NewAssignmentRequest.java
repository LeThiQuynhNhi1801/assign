package com.gr.schedule.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NewAssignmentRequest {
    private String name;
    private LocalDateTime deadline;
    private Integer assignedByUser;
    private String description;
}
