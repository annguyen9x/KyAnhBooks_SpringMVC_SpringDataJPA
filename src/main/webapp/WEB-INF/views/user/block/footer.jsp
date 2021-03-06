<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/user/init.jsp" %>

<footer>
	<div class="noidung_footer container">
		<div class="row">

			<div class="col-md-3 col-sm-6 col-xs-12">
				<div class="group_footer">
					<div class="top_footer logo_footer">
						<a href="${kyanhbooksRootPath}" class="text-a">
							<img src="${kyanhbooksRootPath}${userStaticRootPath}img/logo/logofooter.png">
						</a>
					</div>
					<ul>
						<li class="list-li">
							<span class="fa fa-map-marker" style="color:#fff;"> </span>
							<a href="#" class="text-a">
								<%=Constant.CauHinh.GIA_TRI_DIA_CHI_SHOP_1 %>
							</a>
						</li>
						<li class="list-li">
							<span class="fa fa-phone" style="color:#fff;"> </span>
							<a href="#" class="text-a">
								<%=Constant.CauHinh.GIA_TRI_SO_DIENTHOAI_CA_NHAN %>
							</a>
						</li>
						<li class="list-li">
							<span class="fa fa-envelope-o" style="color:#fff;"> </span>
							<a href="#" class="text-a">
								<%=Constant.CauHinh.GIA_TRI_EMAIL_CA_NHAN %>
							</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="col-md-3 col-sm-6 col-xs-12">
				<div class="group_footer">
					<div class="top_footer">
						<h4><a href="#" class="text-a">
								Thông tin
							</a>
						</h4>
					</div>
					<ul>
						<li class="list-li">
							<span class="glyphicon glyphicon-chevron-right" style="color:#fff; font-size: 1rem"></span>
							<a href="${kyanhbooksRootPathMenuLoaiSach}<%=Constant.Path.USER_CONTROLLER_MENU_NGANG %>/<%=Constant.MenuNgang.GIOI_THIEU_NUMBER %>" class="text-a">
								<%=Constant.MenuNgang.GIOI_THIEU%>
							</a>
						</li>
						<li class="list-li">
							<span class="glyphicon glyphicon-chevron-right" style="color:#fff; font-size: 1rem"></span>
							<a href="${kyanhbooksRootPathMenuLoaiSach}<%=Constant.Path.USER_CONTROLLER_MENU_NGANG %>/<%=Constant.MenuNgang.HUONG_DAN_MUA_HANG_NUMBER %>" class="text-a">
								<%=Constant.MenuNgang.HUONG_DAN_MUA_HANG%>
							</a>
						</li>
						<li class="list-li">
							<span class="glyphicon glyphicon-chevron-right" style="color:#fff; font-size: 1rem"></span>
							<a href="${kyanhbooksRootPathMenuLoaiSach}<%=Constant.Path.USER_CONTROLLER_MENU_NGANG %>/<%=Constant.MenuNgang.DICH_VU_NUMBER %>" class="text-a">
								<%=Constant.MenuNgang.DICH_VU%>
							</a>
						</li>
						<li class="list-li">
							<span class="glyphicon glyphicon-chevron-right" style="color:#fff; font-size: 1rem"></span>
							<a href="${kyanhbooksRootPathMenuLoaiSach}<%=Constant.Path.USER_CONTROLLER_MENU_NGANG %>/<%=Constant.MenuNgang.LIEN_HE_NUMBER %>" class="text-a">
								<%=Constant.MenuNgang.LIEN_HE%>
							</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="col-md-3 col-sm-6 col-xs-12 clear-left">
				<div class="group_footer">
					<div class="top_footer">
						<h4>
							<a href="#" class="text-a">
								Kết nối
							</a>
						</h4>
					</div>
					<ul>
						<li class="img_kn list-li">				
							<a href="#" class="text-a">
								<img src="${kyanhbooksRootPath}${userStaticRootPath}img/icon/linkedin.png" title="anvang" alt="logo">
							</a>
							<a href="#" class="text-a">
								<img src="${kyanhbooksRootPath}${userStaticRootPath}img/icon/instagram.png" title="anvang" alt="logo">
							</a>
							<a href="#" class="text-a">
								<img src="${kyanhbooksRootPath}${userStaticRootPath}img/icon/twister.png" title="anvang" alt="logo">
							</a>
							<a href="#" class="text-a">
								<img src="${kyanhbooksRootPath}${userStaticRootPath}img/icon/youtube2.png" title="anvang" alt="logo">
							</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="col-md-3 col-sm-6 col-xs-12">
				<div class="group_footer">
					<div class="top_footer">
						<h4>
							<a href="#" class="text-a">
								Facebook
							</a>
						</h4>
					</div>
					<ul>
						<li class="list-li">
							<div class="fb-page" data-href="https://www.facebook.com/Ky-Anh-Books-114377869939137/" data-tabs="timeline" data-width="255" data-height="180" data-small-header="false" data-adapt-container-width="true" data-hide-cover="false" data-show-facepile="true"><blockquote cite="https://www.facebook.com/Ky-Anh-Books-114377869939137/" class="fb-xfbml-parse-ignore"><a href="https://www.facebook.com/Ky-Anh-Books-114377869939137/">Ky Anh Books</a></blockquote></div>
						</li>
					</ul>
				</div>
			</div>

		</div>
	</div>
	
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<p class="text-bottom-footer">Hiệu sách nhân dân Kỳ Anh - Địa chỉ: Tx. Kỳ Anh, Tỉnh. Hà Tĩnh</p>
			</div>
			<div class="col-md-12 col-sm-12 col-xs-12">
				<p class="text-bottom-footer">&copy; 2019 Bản quyền thuộc về Hiệu sách nhân dân Kỳ Anh -
					 Cung cấp bởi <a href="https://www.facebook.com/profile.php?id=100005794591130"  class="text-a">annguyen
					 </a>
				</p>
			</div>
		</div>
	</div>
</footer>