package com.wuxufang.cms.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.wuxufang.cms.domain.Article;
import com.wuxufang.cms.respository.ArticleRepositroy;
import com.wuxufang.cms.service.ArticleService;

/**
 * 同步文章到索引库
 * @author 煜
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class ArticleToIndex {

	@Autowired
	private ArticleService articleService;b
	@Autowired
	private ArticleRepositroy articleRepositroy;
	@SuppressWarnings("null")
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	@Test
	public void articleToIndex() {
		/** 分页读取文章 **/
		for (int pageNum = 1; pageNum < 10000; pageNum++) {
			/** 文章审核通过，未删除同步到索引库 **/
			Article article = new Article();
			article.setStatus(1);
			article.setDeleted(0);
			PageInfo<Article> pageInfo = articleService.selects(article, pageNum, 100);
			/** 文章读取完成，结束循环，退出测试 **/
			if(pageInfo==null || pageInfo.getList().size()==0) {
				break;
			}
			/** 同步到索引库 **/
			articleRepositroy.saveAll(pageInfo.getList());
			/*for(Article a : pageInfo.getList()) {
				articleRepositroy.save(a);
			}*/
		}
	}
}
