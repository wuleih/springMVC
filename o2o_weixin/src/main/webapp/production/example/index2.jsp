<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no,email=no"/>
<meta name="apple-mobile-web-app-capable" content="yes"/>
<title>jquery-mobile</title>
    <!-- <script type="text/javascript" src="http://7xvbfr.com1.z0.glb.clouddn.com/jquery-3.0.0.min.js"></script> -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/common-jqm/core/jquery.js"></script>
    <script type="text/javascript" src="http://7xvbfr.com1.z0.glb.clouddn.com/template.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/common-js/common-all.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/production/example/example.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/common-jqm/jqm/jquery.mobile-1.4.5.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/common-jqm/jqm/jquery.mobile-1.4.5.min.css">
    <script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <script>
    wx.config({
        debug: true, 
        appId: '${jsapiSignature.appId}', 
        timestamp: parseInt("${jsapiSignature.timestamp}",10), 
        nonceStr: '${jsapiSignature.nonceStr}', 
        signature: '${jsapiSignature.signature}',
        jsApiList: ['getLocation'] 
    });
    wx.ready(function(){
    });

    wx.error(function(res){
    });
    </script>

</head>
<body>
<div data-role="page" id="pageone">
  <div data-role="header">
    <h1>欢迎来到我的主页</h1>
  </div>
  
  <button id="getBBS" onclick="submitOrderInfoClick();">获取地理位置</button>
  
  <div data-role="main" class="ui-content" id="content">
    
  </div>
  
<button type="button" class="mui-btn">默认</button>
<button type="button" class="mui-btn mui-btn-primary">蓝色</button>
<button type="button" class="mui-btn mui-btn-success">绿色</button>
<button type="button" class="mui-btn mui-btn-warning">黄色</button>
<button type="button" class="mui-btn mui-btn-danger">红色</button>
<button type="button" class="mui-btn mui-btn-royal">紫色</button>
  

  <div data-role="footer">
    <h1>底部文本</h1>
  </div>
</div> 

<div data-role="page" id="pagetwo">
  <div data-role="header">
    <h1>欢迎来到我的主页</h1>
  </div>

  <div data-role="main" class="ui-content">
    <p>点击链接返回上一个页面。。。<b>注意</b>: fade（淡入）效果是默认的</p>
    <a href="#pageone">返回第一个页面</a>
  </div>
</div>

<jsp:include page="index22.html"></jsp:include>

<script>
var str = new Array();
str.push('文艺');
str.push('博客');
str.push('电影');

template.helper("add", function(a){  
    return 10 + "--" + a;  
});

var data = {
	title: '嵌入子模板',
	//list: ['文艺', '博客', '摄影', '电影', '民谣', '旅行', '吉他']
	list: str
};

var html2 = template("test2", {n:'123'});

var html = template('test', data);

$("#content").html(html);
</script>
    <script type="text/javascript">
       /* $.include($.getContextPath()+"/common-js/ext.js");
       $.include($.getContextPath()+"/production/example/example.js");
       $.include($.getContextPath()+"/common-jqm/jqm/jquery.mobile-1.4.5.min.js"); */
       
       function submitOrderInfoClick(){
    	   wx.getLocation({
    	         success: function (res) {
    	             alert("小宝鸽获取地理位置成功，经纬度为：（" + res.latitude + "，" + res.longitude + "）" );
    	         },
    	         fail: function(error) {
    	        	 console.log(error);
    	             AlertUtil.error("获取地理位置失败，请确保开启GPS且允许微信获取您的地理位置！");
    	         }
    	     });
    	 }
    </script>
</body>
</html>