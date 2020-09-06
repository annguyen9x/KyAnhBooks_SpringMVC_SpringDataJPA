<%@page import="com.annguyen.kyanhbooks.util.DinhDang"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/user/init.jsp" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.annguyen.kyanhbooks.model.GioHang" %>
<%@ page import="java.lang.Object" %>
<%@page import="java.util.HashMap"%>
<%@page import="org.json.JSONObject"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Giỏ hàng</title>
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

<!-- begin jquery notify -->
<link rel="stylesheet" href="${userStaticRootPath}jquery-confirm/css/jquery-confirm.css" />
<script src="${userStaticRootPath}jquery-confirm/js/jquery-confirm.js"></script>
<!-- end jquery notify -->

</head>
<%
	Map gioHangMap = new HashMap();
	GioHang gioHang = null;
	List<Object[]> chiTietGioHangAndSanPhams = null;
	Object[] chiTietGioHangAndSanPham = null;
	
	if( session.getAttribute(Constant.GioHang.GIOHANG_SESSION) != null ){
		gioHangMap = (Map)session.getAttribute(Constant.GioHang.GIOHANG_SESSION);
		if( gioHangMap != null ){
			gioHang = (GioHang)gioHangMap.get("GioHang");
			chiTietGioHangAndSanPhams = (List<Object[]>)gioHangMap.get("ChiTietGioHangAndSanPhams");
		}
	}
	boolean isChuaTaoGioHang = false;
	if( request.getAttribute(Constant.GioHang.CHUA_TAO_GIOHANG) != null){
		isChuaTaoGioHang = Boolean.parseBoolean(request.getAttribute(Constant.GioHang.CHUA_TAO_GIOHANG).toString());
	}
	
	String urlDangNhapXemGioiHang = Constant.Path.KYANHBOOKS_ROOT_PATH + Constant.Path.USER_CONTROLLER_GIO_HANG_DANGNHAP_XEM;
	String urlDangNhapXemGioiHangReloading = Constant.Path.KYANHBOOKS_ROOT_PATH + Constant.Path.USER_CONTROLLER_GIO_HANG_XEM_RELOADING;
	String urlGuiMaXacNhanSDT = Constant.Path.KYANHBOOKS_ROOT_PATH + Constant.Path.USER_CONTROLLER_GIO_HANG_GUI_MA_XACNHAN_SDT;
	String urlXacNhanSdtXemGioHang = Constant.Path.KYANHBOOKS_ROOT_PATH + Constant.Path.USER_CONTROLLER_GIO_HANG_XACNHAN_SDT_XEM;
