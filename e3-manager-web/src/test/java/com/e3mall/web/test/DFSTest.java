package com.e3mall.web.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import com.e3mall.common.util.FastDFSClient;

public class DFSTest
{
	/*
	 * 测试使用原声的dfs工具进行图片上传
	 */
	@Test
	public void testFileUpload() throws FileNotFoundException, IOException, Exception
	{
		//加载配置文件，也就是待访问的图片服务器的位置信息（ip和端口号）
		ClientGlobal.init("D:/My Eclipse Workspace/workspace4/e3-manager-web/src/main/resources/conf/dfs.conf");
		//创建一个TrackerClient对象
		TrackerClient tc = new TrackerClient();
		//通过TrackerClient对象获得TrackerServer对象
		TrackerServer ts = tc.getConnection();
		//创建StorageServer引用，值可为null
		StorageServer  ss = null;
		//创建StorageClient对象，需要2个参数TrackerServer和StorageServer引用
		StorageClient sc = new StorageClient(ts,ss);
		//使用StorageClient对象调用相关API实现图片上传。返回字符串数组，包含组名和图片路径
		String[] strings = sc.upload_file("E:/我的资料/Photos/sunset.jpg","jpg",null);
		for (String str : strings)
		{
			System.out.println(str);
		}
	}
	
	/*
	 * 测试工具类
	 */
	@Test
	public void testFastDFSClient() throws Exception
	{
		FastDFSClient sc;
		sc = new FastDFSClient("D:/My Eclipse Workspace/workspace4/e3-manager-web/src/main/resources/conf/dfs.conf");
		String string = sc.uploadFile("E:/我的资料/Photos/sunset.jpg");
		System.err.println(string);
	}
}
