package com.example.kusithm_part_study.domain.article.repository;

import com.example.kusithm_part_study.domain.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
    Article save(Article entity);
}
