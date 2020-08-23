<%@page import="com.annguyen.kyanhbooks.util.DinhDang"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/user/init.jsp" %>
<%@ page import="com.annguyen.kyanhbooks.model.Sach" %>
<%@ page import="com.annguyen.kyanhbooks.model.LoaiSach" %>
<%@ page import="com.annguyen.kyanhbooks.service.LoaiSachService" %>
<%@ page import="java.util.List" %>

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
<!-- begin: paging -->
<script src="${kyanhbooksRootPath}${userStaticRootPath}paging/jquery.twbsPagination.js" type="text/javascript"></script>
<!-- end: paging -->
</head>

<c:url var="ur" value="" />
<%
	LoaiSachService loaiSachService = null;
	LoaiSach loaiSach = null;
	String maLoaiSach = "";
	String tenLoaiSach = "";
	List<Sach> sachTheoLoaiSach = null;
	if( request.getAttribute("LoaiSach") != null ){
		loaiSach = (LoaiSach)request.getAttribute("LoaiSach");
		maLoaiSach = loaiSach.getMaLoaiSach();
		tenLoaiSach = loaiSach.getTenLoaiSach();
	}
	if(request.getAttribute("SachTheoLoaiSach") != null ){
		sachTheoLoaiSach = (List<Sach>)request.getAttribute("SachTheoLoaiSach");
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
							<!-- left: phần chi tiết sách -->
							<div class="col-md-8 col-sm-8 col-xs-12 padding-0">
								<section class="left">
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12 group-left-list-sp">
											<%
												if(sachTheoLoaiSach != null && sachTheoLoaiSach.size()> 0 ){
																														for(int i = 0; i < sachTheoLoaiSach.size(); i++)
																														{	
																															Sach sach = sachTheoLoaiSach.get(i);
																															String maSach = sach.getMaSach();
																															String tenSach = sach.getTenSach();
																															String donGia = DinhDang.MyNumberFormat(sach.getDonGia(), Constant.TienTe.TIEN_COMMA_PATTERN);
																															String urlHinh = sach.getUrlHinh();
											%>
												<!-- sản phẩm  -->
												<div class="col-md-3 col-sm-4 col-xs-12 padding-0 grid_group_sp">
														<div class="col-md-12 col-sm-12 col-xs-12 padding-0">
															<div class="group_sp my_border">
																<div class="anh_sp">
																	<a href="${kyanhbooksRootPathMenuLoaiSach}ChiTietSP?MaSach=<%=maSach %>" class="">
																		<img class="anh" src="${kyanhbooksRootPath}${userStaticRootPath}img/sanpham/<%=urlHinh %>" title="sp" alt="anhsp">
																		<%
																			
																		%>
																			<a href="${kyanhbooksRootPathMenuLoaiSach}ThemSachVaoGioHang?MaSach=<%=maSach%>&SoLuong=1&DuongDan=<%= request.getServletPath() %>" class="them_gh text-a" >
																				<span class="glyphicon glyphicon-shopping-cart"></span>
																				<span class="text"> Thêm vào giỏ</span>
																			</a>
																		<%
																			
																		%>
																	</a>
																</div>
																<div class="tensp_giasp">
																	<h3 class="tensp">
																		<a href="${kyanhbooksRootPathMenuLoaiSach}ChiTietSP?MaSach=<%=maSach %>" class="text-a">
																			<%=tenSach%>
																		</a>
																	</h3>	
																	<div class="giasp">
																		<span class="gia_goc">
																			<%=donGia%> <%=Constant.TienTe.DON_VI_TIEN_TE_VN%>
																		</span>
																		<a href="${kyanhbooksRootPathMenuLoaiSach}ChiTietSP?MaSach=<%=maSach %>" class="chi_tiet">
																			<%=Constant.TenNut.CHI_TIET%>
																		</a>
																	</div>
																</div>
															</div>
														</div>
												</div>
												<!-- kt sản phẩm  -->
											<%
												}
											}else{
											%>
												<p class="alert alert-danger">Không có sản phẩm nào trong loại sách này !</p>
											<%
											}
											%>
										</div>
									</div>
									
							 	</section>
							</div>
							<!-- kt left: phần chi tiết sách -->
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
					<!-- begin: paging - phân trang -->
					<c:url var="urlSachCungLoai" value="<KhongcanRootPath vi tu co>/SachCungLoai..." />
					<nav aria-label="Page navigation">
				        <ul class="pagination" id="pagination"></ul>
				    </nav>
					<!-- end: paging - phân trang -->
				</div>
			</div>
		</section>
		<!-- kt phần nội dung sản phẩm -->

		<!-- phần footer  -->
		<jsp:include page="${userViewBlockPath}footer.jsp" />
		<!-- kt footer  -->
	</div>

	<script type="text/javascript">
		var totalPages = ${model.totalPage};
		var currentPage = ${model.page};
		$(function () {
	        window.pagObj = $('#pagination').twbsPagination({
	            totalPages: totalPages,
	            visiblePages: 10,
	            startPage: currentPage,
	            onPageClick: function (event, page) {
	            	if (currentPage != page) {
	            		$('#limit').val(2);
						$('#page').val(page);
						$('#formSubmit').submit();
					}
	            }
	        });
	    });
	</script>
	
</body>
</html>