%>
<body>
<div class="wrapper">
	<!-- header  -->
	<jsp:include page="${userViewBlockPath}header.jsp" />
	<!-- kt header  -->
	
	<section class="main_center main_sp_cungloai">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12 padding-0 main_title_line">
					<!-- phần top -->
					<div class="col-md-12 padding-0 top_nd_trang">
						<div class="top">
							<h2>
								<span>Giỏ hàng</span>
							</h2>
						</div>
					</div>
					<!-- kt phần top -->
					<!-- phần nội dung trang -->
					<div class="col-md-12 padding-0 nd_trang">
						<div class="row margin-0">
							<!-- noi dung gio hang -->
							<section class="gio_hang">
								<%
									
									if( gioHangMap == null || gioHang == null || isChuaTaoGioHang == true ){
								%>
									<div class="alert alert-danger col-md-12 text-center">
										Vui lòng<button style="font-size:16px; padding: 0px;" type="button" class="btn btn-link" data-toggle="modal" id="btnDangNhapModal" data-target="#dangNhapModal">&nbsp;đăng nhập,</button>&nbsp;hoặc xác nhận
										<button style="font-size:16px; padding: 0px;" type="button" class="btn btn-link" data-toggle="modal" id="btnXacNhanSdtModa" data-target="#xacNhanSdtModal">&nbsp;số điện thoại</button>&nbsp;để xem giỏ hàng.
									</div>
									
									<!-- begin: modal đăng nhập-->
									<div id="dangNhapModal" class="modal fade" role="dialog" tabindex="-1" >
									  <div class="modal-dialog">
									
									    <!-- Modal content-->
									    <div class="modal-content text-center" style="border-radius: 10px;">
									      <div class="modal-header">
									        <button type="button" class="close" data-dismiss="modal">&times;</button>
									        <h4 class="modal-title" style="color:#f47920; font-size:20px;">Đăng Nhập</h4>
									      </div>
									      <div class="modal-body">
										       <div id="ketQuaDangNhapXemGioHang">
										       	 <form method="post" id="formDNXemGH" action="#" class="form-horizontal">
													<div class="form-group">
										            	<label for="email" class="col-sm-3 control-label">Email</label>
										            	<div class="col-sm-8">
										            		<input type="email" class="form-control" name="email" id="email">
										            		<span id="errorEmail" class="col-xs-12" style="color:red; text-align:left; font-size:12px;"></span>
										            	</div>
										            </div>
										            <div class="form-group">
										            	<label for="pwd" class="col-sm-3 control-label">Mật khẩu</label>
										            	<div class="col-sm-8">
										            		<input type="password" class="form-control" name="matkhau" id="matkhau">
										            		<span id="errorMatkhau" class="col-xs-12" style="color:red; text-align:left; font-size:12px;"></span>
										            	</div>
										            </div>
										            <div class="form-group">
										            	<div class="col-sm-12" Style="text-align: center;">
										            		<span id="errorLogin" class="col-xs-12" style="color:red; text-align:center; font-size:14px; margin-top:5px;"></span>
										            	</div>
										            </div>
										            <div class="form-group">
										            	<div class="col-xs-12">
										            		<button type="button" class="btn btn-default" data-dismiss="modal" style="margin-right: 10px; ">Thoát</button>
										            		<button type="button" class="btn" id="btnDanhNhap" style="background: #f47920; color: #fff;">
										            			Đăng nhập
										            		</button>
										            	</div>
										            </div>
										          </form>
										          <button class="jquery-script-ads" type="hidden" id="success"></button>
											  </div>
									      </div>
									    </div>
									
									  </div>
									</div>
									<!-- end: modal đăng nhập-->
									
									<!-- begin: modal xác nhận SDT-->
									<div id="xacNhanSdtModal" class="modal fade" role="dialog" tabindex="-1">
									  <div class="modal-dialog">
									
									    <!-- Modal content-->
									    <div class="modal-content text-center" style="border-radius: 10px;">
									      <div class="modal-header">
									        <button type="button" class="close" data-dismiss="modal">&times;</button>
									        <h4 class="modal-title" style="color:#f47920; font-size:20px;">Xác Nhận Số Điện Thoại</h4>
									      </div>
									      <div class="modal-body">
									      		<div id="ketQuaXacNhanSdt">
											        <form method="post" id="formxacNhanSdt" action="" class="form-horizontal">
														<div class="form-group">
											            	<label for="dienThoai" class="col-sm-3 control-label">Điện Thoại</label>
											            	<div class="col-sm-8">
												            	<div class="col-sm-7" style="padding:0px; ">
												            		<input type="number" class="form-control" name="dienThoai" id="dienThoai">
												            		<span id="errorDienThoai" class="col-xs-12" style="color:red; text-align:left; font-size:12px;"></span>
												            	</div>
												            	<div class="col-sm-3" style="padding-left: 4px; ">
												            		<button type="button" id="btnGuiMaXN" class="btn" style="background:#70ba28; color:#fff;">
												            			<i class="fa fa-spinner fa-spin" id="loadingMaXN" style="font-size:14px; color:red"></i>
												            			<span id="spanGuiMaXN" style="padding: 0px 9px;">Gửi mã xác nhận</span>
												            		</button>
												            	</div>
												            </div>
											            </div>
											            <div class="form-group">
											            	<div class="col-sm-12" Style="text-align: center;">
											            		<span id="thongBaoGuiMaXN" class="col-xs-12" style="color:#70ba28; text-align:center; font-size:14px; margin-top:5px;"></span>
											            	</div>
											            </div>
											            <div class="form-group">
											            	<label for="hoTen" class="col-sm-3 control-label">Họ tên</label>
										            		<div class="col-sm-8">
												            	<div class="col-sm-7" style="padding:0px; ">
												            		<input type="text" class="form-control" name="hoTen" id="hoTen" placeholder="" required="required">
												            		<span id="errorHoTen" class="col-xs-12" style="color:red; text-align:left; font-size:12px;"></span>
												            	</div>
												            	<div class="col-sm-5" style="padding-left: 4px; padding-right: 0px;">
												            		<input type="text" class="form-control" name="maXnSdt" id="maXnSdt" placeholder="Nhập mã xác nhận" required="required">
												            		<span id="errorMaXnRong" class="col-xs-12" style="color:red; text-align:left; font-size:12px;"></span>
												            	</div>
												            </div>
											            </div>
											            <div class="form-group">
											            	<div class="col-sm-12" Style="text-align: center;">
											            		<span id="errorMaXN" class="col-xs-12" style="color:red; text-align:center; font-size:14px; margin-top:5px;"></span>
											            	</div>
											            </div>
											            <div class="form-group">
											            	<div class="col-xs-12">
											            		<button type="button" class="btn btn-default" data-dismiss="modal" style="margin-right: 10px; ">Thoát</button>
											            		<button type="button" class="btn" id="btnXacNhanSdt" onclick="xacNhanMaXacNhan();" style="background: #f47920; color: #fff;">
											            			Xác nhận SĐT
											            		</button>
											            	</div>
											            </div>
													</form>
												</div>
									      </div>
									    </div>
									
									  </div>
									</div>
									<!-- end: modal xác nhận SDT-->
									
								<%
									}
									else if( gioHangMap != null && gioHang != null ){
									 		if( chiTietGioHangAndSanPhams == null || ( chiTietGioHangAndSanPhams != null && chiTietGioHangAndSanPhams.size() < 1 ) ){
								%>
									<div class="alert alert-danger">
										<strong>Không có sản phẩm nào trong giỏ hàng.</strong> Nhấn <a href="${kyanhbooksRootPath }" class="text-a">"Quay lại"</a> để mua hàng !
									</div>
								<%
											}else if( chiTietGioHangAndSanPhams != null && chiTietGioHangAndSanPhams.size() >= 1 ){
								%>
									<form action="${kyanhbooks}<%=Constant.Path.USER_CONTROLLER_GIO_HANG_CAPNHAT_SP %>" method="post" onsubmit="return ktSoLuongCapNhat();" id="gioHang" class="form_giohang">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>
													Hình ảnh
													</th>
													<th>
													Tên sách
													</th>
													<th>
													Giá
													</th>
													<th>
													Số lượng
													</th>
													<th>
													Thành tiền
													</th>
													<th>
													Xóa
													</th>
												</tr>
											</thead>
											<tbody>
												<%
												float tongTien = 0;
												String maSach = "";
												String tenSach = "";
												String urlHinh = "";
												int soLuong = 0;
												float donGia = 0;
												for( int i = 0; i < chiTietGioHangAndSanPhams.size(); i++){
													chiTietGioHangAndSanPham = chiTietGioHangAndSanPhams.get(i);
													tenSach = chiTietGioHangAndSanPham[3].toString();
													urlHinh = chiTietGioHangAndSanPham[4].toString();
													donGia = Float.parseFloat(chiTietGioHangAndSanPham[1].toString());
													soLuong = Integer.parseInt(chiTietGioHangAndSanPham[2].toString());
													maSach = chiTietGioHangAndSanPham[0].toString();
												%>
												<tr>
													<td class="hinh">
														<img src="${userStaticRootPath}img/sanpham/<%=urlHinh %>" alt="anh">
													</td>
													<td class="ten_sp">
														<%=tenSach %>
														<input type="hidden" name="TenSachHidden" value="<%=tenSach %>" class="TenSachHidden" >
													</td>
													<td class="tien">
														<%=DinhDang.MyNumberFormat(donGia, Constant.TienTe.TIEN_COMMA_PATTERN)%> <span class="text_underline"><%=Constant.TienTe.DON_VI_TIEN_TE_VN %></span>
													</td>
													<td class="so_luong">
														<input type="number" name="soLuong" value="<%=soLuong %>" class="soLuong">
														<input type="hidden" name="TSLDB" value="<%=soLuong %>" class="TongSoLuongDB" >
													</td>
													<td class="tien">
														<%=DinhDang.MyNumberFormat(soLuong*donGia, Constant.TienTe.TIEN_COMMA_PATTERN) %> <span class="text_underline"><%=Constant.TienTe.DON_VI_TIEN_TE_VN %></span>
													</td>
													<td class="trash">
														<a href="/SachKyAnh/XoaGioHang?MaSach=<%=maSach%>">
															<span class="glyphicon glyphicon-trash"></span>
														</a>
													</td>
												</tr>
												<%
												 tongTien += soLuong*donGia;
												}
												%>
											</tbody>
										</table>
										<div class="tong_tien">
											<b>Tổng tiền tạm tính: </b>
											<span class="tien">
												<%=DinhDang.MyNumberFormat(tongTien, Constant.TienTe.TIEN_COMMA_PATTERN) %> <span class="text_underline"><%=Constant.TienTe.DON_VI_TIEN_TE_VN %></span>
											</span>
										</div>
										<div class="nut">
											<a href="/SachKyAnh/XoaGioHang?MaSach=XoaTatCa" class="btn btn-default mua_them">Xóa giỏ hàng</a>
											<button type="submit" class="btn  btn-default cap_nhat">Cập nhật</button>
											<a href="/SachKyAnh/DatHang" class="btn  btn-default dat_hang">Tiến hành đặt hàng</a>
										</div> 
									</form>
									<%
										}
									}
									%>
						 	</section>
						 	<!-- kt noi dung gio hang -->
						</div>
					</div>
					<!-- kt phần nội dung trang -->
				</div>
			</div>
		</div>
	</section>

	<!-- footer  -->
	<jsp:include page="${userViewBlockPath}footer.jsp" />
	<!-- kt footer  -->
