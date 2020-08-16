<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Hủy đơn hàng</title>
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

		<section class="main_center">
			<div class="container">
				<div class="row">
					<div class="col-md-9 col-md-offset-3 padding-0 main_title_line">
						<!-- phần top -->
						<div class="col-md-12 padding-0 top_nd_trang">
							<div class="top">
								<h2>
									<span>Hủy đơn hàng</span>
								</h2>
							</div>
						</div>
						<!-- kt phần top -->
						<!-- phần nội dung trang -->
						<div class="col-md-12 padding-0 nd_trang">
							<div class="row margin-0 huy_donhang">
								<div class="alert alert-success">
									<strong>Hủy đơn hàng thành công.</strong> Đơn hàng 0123456 đã được hủy, quay về <a href="trangchu.jsp">trang chủ</a> để tiếp tục mua hàng !
								</div>
								<div class="alert alert-danger">
									<strong>Hủy đơn hàng thất bại.</strong> Mã xác nhận không chính xác, quay về <a href="trangchu.jsp">trang chủ</a> để tiếp tục mua hàng !
								</div>
								<div class="ma_donhang" style="margin-bottom: 10px;">
									<b>Hủy đơn hàng số: </b><span>0123456</span>
								</div>
								<form method="post" action="./trangchu.jsp" id="formTDDH">
						            <div class="form-group">
					            		<label>Email mua hàng</label>
					            		<input type="email" class="form-control" name="email" placeholder="Cung cấp email mua hàng để xác nhận hủy"required="required">
						            </div>
						            <div class="form-group">
						            	<button class="btn" style="background:#70ba28;">Gửi mã xác nhận</button>
						            </div>
						            <div class="form-group">
					            		<label>Nhập mã xác nhận</label>
					            		<input type="text" class="form-control" name="ktDonHang" placeholder="Nhập mã xác nhận đã được gửi về email" required="required">
						            </div>
						            <div style="text-align:right;">
							            <a href="trangchu.jsp" class="btn">Không hủy</a>
						            	<button type="submit" class="btn">Xác nhận hủy</button>
						            </div>
								</form>
							</div>
						</div>
						<!-- kt phần nội dung trang -->
					</div>
				</div>
			</div>
		</section>

		<!-- phần footer  -->
		<jsp:include page="block/footer.jsp" />
		<!-- kt footer  -->
	</div>
</body>
</html>