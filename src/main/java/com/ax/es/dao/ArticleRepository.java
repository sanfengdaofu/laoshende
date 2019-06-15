package com.ax.es.dao;

import com.ax.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article,Integer> {
    Page<Article> findByTitle(String title, Pageable page);
}
