package com.e3mall.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.e3mall.common.util.FastDFSClient;

@Controller
public class FileUploadController
{
	//注入配置文件中的值
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	
	/*
	 * 采用富文本编辑器实现图片上传
	 */
	@RequestMapping("/pic/upload")//, produces=MediaType.TEXT_PLAIN_VALUE + ";chaset=utf-8"
	@ResponseBody
	public Map<String,Object> fileUpload(MultipartFile uploadFile)
	{
		//获取文件全名
		String fileName = uploadFile.getOriginalFilename();
		//获取文件扩展名
		String extName = FilenameUtils.getExtension(fileName);
		//以Map对象的形式向客户端响应数据
		Map<String,Object> map = new HashMap<String,Object>();
		//调用fastDFS的API实现文件上传
		try
		{
			//载入图片服务器的位置信息
			FastDFSClient dfsClient = new FastDFSClient("classpath:conf/resource.properties");
			//返回该普片在图片服务器上的位置信息
			String path = dfsClient.uploadFile(uploadFile.getBytes(), extName);
			//拼接访问该图片的完整的地址
			String url = IMAGE_SERVER_URL + path;
			
			//上传成功时
			map.put("error",0);
			map.put("url",url);
			return map;
		} catch (Exception e)
		{
			//上传失败时
			map.put("error", 1);
			map.put("message", "图片上传失败！");
			e.printStackTrace();
			return map;
		}  
	}
}
