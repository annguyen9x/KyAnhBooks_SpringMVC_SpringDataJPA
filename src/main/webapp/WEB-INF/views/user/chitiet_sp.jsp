<%@page import="com.annguyen.kyanhbooks.service.impl.LoaiSachServiceImpl"%>
<%@page import="javax.naming.NoInitialContextException"%>
<%@page import="com.annguyen.kyanhbooks.util.DinhDang"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/user/init.jsp" %>

<%@page import="java.util.List" %>
<%@page import="com.annguyen.kyanhbooks.model.Sach" %>
<%@page import="com.annguyen.kyanhbooks.model.LoaiSach" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Chi tiết sản phẩm</title>
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
	Sach sach = null;
	String maSach = "";
	String tenSach = "";
	String urlHinh = "";
	String donGia = "";
	int soLuong = 0;
	int namXB = 0;
	String nXB = "";
	String tacGia = "";
	String noiDung = "";
	if( request.getAttribute("LoaiSach") != null ){
		loaiSach  = (LoaiSach)request.getAttribute("LoaiSach");
		maLoaiSach = loaiSach.getMaLoaiSach();
		tenLoaiSach = loaiSach.getTenLoaiSach();
	}
	if(request.getAttribute("Sach") != null ){
		sach = (Sach)request.getAttribute("Sach");
		maSach = sach.getMaSach();
		tenSach = sach.getTenSach();
		urlHinh = sach.getUrlHinh();
		donGia = DinhDang.MyNumberFormat(sach.getDonGia(), Constant.TienTe.TIEN_COMMA_PATTERN);
		soLuong = sach.getSoLuong();
		namXB = sach.getNamXB();
		nXB = sach.getnXB();
		tacGia = sach.getTacGia();
		noiDung = sach.getNoiDung();
	}
%>

