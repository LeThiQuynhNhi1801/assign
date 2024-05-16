package com.example.Assgin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentReponse {
    private int assignmentId;
    private String nameAssignment;
    private LocalDateTime deadline;
    private Integer assignedByUser;
    private String description;

}
