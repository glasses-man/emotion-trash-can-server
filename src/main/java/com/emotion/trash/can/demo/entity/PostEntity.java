package com.emotion.trash.can.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "tb_post")
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateContent(String content) {
        this.content = content;
    }
}