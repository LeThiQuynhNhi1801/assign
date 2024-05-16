package com.gr.schedule.dto.response;

import com.gr.schedule.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Integer id;
    private String username;
    private String password;

    public UserResponse (User user){
        this.id = user.getUserId();
        this.username = user.getUsername();
        this.password = user.getPassword();
    }
}
