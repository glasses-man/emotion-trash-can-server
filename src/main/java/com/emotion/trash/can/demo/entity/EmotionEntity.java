package com.emotion.trash.can.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_emotion")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class EmotionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "fk_post_id")
    private PostEntity post;
    public void modify(String content){
        this.content=content;
    }
}
