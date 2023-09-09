package com.example.kusithm_part_study.domain.article.service;

import com.example.kusithm_part_study.domain.article.dto.ArticleCreateDTO;
import com.example.kusithm_part_study.domain.article.dto.ArticleModifyDTO;
import com.example.kusithm_part_study.domain.article.dto.ArticleResponseDTO;
import com.example.kusithm_part_study.domain.article.dto.ArticleListResponseDTO;
import com.example.kusithm_part_study.domain.article.entity.Article;
import com.example.kusithm_part_study.domain.article.entity.Tag;
import com.example.kusithm_part_study.domain.article.repository.ArticleRepository;
import com.example.kusithm_part_study.domain.article.repository.HashTagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final HashTagRepository hashTagRepository;

    //게시물 등록
    public ArticleResponseDTO insert(final ArticleCreateDTO dto)
            throws RuntimeException {

        // 게시물 저장
        Article saved = articleRepository.save(dto.toEntity());

        // 해시태그 저장
        List<Tag> hashTags = dto.getTagList();
        if (hashTags != null && hashTags.size() > 0) {
            hashTags.forEach(ht -> {
                Tag savedTag = hashTagRepository.save(ht);
                saved.addHashTag(savedTag);
            });
        }
        return new ArticleResponseDTO(saved);
    }

    //게시물 수정
        public ArticleResponseDTO modify(final Long articleId) {

        // 수정 전 데이터를 조회
        final Article articleEntity = getArticle(articleId);

        articleRepository.findById(articleId);

        // 수정 시작
        articleEntity.setTitle(dto.getTitle());
        articleEntity.setDescription(dto.getDescription());
        articleEntity.setTitle(dto.getTitle());
        articleEntity.setTagList(dto.getTagList());

        // 수정 완료
        Article modifiedPost = articleRepository.save(articleEntity);

        return new ArticleResponseDTO(modifiedPost);
    }

    private Article getArticle(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                id + "번 게시물이 존재하지 않습니다!"
                        )
                );
    }

    //게시물 삭제
    public void delete(Long id) throws RuntimeException, SQLException {
        articleRepository.deleteById(id);
    }

    //게시물 개별 조회
    public ArticleResponseDTO getDetail(Long id) {

        Article articleEntity = getArticle(id);
        return new ArticleResponseDTO(articleEntity);
    }

    //게시물 전체 조회
    public ArticleListResponseDTO getPosts() {

        //데이터베이스에서 게시물 목록 조회
        List<Article> allArticle = articleRepository.findAll();

        return null;
    }



}
