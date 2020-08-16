<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/user/init.jsp" %>

<nav class="menu_sp navbar-inverse"> 
	<div class="top_menu_sp">
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
	<ul class="main_menu_sp collapse navbar-collapse" id="nbMenuSP">
		<c:forEach var="loaiSach" items="${DSLoaiSach}">
			<li>
				<span class="glyphicon glyphicon-ok" style="font-size:10px">&nbsp;</span>
				<span>
					<a href="sp_cungloai.jsp" class="text-a">
						${loaiSach.tenLoaiSach} 
					</a>
				</span>
			</li>
		</c:forEach>
	</ul>
</nav>