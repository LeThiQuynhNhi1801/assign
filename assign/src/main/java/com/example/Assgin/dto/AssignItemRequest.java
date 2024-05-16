package com.example.Assgin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignItemRequest {
    private String name;
    private String description;

    private List<Integer> listUser;

    private LocalDateTime deadline;
    private Integer idTeam;
}
