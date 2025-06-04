package com.musahalilecer.booksaleproject.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserRequest {
    private String username;
    private String password;
}
