<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no,email=no"/>
<meta name="apple-mobile-web-app-capable" content="yes"/>
<title>jsp页面</title>
    
    
    <script type="text/javascript" src="http://7xvbfr.com1.z0.glb.clouddn.com/jquery-3.0.0.min.js"></script>
    
    <%-- <script type="text/javascript" src="<%=request.getContextPath()%>/production/example/example.js"></script> --%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/production/example/example.js"></script>
    <!--组件依赖js end-->
    <script type="text/javascript">
    var str = '${pageContext.request.contextPath }';
       console.log(str);
    </script>
</head>
<body>
    
    <section data-role="page">
    <section data-role="header" class="header" style="position:relative;">
        <span class="  font-size16 pagetitle" style="color:#fff;" >
            <span class="sele-businessname">六一儿童节</span>
        </span>        
    </section>
    
    
    
    <section>
    
    <section class="error404-img">
        <img style="width: 100%" src="${pageContext.request.contextPath}/images/index.jpg" alt=""/>
    </section>
    <section class="error-sign font-color5 mrgT15 font-size3" style="text-align: center;">嗨，好像出错了，顺便休息一下吧！</section>
    <a href="javascript:history.go(-1);">
    	<section class="font-color7 mrgT15 font-size3" style="text-align: center;">返回到上一页</section>
	<a>
	
    <section style="text-align: center;">jsp页面</section>
	<section>
      <button style="margin-top: 5%;margin-left: 35%;text-align: center;" class="btn_example" style="width:100px">点击我</button>
    </section>
    
    </section>
    
    </section>
  <div>
   <div class="mui-container">
      <div class="mui-panel">
        <h1>My Title</h1>
        <button id="btn-click" class="mui-btn mui-btn-primary mui-btn-raised">My Button</button>
      </div>
    </div>
   </div>
</body>
</html>