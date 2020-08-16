<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/user/init.jsp" %>

<div class="slide_nut">
	<a href="">
		<img src="${userStaticRootPath}img/slideshow/slide1.jpg" title="" alt="anh" class="slide" id="img1" />
	</a>
	<a href="">
		<img src="${userStaticRootPath}img/slideshow/slide2.jpg" title="" alt="anh" class="slide" id="img2" />
	</a>
	<a href="">
		<img src="${userStaticRootPath}img/slideshow/slide3.jpg" title="" alt="anh" class="slide" id="img3" />
	</a>
	<a href="">
		<img src="${userStaticRootPath}img/slideshow/slide4.jpg" title="" alt="anh" class="slide" id="img1" />
	</a>
	<!-- Nút di chuyển slide -->
	<button onClick="Chuyen_slide(1);" type="button" id="next" class="nut">&lt;</button>
	<button onClick="Chuyen_slide(-1);" type="button" id="back" class="nut">&gt;</button>
</div>

<!-- start my js -->
<script src="${userStaticRootPath}js/slide.js" type="text/javascript" charset="utf-8"></script>
<!-- end my js -->
