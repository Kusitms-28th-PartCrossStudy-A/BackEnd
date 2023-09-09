package com.example.kusithm_part_study.domain.article.controller;

import com.example.kusithm_part_study.domain.article.dto.ArticleResquestDto;
import com.example.kusithm_part_study.domain.article.dto.BaseArticleResponseDto;
import com.example.kusithm_part_study.domain.article.dto.GetArticlesResponseDto;
import com.example.kusithm_part_study.domain.article.service.ArticleService;
import com.example.kusithm_part_study.global.common.BaseResponse;
import com.example.kusithm_part_study.global.common.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
@Controller
public class ArticleApiController {
    private final ArticleService articleService;

    @GetMapping
    public ResponseEntity<BaseResponse<?>> getArticles() {
        final GetArticlesResponseDto responseDto = articleService.getActicles();
        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.of(SuccessCode.OK, responseDto));
    }

    @PostMapping
    public ResponseEntity<BaseResponse<?>> addArticle(@RequestBody final ArticleResquestDto articleResquestDto) {
        final BaseArticleResponseDto responseDto = articleService.createArticle(articleResquestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BaseResponse.of(SuccessCode.CREATED, responseDto));
    }
    @GetMapping("/{articleId}")
    public ResponseEntity<BaseResponse<?>> getArticle(@PathVariable final Long articleId) {
        final BaseArticleResponseDto responseDto = articleService.getArticle(articleId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.of(SuccessCode.OK, responseDto));
    }

    @PutMapping("/{articleId}")
    public ResponseEntity<BaseResponse<?>> updateArticle(@PathVariable final Long articleId, @RequestBody final ArticleResquestDto articleResquestDto) {
        final BaseArticleResponseDto responseDto = articleService.modify(articleId, articleResquestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.of(SuccessCode.OK, responseDto));
    }

    @DeleteMapping("/{articleId}")
    public ResponseEntity<BaseResponse<?>> deleteArticle(@PathVariable final Long articleId) {
        articleService.deleteArticle(articleId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.of(SuccessCode.OK, null));
    }

}
