package com.example.kusithm_part_study.domain.article.repository;

import com.example.kusithm_part_study.domain.article.entity.Article;
import com.example.kusithm_part_study.domain.article.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashTagRepository extends JpaRepository<Tag,Long> {
    Tag save(Tag entity);
}
