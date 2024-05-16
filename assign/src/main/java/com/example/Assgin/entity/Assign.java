package com.example.Assgin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.config.Task;

import java.time.LocalDateTime;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAssign;

    private Integer idAssignment;
    private Integer idEmployee;


    private LocalDateTime deadline;
    private Integer idTeam;
}
