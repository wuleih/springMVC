<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%--@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" --%>
<%--@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" --%>
<%--@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" --%>
<%--@ taglib prefix="spring" uri="http://www.springframework.org/tags" --%>
<%--@ taglib prefix="form" uri="http://www.springframework.org/tags/form"--%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no,email=no"/>
<meta name="apple-mobile-web-app-capable" content="yes"/>
<title>jquery-mobile</title>
    <!-- <script type="text/javascript" src="http://7xvbfr.com1.z0.glb.clouddn.com/jquery-3.0.0.min.js"></script> -->
    <script type="text/javascript" src="../../common_jqm/core/jquery.js"></script>
    <script type="text/javascript" src=" http://7xvbfr.com1.z0.glb.clouddn.com/template.js"></script>
    <script type="text/javascript" src="../../production/example/example.js"></script>
    <script type="text/javascript" src="../../common_jqm/jqm/jquery.mobile-1.4.5.min.js"></script>
    <script type="text/javascript" src="../../common_jqm/jqm/iscroll.js"></script>
    <link rel="stylesheet" href="../../common_jqm/jqm/jquery.mobile-1.4.5.min.css">
</head>
<body>
    <script type="text/javascript">
var myScroll,
	pullDownEl, pullDownOffset,
	pullUpEl, pullUpOffset,
	generatedCount = 0;
/**
	* 下拉刷新 （自定义实现此方法）
	* myScroll.refresh();		// 数据加载完成后，调用界面更新方法
	*/
function pullDownAction () {
	setTimeout(function () {
	console.log("下拉刷新...");
		myScroll.refresh();		//数据加载完成后，调用界面更新方法   Remember to refresh when contents are loaded (ie: on ajax completion)
	}, 1000);
}
/**
	* 滚动翻页 （自定义实现此方法）
	* myScroll.refresh();		// 数据加载完成后，调用界面更新方法
	*/
function pullUpAction () {
	setTimeout(function () {	// <-- Simulate network congestion, remove setTimeout from production!
		var el, li, i;
		el = document.getElementById('list-table');

		for (i=0; i<3; i++) {
			li = document.createElement('li');
			li.innerText = 'Generated row ' + (++generatedCount);
			el.appendChild(li, el.childNodes[0]);
		}
		myScroll.refresh();		// 数据加载完成后，调用界面更新方法 Remember to refresh when contents are loaded (ie: on ajax completion)
	}, 50);	// <-- Simulate network congestion, remove setTimeout from production!
}
/**
	* 初始化iScroll控件
	*/
$(function(){
	pullDownEl = document.getElementById('pullDown');
	pullUpEl = document.getElementById('pullUp');
	pullDownOffset = pullDownEl.offsetHeight;
	pullUpOffset = pullUpEl.offsetHeight;
	
	var id='list';
	var yLen=80;
	
	var hei=document.getElementById(id).maxScrollY;
	
	myScroll = new iScroll(id, {
		useTransition: false,
		topOffset: pullDownOffset,
		onRefresh: function () {
			if (pullDownEl.className.match('loading')) {
				pullDownEl.className = '';
				pullDownEl.querySelector('.pullDownLabel').innerHTML = '下拉刷新...';
			} else if (pullUpEl.className.match('loading')) {
				pullUpEl.className = '';
				pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载更多...';
			}
		},
		onScrollMove: function () {
			if (this.y >= yLen && !pullDownEl.className.match('flip')) {
				pullDownEl.className = 'flip';
				pullDownEl.querySelector('.pullDownLabel').innerHTML = '松手开始更新...';
				this.minScrollY = 0;
			} else if (this.y < yLen && pullDownEl.className.match('flip')) {
				pullDownEl.className = '';
				pullDownEl.querySelector('.pullDownLabel').innerHTML = '下拉刷新...';
				this.minScrollY = -pullDownOffset;
			}
			else if (this.y < (this.maxScrollY - yLen) && !pullUpEl.className.match('flip')) {
				pullUpEl.className = 'flip';
				pullUpEl.querySelector('.pullUpLabel').innerHTML = '松手开始更新...';
				this.maxScrollY = this.maxScrollY;
			} else if (this.y > (this.maxScrollY + yLen) && pullUpEl.className.match('flip')) {
				pullUpEl.className = '';
				pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载更多...';
				this.maxScrollY = pullUpOffset;
			}
			
		},
		onScrollEnd: function () {
			if (pullDownEl.className.match('flip')) {
				pullDownEl.className = 'loading';
				pullDownEl.querySelector('.pullDownLabel').innerHTML = '加载中...';				
				pullDownAction();	// Execute custom function (ajax call?)
			}
				else if (pullUpEl.className.match('flip')) {
				var hei=document.getElementById("list").height;
				pullUpEl.className = 'loading';
				pullUpEl.querySelector('.pullUpLabel').innerHTML = '加载中...';				
				pullUpAction();	// Execute custom function (ajax call?)
			}
			
		}
	});
	
	setTimeout(function () { document.getElementById(id).style.left = '0'; }, 800);
});
</script>
<style type="text/css" media="all">
/*需要修改的jquery mobile样式  */
.ui-table-columntoggle-btn {display:none;}
#list{
	position:absolute;
	top:45px;
	bottom:1px;
	width:100%;
}
/**
	*
	* 下拉样式 Pull down styles
	*
	*/
