<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Chi tiết sản phẩm</title>
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
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v4.0&appId=2525119214214430&autoLogAppEvents=1"></script>
<!-- end facebook -->
<!-- start my css -->
<link rel="stylesheet" type="text/css" href="../static/css/trangchu.css"/>
<!-- end my css -->
<!-- start my js -->
	<script src="../static/js/menuAnHien.js" type="text/javascript" charset="utf-8"></script>
<!-- end my js -->

</head>
<body>
	<div class="wrapper">
		<!-- phần header  -->
		<jsp:include page="./block/header.jsp" />
		<!-- kt header  -->
		
		<!-- phần nội dung sản phẩm -->
		<section class="main_chitiet_sp main_center">
			<div class="container">
				<div class="row">
					<!-- phần top -->
					<div class="col-md-12 col-sm-12 col-xs-12 padding-0 top_nd_trang">
						<div class="top">
							<h2>
								<a href="sp_cungloai.jsp" class="text-a">Loại sách </a>
								<span class="glyphicon glyphicon-chevron-right"></span>
								<a href="chitiet_sp.jsp"  class="text-a"> Tên sách </a>
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
												 <img class="" src="../static/img/sanpham/c6.jpg" title="sp" alt="anhsp">
											</div>
							 			</div>
							 			<div class="col-md-7 col-sm-6 col-xs-12 padding-0 ten_gia_tg_sl">
							 				<div class="ten_gia">
								 				<h3 class="tensp">
														Tên sách
												</h3>	
												<div class="giasp">
													<p>
														Tình trạng: <span class="trang_thai">Còn hàng/ Hết hàng</span>
													</p>
													<p>
														Giá bìa: <span class="gia_goc">1.457.568 đ</span>
													</p>
													<p>
														Giá khuyến mãi: <span class="gia_km">457.000 đ (có hoặc không)</span>
													</p>
												</div>
											</div>
											<div class="tg">
												<p>
													<span class="tieude">Tác giả: </span>Nguyễn Văn A - Nguyễn Văn B
												</p>
												<p>
													<span class="tieude">Năm xuất bản: </span>2019
												</p>
												<p>
													<span class="tieude">Nhà xuất bản: </span>Lao Động
												</p>
											</div>
											<div class="sl_button">
												<form method="get" action="#">
												 	<span class="label_sl">Số lượng: </span>
													<input type='number' name='so_luong' value='1' class="sl"><br/> 
													<div class="col-md-12 col-sm-12 col-xs-12 padding-0 nut">
														<div class="col-md-4 col-sm-4 col-xs-4 padding-0 margin_right">
															<a href="trangchu.jsp" class="">
																<button type="button" class="btn btn-default">
																	<span class="thoat">Thoát</span>
																</button>
															</a>
														</div>
														<div class="col-md-8 col-sm-8 col-xs-8 padding-0">
															<button type="submit" class="btn bg_btn">Thêm vào giỏ hàng</button>
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
						 					<p>
						 						Nhắc đến marketing, với những doanh nghiệp thực sự quan tâm, họ thường nghĩ ngay đến những buổi diễn thuyết nhiều tiếng đồng hồ, hàng nghìn đầu sách “nặng đô”, hàng tá chiến lược dài lê thê và phức tạp với cơ man biểu đồ, diễn giải... 
						 					</p>
						 					<p>
						 						Trên thực tế, chiến lược Marketing của doanh nhân thành công Allan Dib chỉ là chín ô vuông gói gọn trong một trang giấy. Bằng việc kết hợp giữa các chiến lược, chiến thuật và các khái niệm đã được bảo chứng thành công sau nhiều thập kỷ thử nghiệm và đo lường bởi các bậc thầy về marketing phản hồi trực tiếp; cộng với những chiến lược thực tiễn do chính Allan đề xướng và áp dụng hiệu quả trong thực tiễn, Kế hoạch marketing một-trang-giấy là một bước đột phá trong khâu thực hiện. Với Kế hoạch marketing một-trang-giấy, marketing là thực sự trở thành một kỹ năng kinh doanh bậc thầy. Nó sẽ giúp doanh nghiệp của bạn thành công và quan trọng hơn thế, nó cũng giúp các doanh nghiệp và hoạt động kinh doanh khác mà bạn tham gia trong tương lai thành công.
						 					</p>
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
							<!-- right: phần hoTroKH_giamGia -->
							<div class="col-md-4 col-sm-4 col-xs-12 padding-0">
								<article class="row  margin-0 right">
									<jsp:include page="./block/hotrokh_giamgia.jsp"/>
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
		<jsp:include page="./block/footer.jsp" />
		<!-- kt footer  -->
	</div>


	
</body>
</html>