</div>
</body>
</html>

<script type="text/javascript">
/* begin: hiệu ứng loadding khi gửi maXN  */
var $loading = $('#loadingMaXN').hide();
$(document).ajaxStart(function () { 
	$('#spanGuiMaXN').attr('style','padding: 0px;');
	$loading.show(); 
	
}).ajaxStop(function () { 
	$('#spanGuiMaXN').attr('style','padding: 0px 9px;');
	$loading.hide(); 
});
/* end: hiệu ứng loadding khi gửi maXN  */

$(document).ready(function () {
	/* begin: Xóa các thông báo lỗi khi mới bật model poup */
	$('#btnDangNhapModal').on('click', function(){
		$("#errorEmail").html('');
		$("#errorMatkhau").html('');
		$("#errorLogin").html('');
	});
	
	$('#btnXacNhanSdtModa').on('click', function(){
		$("#errorDienThoai").html('');
		$("#thongBaoGuiMaXN").html('');
		$("#errorMaXN").html('');
		$("#maXnSdt").html('');
		$("#errorMaXnRong").html('');
		$("#errorHoTen").html('');
	});
	/* end: Xóa các thông báo lỗi khi mới bật model poup*/
	
	/* begin: validation và ajax đăng nhập xem giỏ hàng */
	$('#btnDanhNhap').on('click', function(){
		var urlDangNhapXemGioiHang = '<%=urlDangNhapXemGioiHang%>';
		var hople = true;
		var email = $('#email').val();
		var matkhau = $('#matkhau').val();
		var reg_mail= <%=Constant.RegularExpression.REG_MAIL%>;
		
		$("#errorEmail").html('');
		$("#errorMatkhau").html('');
		$("#errorLogin").html('');
		
		if( reg_mail.test(email) == false ){
			$("#errorEmail").html("Email không đúng định dạng !");
			if( hople ){
				document.getElementById("email").focus();
			}
			hople = false;
		}
		if( matkhau.length < 6 ){
			$("#errorMatkhau").html("Mật khẩu phải từ 6 ký tự !");
			if( hople ){
				document.getElementById("matkhau").focus();
			}
			hople = false;
		}
		if( hople == true ){
			$.ajax({
				url: urlDangNhapXemGioiHang,
				type: 'POST',
				contentType: 'application/x-www-form-urlencoded; charset=UTF-8', /*kiểu gửi dữ liệu lên server mặc định */
				dataType: 'json',/*kiểu dữ liệu nhận về từ server */
				data:{
					email: email,
					matkhau: matkhau,
				},
				success: function(data){
					var errorLogin = data.errorLogin;
					var successLogin = data.successLogin;
					if( errorLogin ){
						$('#errorLogin').html(errorLogin);
					}
					else if( successLogin ){
						$('#dangNhapModal').modal('hide');

						var tieuDe = 'Đăng nhập thành công !';
						var cauThongBao = '<span style="color:#70ba28; font-size: 16px; ">Mời bạn xem giỏ hàng và tiếp tục mua sắm.</span>';
						thongBaoThanhCong(tieuDe, cauThongBao);
						
					}
				},
			    error: function (jqXHR, exception) {
			        var msg = '';
			        if (jqXHR.status === 0) {
			            msg = 'Not connect.\n Verify Network.';
			        } else if (jqXHR.status == 404) {
			            msg = 'Requested page not found. [404]';
			        } else if (jqXHR.status == 500) {
			            msg = 'Internal Server Error [500].';
			        } else if (exception === 'parsererror') {
			            msg = 'Requested JSON parse failed.';
			        } else if (exception === 'timeout') {
			            msg = 'Time out error.';
			        } else if (exception === 'abort') {
			            msg = 'Ajax request aborted.';
			        } else {
			            msg = 'Ajax Uncaught Error: ' + jqXHR.responseText;
			        }
			        $('#ketQuaDangNhapXemGioHang').html(msg);
			    },
			});
		}
	});
	/* end: validation và ajax đăng nhập xem giỏ hàng */
	
	/* begin: validation và ajax gửi mã xác nhận sđt xem giỏ hàng */
	$('#btnGuiMaXN').on('click', function(){
		var urlGuiMaXacNhanSDT = '<%=urlGuiMaXacNhanSDT%>';
		var hople = true;
		var dienThoai = $('#dienThoai').val();
		var reg_sdt= <%=Constant.RegularExpression.REG_SDT %>;
		
		$("#errorDienThoai").html('');
		$("#thongBaoGuiMaXN").html('');
		$("#errorMaXN").html('');
		$("#maXnSdt").html('');
		
		if( reg_sdt.test(dienThoai) == false || dienThoai.length != 10 ){
			$("#errorDienThoai").html("Số điện thoại chưa đúng !");
			document.getElementById("dienThoai").focus();
			hople = false;
		}
		if( hople == true ){
			$.ajax({
				url: urlGuiMaXacNhanSDT,
				type: 'POST',
				contentType: 'application/x-www-form-urlencoded; charset=UTF-8', /*kiểu gửi dữ liệu lên server mặc định */
				dataType: 'json',/*kiểu dữ liệu nhận về từ server */
				data:{
					dienThoai: dienThoai,
				},
				success: function(data){
					var errorGuiMaXn = data.errorGuiMaXn;
					var successMaXN = data.successMaXN;
					if( errorGuiMaXn ){
						$('#thongBaoGuiMaXN').html(errorGuiMaXn);
					}
					else if( successMaXN ){
						$('#thongBaoGuiMaXN').html(successMaXN);
						$("#maXnSdt").focus();
					}
				},
			    error: function (jqXHR, exception) {
			        var msg = '';
			        if (jqXHR.status === 0) {
			            msg = 'Not connect.\n Verify Network.';
			        } else if (jqXHR.status == 404) {
			            msg = 'Requested page not found. [404]';
			        } else if (jqXHR.status == 500) {
			            msg = 'Internal Server Error [500].';
			        } else if (exception === 'parsererror') {
			            msg = 'Requested JSON parse failed.';
			        } else if (exception === 'timeout') {
			            msg = 'Time out error.';
			        } else if (exception === 'abort') {
			            msg = 'Ajax request aborted.';
			        } else {
			            msg = 'Ajax Uncaught Error: ' + jqXHR.responseText;
			        }
			        $('#ketQuaDangNhapXemGioHang').html(msg);
			    },
			});
		}
	});
	/* end: validation và ajax gửi mã xác nhận sđt xem giỏ hàng */
});

