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
    <script src="${pageContext.request.contextPath}/common-mui/ext/mui.pullToRefresh.js"></script>
	<script src="${pageContext.request.contextPath}/common-mui/ext/mui.pullToRefresh.material.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/common-mui/mui.min.css">
    <script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    
    <style>
			html,
			body {
				background-color: #efeff4;
			}
			.mui-bar~.mui-content .mui-fullscreen {
				top: 44px;
				height: auto;
			}
			.mui-pull-top-tips {
				position: absolute;
				top: -20px;
				left: 50%;
				margin-left: -25px;
				width: 40px;
				height: 40px;
				border-radius: 100%;
				z-index: 1;
			}
			.mui-bar~.mui-pull-top-tips {
				top: 24px;
			}
			.mui-pull-top-wrapper {
				width: 42px;
				height: 42px;
				display: block;
				text-align: center;
				background-color: #efeff4;
				border: 1px solid #ddd;
				border-radius: 25px;
				background-clip: padding-box;
				box-shadow: 0 4px 10px #bbb;
				overflow: hidden;
			}
			.mui-pull-top-tips.mui-transitioning {
				-webkit-transition-duration: 200ms;
				transition-duration: 200ms;
			}
			.mui-pull-top-tips .mui-pull-loading {
				/*-webkit-backface-visibility: hidden;
				-webkit-transition-duration: 400ms;
				transition-duration: 400ms;*/
				
				margin: 0;
			}
			.mui-pull-top-wrapper .mui-icon,
			.mui-pull-top-wrapper .mui-spinner {
				margin-top: 7px;
			}
			.mui-pull-top-wrapper .mui-icon.mui-reverse {
				/*-webkit-transform: rotate(180deg) translateZ(0);*/
			}
			.mui-pull-bottom-tips {
				text-align: center;
				background-color: #efeff4;
				font-size: 15px;
				line-height: 40px;
				color: #777;
			}
			.mui-pull-top-canvas {
				overflow: hidden;
				background-color: #fafafa;
				border-radius: 40px;
				box-shadow: 0 4px 10px #bbb;
				width: 40px;
				height: 40px;
				margin: 0 auto;
			}
			.mui-pull-top-canvas canvas {
				width: 40px;
			}
			.mui-slider-indicator.mui-segmented-control {
				background-color: #efeff4;
			}
		</style>
