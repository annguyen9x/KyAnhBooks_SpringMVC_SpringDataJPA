<%@page import="com.annguyen.kyanhbooks.util.DinhDang"%>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.annguyen.kyanhbooks.model.Sach" %>
<%@ page import="com.annguyen.kyanhbooks.model.LoaiSach" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/user/init.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>KyAnhBook - Trang chủ</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<!--  bootstrap -->
<link rel="stylesheet" type="text/css" href="${userStaticRootPath}bootstrap-3.4.1-dist/css/bootstrap.css"/>
<script type="text/javascript" src="${userStaticRootPath}js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${userStaticRootPath}bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
<!--  kt bootstrap -->
<!--  fontawesome -->
<link rel="stylesheet" href="${userStaticRootPath}font/font-awesome-4.7.0/css/font-awesome.min.css">
<!-- kt fontawesome -->
<!-- start facebook -->
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v4.0&appId=2525119214214430&autoLogAppEvents=1"></script>
<!-- end facebook -->
<!-- my css -->
<link rel="stylesheet" type="text/css" href="${userStaticRootPath}css/trangchu.css"/>
<!-- kt my css -->

</head>
<body>
	<div class="wrapper">
		<!-- header  -->
		<jsp:include page="${userViewBlockPath}header_tc.jsp" />
		<!-- kt header  -->
		
		<!-- phần nội dung trang -->
		<section class="main">
			<div class="container">
				<!-- phần danh sách sản phẩm main -->
				<section class="danhsach_sp_main">
					<div class="row sachNoiBat_sachMoi">
						<!-- phần bên trái -->
						<div class="col-md-3 col-sm-12 col-xs-12 left_main padding-left0">
							<div class="row">
								<div class="col-md-12 col-sm-12 col-xs-12 top-lefft-list-sp">
									<div class="top_sp_cungloai">
										<h2>
											<span class="text">
												<%=Constant.TrangChu.SACH_NOI_BAT%>
											</a> 
										</h2>
									</div>
								</div>

								<div class="col-md-12 col-sm-12 col-xs-12 group-lefft-list-sp">
									<div class="col-md-12 col-sm-6 col-xs-12 padding-0 grid_group_sp">
										<%
											List<Sach> sachNoiBat = (List<Sach>)request.getAttribute("SachNoiBat");
																											for(int i= 0; null != sachNoiBat && i < sachNoiBat.size(); i++ ){
																												String tenSach = sachNoiBat.get(i).getTenSach();
																												String donGia = DinhDang.MyNumberFormat(sachNoiBat.get(i).getDonGia(), Constant.TienTe.TIEN_COMMA_PATTERN);
																												String urlHinh = sachNoiBat.get(i).getUrlHinh();
																												String maSach = sachNoiBat.get(i).getMaSach();
										%>
											<!-- sản phẩm  -->
											<div class="col-md-12 col-sm-6 col-xs-12 padding-0" style="margin-bottom: 10px;">
												<div class="group_sp my_border">
													<div class="anh_sp">
														<a href="${kyanhbooksRootPathMenuLoaiSach}ChiTietSP?MaSach=<%=maSach%>" class="">
															<img class="anh" src="${userStaticRootPath}img/sanpham/<%=urlHinh %>" title="sp" alt="anhsp">
															<a href="" class="them_gh text-a" >
																<span class="glyphicon glyphicon-shopping-cart"></span>
																<span class="text"> Thêm vào giỏ</span>
															</a>
														</a>
													</div>
													<div class="tensp_giasp">
														<h3 class="tensp">
															<a href="${kyanhbooksRootPathMenuLoaiSach}ChiTietSP?MaSach=<%=maSach%>" class="text-a">
																<%=tenSach%>
															</a>
														</h3>	
														<div class="giasp">
															<span class="gia_goc">
																<%=donGia%> <%=Constant.TienTe.DON_VI_TIEN_TE_VN%>
															</span>
															<a href="${kyanhbooksRootPathMenuLoaiSach}ChiTietSP?MaSach=<%=maSach%>" class="chi_tiet">
																<%=Constant.TenNut.CHI_TIET%>
															</a>
														</div>
													</div>
												</div>
											</div>
											<!-- kt sản phẩm  -->
										<%
											}
										%>
									</div>
								</div>
							</div>
						</div>
						<!-- kt phần bên trái -->
						<!-- phần bên phải -->
						<div class="col-md-9 col-sm-12 col-xs-12 right_main padding-0">
							<div class="row">
								<div class="col-md-12 col-sm-12 col-xs-12 top-right-list-sp">
									<div class="top_sp_cungloai">
										<h2>
											<span class="text">
												<%=Constant.TrangChu.SACH_MOI%>
											</a> 
										</h2>
									</div>
								</div>

								<%
									List<Sach> sachMois = (List<Sach>)request.getAttribute("SachMoi");
																				if(sachMois != null ){
																					String maSach = "";
																					String tenSach = "";
																					String donGia = "";
																					String urlHinh = "";
								%>
								<div class="col-md-12 col-sm-12 col-xs-12 group-right-list-sp">
									<%
										for(int i = 0; i < (Constant.TrangChu.SACH_MOI_NUMBER/2); i++){
																								maSach = sachMois.get(i).getMaSach();
																								tenSach = sachMois.get(i).getTenSach();
																								urlHinh = sachMois.get(i).getUrlHinh();
																								donGia = DinhDang.MyNumberFormat(sachMois.get(i).getDonGia(), Constant.TienTe.TIEN_COMMA_PATTERN);
									%>
									<!-- sản phẩm  -->
									<div class="col-md-3 col-sm-3 col-xs-12 padding-0 grid_group_sp">
											<div class="col-md-12 col-sm-12 col-xs-12 padding-0">
												<div class="group_sp my_border">
													<div class="anh_sp">
														<a href="${kyanhbooksRootPathMenuLoaiSach}ChiTietSP?MaSach=<%=maSach%>" class="">
															<img class="anh" src="${userStaticRootPath}img/sanpham/<%=urlHinh %>" title="sp" alt="anhsp">
															<a href="#" class="them_gh text-a" >
																<span class="glyphicon glyphicon-shopping-cart"></span>
																<span class="text"> Thêm vào giỏ</span>
															</a>
														</a>
													</div>
													<div class="tensp_giasp">
													<h3 class="tensp">
														<a href="${kyanhbooksRootPathMenuLoaiSach}ChiTietSP?MaSach=<%=maSach%>" class="text-a">
															<%=tenSach%>
														</a>
													</h3>	
													<div class="giasp">
														<span class="gia_goc">
															<%=donGia%> <%=Constant.TienTe.DON_VI_TIEN_TE_VN%>
														</span>
														<a href="${kyanhbooksRootPathMenuLoaiSach}ChiTietSP?MaSach=<%=maSach%>" class="chi_tiet">
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
									%>
								</div>
								
								<div class="col-md-12 col-sm-12 col-xs-12 group-right-list-sp">
									<%
										for(int i = (Constant.TrangChu.SACH_MOI_NUMBER/2); i < Constant.TrangChu.SACH_MOI_NUMBER; i++){
																								maSach = sachMois.get(i).getMaSach();
																								tenSach = sachMois.get(i).getTenSach();
																								urlHinh = sachMois.get(i).getUrlHinh();
																								donGia = DinhDang.MyNumberFormat(sachMois.get(i).getDonGia(), Constant.TienTe.TIEN_COMMA_PATTERN);
									%>
									<!-- sản phẩm  -->
									<div class="col-md-3 col-sm-3 col-xs-12 padding-0 grid_group_sp">
											<div class="col-md-12 col-sm-12 col-xs-12 padding-0">
												<div class="group_sp my_border">
													<div class="anh_sp">
														<a href="${kyanhbooksRootPathMenuLoaiSach}ChiTietSP?MaSach=<%=maSach%>" class="">
															<img class="anh" src="${userStaticRootPath}img/sanpham/<%=urlHinh %>" title="sp" alt="anhsp">
															<a href="#" class="them_gh text-a" >
																<span class="glyphicon glyphicon-shopping-cart"></span>
																<span class="text"> Thêm vào giỏ</span>
															</a>
														</a>
													</div>
													<div class="tensp_giasp">
													<h3 class="tensp">
														<a href="${kyanhbooksRootPathMenuLoaiSach}ChiTietSP?MaSach=<%=maSach%>" class="text-a">
															<%=tenSach%>
														</a>
													</h3>	
													<div class="giasp">
														<span class="gia_goc">
															<%=donGia%> <%=Constant.TienTe.DON_VI_TIEN_TE_VN%>
														</span>
														<a href="${kyanhbooksRootPathMenuLoaiSach}ChiTietSP?MaSach=<%=maSach%>" class="chi_tiet">
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
									%>
								</div>
								<%
									}
								%>
							</div>
						</div>
						<!-- kt phần bên phải -->
					</div>

				</section>
				<!-- kt phần danh sách sản phẩm main -->
				<!-- phần banner bottom -->
				<article class="row banner_bottom">
					<div class="container">
						<div class="row">
							<div class="col-md-6 col-sm-6 col-xs-12 padding-left0">
								<a href="" class="hinh_bottom">
									<img class="hinh" src="${userStaticRootPath}img/banner/banner_bottom1.png">
								</a>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-12 padding-right0">
								<a href="" class="hinh_bottom">
									<img class="hinh" src="${userStaticRootPath}img/banner/banner_bottom2.png">
								</a>
							</div>
						</div>
					</div>
				</article>
				<!-- kt phần banner bottom -->
				<!-- phần danh sách sản phẩm bottom -->
				<section class="danhsach_sp_bottom">
						<div class="row">
							<div class="col-md-12 col-sm-12 col-xs-12 padding-0 top-list-sp">
								<div class="top_sp_cungloai">
									<h2>
										<a href="${kyanhbooksRootPathMenuLoaiSach}<%=Constant.Path.USER_CONTROLLER_SACH_THEO_LOAISACH %>?MaLS=<%=Constant.TrangChu.MA_LOAI_SACH_VAN_HOC%>" class="text-a">
											<%=Constant.TrangChu.SACH_VAN_HOC%>
										</a> 
									</h2>
								</div>
							</div>

							<div class="col-md-12 col-sm-12 col-xs-12 padding-0 group-list-sp">
								<!-- phần 1: banner svh, sp -->
									<%
										List<Sach> sachVanHocs = (List<Sach>)request.getAttribute("sachVanHocTrangChu");
																							String tenSach = "";
																							String donGia = "";
																							String urlHinh = "";
																							String maSach = "";
									%>
									<div class="col-md-6 col-sm-12 col-xs-12 padding-0">
										<!-- phần banner sách văn học -->
										<div class="col-md-6 col-sm-6 col-xs-12 padding-0 banner_bottom">
											<a href="${kyanhbooksRootPathMenuLoaiSach}<%=Constant.Path.USER_CONTROLLER_SACH_THEO_LOAISACH %>?MaLS=<%=Constant.TrangChu.MA_LOAI_SACH_VAN_HOC%>" class="hinh_svh">
												<img class="hinh" src="${userStaticRootPath}img/banner/banner_svh.jpg">
											</a>
										</div>
										<!-- kt phần banner sách văn học -->
										<!-- phần sản phẩm  -->
										<div class="col-md-6 col-sm-6 col-xs-12 padding-0 grid_group_sp">
											<%
												for(int i= 0; i < 2; i++){
																														tenSach = sachVanHocs.get(i).getTenSach();
																														donGia = DinhDang.MyNumberFormat(sachVanHocs.get(i).getDonGia(), Constant.TienTe.TIEN_COMMA_PATTERN);
																														urlHinh = sachVanHocs.get(i).getUrlHinh();
																														maSach = sachVanHocs.get(i).getMaSach();
											%>
											<!-- sản phẩm 1 -->
											<div class="col-md-12 col-sm-12 col-xs-12 padding-0">
												<div class="group_sp">
													<div class="anh_sp my_border">
														<a href="${kyanhbooksRootPathMenuLoaiSach}ChiTietSP?MaSach=<%=maSach%>" class="">
															<img class="anh" src="${userStaticRootPath}img/sanpham/<%=urlHinh %>" title="sp" alt="anhsp">
															<a href="#" class="them_gh text-a" >
																<span class="glyphicon glyphicon-shopping-cart"></span>
																<span class="text"> Thêm vào giỏ</span>
															</a>
														</a>
													</div>
													<div class="tensp_giasp">
														<h3 class="tensp">
															<a href="${kyanhbooksRootPathMenuLoaiSach}ChiTietSP?MaSach=<%=maSach%>" class="text-a">
																<%=tenSach%>
															</a>
														</h3>	
														<div class="giasp">
															<span class="gia_goc">
																<%=donGia%> <%=Constant.TienTe.DON_VI_TIEN_TE_VN%>
															</span>
															<a href="${kyanhbooksRootPathMenuLoaiSach}ChiTietSP?MaSach=<%=maSach%>" class="chi_tiet">
																<%=Constant.TenNut.CHI_TIET%>
															</a>
														</div>
													</div>
												</div>
											</div>
											<!-- kt sản phẩm 1 -->
											<%
												}
											%>
										</div>
										<!-- kt phần sản phẩm  -->
									</div>
								<!-- kt phần 1: banner svh, sp -->
								<!-- phần 2: 4sp -->
									<div class="col-md-6 col-sm-12 col-xs-12 padding-0">
										<!-- phần sản phẩm  -->
										<div class="col-md-6 col-sm-6 col-xs-12 padding-0 grid_group_sp">
											<%
												for(int i= 2; i < 4; i++){
																														tenSach = sachVanHocs.get(i).getTenSach();
																														donGia = DinhDang.MyNumberFormat(sachVanHocs.get(i).getDonGia(), Constant.TienTe.TIEN_COMMA_PATTERN);
																														urlHinh = sachVanHocs.get(i).getUrlHinh();
																														maSach = sachVanHocs.get(i).getMaSach();
											%>
											<!-- sản phẩm 1 -->
											<div class="col-md-12 col-sm-12 col-xs-12 padding-0">
												<div class="group_sp ">
													<div class="anh_sp my_border">
														<a href="${kyanhbooksRootPathMenuLoaiSach}ChiTietSP?MaSach=<%=maSach%>" class="">
															<img class="anh" src="${userStaticRootPath}img/sanpham/<%=urlHinh %>" title="sp" alt="anhsp">
															<a href="#" class="them_gh text-a" >
																<span class="glyphicon glyphicon-shopping-cart"></span>
																<span class="text"> Thêm vào giỏ</span>
															</a>
														</a>
													</div>
													<div class="tensp_giasp">
														<h3 class="tensp">
															<a href="${kyanhbooksRootPathMenuLoaiSach}ChiTietSP?MaSach=<%=maSach%>" class="text-a">
																<%=tenSach%>
															</a>
														</h3>	
														<div class="giasp">
															<span class="gia_goc">
																<%=donGia%> <%=Constant.TienTe.DON_VI_TIEN_TE_VN%>
															</span>
															<a href="${kyanhbooksRootPathMenuLoaiSach}ChiTietSP?MaSach=<%=maSach%>" class="chi_tiet">
																<%=Constant.TenNut.CHI_TIET%>
															</a>
														</div>
													</div>
												</div>
											</div>
											<!-- kt sản phẩm 1 -->
											<%
												}
											%>
										</div>
										<!-- kt phần sản phẩm  -->
										<!-- phần sản phẩm  -->
										<div class="col-md-6 col-sm-6 col-xs-12 padding-0 grid_group_sp">
											<%
												for(int i= 4; i < 6; i++){
																														tenSach = sachVanHocs.get(i).getTenSach();
																														donGia = DinhDang.MyNumberFormat(sachVanHocs.get(i).getDonGia(), Constant.TienTe.TIEN_COMMA_PATTERN);
																														urlHinh = sachVanHocs.get(i).getUrlHinh();
																														maSach = sachVanHocs.get(i).getMaSach();
											%>
											<!-- sản phẩm 1 -->
											<div class="col-md-12 col-sm-12 col-xs-12 padding-0">
												<div class="group_sp ">
													<div class="anh_sp my_border">
														<a href="${kyanhbooksRootPathMenuLoaiSach}ChiTietSP?MaSach=<%=maSach%>" class="">
															<img class="anh" src="${userStaticRootPath}img/sanpham/<%=urlHinh %>" title="sp" alt="anhsp">
															<a href="#" class="them_gh text-a" >
																<span class="glyphicon glyphicon-shopping-cart"></span>
																<span class="text"> Thêm vào giỏ</span>
															</a>
														</a>
													</div>
													<div class="tensp_giasp">
														<h3 class="tensp">
															<a href="${kyanhbooksRootPathMenuLoaiSach}ChiTietSP?MaSach=<%=maSach%>" class="text-a">
																<%=tenSach%>
															</a>
														</h3>	
														<div class="giasp">
															<span class="gia_goc">
																<%=donGia%> <%=Constant.TienTe.DON_VI_TIEN_TE_VN%>
															</span>
															<a href="${kyanhbooksRootPathMenuLoaiSach}ChiTietSP?MaSach=<%=maSach%>" class="chi_tiet">
																<%=Constant.TenNut.CHI_TIET%>
															</a>
														</div>
													</div>
												</div>
											</div>
											<!-- kt sản phẩm 1 -->
											<%
											}
											%>
										</div>
										<!-- kt phần sản phẩm  -->
									</div>
									<!-- kt phần 2: 4sp -->
							</div>
						</div>
				</section>
				<!-- kt phần danh sách sản phẩm bottom -->				
			</div>
		</section>
		<!-- kt phần nội dung trang "main"-->

		<!-- footer  -->
		<jsp:include page="${userViewBlockPath}footer.jsp" />
		<!-- kt footer  -->
	</div>


	<%-- <!-- start my js -->
	<script src="${userStaticRootPath}js/slide.js" type="text/javascript" charset="utf-8"></script>
	<!-- end my js --> --%>
</body>
</html>