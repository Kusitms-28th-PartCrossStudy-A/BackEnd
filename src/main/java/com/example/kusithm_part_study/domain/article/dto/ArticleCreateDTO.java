package com.example.kusithm_part_study.domain.article.dto;

import com.example.kusithm_part_study.domain.article.entity.Article;
import com.example.kusithm_part_study.domain.article.entity.Tag;
import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleCreateDTO {

    private Long articleId;
    private String title;
    private String description;
    private String createdAt;
    private String updatedAt;
    private String message;
    private List<Tag> tagList;

    // dto를 엔터티로 변환하는 메서드
    public Article toEntity() {
        return Article.builder()
                .title(this.title)
                .description(this.description)
                .createdAt(this.createdAt)
                .updatedAt(this.updatedAt)
                .message(this.message)
                .build();
    }
}
