package com.gr.schedule.service.impl;

import com.gr.schedule.dto.response.UserInTeamResponse;
import com.gr.schedule.entity.Team;
import com.gr.schedule.entity.User;
import com.gr.schedule.entity.UserTeam;
import com.gr.schedule.repository.TeamRepository;
import com.gr.schedule.repository.UserRepository;
import com.gr.schedule.repository.UserTeamRepository;
import com.gr.schedule.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private UserTeamRepository userTeamRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public UserInTeamResponse isUserManagerForTeam(Integer userId, Integer teamId) {
        User user = userRepository.findById(userId).orElseThrow();
        Team team = teamRepository.findById(teamId).orElseThrow();
        UserTeam userTeam = userTeamRepository.getUserTeamByTeamAndUser(team, user);
        return new UserInTeamResponse(userTeam.getUser().getUserId(), userTeam.getUser().getUsername(), userTeam.getRole());
    }
}
