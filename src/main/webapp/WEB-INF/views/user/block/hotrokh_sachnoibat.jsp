<%@page import="com.annguyen.kyanhbooks.util.DinhDang"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/user/init.jsp" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.annguyen.kyanhbooks.model.Sach" %>


<%
	List<Sach> sachNoiBat = null;
	if( request.getAttribute("SachNoiBat") != null ){
		sachNoiBat = (List<Sach>)request.getAttribute("SachNoiBat");
	}
%>
<div class="hotrokh_sachNoiBat">
	<div class="col-md-12 col-sm-12 col-xs-12 padding-0 my_border hotro_kh">
		<div class="top">
			<h2>
				<span class="text-title">
					Hỗ trợ khách hàng
				</span> 
			</h2>
		</div>
		<!-- nd  -->
		<div class="col-md-12 col-sm-12 col-xs-12 padding-0 grid_group_htkh">
			<div class="group_hotrokh">
				<ul>
					<li class="list-li">
						
						<span><i class='fa fa-commenting' style="color:#70ba28;"></i> Tư vấn bán hàng 24/7
						</span>

					</li>
					<li class="list-li">
						<span>
							<span class="glyphicon glyphicon-phone" style="color:#ed4c4c;"></span>
							(84)34.724.4142
						</span>
					</li>
					<li class="list-li">
						<span class="glyphicon glyphicon-phone-alt" style="color:#ff5400;"></span>
						<span>(84)92.910.9072</span>
					</li>
					<li class="list-li">
						<span>
							<span class="fa fa-envelope" style="color:#15aabf;"></span>
							kyanhbooks@gmail.com
						</span>
					</li>
				</ul>
			</div>
		</div>
		<!-- kt nd  -->
	</div>
	<div class="col-md-12 col-sm-12 col-xs-12 padding-0 my_border sp_cungloai sachNoiBat">
		<div class="top">
			<h2>
				<a href="#" class="text-a">
					Sách nổi bật
				</a> 
			</h2>
		</div>
		<%
			for(int i = 0; sachNoiBat != null && i < sachNoiBat.size(); i++ ){
				Sach sach = sachNoiBat.get(i);
				String maSach = sach.getMaSach();
				String tenSach = sach.getTenSach();
				String urlHinh = sach.getUrlHinh();
				String donGia = DinhDang.MyNumberFormat(sach.getDonGia(), Constant.TienTe.TIEN_COMMA_PATTERN);
		%>
			<div class="col-md-12 col-sm-12 col-xs-12 padding-0 grid_group_sp">
				<div class="group_sp">
					<div class="anh_sp">
						<a href="/SachKyAnh/ChiTietSach?MaSach=<%=maSach %>" class="">
							<img class="anh" src="${kyanhbooksRootPath}${userStaticRootPath}img/sanpham/<%=urlHinh %>" title="sp" alt="anhsp">
								<a href="/SachKyAnh/ThemSachVaoGioHang?MaSach=<%=maSach %>&SoLuong=1" class="them_gh text-a" >
									<span class="glyphicon glyphicon-shopping-cart"></span>
									<span class="text"> Thêm vào giỏ</span>
								</a>
						</a>
					</div>
					<div class="tensp_giasp">
						<h3 class="tensp">
							<a href="/SachKyAnh/ChiTietSach?MaSach=<%=maSach %>" class="text-a">
								<%=tenSach %>
							</a>
						</h3>	
						<div class="giasp">
							<span class="gia_goc">
								<%=donGia%> <%=Constant.TienTe.DON_VI_TIEN_TE_VN %>
							</span>
							<a href="/SachKyAnh/ChiTietSach?MaSach=<%=maSach %>" class="chi_tiet">
								Chi Tiết
							</a>
						</div>
					</div>
				</div>
			</div>
			<!-- kt sản phẩm  -->
		<%
			}
		%>
		<!-- </div> -->
	</div>
</div>