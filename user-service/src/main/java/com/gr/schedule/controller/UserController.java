package com.gr.schedule.controller;

import com.gr.schedule.dto.request.UserLogin;
import com.gr.schedule.service.TeamService;
import com.gr.schedule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("apiv1/user")
public class UserController {
    @Autowired
    private UserService  userService;
    @Autowired
    TeamService teamService;
    @GetMapping("{userId}")
    public ResponseEntity<?> getById(@PathVariable("userId") Integer userId){
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @GetMapping("inTeam/{teamId}")
    public ResponseEntity<?> getUserInTeam(@PathVariable("teamId") Integer teamId){
        return new ResponseEntity<>(userService.getUserInTeam(teamId), HttpStatus.OK);
    }

    @GetMapping("inTeam/isManager/{teamId}")
    public ResponseEntity<?> checkManager(@PathVariable("teamId") Integer teamId, @RequestParam("userId") Integer userId){
        return new ResponseEntity<>(teamService.isUserManagerForTeam(userId, teamId), HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody UserLogin userLogin){
        return new ResponseEntity<>(userService.login(userLogin), HttpStatus.OK);
    }

    @GetMapping("/allTeam/{userId}")
    public ResponseEntity<?> getAllTeam(@PathVariable("userId") Integer userId){
        return new ResponseEntity<>(userService.getAllTeamByUser(userId), HttpStatus.OK);

    }
}
