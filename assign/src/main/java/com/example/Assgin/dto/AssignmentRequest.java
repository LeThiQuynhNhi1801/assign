package com.example.Assgin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class AssignmentRequest {
    private String name;
    private LocalDateTime deadline;
    private String description;
    private Integer assignedByUser;
}
