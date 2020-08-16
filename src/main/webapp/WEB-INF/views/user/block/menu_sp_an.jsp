<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/user/init.jsp" %>

<%@page import="java.util.List" %>
<%@page import="com.annguyen.kyanhbooks.model.LoaiSach" %>

<nav class="menu_sp navbar-inverse" id="menu_an"> 
	<div class="top_menu_sp" id="top_menu_an">
		<div class="navbar-header">
			<i class="fa fa-bars"></i>
			<span class="">DANH MỤC SÁCH</span>
	      	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#nbMenuSP">
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span> 
	      	</button>
	  	</div>
	</div>
	<ul class="main_menu_sp collapse navbar-collapse an_menu" id="nbMenuSP">
		<%
		if(request.getAttribute("menuLoaiSach") != null ){
			List<LoaiSach> loaiSachs = (List<LoaiSach>)request.getAttribute("menuLoaiSach");
			for(int i = 0; loaiSachs != null && i < loaiSachs.size(); i++){
				String maLoaiSach = loaiSachs.get(i).getMaLoaiSach();
				String tenLoaiSach = loaiSachs.get(i).getTenLoaiSach();
		%>
			<li>
				<span class="glyphicon glyphicon-ok" style="font-size:10px">&nbsp;</span>
				<span>
					<a href="${kyanhbooksRootPathMenuLoaiSach}sachTheoLoaiSach?MaLS=<%=maLoaiSach %>" class="text-a">
						<%=tenLoaiSach %> 
					</a>
				</span>
			</li>
		<%
			}
		}
		%>
	</ul>
</nav>