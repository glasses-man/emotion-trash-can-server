package com.emotion.trash.can.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

@Entity
@Table
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @Column(length = 16, nullable = false)
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(length = 16, nullable = false)
    private String userName;
}
