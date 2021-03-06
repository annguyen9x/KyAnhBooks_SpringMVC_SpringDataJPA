<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Đặt hàng hoàn tất</title>
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
	<!-- header  -->
	<jsp:include page="./block/header.jsp" />
	<!-- kt header  -->
	
	<section class="main_center main_sp_cungloai">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12 padding-0 main_title_line">
					<!-- phần top -->
					<div class="col-md-12 padding-0 top_nd_trang">
						<div class="top">
							<h2>
								<span>hoàn tất</span>
							</h2>
						</div>
					</div>
					<!-- kt phần top -->
					<!-- phần nội dung trang -->
					<div class="col-md-12 padding-0 nd_trang">
						<div class="row margin-0">
							<!-- noi dung dat hang -->
							<section class="dathang_hoantat">
								<div class="alert alert-warning">
									<strong>Đặt hàng thất bại.</strong> Lỗi thao tác ! 
								</div>
								<div class="alert alert-success">
									<strong>Đặt hàng thành công.</strong> Thông tin về đơn hàng đã được gửi qua email của bạn ! 
								</div>
								<div class="row margin-0 my_border">
									<div class="col-md-6 col-sm-6 col-xs-12">
										<p><b>Mã đơn hàng của bạn: </b><span class="ma_dh">14566789</span></p>
										<p><b>Tên khách hàng: </b>Nguyễn Văn An</p>
										<p><b>Ngày đặt hàng: </b>12/12/2019</p>
										<p><b>Ngày giao hàng (Dự kiến): </b>14/12/2019</p>
									</div>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<p><b>Email: </b>a@gmail.com</p>
										<p><b>Điện thoại: </b>098342523</p>
										<p><b>Địa chỉ: </b>Q.Hải Châu, TP.Đà Nẵng</p>
										<p><b>Tổng thanh toán: </b>200.000<span class="text_underline"> đ</span></p>
									</div>
									<a href="trangchu.jsp" class="btn">Tiếp tục mua hàng</a>
								</div>
						 	</section>
						 	<!-- kt noi dung dat hang -->
						</div>
					</div>
					<!-- kt phần nội dung trang -->
				</div>
			</div>
		</div>
	</section>

	<!-- footer  -->
	<jsp:include page="./block/footer.jsp" />
	<!-- kt footer  -->
</div>
</body>
</html>