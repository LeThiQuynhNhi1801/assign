package com.gr.schedule.repository;

import com.gr.schedule.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTeamRepository extends JpaRepository<UserTeam, Integer> {
    @Query("SELECT ut FROM UserTeam ut WHERE ut.user = :user AND ut.team = :team AND ut.role = 'manager'")
    UserTeam findByUserAndTeamAndManagerRole(@Param("user") User user, @Param("team") Team team);

    List<UserTeam> getUserTeamByTeam(Team team);

    @Query("select u from User u " +
            "join UserTeam ut on u.userId = ut.user.userId " +
            "where ut.team.teamId = :teamId")
    List<User> getUserInTeam(@Param("teamId") Integer teamId);

    UserTeam getUserTeamByTeamAndUser(Team team,User user);
    @Query("select t from Team t " +
            "join UserTeam ut on t.teamId = ut.team.teamId " +
            "where ut.user.userId = :userId")
    List<Team> getTeamByUser(@Param("userId") Integer userId);
}
