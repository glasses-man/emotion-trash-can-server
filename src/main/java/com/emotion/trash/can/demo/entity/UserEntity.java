package com.emotion.trash.can.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tb_users")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @Column(name="id", length = 16, nullable = false, unique = true)
    private String id;

    @Column(length = 64, nullable = false)
    private String password;

    @Column(length = 16, nullable = false)
    private String userName;

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateUserName(String userName) {
        this.userName = userName;
    }
}
