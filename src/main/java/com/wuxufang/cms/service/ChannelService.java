package com.wuxufang.cms.service;

import java.util.List;

import com.wuxufang.cms.domain.Category;
import com.wuxufang.cms.domain.Channel;

public interface ChannelService {
	/**
	 * 
	 * @Title: selects 
	 * @Description: 栏目列表
	 * @return
	 * @return: List<Channel>
	 */
	List<Channel> selects();
	
	/**
	 * 
	 * @Title: selectsByCid 
	 * @Description: 根据栏目查询分类
	 * @param channelId
	 * @return
	 * @return: List<Category>
	 */
	List<Category> selectsByCid(Integer channelId);
	
	//获取随即频道id
	Integer getRandomChannelId();
	
	//随机指定频道下的分类id
	Integer getRandomCateId(Integer channelId);
}
