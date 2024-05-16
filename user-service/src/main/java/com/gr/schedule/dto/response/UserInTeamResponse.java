package com.gr.schedule.dto.response;

import com.gr.schedule.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInTeamResponse {
    private Integer id;
    private String username;
    private String role;

}
