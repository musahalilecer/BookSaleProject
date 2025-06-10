package com.musahalilecer.booksaleproject.dto.request;

import lombok.*;

@Data
@Builder
public class UserRequest {
    private String username;
    private String password;
}
