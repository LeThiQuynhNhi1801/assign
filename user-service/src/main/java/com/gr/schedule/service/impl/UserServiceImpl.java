package com.gr.schedule.service.impl;

import com.gr.schedule.dto.request.UserLogin;
import com.gr.schedule.dto.response.TeamResponse;
import com.gr.schedule.dto.response.UserInTeamResponse;
import com.gr.schedule.dto.response.UserResponse;
import com.gr.schedule.entity.Team;
import com.gr.schedule.entity.User;
import com.gr.schedule.entity.UserTeam;
import com.gr.schedule.exception.CustomException;
import com.gr.schedule.repository.TeamRepository;
import com.gr.schedule.repository.UserRepository;
import com.gr.schedule.repository.UserTeamRepository;
import com.gr.schedule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTeamRepository userTeamRepository;
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public UserResponse getUserById(Integer userId){
        User user = userRepository.findById(userId).orElseThrow();
        return new UserResponse(user);
    }

    @Override
    public List<UserInTeamResponse> getUserInTeam(Integer teamId) {
        List<UserTeam> users = userTeamRepository.getUserTeamByTeam(teamRepository.findById(teamId).orElseThrow());

        List<UserInTeamResponse> list = new ArrayList<>();
        for (UserTeam userTeam : users){

            list.add(new UserInTeamResponse(userTeam.getUser().getUserId(), userTeam.getUser().getUsername(), userTeam.getRole()));
        }
        return list;
    }

    @Override
    public UserResponse login(UserLogin userLogin) {
        User user = userRepository.getUserByUsername(userLogin.getUsername());
        if (user == null) {
            throw new CustomException(404, "User not found");
        }

        if (!user.getPassword().equals(userLogin.getPassword())) {
            throw new CustomException(400, "Username or password is not correct");
        }

        return new UserResponse(user);
    }

    @Override
    public List<TeamResponse> getAllTeamByUser(Integer userId) {
        List<Team> teams = userTeamRepository.getTeamByUser(userId);

        List<TeamResponse> list = new ArrayList<>();
        for (Team team : teams){
            TeamResponse teamResponse = new TeamResponse();
            teamResponse.setIdTeam(team.getTeamId());
            teamResponse.setTeamName(team.getTeamName());
            list.add(teamResponse);
        }
        return list;
    }

}