/* begin: hàm xác nhận maXN sđt để xem giỏ hàng */
function xacNhanMaXacNhan(){
	var urlXacNhanSdtXemGioHang = '<%=urlXacNhanSdtXemGioHang%>';
	var reg_sdt= <%=Constant.RegularExpression.REG_SDT %>;
	var hople = true;
	var maXnSdt = $('#maXnSdt').val();
	var dienThoai = $('#dienThoai').val();
	var hoTen = $('#hoTen').val();
	
	$("#errorDienThoai").html('');
	$("#thongBaoGuiMaXN").html('');
	$("#errorMaXN").html('');
	$("#maXnSdt").html('');
	$("#errorMaXnRong").html('');
	$("#errorHoTen").html('');
	
	if( reg_sdt.test(dienThoai) == false || dienThoai.length != 10 ){
		$("#errorDienThoai").html("Số điện thoại chưa đúng !");
		document.getElementById("dienThoai").focus();
		hople = false;
	}
	if( maXnSdt == '' ){
		$("#errorMaXnRong").html("Vui lòng nhập mã xác nhận !");
		document.getElementById("maXnSdt").focus();
		hople = false;
	}
	if( hoTen == '' ){
		$("#errorHoTen").html("Vui lòng nhập họ tên !");
		document.getElementById("hoTen").focus();
		hople = false;
	}
	if( hople == true ){
		$.ajax({
			url: urlXacNhanSdtXemGioHang,
			type: 'POST',
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8', /*kiểu gửi dữ liệu lên server mặc định */
			dataType: 'json',/*kiểu dữ liệu nhận về từ server */
			data:{
				maXnSdt: maXnSdt,
				dienThoai: dienThoai,
				hoTen: hoTen,
			},
			success: function(data){
				var errorMaXN = data.errorMaXN;
				var successMaXN = data.successMaXN;
				if( errorMaXN ){
					$('#errorMaXN').html(errorMaXN);
				}
				else if( successMaXN ){
					$('#xacNhanSdtModal').modal('hide');

					var tieuDe = 'Xác nhận SĐT thành công !';
					var cauThongBao = '<span style="color:#70ba28; font-size: 16px; ">Mời bạn xem giỏ hàng và tiếp tục mua sắm.</span>';
					thongBaoThanhCong(tieuDe, cauThongBao);
				}
			},
		    error: function (jqXHR, exception) {
		        var msg = '';
		        if (jqXHR.status === 0) {
		            msg = 'Not connect.\n Verify Network.';
		        } else if (jqXHR.status == 404) {
		            msg = 'Requested page not found. [404]';
		        } else if (jqXHR.status == 500) {
		            msg = 'Internal Server Error [500].';
		        } else if (exception === 'parsererror') {
		            msg = 'Requested JSON parse failed.';
		        } else if (exception === 'timeout') {
		            msg = 'Time out error.';
		        } else if (exception === 'abort') {
		            msg = 'Ajax request aborted.';
		        } else {
		            msg = 'Ajax Uncaught Error: ' + jqXHR.responseText;
		        }
		        $('#ketQuaDangNhapXemGioHang').html(msg);
		    },
		});
	}
}
/* end: hàm xác nhận maXN sđt để xem giỏ hàng */

