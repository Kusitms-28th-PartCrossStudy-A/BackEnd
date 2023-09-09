package com.example.kusithm_part_study.domain.article.controller;

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

    @GetMapping
    public ResponseEntity<BaseResponse<?>> getArticles() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.of(SuccessCode.OK, null));
    }

    @PostMapping
    public ResponseEntity<BaseResponse<?>> addArticle() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.of(SuccessCode.OK, null));
    }
    @GetMapping
    public ResponseEntity<BaseResponse<?>> getArticle(@PathVariable final Long articleId) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.of(SuccessCode.OK, null));
    }

    @PutMapping
    public ResponseEntity<BaseResponse<?>> updateArticle(@PathVariable final Long articleId) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.of(SuccessCode.OK, null));
    }

    @DeleteMapping
    public ResponseEntity<BaseResponse<?>> deleteArticle(@PathVariable final Long articleId) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.of(SuccessCode.OK, null));
    }

}
