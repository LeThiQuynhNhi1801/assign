package com.gr.schedule.service;

import com.gr.schedule.dto.request.UserLogin;
import com.gr.schedule.dto.response.TeamResponse;
import com.gr.schedule.dto.response.UserInTeamResponse;
import com.gr.schedule.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse getUserById(Integer userId);

    List<UserInTeamResponse> getUserInTeam(Integer teamId);

    UserResponse login(UserLogin userLogin);

    List<TeamResponse> getAllTeamByUser(Integer userId);
}
