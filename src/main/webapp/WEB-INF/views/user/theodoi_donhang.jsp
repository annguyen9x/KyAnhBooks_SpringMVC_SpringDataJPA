<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Theo dõi đơn hàng</title>
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
									<span>Theo dõi đơn hàng</span>
								</h2>
							</div>
						</div>
						<!-- kt phần top -->
						<!-- phần nội dung trang -->
						<div class="col-md-12 padding-0 nd_trang">
							<div class="row margin-0">
								<form method="get" action="./trangchu.jsp" id="formTDDH" class="form-inline">
						            <div class="form-group">
					            		<label>Nhập mã đơn hàng </label>
					            		<input type="text" class="form-control" name="maDH" placeholder="Mã số đơn hàng (VD:123456789)" size="30" required="required">
						            </div>
					            	<button type="submit" class="btn">Xem ngay</button>
								</form>
								<div class="alert alert-danger">
									<strong>Không tìm thấy đơn hàng trong hệ thống.</strong> Vui lòng kiểm tra lại mã đơn hàng của bạn !
								</div>
								<!-- thong_tin_dh -->
								<div class="thong_tin_dh">
									<h4>Thông tin đơn hàng số: 01234564</h4>
									<table class="table">
										<thead>
											<tr>
												<th>
												Tên sách
												</th>
												<th>
												Hình ảnh
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
											<tr>
												<td class="ten_sp">
												Tên sách dgfds ágfedg Tên sách dgfds ágfedg Tên sách dgfds ágfedg
												</td>
												<td class="hinh">
													<img src="../static/img/sanpham/c1.jpg" alt="anh">
												</td>
												<td class="tien">
													15.567457 <span class="text_underline">đ</span>
												</td>
												<td class="so_luong">
													<input type="number" name="soLuong">
												</td>
												<td class="tien">
													15.235.235 <span class="text_underline">đ</span>
												</td>
												<td class="trash">
													<a href="#">
														<span class="glyphicon glyphicon-trash"></span>
													</a>
												</td>
											</tr>
										</tbody>
									</table>
									<div class="thongtin_giaohang_tongtien">
										<div class="tong_tien">
											<b>Tổng tiền: </b>
											<span class="tien">
												15.235.235 <span class="text_underline">đ</span>
											</span>
										</div>
										<div class="thongtin_giaohang">
											<h4>Thông tin giao hàng</h4>
											<table class="table">
												<tr>
													<td>
														<b>Tên khách hàng: </b>Nguyen Van B
													</td>
													<td>
														<b>Số điện thoại: </b>0845325
													</td>
												</tr>
												<tr>
													<td>
														<b>Ngày đặt: </b>12/2/2019
													</td>
													<td>
														<b>Email: </b>a@gmail.com
													</td>
												</tr>
												<tr>
													<td>
														<b>Ngày giao(dự kiến): </b>22/2/2019
													</td>
													<td>
														<b>Tình trạng đơn hàng: </b>
														Đang giao
														<a href="huy_donhang.jsp" class="btn btn-default">Hủy đơn hàng?</a>
													</td>
												</tr>
											</table>
										</div>
										
									</div>
									<div class="nut" style="margin-top:15px;float: left;">
										<a href="trangchu.jsp" class="btn btn-default">Trở về trang chủ</a>
									</div>
								</div>
								<!-- kt thong_tin_dh -->
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