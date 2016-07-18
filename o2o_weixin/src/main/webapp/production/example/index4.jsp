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
    <script type="text/javascript" src="${pageContext.request.contextPath}/common-mui/mui.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/common-mui/mui.min.css">
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
  <div>
  <button id="getBBS" onclick="submitOrderInfoClick();">获取地理位置</button></br>
  经度:&nbsp;&nbsp;&nbsp;<input class="location-input-x" value="" style="height:35px;"/></br>
  纬度:&nbsp;&nbsp;&nbsp;<input class="location-input-y" value="" style="height:35px;"/>
  </div>
  
  
  <div>
     <div id="sheet1" class="mui-popover mui-popover-bottom mui-popover-action ">
    <!-- 可选择菜单 -->
    <ul class="mui-table-view">
      <li class="mui-table-view-cell">
        <a href="#">菜单1</a>
      </li>
      <li class="mui-table-view-cell">
        <a href="#">菜单2</a>
      </li>
    </ul>
    <!-- 取消菜单 -->
    <ul class="mui-table-view">
      <li class="mui-table-view-cell">
        <a href="#sheet1"><b>取消</b></a>
      </li>
    </ul>
</div>
  </div>
  
  
<div class="mui-slider">
  <div class="mui-slider-group mui-slider-loop">
    <!--支持循环，需要重复图片节点-->
    <div class="mui-slider-item mui-slider-item-duplicate"><a href="#"><img src="${pageContext.request.contextPath}/images/splash_bg.jpg" /></a></div>
    <div class="mui-slider-item" style="width:100%;height:20%"><a href="#"><img src="${pageContext.request.contextPath}/images/index.jpg" /></a></div>
    <div class="mui-slider-item"><a href="#"><img src="${pageContext.request.contextPath}/images/splash_bg.jpg" /></a></div>
    <div class="mui-slider-item"><a href="#"><img src="${pageContext.request.contextPath}/images/index.jpg" /></a></div>
    <div class="mui-slider-item"><a href="#"><img src="${pageContext.request.contextPath}/images/splash_bg.jpg" /></a></div>
    <!--支持循环，需要重复图片节点-->
    <div class="mui-slider-item mui-slider-item-duplicate"><a href="#"><img src="${pageContext.request.contextPath}/images/index.jpg" /></a></div>
  </div>
</div>

<div>

<ul class="mui-table-view"> 
        <li class="mui-table-view-cell mui-collapse mui-active">
            <a class="mui-navigate-right" href="#">面板1</a>
            <div class="mui-collapse-content">
                <p>面板1子内容</p>
            </div>
        </li>
        <li class="mui-table-view-cell mui-collapse">
            <a class="mui-navigate-right" href="#">面板</a>
                <div class="mui-collapse-content">
                <p>面板2子内容</p>
            </div>
        </li>
        <li class="mui-table-view-cell mui-collapse">
            <a class="mui-navigate-right" href="#">面板3</a>
            <div class="mui-collapse-content">
                <p>面板3子内容</p>
            </div>
        </li> 
    </ul> 

</div>

    <script type="text/javascript">
       /* $.include($.getContextPath()+"/common-js/ext.js");
       $.include($.getContextPath()+"/production/example/example.js");
       $.include($.getContextPath()+"/common-jqm/jqm/jquery.mobile-1.4.5.min.js"); */
       
       mui('#sheet1').show().popover('toggle');
       
       //获得slider插件对象
       var gallery = mui('.mui-slider');
       gallery.slider({
         interval:5000//自动轮播周期，若为0则不自动播放，默认为0；
       });
       
       
       function submitOrderInfoClick(){
    	   wx.getLocation({
    	         success: function (res) {
    	             //alert("小宝鸽获取地理位置成功，经纬度为：（" + res.latitude + "，" + res.longitude + "）" );
    	             $("input.location-input-x").val(res.latitude);
    	             $("input.location-input-y").val(res.longitude);
    	         },
    	         fail: function(error) {
    	        	 console.log(error);
    	             AlertUtil.error("获取地理位置失败，请确保开启GPS且允许微信获取您的地理位置！");
    	         }
    	     });
    	   
    	   var x = $("input.location-input-x");
    	   var y = $("input.location-input-y");
    	   if(x && y){
    		   $.ajax({
    			    url: "${pageContext.request.contextPath}/o2o/com/",    //请求的url地址
    			    dataType: "json",   //返回格式为json
    			    async: true, //请求是否异步，默认为异步，这也是ajax重要特性
    			    data: {"x":x,"y":y},    //参数值
    			    type: "post",   //请求方式
    			    beforeSend: function() {
    			        //请求前的处理
    			    },
    			    success: function(data) {
    			        //请求成功时处理
    			    },
    			    complete: function() {
    			        //请求完成的处理
    			    },
    			    error: function() {
    			        //请求出错处理
    			    }
    			});
    	   }
    	   
    	 }
    </script>
</body>
</html>