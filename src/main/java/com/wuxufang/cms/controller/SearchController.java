package com.wuxufang.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.wuxufang.cms.domain.Article;
import com.wuxufang.cms.util.EsUtil;
/**
 * 
 * @author 煜
 * 搜索控制器
 */
@Controller
public class SearchController {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	@RequestMapping("search")
	public String search(String keyword,Model model,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum) {
		PageInfo<?> pageInfo = EsUtil.findByKeyword(elasticsearchTemplate, keyword, Article.class, "id", pageNum, 10, "title");
		model.addAttribute("pageInfo", pageInfo);
		return "search";
	}
}
