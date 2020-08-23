<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/views/user/init.jsp" %>

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
							<%=Constant.CauHinh.GIA_TRI_SO_DIENTHOAI_CA_NHAN %>
						</span>
					</li>
					<li class="list-li">
						<span class="glyphicon glyphicon-phone-alt" style="color:#ff5400;"></span>
						<span><%=Constant.CauHinh.GIA_TRI_SO_DIENTHOAI_SHOP %></span>
					</li>
					<li class="list-li">
						<span>
							<span class="fa fa-envelope" style="color:#15aabf;"></span>
							<%=Constant.CauHinh.GIA_TRI_EMAIL_SHOP %>
						</span>
					</li>
				</ul>
			</div>
		</div>
		<!-- kt nd  -->
	</div>
</div>