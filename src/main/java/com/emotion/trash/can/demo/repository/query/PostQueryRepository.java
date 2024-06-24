package com.emotion.trash.can.demo.repository.query;

import com.emotion.trash.can.demo.dto.PostDTO;
import com.emotion.trash.can.demo.dto.PostListDTO;
import com.emotion.trash.can.demo.dto.request.PageRequest;
import com.emotion.trash.can.demo.dto.request.PostSearchRequest;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.emotion.trash.can.demo.entity.QPostEntity.postEntity;

@Repository
@RequiredArgsConstructor
public class PostQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<PostListDTO> postSearch(PostSearchRequest request){
        return jpaQueryFactory
                .select(postListConstructorExpression())
                .from(postEntity)
                .where(eqTitle(request.getTitle()))
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(postEntity.postId.asc())
                .fetch();
    }

    public List<PostListDTO> postList(PageRequest request){
        return jpaQueryFactory
                .select(postListConstructorExpression())
                .from(postEntity)
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(postEntity.postId.asc())
                .fetch();
    }

    private ConstructorExpression<PostListDTO> postListConstructorExpression(){
        return Projections.constructor(PostListDTO.class,
                postEntity.postId,
                postEntity.title,
                postEntity.content,
                postEntity.regDate,
                postEntity.modDate
        );
    }

    private BooleanExpression eqTitle(String title){
        if(title == null){
            throw new NullPointerException("title is null");
        }
        return postEntity.title.eq(title);
    }

}