#pullDown, #pullUp {
	background:#fff;
	height:40px;
	line-height:40px;
	padding:5px 10px;
	border-bottom:1px solid #ccc;
	font-weight:bold;
	font-size:14px;
	color:#888;
}
#pullDown .pullDownIcon, #pullUp .pullUpIcon  {
	display:block; float:left;
	width:40px; height:40px;
	background:url(pull-icon@2x.png) 0 0 no-repeat;
	-webkit-background-size:40px 80px; background-size:40px 80px;
	-webkit-transition-property:-webkit-transform;
	-webkit-transition-duration:250ms;	
}
#pullDown .pullDownIcon {
	-webkit-transform:rotate(0deg) translateZ(0);
}
#pullUp .pullUpIcon  {
	-webkit-transform:rotate(-180deg) translateZ(0);
}
#pullDown.flip .pullDownIcon {
	-webkit-transform:rotate(-180deg) translateZ(0);
}
#pullUp.flip .pullUpIcon {
	-webkit-transform:rotate(0deg) translateZ(0);
}
#pullDown.loading .pullDownIcon, #pullUp.loading .pullUpIcon {
	background-position:0 100%;
	-webkit-transform:rotate(0deg) translateZ(0);
	-webkit-transition-duration:0ms;
	-webkit-animation-name:loading;
	-webkit-animation-duration:2s;
	-webkit-animation-iteration-count:infinite;
	-webkit-animation-timing-function:linear;
}
@-webkit-keyframes loading {
	from { -webkit-transform:rotate(0deg) translateZ(0); }
	to { -webkit-transform:rotate(360deg) translateZ(0); }
}
</style>
</head>
<body>
	<div id="listPage" data-role="page" data-theme="a" >
		<div class="myPage-header" data-role="header" data-position="fixed">
			<!-- <a class="A-BACK ui-link ui-btn ui-btn-a ui-icon-arrow-l ui-btn-icon-notext ui-btn-inline ui-shadow ui-corner-all" role="button" data-role="button" data-iconpos="notext" data-theme="a" data-inline="true" data-icon="arrow-l">返回</a> -->
			<!-- <h1 class="title" style="padding:1px">下拉刷新（上拉加载）</h1> -->
			<!-- <a class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-icon-gear ui-btn-icon-left ui-btn-a ui-btn-icon-notext" href="#ssjcPanel" style="margin-right:6px; margin-top:3px" data-transition="slideup">Actions...</a> -->
		</div>
		<div id="list" class="ui-content" role="main" style="padding:0px;">
			<div id="shishi" name="shishi"  class="listDiv"  >
				<div id="pullDown">
					<span class="pullDownIcon"></span>
					<span class="pullDownLabel">下拉刷新...</span>
				</div>
				<table data-role="table" id="list-table"  data-filter="true" data-input="#filterTable-input" class="ui-responsive movie-list table-stroke" data-mode="columntoggle">
					<thead id="dataThead"></thead>
					<tbody id="dataTbody">
						<tr>
							<td>111</td>
							<td>222</td>
						</tr>
					</tbody>
				</table>
				<div id="pullUp">
					<span class="pullUpIcon"></span>
					<span class="pullUpLabel">上拉加载更多...</span>
				</div>
			</div>
		</div>
		<!-- /content -->
	</div>
    
</body>
</html>