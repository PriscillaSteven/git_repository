package com.e3mall.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e3mall.manager.pojo.TbItem;
import com.e3mall.service.ItemService;

@Controller
public class ItemController
{
	@Autowired
	private ItemService itemService;
	
	@ResponseBody
	@RequestMapping("/item/{itemId}")
	private TbItem findItemById(@PathVariable Long itemId)
	{
		TbItem tbItem = itemService.findItemById(itemId);
		return tbItem;
	}
}
