<%@page import="com.annguyen.kyanhbooks.util.DinhDang"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/user/init.jsp" %>
<%@ page import="com.annguyen.kyanhbooks.model.Sach" %>
<%@ page import="com.annguyen.kyanhbooks.model.LoaiSach" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>KyAnhBook - Sản phẩm cùng loại</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<!--  start bootstrap -->
<link rel="stylesheet" type="text/css" href="${kyanhbooksRootPath}${userStaticRootPath}bootstrap-3.4.1-dist/css/bootstrap.min.css"/>
<script type="text/javascript" src="${kyanhbooksRootPath}${userStaticRootPath}js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${kyanhbooksRootPath}${userStaticRootPath}bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
<!--  end bootstrap -->
<!-- start fontawesome -->
<link rel="stylesheet" href="${kyanhbooksRootPath}${userStaticRootPath}font/font-awesome-4.7.0/css/font-awesome.min.css">
<!-- start fontawesome -->
<!-- start facebook -->
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v4.0&appId=2525119214214430&autoLogAppEvents=1"></script>
<!-- end facebook -->
<!-- start my css -->
<link rel="stylesheet" type="text/css" href="${kyanhbooksRootPath}${userStaticRootPath}css/trangchu.css"/>
<!-- end my css -->
<!-- start my js -->
	<script src="${kyanhbooksRootPath}${userStaticRootPath}js/menuAnHien.js" type="text/javascript" charset="utf-8"></script>
<!-- end my js -->
</head>
<%
	LoaiSach loaiSach = null;
	String maLoaiSach = "";
	String tenLoaiSach = "";
	
	if( request.getAttribute("LoaiSach") != null ){
		loaiSach = (LoaiSach)request.getAttribute("LoaiSach");
		maLoaiSach = loaiSach.getMaLoaiSach();
		tenLoaiSach = loaiSach.getTenLoaiSach();
	}
	
%>
					
<body>
	<div class="wrapper">
		<!-- phần header  -->
		<jsp:include page="${userViewBlockPath}header.jsp" />
		<!-- kt header  -->
		
		<!-- phần nội dung sản phẩm -->
		<section class="main_sp_cungloai main_center">
			<div class="container">
				<div class="row">
					<!-- phần top -->
					<div class="col-md-12 col-sm-12 col-xs-12 padding-0 top_nd_trang">
						<div class="top">
							<h2>
								<a href="#" class="text-a"><%=tenLoaiSach%></a>
							</h2>
						</div>
					</div>
					<!-- kt phần top -->
					<!-- phần nội dung trang -->
					<div class="col-md-12 col-sm-12 col-xs-12 padding-0 nd_trang">
						<div class="row margin-0 my_border">
							<!-- left: phần chi tiết danh sách sách -->
							<div class="col-md-8 col-sm-8 col-xs-12 padding-0">
								<section class="left">
									<div class="row">
										<div id="danhSachSPCungLoai" class="col-md-12 col-sm-12 col-xs-12 group-left-list-sp">
												<jsp:include page="${userViewRootPath}block_danhsach_sp_cungloai.jsp" />
										</div>
									</div>
							 	</section>
							</div>
							<!-- kt left: phần chi tiết danh sách sách -->
							
							<!-- right: phần hoTroKH_sachNoiBat -->
							<div class="col-md-4 col-sm-4 col-xs-12 padding-0">
								<article class="row  margin-0 right">
									<jsp:include page="${userViewBlockPath}hotrokh_sachnoibat.jsp" />
								</article>
							</div>
							<!-- kt right: phần hoTroKH_sachNoiBat -->
						</div>
					</div>
					<!-- kt phần nội dung trang -->
				</div>
			</div>
		</section>
		<!-- kt phần nội dung sản phẩm -->

		<!-- phần footer  -->
		<jsp:include page="${userViewBlockPath}footer.jsp" />
		<!-- kt footer  -->
	</div>
</body>
</html>