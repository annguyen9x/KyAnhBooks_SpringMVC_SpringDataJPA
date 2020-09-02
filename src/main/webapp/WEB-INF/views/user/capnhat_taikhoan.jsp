<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/user/init.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.annguyen.kyanhbooks.model.KhachHang" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Cập nhật thông tin tài khoản thành viên</title>
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
	String urlCapNhatTaiKhoan = Constant.Path.KYANHBOOKS_ROOT_PATH + Constant.Path.USER_CONTROLLER_KHACH_HANG_CAPNHAT_TAIKHOAN;
	KhachHang khachHang = (KhachHang) session.getAttribute("KhachHang");	
	String errorThongTinCapNhat = "";	
	if( session.getAttribute("errorThongTinCapNhat") != null ){
		errorThongTinCapNhat = session.getAttribute("errorThongTinCapNhat").toString();
	}
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
									<a href="#" class="text-a">Cập nhật thông tin tài khoản</a>
								</h2>
							</div>
						</div>
						<!-- kt phần top -->
						<!-- phần nội dung trang -->
						<div class="col-md-12 padding-0 nd_trang">
							<div class="row margin-0 my_border">
			                    <div class="col-sx-12">
			                    	<h2 class="col-xs-12 text-center">
			                    		<span>Cập nhật tài khoản</span>
			                    	</h2>
			                    	
			                    	<%
			                    	if( !errorThongTinCapNhat.equals("") ){
			                    	%>
			                    	<div class="col-sm-12" style="text-align:center; margin-bottom: 30px;">
					                    <span id="errorThongTinDangKy" class="col-xs-12 alert alert-warning"><%=errorThongTinCapNhat %></span>
					                </div>
			                    	<%
			                    	}
			                    	%>
			                    	
			                    	<%
				                    	String thanhCong = (String)session.getAttribute("thanhCong");
				                    	if(  thanhCong != null ){
			                    	%>
			                    			<div class="col-xs-12 alert alert-success"><%=thanhCong %></div>
			                    	<%
			                    		session.removeAttribute("thanhCong");
			                    		}
				                    	String thatBai = (String)session.getAttribute("thatBai");
				                    	if(  thatBai != null ){
			                    	%>
			                    		<div class="col-xs-12 alert alert-danger"><%=thatBai %></div>
			                    	<%
			                    		session.removeAttribute("thatBai");
			                    	}
			                    	%>
			                    	
			                    	<%
				            			if( khachHang != null ){
			                    	%>
									<form:form method="post" modelAttribute="KhachHang" action="<%=urlCapNhatTaiKhoan %>" id="formCN" onsubmit="return validation();" class="form-horizontal">
										<div class="form-group">
							                <form:label path="tenKH" class="col-sm-3 control-label">Họ tên<span class="warning"> (*)</span></form:label>
							                <div class="col-sm-9">
							                    <form:input path="tenKH" type="text" class="form-control" name="hoten" id="hoten" />
							                    <form:input path="maKH" type="hidden" class="form-control" name="maKH" id="maKH" />
							                    <span id="errorHoten" class="col-xs-12 error warning"></span>
							                </div>
							            </div>
							            <div class="form-group">
							            	<form:label path="matKhau" class="col-sm-3 control-label">Mật khẩu<span class="warning"> (*)</span></form:label>
							            	<div class="col-sm-9">
							            		<form:input path="matKhau" type="password" class="form-control" name="matkhau" id="matkhau" placeholder="Vui lòng nhập mật khẩu cần thay đổi" />
							            		<span id="errorMatkhau" class="col-xs-12 error warning"></span>
							            	</div>
							            </div>
							            <div class="form-group">
							            	<label for="rePassword" class="col-sm-3 control-label">Nhập lại mật khẩu<span class="warning"> (*)</span></label>
							            	<div class="col-sm-9">
							            		<input type="password" class="form-control" name="nlMatkhau" id="nlMatkhau" placeholder="Nhập lại mật khẩu" >
							            		<span id="errorNlMatkhau" class="col-xs-12 error warning"></span>
							            	</div>
							            </div>
							            <div class="form-group">
							            	<form:label path="email" class="col-sm-3 control-label">Email<span class="warning"> (*)</span></form:label>
							            	<div class="col-sm-9">
							            		<form:input path="email" type="email" class="form-control" name="email" id="email" />
							            		<span id="errorEmail" class="col-xs-12 error warning"></span>
							            	</div>
							            </div>
							            <div class="form-group">
							            	<form:label path="dienThoai" class="col-sm-3 control-label">Điện thoại<span class="warning"> (*)</span></form:label>
							            	<div class="col-sm-9">
							            		<form:input path="dienThoai" type="text" class="form-control" name="dienthoai" id="dienthoai" />
							            		<span id="errorDienthoai" class="col-xs-12 error warning"></span>
							            	</div>
							            </div>
							            <div class="form-group form-inline">
							            	<form:label path="gioiTinh" class="col-sm-3 control-label">Giới Tính</form:label>
							            	<div class="col-sm-9">
							            		<div class="col-sm-9">
								            		<%-- <%
								            			String gioiTinh = khachHang.getGioiTinh(); 
								            			out.print("gioiTinh: " + gioiTinh);
								            			if( gioiTinh.equals("Nam") ){
								            		%> --%>
								            		<div class="col-xs-2">
								            			<form:radiobutton path="gioiTinh" class="form-control" name="gioitinh" value="Nam" checked="checked" />Nam
								            		</div>
								            		<div class="col-xs-2">
									            		<form:radiobutton path="gioiTinh" class="form-control" name="gioitinh" value="Nữ" />Nữ
									            	</div>
									            	<div class="col-xs-3">
									            		<form:radiobutton path="gioiTinh" class="form-control" name="gioitinh" value="Khác" />Khác
									            	</div>
								            	</div>
							            	</div>
							            </div>
							            <div class="form-group form-inline">
							            	<label for="ngaysinh" class="col-sm-3 control-label">Ngày sinh<span class="warning"> (*)</span></label>
							            	<div class="col-sm-9">
							            		<%
							            			Date ngaySinhDB = khachHang.getNgaySinh();
							            			Calendar calendar = Calendar.getInstance();
							            			calendar.setTime(ngaySinhDB);
							            			
								            		int ngaySinh = calendar.get(Calendar.DAY_OF_MONTH);
								            		int thangSinh = calendar.get(Calendar.MONTH)+1;
								            		int namSinh = calendar.get(Calendar.YEAR);
							            		%>
							            		<select name="ngaysinh" id="ngaysinh" class="col-xs-4 form-control">
							            			<%
							            				for(int i = 1; i <= 31; i++){
							            					if(i == ngaySinh){
							            			%>
									            				<option value="<%=i%>" selected="true"><%=i%></option>
									            	<%
							            					}else{
							            			%>
							            						<option value="<%=i%>"><%=i%></option>
							            			<%
							            					}
							            				}
							            			%>
							            		</select>
							            		<select name="thangsinh" id="thangsinh" class="col-xs-4 form-control">
							            			<%
							            				for(int i = 1; i <= 12; i++){
									            			if(i == thangSinh){
							            			%>
									            				<option value="<%=i%>" selected="true"><%=i%></option>
									            	<%
							            					}else{
							            			%>
							            						<option value="<%=i%>"><%=i%></option>
							            			<%
							            					}
							            				}
							            			%>
							            		</select>
							            		<select name="namsinh" id="namsinh" class="col-xs-4 form-control">
							            			<%
							            				int namHT = Calendar.getInstance().get(Calendar.YEAR);
							            				for(int i = 1920 ; i <= namHT; i++){
							            					if(i == namSinh){
							            			%>
									            				<option value="<%=i%>" selected="true"><%=i%></option>
									            	<%
							            					}else{
							            			%>
							            						<option value="<%=i%>"><%=i%></option>
							            			<%
							            					}
							            				}
							            			%>
							            		</select>
							            		<span id="errorNgaysinh" class="col-xs-12 error warning"></span>
							            	</div>
							            </div>
							             <div class="form-group">
							            	<form:label path="diaChi" class="col-sm-3 control-label">Địa chỉ<span class="warning"> (*)</span></form:label>
							            	<div class="col-sm-9">
							            		<form:input path="diaChi" class="form-control" name="diachi" id="diachi" />
							            		<span id="errorDiachi" class="col-xs-12 error warning"></span>
							            	</div>
							            </div>
							            <div class="form-group">
							            	<div class="col-xs-8 col-xs-offset-4">
							            		<form:button type="submit" class="btn">
							            			Cập nhật
							            		</form:button>
							            	</div>
							            </div>
									</form:form>
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