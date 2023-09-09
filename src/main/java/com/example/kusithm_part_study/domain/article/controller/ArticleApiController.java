package com.example.kusithm_part_study.domain.article.controller;

import com.example.kusithm_part_study.domain.article.dto.ArticleCreateDTO;
import com.example.kusithm_part_study.domain.article.dto.ArticleListResponseDTO;
import com.example.kusithm_part_study.domain.article.dto.ArticleResponseDTO;
import com.example.kusithm_part_study.domain.article.service.ArticleService;
import com.example.kusithm_part_study.global.common.BaseResponse;
import com.example.kusithm_part_study.global.common.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
@Controller
public class ArticleApiController {
    private final ArticleService articleService;

    //게시물 전체 조회
    @GetMapping
    public ResponseEntity<BaseResponse<?>> getArticles() {
        ArticleListResponseDTO totalList = articleService.getPosts();

        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.of(SuccessCode.OK, totalList));
    }

    //게시물 작성
    @PostMapping
    public ResponseEntity<BaseResponse<?>> addArticle(
            @Validated @RequestBody ArticleCreateDTO dto
    ) {

        ArticleResponseDTO responseDTO = articleService.insert(dto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.of(SuccessCode.OK, responseDTO));
    }
    
    //게시물 개별 조회
    @GetMapping
    public ResponseEntity<BaseResponse<?>> getArticle(@PathVariable final Long articleId) {

        ArticleResponseDTO detailArticle = articleService.getDetail(articleId);

        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.of(SuccessCode.OK, detailArticle));
    }

    //게시물 수정
    @PutMapping
    public ResponseEntity<BaseResponse<?>> updateArticle(@PathVariable final Long articleId) {

        articleService.modify(articleId);

        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.of(SuccessCode.OK, null));
    }

    //게시물 삭제
    @DeleteMapping
    public ResponseEntity<BaseResponse<?>> deleteArticle(@PathVariable final Long articleId) {

        try {
            articleService.delete(articleId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(BaseResponse.of(SuccessCode.OK, null));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
