package com.musahalilecer.booksaleproject.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserResponse {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserResponse(Integer id, String password, String username) {
        this.id = id;
        this.password = password;
        this.username = username;
    }

    private Integer id;
    private String username;
    private String password;
}
