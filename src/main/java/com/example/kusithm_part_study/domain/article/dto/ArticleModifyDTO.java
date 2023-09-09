package com.example.kusithm_part_study.domain.article.dto;

import com.example.kusithm_part_study.domain.article.entity.Tag;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;


@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleModifyDTO {
    private Long articleId;
    private String title;
    private String description;
    private String createdAt;
    private String updatedAt;
    private String message;
    private List<Tag> tagList;

}
