<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/user/init.jsp" %>

<header id="header" class="header"> 
	<!-- top-header -->
	<section class="top-header clearfix">	
		<div class="container">
			<nav class="navbar navbar-inverse ">
			  <div class="container-fluid">
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
			        <i class="fa fa-list"></i>                        
			      </button>
			     
			    </div>
			    <div class="collapse navbar-collapse" id="myNavbar">
			      <ul class="nav navbar-nav navbar-right">
			        <li><a href="theodoi_donhang.jsp"><span class="glyphicon glyphicon-edit"></span> Theo dõi đơn hàng</a></li>
			        <li><a href="dangnhap.jsp"><span class="glyphicon glyphicon-log-in"></span> Đăng nhập</a></li>
			        <li><a href="capnhat_taikhoan.jsp"><span class="glyphicon glyphicon-user"></span> Nguyen Van An</a></li>
			        <li><a href="dangky.jsp"><span class="glyphicon glyphicon-lock"></span> Đăng ký</a></li>
			      </ul>
			    </div>
			  </div>
			</nav>	
		</div>	
	</section> 
	<!-- kt top-header -->
	<!-- main-header -->
	<section class="main-header">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-12 col-xs-12">
					<a href="trangchu.jsp">
						<img src="${kyanhbooksRootPath}${userStaticRootPath}img/logo/logo.png">
					</a>
				</div>
				<div class="col-md-6 col-sm-8 col-xs-7">
					 <div class="search-box">
	                    <form action="tim_kiem.jsp" method="get" id="form_timKiem" class="form-inline">
	                        <div class="input-group">
	                            <input type="text" name="timKiem" id="timKiem" class="form-control" size="70" placeholder="Nhập từ khóa tìm kiếm..." />
		                        <div class="input-group-btn">
		                        	<button type="submit" class="btn mau_btn">
		                        		Tìm kiếm
		                        	</button>	
		                        </div> 
	                        </div>
	                    </form>
	                </div>
				</div>
				<div class="col-md-3 col-sm-4 col-xs-5">
					<div class="cart" id="cart-block">
	                    <a title="Giỏ hàng" href="gio_hang.jsp">
	                    	<img src="${kyanhbooksRootPath}${userStaticRootPath}img/icon/cart.png" alt="">
	                    	<span class="text-show">Giỏ hàng</span>
	                    	<span class="soluong_sp">0</span>
	                    </a>
	                </div>
				</div>
			</div>
		</div>
	</section>
	<!-- kt main-header -->
	<!-- menu ngang -->
	<section class="menu-ngang">
		<div class="container">
			<div class="row">
				<nav class="navbar navbar-inverse">
					<div class="container-fluid">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle sua_navbar-toggle" data-toggle="collapse" data-target="#navbarMnN">
								Menu trang chủ
							</button>
						</div>
						<div class="collapse navbar-collapse sua_collapse" id="navbarMnN"> 
							<ul class="nav navbar-nav sua_ul">
								<li>
									<a href="${kyanhbooksRootPath}" class="a_menu_ngang"><%=Constant.MenuNgang.TRANG_CHU %></a>
								</li>
								<li>
									<a href="${kyanhbooksRootPath}menuNgang/<%=Constant.MenuNgang.GIOI_THIEU_NUMBER %>" class="a_menu_ngang"><%=Constant.MenuNgang.GIOI_THIEU %></a>
								</li>
								<li>
									<a href="${kyanhbooksRootPath}menuNgang/<%=Constant.MenuNgang.DICH_VU_NUMBER %>" class="a_menu_ngang"><%=Constant.MenuNgang.DICH_VU %></a>
								</li>
								<li>
									<a href="${kyanhbooksRootPath}menuNgang/<%=Constant.MenuNgang.HUONG_DAN_MUA_HANG_NUMBER %>" class="a_menu_ngang"><%=Constant.MenuNgang.HUONG_DAN_MUA_HANG %></a>
								</li>
								<li>
									<a href="${kyanhbooksRootPath}menuNgang/<%=Constant.MenuNgang.LIEN_HE_NUMBER %>" class="a_menu_ngang"><%=Constant.MenuNgang.LIEN_HE %></a>
								</li>
							</ul>
						</div>
					</div>
				</nav>
			</div> 
		</div>
	</section>
	<!-- kt menu ngang -->
</header>
<!-- kt header -->

<!-- menu_sp_hienthi, slideShow -->
<section class="menusp_slideshow">
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-5 col-xs-12 padding-left0">
				<!-- menu_sp_hienthi -->
				<jsp:include page="menu_sp_an.jsp" />
				<!-- kt menu_sp_hienthi -->
			</div>
		</div>
	</div>
</section>
<!-- kt menu_sp_hienthi, slideShow -->