<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Xác nhận email đăng ký tài khoản thành viên</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<!--  start bootstrap -->
<link rel="stylesheet" type="text/css" href="../static/bootstrap-3.4.1-dist/css/bootstrap.min.css"/>
<script type="text/javascript" src="../static/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../static/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
<!--  end bootstrap -->
<!-- start fontawesome -->
<link rel="stylesheet" href="../static/font/font-awesome-4.7.0/css/font-awesome.min.css">
<!-- start fontawesome -->
<!-- start facebook -->
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v4.0&appId=2525119214214430&autoLogAppEvents=1"></script>
<!-- end facebook -->
<!-- start my css -->
<link rel="stylesheet" type="text/css" href="../static/css/trangchu.css"/>
<!-- end my css -->
<!-- start my js -->
	<script src="../static/js/menuAnHien.js" type="text/javascript" charset="utf-8"></script>
	<script src="../static/js/formValidation.js" type="text/javascript" charset="utf-8"></script>
<!-- end my js -->

</head>
<body>
	<div class="wrapper">
		<!-- phần header  -->
		<jsp:include page="block/header.jsp" />
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
						        <li class="list-li"><a href="dangnhap.jsp" class="text-a"><i class="fa fa-sign-in"></i> Đăng nhập</a></li>
						        <li class="list-li"><a href="dangky.jsp" class="text-a"><i class="fa fa-lock"></i> Đăng ký</a></li>
						        <li class="list-li"><a href="lay_matkhau.jsp" class="text-a"><i class="fa fa-question"></i> Quên mật khẩu</a></li>
						    </ul>
						</div>
					</div>
					<div class="col-md-9 padding-0 right">
						<!-- phần top -->
						<div class="col-md-12 padding-0 top_nd_trang">
							<div class="top">
								<h2>
									<a href="#" class="text-a">Xác nhận email đăng ký</a>
								</h2>
							</div>
						</div>
						<!-- kt phần top -->
						<!-- phần nội dung trang -->
						<div class="col-md-12 padding-0 nd_trang">
							<div class="row margin-0 my_border">
			                    <div class="col-sx-12">
			                    	<h2 class="col-xs-12 text-center">
			                    		<span>Xác nhận email để hoàn tất đăng ký</span>
			                    	</h2>
			                    	<div class="col-md-3 col-sm-4 col-xs-10 col-md-offset-5 col-sm-offset-4 col-xs-offset-1">
										<form method="post" action="./trangchu.jsp" id="formXacNhanDK" class="form-horizontal">
											<div class="form-group">
								            	<label for="email">Email:</label>
							            		an@gmail.com	
								            </div>
								            <div class="form-group">
							            		<label>Nhập mã xác nhận email</label>
							            		<input type="text" class="form-control" name="ktDonHang" placeholder="Mã xác nhận gửi về email" required="required">
								            </div>
								            <div class="form-group">
								            		<button type="submit" class="btn" style="float:right">
								            			Xác nhận
								            		</button>
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
		<jsp:include page="block/footer.jsp" />
		<!-- kt footer  -->
	</div>
</body>
</html>