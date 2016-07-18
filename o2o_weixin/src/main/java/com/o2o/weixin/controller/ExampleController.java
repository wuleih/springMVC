package com.o2o.weixin.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.o2o.soa.service.ExampleSoaService;
import com.o2o.util.HttpUtil;


/**
 * @author wulei
 * @date 2016年4月18日
 * @version 1.0
 */
@Controller
@RequestMapping("com/o2o")
public class ExampleController extends BaseController{
	@Value("${baiduMapUrl}")
	String baiduMap ;
	@Value("${xyToDirectory}")
	String xyToDirectory;
	@Autowired
    private ExampleSoaService exampleSoaService;
	
	@RequestMapping("example")
	//public String getExample(@PathVariable(value="q") String q,String p){
	public String getExample(String q,ModelMap model){
		@SuppressWarnings("unused")
		//String ht_name = exampleSoaService.getExampleString();
		//Assert.assertNotNull(q);
		StringBuffer sb = new StringBuffer();
		sb.append("production/example/index");
		sb.append(q+".jsp");
		//String ht_name = "example";
		return sb.toString();
	}
	
	@RequestMapping(value="getXY",method=RequestMethod.POST)
	@ResponseBody
	public String getXYByBaiduMap(String x,String y){
		//&mode=driving&origin=清华大学&destination=北京大学&origin_region=北京&destination_region=北京&output=json
		//Properties property = new Properties();
		//property.load(new FileInputStream("config.properties"));
		String XYToDirectory = xyToDirectory+"coords="+x+","+y;
		String res = HttpUtil.doPost(XYToDirectory);
		JSONObject object = JSON.parseObject(res);
		int status = object.getIntValue("status");
		String result = null;
		if(status == 0){
			result = object.getString("result");
		}else{
			result = null;
		}
		return result;
	}
	
}
