package com.gr.schedule.service;

import com.gr.schedule.dto.request.NewAssignmentRequest;
import com.gr.schedule.dto.response.AssignmentResponse;

public interface AssignmentService {

    AssignmentResponse getAssignmentById(Integer assignmentId);

    AssignmentResponse createAssignment(NewAssignmentRequest assignmentRequest);
}
