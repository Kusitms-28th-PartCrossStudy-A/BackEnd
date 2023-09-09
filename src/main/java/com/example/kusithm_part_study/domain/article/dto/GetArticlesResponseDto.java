package com.example.kusithm_part_study.domain.article.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class GetArticlesResponseDto {
    private List<BaseArticleResponseDto> articles;

    public static GetArticlesResponseDto of(List<BaseArticleResponseDto> baseArticleResponseDtos){
        return GetArticlesResponseDto.builder()
                .articles(baseArticleResponseDtos)
                .build();
    }
}
