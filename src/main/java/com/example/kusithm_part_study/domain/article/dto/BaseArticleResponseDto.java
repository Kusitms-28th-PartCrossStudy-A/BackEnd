package com.example.kusithm_part_study.domain.article.dto;

import com.example.kusithm_part_study.domain.article.entity.Article;
import com.example.kusithm_part_study.domain.article.entity.Tag;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class BaseArticleResponseDto {
    private Long id;
    private String title;
    private String description;
    private String body;
    private List<Tag> tagList;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static BaseArticleResponseDto of(Article article){
        return BaseArticleResponseDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .description(article.getDescription())
                .body(article.getBody())
                .tagList(article.getTagList())
                .createdAt(article.getCreateDate())
                .updatedAt(article.getLastModifiedDate())
                .build();
    }
}
