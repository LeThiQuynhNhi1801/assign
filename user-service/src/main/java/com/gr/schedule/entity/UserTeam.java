package com.gr.schedule.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UserTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userTeamId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    private String role;
}
