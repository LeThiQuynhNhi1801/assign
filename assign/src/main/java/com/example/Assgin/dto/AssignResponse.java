package com.example.Assgin.dto;

import com.example.Assgin.entity.Assign;

import java.time.LocalDateTime;
import java.util.List;

public class AssignResponse {
    private String nameAssignment;
    private List<String> listEmployee;

    private LocalDateTime deadline;
}