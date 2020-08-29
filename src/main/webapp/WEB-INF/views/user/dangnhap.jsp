<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/user/init.jsp"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Đăng nhập tài khoản thành viên</title>
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
	String errorLogin = (String)request.getAttribute("errorLogin");
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
						            Tài khoản
						        </span>
						    </h2>
						    <ul>
						        <li class="list-li"><a href="${kyanhbooksRootPath}<%=Constant.Path.USER_CONTROLLER_KHACH_HANG_HIENTHI_DANGNHAP%>" class="text-a"><i class="fa fa-sign-in"></i> Đăng nhập</a></li>
						        <li class="list-li"><a href="${kyanhbooksRootPath}<%=Constant.Path.USER_CONTROLLER_KHACH_HANG_HIENTHI_DANGKY%>" class="text-a"><i class="fa fa-lock"></i> Đăng ký</a></li>
						        <li class="list-li"><a href="${kyanhbooksRootPath}<%=Constant.Path.USER_CONTROLLER_KHACH_HANG_QUEN_MATKHAU%>" class="text-a"><i class="fa fa-question"></i> Quên mật khẩu</a></li>
						    </ul>
						</div>
					</div>
					<div class="col-md-9 padding-0 right">
						<!-- phần top -->
						<div class="col-md-12 padding-0 top_nd_trang">
							<div class="top">
								<h2>
									<a href="#" class="text-a">Đăng nhập tài khoản</a>
								</h2>
							</div>
						</div>
						<!-- kt phần top -->
						<!-- phần nội dung trang -->
						<div class="col-md-12 padding-0 nd_trang">
							<div class="row margin-0 my_border">
			                    <div class="col-sx-12">
			                    	<h2 class="col-xs-12 text-center">
			                    		<span>Đăng nhập tài khoản khách hàng</span>
			                    	</h2>
			                    	<div class="col-md-6 col-md-offset-3">
										<form method="post" id="formDN" action="${kyanhbooksRootPath}<%=Constant.Path.USER_CONTROLLER_KHACH_HANG_DANGNHAP %>" class="form-horizontal">
											<div class="form-group">
								            	<label for="email" class="col-sm-3 control-label">Email</label>
								            	<div class="col-sm-9">
								            		<input type="email" class="form-control" name="email" id="email">
								            		<span id="errorEmail" class="col-xs-12 error warning"></span>
								            	</div>
								            </div>
								            <div class="form-group">
								            	<label for="pwd" class="col-sm-3 control-label">Mật khẩu</label>
								            	<div class="col-sm-9">
								            		<input type="password" class="form-control" name="matkhau" id="matkhau">
								            		<span id="errorMatkhau" class="col-xs-12 error warning"></span>
								            	</div>
								            </div>
								            <%
								            if( errorLogin != null && !errorLogin.isEmpty() ){
								            %>
								            <div class="form-group">
								            	<div class="col-sm-12" Style="text-align: center;">
								            		<span id="errorLogin" class="col-xs-12 error warning"><%=errorLogin %></span>
								            	</div>
								            </div>
								            <%
								            }
								            %>
								            <div class="form-group">
								            	<div class="col-xs-8 col-xs-offset-4">
								            		<button type="button" class="btn" id="btnDanhNhap">
								            			Đăng nhập
								            		</button>
								            		<a href="${kyanhbooksRootPath}<%=Constant.Path.USER_CONTROLLER_KHACH_HANG_QUEN_MATKHAU%>">Quên mật khẩu ?</a>
								            	</div>
								            </div>
										</form>
									</div>
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

<script type="text/javascript">
	$(document).ready(function () {
		$('#btnDanhNhap').on('click', function (e) {
			$("#errorLogin").html('');
			$("#errorEmail").html('');
			$("#errorMatkhau").html('');
			
			var hople = true;
			var email = $('#email').val();
			var matkhau = $('#matkhau').val();
			var reg_mail= <%=Constant.Form.REG_MAIL%>;
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
				$('#formDN').submit();
			}
		});
	});
</script>