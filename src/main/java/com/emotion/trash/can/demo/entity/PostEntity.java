package com.emotion.trash.can.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_post")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@ToString
public class PostEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String content;

    @Column(nullable = false)
    private String userName;

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateContent(String content) {
        this.content = content;
    }
}