<%@page import="com.annguyen.kyanhbooks.util.DinhDang"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ include file="/WEB-INF/views/user/init.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Lịch sử mua hàng</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<!--  start bootstrap -->
<link rel="stylesheet" type="text/css" href="${userStaticRootPath}bootstrap-3.4.1-dist/css/bootstrap.min.css"/>
<script type="text/javascript" src="${userStaticRootPath}js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${userStaticRootPath}bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
<!--  end bootstrap -->
<!-- start fontawesome -->
<link rel="stylesheet" href="${userStaticRootPath}font/font-awesome-4.7.0/css/font-awesome.min.css">
<!-- start fontawesome -->
<!-- start facebook -->
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v4.0&appId=2525119214214430&autoLogAppEvents=1"></script>
<!-- end facebook -->
<!-- start my css -->
<link rel="stylesheet" type="text/css" href="${userStaticRootPath}css/trangchu.css"/>
<!-- end my css -->
<!-- start my js -->
	<script src="${userStaticRootPath}js/menuAnHien.js" type="text/javascript" charset="utf-8"></script>
	<script src="${userStaticRootPath}js/formValidation.js" type="text/javascript" charset="utf-8"></script>
<!-- end my js -->

</head>
<%
	List<Object[]> listHoaDonAndKhachHang = (List<Object[]>)request.getAttribute("ListHoaDonAndKhachHang");
%>
<body>
	<div class="wrapper">
		<!-- phần header  -->
		<jsp:include page="${userViewBlockPath}header.jsp" />
		<!-- kt header  -->
		
		<!-- phần nội dung sản phẩm -->
		<section class="main_dangky main_center">
			<div class="container">
				<div class="row">
					<div class="col-md-3 padding-left0 left">
						<div class="menu_taikhoan my_border">
						    <h2>
						        <span>
						            Quản lý tài khoản
						        </span>
						    </h2>
						    <ul>
						        <li class="list-li"><a href="${kyanhbooksRootPath}<%=Constant.Path.USER_CONTROLLER_KHACH_HANG_HIENTHI_CAPNHAT_TAIKHOAN%>" class="text-a"><span class="glyphicon glyphicon-user"></span> Cập nhật tài khoản</a></li>
						        <li class="list-li"><a href="${kyanhbooksRootPath}<%=Constant.Path.USER_CONTROLLER_KHACH_HANG_XEM_LICHSU_MUAHANG%>" class="text-a"><i class="glyphicon glyphicon-list"></i> Xem lịch sử mua hàng</a></li>
						        <li class="list-li"><a href="${kyanhbooksRootPath}<%=Constant.Path.USER_CONTROLLER_KHACH_HANG_DANG_XUAT%>" class="text-a"><i class="glyphicon glyphicon-log-out"></i> Đăng xuất</a></li>
						    </ul>
						</div>
					</div>
					<div class="col-md-9 padding-0 right">
						<!-- phần top -->
						<div class="col-md-12 padding-0 top_nd_trang">
							<div class="top">
								<h2>
									<a href="#" class="text-a">Xem lịch sử mua hàng</a>
								</h2>
							</div>
						</div>
						<!-- kt phần top -->
						<!-- phần nội dung trang -->
						<div class="col-md-12 padding-0 nd_trang">
							<div class="row margin-0 my_border">
			                    <div class="col-sx-12">
			                    	<h2 class="col-xs-12 text-center">
			                    		<span>Lịch sử mua hàng</span>
			                    	</h2>
			                    	<%
										if( listHoaDonAndKhachHang == null || (listHoaDonAndKhachHang != null && listHoaDonAndKhachHang.size() == 0 ) ){
									%>
									<div class="col-xs-12">
										<div class="alert alert-danger">
											<strong>Bạn chưa đặt đơn hàng nào, danh sách rỗng.</strong> Vui lòng mua hàng để xem lịch sử !
										</div> 
									</div>
									<%
										}
										if( listHoaDonAndKhachHang != null && listHoaDonAndKhachHang.size() > 0 ){
									%>
									<table class="table my_border">
										<thead style="background:#5a5858; color:#fff">
											<tr>
												<th>STT</th>
												<th>Mã Đơn Hàng</th>
												<th>Ngày Đặt</th>
												<th>Tổng Tiền</th>
												<th>Tình Trạng</th>
												<th>Chi Tiết</th>
											</tr>
										</thead>
										<tbody>
											<%
												for(int i = 0; i < listHoaDonAndKhachHang.size(); i++){
													String soHD = (listHoaDonAndKhachHang.get(i)[0]).toString();
													String tongTienStr = listHoaDonAndKhachHang.get(i)[1].toString();
													int tongTien = Integer.parseInt(tongTienStr.substring(0, tongTienStr.lastIndexOf(Constant.KyTuDacBiet.DOT)));
													Date ngayDat = (Date)listHoaDonAndKhachHang.get(i)[2];
													String tinhTrang = (listHoaDonAndKhachHang.get(i)[4]).toString();
											%>
												<tr>
													<td><%=i+1 %></td>
													<td><%=soHD %></td>
													<td>
														<%=DinhDang.MyStringDateFormat(ngayDat, Constant.NgayThang.DATE_TIME_VN1) %>
													</td>
													<td>
														<%=DinhDang.MyNumberFormat(tongTien, Constant.TienTe.TIEN_COMMA_PATTERN)%> <%= Constant.TienTe.DON_VI_TIEN_TE_VN %>
													</td>
													<td><%=tinhTrang %></td>
													<td>
														<form action="${kyanhbooksRootPath}<%=Constant.Path.USER_CONTROLLER_THEO_DOI_DON_HANG%>" method="post">
															<input type="hidden" name="maDH" value="<%=soHD %>" />
															<button type="submit" class="btn btn-link">Xem chi tiết</button>
														</form>
													</td>
												</tr>
											<%
												}
											%>
										</tbody>
									</table>
									<%
										}
									%>
			                    </div>
							</div>
						</div>
						<!-- kt phần nội dung trang -->
					</div>
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