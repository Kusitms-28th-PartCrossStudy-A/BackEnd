package com.example.kusithm_part_study.domain.article.entity;

import com.example.kusithm_part_study.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "article")
@Entity
public class Article extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long id;
    private String title;
    private String description;
    private String body;
    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
    @Builder.Default
    private List<Tag> tagList = new ArrayList<>();
}
