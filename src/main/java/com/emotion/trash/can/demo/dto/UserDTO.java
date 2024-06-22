package com.emotion.trash.can.demo.dto;


import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long userID;
    private String id;
    private String password;
    private String userName;
}
