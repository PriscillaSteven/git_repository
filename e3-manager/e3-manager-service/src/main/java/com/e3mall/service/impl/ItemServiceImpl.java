package com.e3mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3mall.manager.mapper.TbItemMapper;
import com.e3mall.manager.pojo.TbItem;
import com.e3mall.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public TbItem findItemById(Long itemId)
	{
		return itemMapper.selectByPrimaryKey(itemId);
	}
}