<body>
	<div class="wrapper">
		<!-- phần header  -->
		<jsp:include page="${userViewBlockPath}header.jsp" />
		<!-- kt header  -->
		
		<!-- phần nội dung sản phẩm -->
		<section class="main_chitiet_sp main_center">
			<div class="container">
				<div class="row">
					<!-- phần top -->
					<div class="col-md-12 col-sm-12 col-xs-12 padding-0 top_nd_trang">
						<div class="top">
							<h2>
								<a href="${kyanhbooksRootPathMenuLoaiSach}<%=Constant.Path.USER_CONTROLLER_SACH_THEO_LOAISACH %>?MaLS=<%=maLoaiSach %>" class="text-a"><%=tenLoaiSach%> </a>
								<span class="glyphicon glyphicon-chevron-right"></span>
								<a href="#"  class="text-a"> <%=tenSach%> </a>
								<span class="glyphicon glyphicon-chevron-right"></span> Chi tiết sản phẩm
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
									<div class="col-md-12 col-sm-12 col-xs-12 padding-0 top_left">
							 			<div class="col-md-5 col-sm-6 col-xs-12 padding-0 anh">
							 				<div class="anh_sp">
												 <img class="" src="${kyanhbooksRootPath}${userStaticRootPath}img/sanpham/<%=urlHinh %>" title="sp" alt="anhsp">
											</div>
							 			</div>
							 			<div class="col-md-7 col-sm-6 col-xs-12 padding-0 ten_gia_tg_sl">
							 				<div class="ten_gia">
								 				<h3 class="tensp">
														<%=tenSach%>
												</h3>	
												<div class="theloai_giasp">
													<p>
														Thể loại: <span class="loai_sach"><%=tenLoaiSach%></span>
													</p>
													<p>
														Tình trạng: <span class="trang_thai">
														<%
															if(soLuong > 0){
																																								out.print("Còn hàng");
																																							}else{
																																								out.print("Hết hàng");
																																							}
														%></span>
													</p>
													<p>
															<div id="<%=namXB%>" class="giaban">
																Giá bán:
																<span class="gia_sp">
																<%=donGia%> <%=Constant.TienTe.DON_VI_TIEN_TE_VN%>
																</span>
															</div>
													</p>
												</div>
											</div>
											<div class="tg_nxb">
												<p class="tab">
													<span class="tieude">Năm xuất bản: </span>
														<button id="hienthiMacDinh" onclick="giaVaMaSachTheoNamXB(event,'<%=namXB%>', '<%=maSach%>')" class="nam_xb"><%=namXB%></button>
														<%-- <button onclick="giaVaMaSachTheoNamXB(event,'<%=sach.getNamXB() %>', '<%=sach.getMaSach() %>')" class="nam_xb"><%=sach.getNamXB() %></button> --%>
												</p>
												<p>
													<span class="tieude">Nhà xuất bản: </span><span class="nxb"><%=nXB%></span>
												</p>
												<p>
													<span class="tieude">Tác giả: </span><span class="tac_gia"><%=tacGia%></span>
												</p>
											</div>
											<div class="sl_button">
												<form method="get" action="#" onsubmit="return ktSoLuongMua('<%=soLuong%>', '<%=tenSach%>');" id="formChiTietSP">
												 	<span class="label_sl">Số lượng: </span>
													<input type='number' name='SoLuong' value='1' class="sl_mua"><br/> 
													<div class="col-md-12 col-sm-12 col-xs-12 padding-0 nut">
														<div class="col-md-3 col-sm-4 col-xs-4 padding-0 margin_right">
															<a href="${kyanhbooksRootPath }" class="">
																<button type="button" class="btn btn-default">
																	<span class="thoat"><%=Constant.TenNut.THOAT%></span>
																</button>
															</a>
														</div>
														<div class="col-md-8 col-sm-8 col-xs-8 padding-0">
															<button type="submit" class="btn bg_btn"><%=Constant.TenNut.THEM_VAO_GIO_HANG%></button>
														</div>
													</div>
											 	</form> 
											</div>
							 			</div>
							 		</div>
							 		<div class="col-md-12 col-sm-12 col-xs-12 padding-0 bottom_leff">
						 				<div class="tieude_gt">
						 					<h3>Giới thiệu sách</h3>
						 				</div>	
						 				<div class="nd_gt my_border">
						 					<%=noiDung %>
						 					<p><strong>KyAnhBooks trân trọng giới thiệu !</strong></p>
						 				</div>
							 		</div>
							 		<!-- kt gioithieu -->
							 		<!-- phần facebook hỏi đáp thảo luận -->
							 		<div class="col-md-12 col-sm-12 col-xs-12 padding-0 bottom_leff_facebook">
						 				<div class="top">
						 					<div class="tieude">
						 						Hỏi đáp, thảo luận
						 					</div>
						 				</div>	
						 				<div class="fb-comments" data-href="http://sachvui.com/ebook/tu-hoc-tieng-anh-hieu-qua-nguyen-thi-ha-bac.4121.html" data-width="100%" data-numposts="3"></div>
						 			</div>
						 			<!-- phần facebook hỏi đáp thảo luận -->
							 	</section>
							</div>
							<!-- kt left: phần chi tiết sách -->
							<!-- right: phần hoTroKH_sachNoiBat -->
							<div class="col-md-4 col-sm-4 col-xs-12 padding-0">
								<article class="row  margin-0 right">
									<jsp:include page="${userViewBlockPath}hotrokh_sachnoibat.jsp"/>
								</article>
							</div>
							<!-- kt right: phần hoTroKH_spCungloai -->
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

		<!-- start my js -->
		<script src="${kyanhbooksRootPath}${userStaticRootPath}js/giaSanPhamVaMaSachTheoNamXB.js" type="text/javascript" charset="utf-8"></script>
		<script src="${kyanhbooksRootPath}${userStaticRootPath}js/kiemTraSoLuongMua.js" type="text/javascript" charset="utf-8"></script>
		<!-- end my js -->
	</div>
</body>
</html>