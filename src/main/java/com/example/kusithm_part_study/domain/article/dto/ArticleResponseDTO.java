package com.example.kusithm_part_study.domain.article.dto;

import com.example.kusithm_part_study.domain.article.entity.Article;
import lombok.*;

import java.util.stream.Collectors;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleResponseDTO {
    private Long articleId;
    private String title;
    private String description;
    private String body;
    private String createdAt;
    private String updatedAt;
    private String message;

    //엔터티를 DTO를 변환하는 생성자
    public ArticleResponseDTO(Article article){
        this.title=article.getTitle();
        this.description=article.getDescription();
        this.createdAt=article.getCreateDate();
        this.hashTags=post.getHashTags()
                .stream()
                .map(ht->ht.getTagName())
                .collect(Collectors.toList());
    }
}
