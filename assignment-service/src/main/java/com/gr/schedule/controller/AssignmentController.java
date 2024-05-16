package com.gr.schedule.controller;

import com.gr.schedule.dto.request.NewAssignmentRequest;
import com.gr.schedule.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("apiv1/assignment")
public class AssignmentController {
    @Autowired
    private AssignmentService assignmentService;
    @GetMapping("{assignmentId}")
    public ResponseEntity<?> getById(@PathVariable("assignmentId") Integer assignmentId){
        return new ResponseEntity<>(assignmentService.getAssignmentById(assignmentId), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> createAssignment(@RequestBody NewAssignmentRequest assignmentRequest){
        return new ResponseEntity<>(assignmentService.createAssignment(assignmentRequest), HttpStatus.CREATED);
    }
}
