package com.e3mall.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController
{
	/*
	 * 显示首页
	 */
	@RequestMapping("/")
	public String showIndex()
	{
		return "index";
	}
	
	/*
	 * 显示任意指定页面
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page)
	{
		return page;
	}
}
