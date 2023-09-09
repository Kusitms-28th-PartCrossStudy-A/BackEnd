package com.example.kusithm_part_study.domain.article.service;

import com.example.kusithm_part_study.domain.article.dto.*;
import com.example.kusithm_part_study.domain.article.entity.Article;
import com.example.kusithm_part_study.domain.article.entity.Tag;
import com.example.kusithm_part_study.domain.article.repository.ArticleRepository;
import com.example.kusithm_part_study.domain.article.repository.HashTagRepository;
import com.example.kusithm_part_study.global.error.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

import static com.example.kusithm_part_study.global.error.exception.ErrorCode.ENTITY_NOT_FOUND;

@org.springframework.stereotype.Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final HashTagRepository hashTagRepository;

    public GetArticlesResponseDto getActicles() {
        List<Article> articles = articleRepository.findAll();
        List<BaseArticleResponseDto> baseArticleResponseDtos = articles.stream().map(BaseArticleResponseDto::of).toList();
        return GetArticlesResponseDto.of(baseArticleResponseDtos);
    }

    public BaseArticleResponseDto createArticle(ArticleResquestDto resquestDto) {
        List<Tag> tags = resquestDto.getTagList().stream().map(this::saveTag).toList();
        Article article = Article.createArticle(resquestDto.getTitle(), resquestDto.getDescription(), resquestDto.getBody(), tags);
        saveArticle(article);
        return BaseArticleResponseDto.of(article);
    }

    public BaseArticleResponseDto getArticle(Long articleId) {
        Article article = articleRepository.findById(articleId).orElseThrow();
        return BaseArticleResponseDto.of(article);
    }

    private Tag saveTag(String tag) {
        Tag newTag = Tag.createTag(tag);
        hashTagRepository.save(newTag);
        return newTag;
    }

    private void saveArticle(Article article) {
        articleRepository.save(article);
    }

    public BaseArticleResponseDto modify(Long articleId, ArticleResquestDto resquestDto) {
        Article acticle = articleRepository.findById(articleId).orElseThrow();
        // 수정 시작
        List<Tag> tagList = resquestDto.getTagList().stream().map(Tag::createTag).toList();
        acticle.updateArticle(resquestDto.getTitle(), resquestDto.getDescription(), resquestDto.getTitle(), tagList);
        return BaseArticleResponseDto.of(acticle);
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
