package com.gr.schedule.service;

import com.gr.schedule.dto.response.UserInTeamResponse;
import com.gr.schedule.entity.Team;
import com.gr.schedule.entity.User;

public interface TeamService {
    UserInTeamResponse isUserManagerForTeam(Integer userId, Integer teamId);
}
