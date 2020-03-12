package com.wuxufang.cms.respository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.wuxufang.cms.domain.Article;

public interface ArticleRepositroy extends ElasticsearchRepository<Article, Integer>{

}

