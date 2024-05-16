package com.gr.schedule.dto.response;

import com.gr.schedule.entity.Assignment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentResponse {
    private int assignmentId;
    private String nameAssignment;
    private LocalDateTime deadline;
    private Integer assignedByUser;
    private String description;

    public AssignmentResponse(Assignment assignment){
        this.assignmentId = assignment.getAssignmentId();
        this.nameAssignment = assignment.getNameAssignment();
        this.deadline = assignment.getDeadline();
        this.assignedByUser = assignment.getAssignedByUser();
        this.description = assignment.getDescription();
    }
}