/* begin: hiển thị confirm thông báo khi đăng nhập/ xác nhận số điện thoại thành công */
function thongBaoThanhCong(tieuDe, cauThongBao){
	$.confirm({
			type: 'green',
		icon: 'glyphicon glyphicon-ok-sign',
	    title: tieuDe,
	    titleClass: 'card-title',
	    theme: 'bootstrap',
	    content: cauThongBao,
	    /* autoClose: 'Đóng|10000', */
	    backgroundDismiss: function(){
	    	callAjaxReloadingPageGioHang();
	    	return true;
	    },
	    buttons: {
	    	Đóng: {
	    		 btnClass: 'btn-warning', 
	    		 action: function(){
	    			 callAjaxReloadingPageGioHang();
	    		 }
	    	},
	    },
	});
}

<%--  url: '<%=urlDangNhapXemGioiHangReloading%>' --%>
function callAjaxReloadingPageGioHang(){
	$.ajax({
	   url: '<%=urlDangNhapXemGioiHangReloading%>',
	   <%--  url: '<%=urlDangNhapXemGioiHang%>', --%>
	   type: 'POST',
	    success: function(data) {
	    	$("body").html(data);
	    },
	    error: function (jqXHR, exception) {
	        var msg = '';
	        if (jqXHR.status === 0) {
	            msg = 'Not connect.\n Verify Network.';
	        } else if (jqXHR.status == 404) {
	            msg = 'Requested page not found. [404]';
	        } else if (jqXHR.status == 500) {
	            msg = 'Internal Server Error [500].';
	        } else if (exception === 'parsererror') {
	            msg = 'Requested JSON parse failed.';
	        } else if (exception === 'timeout') {
	            msg = 'Time out error.';
	        } else if (exception === 'abort') {
	            msg = 'Ajax request aborted.';
	        } else {
	            msg = 'Ajax Uncaught Error: ' + jqXHR.responseText;
	        }
	        $('#ketQuaDangNhapXemGioHang').html(msg);
	    },
	});
}
/* end: hiển thị confirm thông báo khi đăng nhập/ xác nhận số điện thoại thành công */
</script>

<!-- begin: css của confirm đăng nhập/ xác nhận điện thoại -->
<style type="text/css" >
	.jconfirm-title-c .jconfirm-title{
		font-size: 18px !important;
	}
	.jconfirm-content{
		border-top: solid 1px #ddd !important;
		padding-top: 25px !important;
		padding-bottom: 25px !important;
	}
</style>
<!-- begin: css của confirm đăng nhập/ xác nhận điện thoại -->