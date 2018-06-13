
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>华清远见-首页</title>
<link href="<%=basePath%>resources/css/main.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>resources/css/style.css" rel="stylesheet"
	type="text/css" />

<link href="<%=basePath%>resources/css/lanrenzhijia.css" type="text/css"
	rel="stylesheet" />
<link href="<%=basePath%>resources/css/initializtion.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/indexjs.js"></script>
<script type="text/javascript" src="js/jquery-1.4.4.js"></script>
<script src="<%=basePath%>resources/js/jquery-1.5.1.min.js"></script>
<script src="<%=basePath%>resources/js/lanrenzhijia.js"></script>
<script>
	$(function() {
		var $window = $(window), window_width = $window.width();
		$('#js_banner, #js_banner_img li').width(window_width);

		var urlParam = G.util.parse.url(), startFrame = 0;
		if (urlParam.search && ('banner' in urlParam.search)) {
			startFrame = (parseInt(urlParam.search['banner']) - 1) || 0;
		}

		new $.Tab({/*添加圆点按钮*/
			target : $('#js_banner_img li'),
			effect : 'slide3d',
			animateTime : 1000,
			stay : 5000,
			playTo : startFrame,
			autoPlay : true,
			merge : true
		});
		$('#js_banner_img').css('left',
				'-' + (window_width * startFrame) + 'px');
	})
</script>
</head>
<body>
	<div class="header">
		<div class="header_all">
			<div class="header_div">
				<ul class="header_ul">
					<li class="header_li"><a class="logoa" href="production.html">学院介绍</a></li>
					<li class="header_li"><a class="logoa" href="teachers.html">教师风采</li>
					<li class="header_li"><a class="logoa" href="coursesOne.html">课程介绍</li>
					<li class="header_li"><a class="logoa" href="index.html#read">推荐阅读</a></li>
					<li class="header_li"><a class="logoa" href="add.html">加入我们</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!--green-->
	<div class="header_bom">

		<div id="js_banner" class="banner">
			<ul id="js_banner_img" class="banner_img clear">
				<li class="bgli01">
					<div class="banner_inner">
						<div class="child child1">
							<img style="width: 1920px;"
								src="<%=basePath%>resources/images/banner.jpg" />
						</div>
						<!-- data-z="2"与data-z="3"表示两个图层进退场的顺序有区别 -->
					</div>
				</li>
				<li class="bgli02">
					<div class="banner_inner">
						<div class="child child1">
							<img src="<%=basePath%>resources/images/banner.jpg" />
						</div>
					</div>
				</li>
				<li class="bgli03">
					<div class="banner_inner">
						<div class="child child1">
							<img src="<%=basePath%>resources/images/banner.jpg" />
						</div>
					</div>
				</li>
			</ul>
		</div>

	</div>

	<!--底部-->

	<script type="text/javascript">
		$(function() {

			/*======next======*/
			$(".next a").click(function() {
				nextscroll()
			});

			function nextscroll() {

				var vcon = $(".v_cont ");
				var offset = ($(".v_cont li").width()) * -1;

				vcon.stop().animate({
					left : offset
				}, "slow", function() {

					var firstItem = $(".v_cont ul li").first();
					vcon.find("ul").append(firstItem);
					$(this).css("left", "0px");

					circle()

				});

			}
			;

			function circle() {

				var currentItem = $(".v_cont ul li").first();
				var currentIndex = currentItem.attr("index");

				$(".circle li").removeClass("circle-cur");
				$(".circle li").eq(currentIndex).addClass("circle-cur");

			}

			setInterval(nextscroll, 3000);

			/*======prev======*/
			$(".prev a").click(function() {

				var vcon = $(".v_cont ");
				var offset = ($(".v_cont li").width() * -1);

				var lastItem = $(".v_cont ul li").last();
				vcon.find("ul").prepend(lastItem);
				vcon.css("left", offset);
				vcon.animate({
					left : "0px"
				}, "slow", function() {
					circle()
				})

			});

			/*======btn====circle======*/
			var animateEnd = 1;

			$(".circle li").click(
					function() {

						if (animateEnd == 0) {
							return;
						}

						$(this).addClass("circle-cur").siblings().removeClass(
								"circle-cur");

						var nextindex = $(this).index();
						var currentindex = $(".v_cont li").first()
								.attr("index");
						var curr = $(".v_cont li").first().clone();

						if (nextindex > currentindex) {

							for (var i = 0; i < nextindex - currentindex; i++) {

								var firstItem = $(".v_cont li").first();
								$(".v_cont ul").append(firstItem);

							}

							$(".v_cont ul").prepend(curr);

							var offset = ($(".v_cont li").width()) * -1;

							if (animateEnd == 1) {

								animateEnd = 0;
								$(".v_cont").stop().animate({
									left : offset
								}, "slow", function() {

									$(".v_cont ul li").first().remove();
									$(".v_cont").css("left", "0px");
									animateEnd = 1;

								});

							}

						} else {

							var curt = $(".v_cont li").last().clone();

							for (var i = 0; i < currentindex - nextindex; i++) {
								var lastItem = $(".v_cont li").last();
								$(".v_cont ul").prepend(lastItem);
							}

							$(".v_cont ul").append(curt);

							var offset = ($(".v_cont li").width()) * -1;

							$(".v_cont").css("left", offset);

							if (animateEnd == 1) {

								animateEnd = 0;
								$(".v_cont").stop().animate({
									left : "0px"
								}, "slow", function() {

									$(".v_cont ul li").last().remove();
									animateEnd = 1;

								});

							}

						}

					});

		})
	</script>
</body>
</html>
