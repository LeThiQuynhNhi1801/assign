package com.gr.schedule.service.impl;

import com.gr.schedule.dto.request.NewAssignmentRequest;
import com.gr.schedule.dto.response.AssignmentResponse;
import com.gr.schedule.entity.Assignment;
import com.gr.schedule.repository.AssignmentRepository;
import com.gr.schedule.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentServiceImpl implements AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;


    @Override
    public AssignmentResponse getAssignmentById(Integer assignmentId) {
        Assignment assignment = assignmentRepository.findById(assignmentId).orElseThrow();
        return new AssignmentResponse(assignment);
    }

    @Override
    public AssignmentResponse createAssignment(NewAssignmentRequest assignmentRequest) {
        Assignment assignment = new Assignment();
        assignment.setNameAssignment(assignmentRequest.getName());
        assignment.setDeadline(assignmentRequest.getDeadline());
        assignment.setAssignedByUser(assignmentRequest.getAssignedByUser());
        Assignment saved = assignmentRepository.save(assignment);
        return new AssignmentResponse(saved);
    }
}