</head>
<body>
<header class="mui-bar mui-bar-nav">
			<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
			<h1 class="mui-title">选项卡切换+下拉刷新</h1>
		</header>
		<div class="mui-content">
			<div id="slider" class="mui-slider mui-fullscreen">
				<div id="sliderSegmentedControl" class="mui-scroll-wrapper mui-slider-indicator mui-segmented-control mui-segmented-control-inverted">
					<div class="mui-scroll">
						<a class="mui-control-item mui-active" href="#item1mobile">
							推荐
						</a>
						<a class="mui-control-item" href="#item2mobile">
							热点
						</a>
						<a class="mui-control-item" href="#item3mobile">
							北京
						</a>
						<a class="mui-control-item" href="#item4mobile">
							社会
						</a>
						<a class="mui-control-item" href="#item5mobile">
							娱乐
						</a>
						<a class="mui-control-item" href="#item6mobile">
							科技
						</a>
					</div>
				</div>
				<div class="mui-slider-group">
					<div id="item1mobile" class="mui-slider-item mui-control-content mui-active">
						<div id="scroll1" class="mui-scroll-wrapper">
							<div class="mui-scroll">
								<ul class="mui-table-view">
									<li class="mui-table-view-cell">
										第1个选项卡子项-1
									</li>
									<li class="mui-table-view-cell">
										第1个选项卡子项-2
									</li>
									<li class="mui-table-view-cell">
										第1个选项卡子项-3
									</li>
									<li class="mui-table-view-cell">
										第1个选项卡子项-4
									</li>
									<li class="mui-table-view-cell">
										第1个选项卡子项-5
									</li>
									<li class="mui-table-view-cell">
										第1个选项卡子项-6
									</li>
									<li class="mui-table-view-cell">
										第1个选项卡子项-7
									</li>
									<li class="mui-table-view-cell">
										第1个选项卡子项-8
									</li>
									<li class="mui-table-view-cell">
										第1个选项卡子项-9
									</li>
									<li class="mui-table-view-cell">
										第1个选项卡子项-10
									</li>
									<li class="mui-table-view-cell">
										第1个选项卡子项-11
									</li>
									<li class="mui-table-view-cell">
										第1个选项卡子项-12
									</li>
									<li class="mui-table-view-cell">
										第1个选项卡子项-13
									</li>
									<li class="mui-table-view-cell">
										第1个选项卡子项-14
									</li>
									<li class="mui-table-view-cell">
										第1个选项卡子项-15
									</li>
									<li class="mui-table-view-cell">
										第1个选项卡子项-16
									</li>
									<li class="mui-table-view-cell">
										第1个选项卡子项-17
									</li>
									<li class="mui-table-view-cell">
										第1个选项卡子项-18
									</li>
									<li class="mui-table-view-cell">
										第1个选项卡子项-19
									</li>
									<li class="mui-table-view-cell">
										第1个选项卡子项-20
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div id="item2mobile" class="mui-slider-item mui-control-content">
						<div class="mui-scroll-wrapper">
							<div class="mui-scroll">
								<ul class="mui-table-view">
									<li class="mui-table-view-cell">
										第2个选项卡子项-1
									</li>
									<li class="mui-table-view-cell">
										第2个选项卡子项-2
									</li>
									<li class="mui-table-view-cell">
										第2个选项卡子项-3
									</li>
									<li class="mui-table-view-cell">
										第2个选项卡子项-4
									</li>
									<li class="mui-table-view-cell">
										第2个选项卡子项-5
									</li>
									<li class="mui-table-view-cell">
										第2个选项卡子项-6
									</li>
									<li class="mui-table-view-cell">
										第2个选项卡子项-7
									</li>
									<li class="mui-table-view-cell">
										第2个选项卡子项-8
									</li>
									<li class="mui-table-view-cell">
										第2个选项卡子项-9
									</li>
									<li class="mui-table-view-cell">
										第2个选项卡子项-10
									</li>
									<li class="mui-table-view-cell">
										第2个选项卡子项-11
									</li>
									<li class="mui-table-view-cell">
										第2个选项卡子项-12
									</li>
									<li class="mui-table-view-cell">
										第2个选项卡子项-13
									</li>
									<li class="mui-table-view-cell">
										第2个选项卡子项-14
									</li>
									<li class="mui-table-view-cell">
										第2个选项卡子项-15
									</li>
									<li class="mui-table-view-cell">
										第2个选项卡子项-16
									</li>
									<li class="mui-table-view-cell">
										第2个选项卡子项-17
									</li>
									<li class="mui-table-view-cell">
										第2个选项卡子项-18
									</li>
									<li class="mui-table-view-cell">
										第2个选项卡子项-19
									</li>
									<li class="mui-table-view-cell">
										第2个选项卡子项-20
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div id="item3mobile" class="mui-slider-item mui-control-content">
						<div class="mui-scroll-wrapper">
							<div class="mui-scroll">
								<ul class="mui-table-view">
									<li class="mui-table-view-cell">
										第3个选项卡子项-1
									</li>
									<li class="mui-table-view-cell">
										第3个选项卡子项-2
									</li>
									<li class="mui-table-view-cell">
										第3个选项卡子项-3
									</li>
									<li class="mui-table-view-cell">
										第3个选项卡子项-4
									</li>
									<li class="mui-table-view-cell">
										第3个选项卡子项-5
									</li>
									<li class="mui-table-view-cell">
										第3个选项卡子项-6
									</li>
									<li class="mui-table-view-cell">
										第3个选项卡子项-7
									</li>
									<li class="mui-table-view-cell">
										第3个选项卡子项-8
									</li>
									<li class="mui-table-view-cell">
										第3个选项卡子项-9
									</li>
									<li class="mui-table-view-cell">
										第3个选项卡子项-10
									</li>
									<li class="mui-table-view-cell">
										第3个选项卡子项-11
									</li>
									<li class="mui-table-view-cell">
										第3个选项卡子项-12
									</li>
									<li class="mui-table-view-cell">
										第3个选项卡子项-13
									</li>
									<li class="mui-table-view-cell">
										第3个选项卡子项-14
									</li>
									<li class="mui-table-view-cell">
										第3个选项卡子项-15
									</li>
									<li class="mui-table-view-cell">
										第3个选项卡子项-16
									</li>
									<li class="mui-table-view-cell">
										第3个选项卡子项-17
									</li>
									<li class="mui-table-view-cell">
										第3个选项卡子项-18
									</li>
									<li class="mui-table-view-cell">
										第3个选项卡子项-19
									</li>
									<li class="mui-table-view-cell">
										第3个选项卡子项-20
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div id="item4mobile" class="mui-slider-item mui-control-content">
						<div class="mui-scroll-wrapper">
							<div class="mui-scroll">
								<ul class="mui-table-view">
									<li class="mui-table-view-cell">
										第4个选项卡子项-1
									</li>
									<li class="mui-table-view-cell">
										第4个选项卡子项-2
									</li>
									<li class="mui-table-view-cell">
										第4个选项卡子项-3
									</li>
									<li class="mui-table-view-cell">
										第4个选项卡子项-4
									</li>
									<li class="mui-table-view-cell">
										第4个选项卡子项-5
									</li>
									<li class="mui-table-view-cell">
										第4个选项卡子项-6
									</li>
									<li class="mui-table-view-cell">
										第4个选项卡子项-7
									</li>
									<li class="mui-table-view-cell">
										第4个选项卡子项-8
									</li>
									<li class="mui-table-view-cell">
										第4个选项卡子项-9
									</li>
									<li class="mui-table-view-cell">
										第4个选项卡子项-10
									</li>
									<li class="mui-table-view-cell">
										第4个选项卡子项-11
									</li>
									<li class="mui-table-view-cell">
										第4个选项卡子项-12
									</li>
									<li class="mui-table-view-cell">
										第4个选项卡子项-13
									</li>
									<li class="mui-table-view-cell">
										第4个选项卡子项-14
									</li>
									<li class="mui-table-view-cell">
										第4个选项卡子项-15
									</li>
									<li class="mui-table-view-cell">
										第4个选项卡子项-16
									</li>
									<li class="mui-table-view-cell">
										第4个选项卡子项-17
									</li>
									<li class="mui-table-view-cell">
										第4个选项卡子项-18
									</li>
									<li class="mui-table-view-cell">
										第4个选项卡子项-19
									</li>
									<li class="mui-table-view-cell">
										第4个选项卡子项-20
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div id="item5mobile" class="mui-slider-item mui-control-content">
						<div class="mui-scroll-wrapper">
							<div class="mui-scroll">
								<ul class="mui-table-view">
									<li class="mui-table-view-cell">
										第5个选项卡子项-1
									</li>
									<li class="mui-table-view-cell">
										第5个选项卡子项-2
									</li>
									<li class="mui-table-view-cell">
										第5个选项卡子项-3
									</li>
									<li class="mui-table-view-cell">
										第5个选项卡子项-4
									</li>
									<li class="mui-table-view-cell">
										第5个选项卡子项-5
									</li>
									<li class="mui-table-view-cell">
										第5个选项卡子项-6
									</li>
									<li class="mui-table-view-cell">
										第5个选项卡子项-7
									</li>
									<li class="mui-table-view-cell">
										第5个选项卡子项-8
									</li>
									<li class="mui-table-view-cell">
										第5个选项卡子项-9
									</li>
									<li class="mui-table-view-cell">
										第5个选项卡子项-10
									</li>
									<li class="mui-table-view-cell">
										第5个选项卡子项-11
									</li>
									<li class="mui-table-view-cell">
										第5个选项卡子项-12
									</li>
									<li class="mui-table-view-cell">
										第5个选项卡子项-13
									</li>
									<li class="mui-table-view-cell">
										第5个选项卡子项-14
									</li>
									<li class="mui-table-view-cell">
										第5个选项卡子项-15
									</li>
									<li class="mui-table-view-cell">
										第5个选项卡子项-16
									</li>
									<li class="mui-table-view-cell">
										第5个选项卡子项-17
									</li>
									<li class="mui-table-view-cell">
										第5个选项卡子项-18
									</li>
									<li class="mui-table-view-cell">
										第5个选项卡子项-19
									</li>
									<li class="mui-table-view-cell">
										第5个选项卡子项-20
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div id="item6mobile" class="mui-slider-item mui-control-content">
						<div class="mui-scroll-wrapper">
							<div class="mui-scroll">
								<ul class="mui-table-view">
									<li class="mui-table-view-cell">
										第6个选项卡子项-1
									</li>
									<li class="mui-table-view-cell">
										第6个选项卡子项-2
									</li>
									<li class="mui-table-view-cell">
										第6个选项卡子项-3
									</li>
									<li class="mui-table-view-cell">
										第6个选项卡子项-4
									</li>
									<li class="mui-table-view-cell">
										第6个选项卡子项-5
									</li>
									<li class="mui-table-view-cell">
										第6个选项卡子项-6
									</li>
									<li class="mui-table-view-cell">
										第6个选项卡子项-7
									</li>
									<li class="mui-table-view-cell">
										第6个选项卡子项-8
									</li>
									<li class="mui-table-view-cell">
										第6个选项卡子项-9
									</li>
									<li class="mui-table-view-cell">
										第6个选项卡子项-10
									</li>
									<li class="mui-table-view-cell">
										第6个选项卡子项-11
									</li>
									<li class="mui-table-view-cell">
										第6个选项卡子项-12
									</li>
									<li class="mui-table-view-cell">
										第6个选项卡子项-13
									</li>
									<li class="mui-table-view-cell">
										第6个选项卡子项-14
									</li>
									<li class="mui-table-view-cell">
										第6个选项卡子项-15
									</li>
									<li class="mui-table-view-cell">
										第6个选项卡子项-16
									</li>
									<li class="mui-table-view-cell">
										第6个选项卡子项-17
									</li>
									<li class="mui-table-view-cell">
										第6个选项卡子项-18
									</li>
									<li class="mui-table-view-cell">
										第6个选项卡子项-19
									</li>
									<li class="mui-table-view-cell">
										第6个选项卡子项-20
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<script>
			mui.init();
			(function($) {
				//阻尼系数
				var deceleration = mui.os.ios?0.003:0.0009;
				$('.mui-scroll-wrapper').scroll({
					bounce: false,
					indicators: true, //是否显示滚动条
					deceleration:deceleration
				});
				$.ready(function() {
					//循环初始化所有下拉刷新，上拉加载。
					$.each(document.querySelectorAll('.mui-slider-group .mui-scroll'), function(index, pullRefreshEl) {
						$(pullRefreshEl).pullToRefresh({
							down: {
								callback: function() {
									var self = this;
									setTimeout(function() {
										var ul = self.element.querySelector('.mui-table-view');
										ul.insertBefore(createFragment(ul, index, 10, true), ul.firstChild);
										self.endPullDownToRefresh();
									}, 1000);
								}
							},
							up: {
								callback: function() {
									var self = this;
									setTimeout(function() {
										var ul = self.element.querySelector('.mui-table-view');
										ul.appendChild(createFragment(ul, index, 5));
										self.endPullUpToRefresh();
									}, 1000);
								}
							}
						});
					});
					var createFragment = function(ul, index, count, reverse) {
						var length = ul.querySelectorAll('li').length;
						var fragment = document.createDocumentFragment();
						var li;
						for (var i = 0; i < count; i++) {
							li = document.createElement('li');
							li.className = 'mui-table-view-cell';
							li.innerHTML = '第' + (index + 1) + '个选项卡子项-' + (length + (reverse ? (count - i) : (i + 1)));
							fragment.appendChild(li);
						}
						return fragment;
					};
				});
			})(mui);
		</script>
	</body>
</html>