<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/user/init.jsp" %>
<%@ page import="com.annguyen.kyanhbooks.model.Sach" %>
<%@page import="com.annguyen.kyanhbooks.util.DinhDang"%>
<%@ page import="java.util.List" %>
<!-- begin: paging -->
<script src="${kyanhbooksRootPath}${userStaticRootPath}paging/jquery.twbsPagination.js" type="text/javascript"></script>
<!-- end: paging -->

<%
	long totalCountLoaiSach = 0;
	long totalPageLoaiSach = 0;
	int currentPage = 0;
	int limit = 0;
	
	if(request.getAttribute("TotalCountLoaiSach") != null ){
		totalCountLoaiSach = (long)request.getAttribute("TotalCountLoaiSach");
	}
	if(request.getAttribute("TotalPageLoaiSach") != null ){
		totalPageLoaiSach = (long)request.getAttribute("TotalPageLoaiSach");
	}
	if(request.getAttribute("CurrentPage") != null ){
		currentPage = (int)request.getAttribute("CurrentPage");
	}
	if(request.getAttribute("Limit") != null ){
		limit = (int)request.getAttribute("Limit");
	}

	List<Sach> sachTheoLoaiSach = null;
	String maLoaiSach = "";
	if(request.getAttribute("SachTheoLoaiSach") != null ){
		sachTheoLoaiSach = (List<Sach>)request.getAttribute("SachTheoLoaiSach");
	}
	
	String phanTrangSachTheoLoaiSachURL = Constant.Path.KYANHBOOKS_ROOT_PATH_MENU_LOAISACH + Constant.Path.USER_CONTROLLER_PHAN_TRANG_SACH_THEO_LOAISACH;
%>
    
	<%
		if(sachTheoLoaiSach != null && sachTheoLoaiSach.size()> 0 ){
			for(int i = 0; i < sachTheoLoaiSach.size(); i++)
				{	
					Sach sach = sachTheoLoaiSach.get(i);
					String maSach = sach.getMaSach();
					String tenSach = sach.getTenSach();
					String donGia = DinhDang.MyNumberFormat(sach.getDonGia(), Constant.TienTe.TIEN_COMMA_PATTERN);
					String urlHinh = sach.getUrlHinh();
					maLoaiSach = sach.getMaLoaiSach();
	%>
		<!-- begin: sản phẩm  -->
		<div class="col-md-3 col-sm-4 col-xs-12 padding-0 grid_group_sp">
				<div class="col-md-12 col-sm-12 col-xs-12 padding-0">
					<div class="group_sp my_border">
						<div class="anh_sp">
							<a href="${kyanhbooksRootPathMenuLoaiSach}ChiTietSP?MaSach=<%=maSach %>" class="">
								<img class="anh" src="${kyanhbooksRootPath}${userStaticRootPath}img/sanpham/<%=urlHinh %>" title="sp" alt="anhsp">
								<%
									
								%>
									<a href="${kyanhbooksRootPathMenuLoaiSach}ThemSachVaoGioHang?MaSach=<%=maSach%>&SoLuong=1&DuongDan=<%= request.getServletPath() %>" class="them_gh text-a" >
										<span class="glyphicon glyphicon-shopping-cart"></span>
										<span class="text"> <%=Constant.TenNut.THEM_VAO_GIO_HANG %></span>
									</a>
								<%
									
								%>
							</a>
						</div>
						<div class="tensp_giasp">
							<h3 class="tensp">
								<a href="${kyanhbooksRootPathMenuLoaiSach}ChiTietSP?MaSach=<%=maSach %>" class="text-a">
									<%=tenSach%>
								</a>
							</h3>	
							<div class="giasp">
								<span class="gia_goc">
									<%=donGia%> <%=Constant.TienTe.DON_VI_TIEN_TE_VN%>
								</span>
								<a href="${kyanhbooksRootPathMenuLoaiSach}ChiTietSP?MaSach=<%=maSach %>" class="chi_tiet">
									<%=Constant.TenNut.CHI_TIET%>
								</a>
							</div>
						</div>
					</div>
				</div>
		</div>
		<!-- kt sản phẩm  -->
	<%
		}
	}else{
	%>
		<p class="alert alert-danger"><%=Constant.ThongBao.KHONG_CO_SP_TRONG_LOAISACH %></p>
	<%
	}
	%>
	<!-- begin: paging - phân trang -->
	<div id="myPage" class="col-md-12 col-sm-12 col-xs-12" style="margin-top: 10px;padding: 0px;margin: 0px;">
		<nav class="col-md-5 col-sm-5 col-xs-12">
			<ul class="pagination">
		    	<li class="page-item">
		    		<span class="page-link" style="color: #777; font-size: 11px; ">
		    		Sản phẩm từ <%=(currentPage - 1)*limit + 1%>  đến <%=currentPage*limit%> của <%=totalCountLoaiSach %> kết quả - Trang: <%=currentPage %>/ <%=totalPageLoaiSach %>
		    		</span>
		    	</li>
		    </ul>
		</nav>
		<nav aria-label="Page navigation" class="col-md-7 col-sm-7 col-xs-12">
	        <ul class="pagination" id="pagination"></ul>
	    </nav>
    </div>
	<!-- end: paging - phân trang -->
	
	
<style>
	#myPage .pagination>.active>a, .pagination>.active>a:focus, .pagination>.active>a:hover, .pagination>.active>span, .pagination>.active>span:focus, .pagination>.active>span:hover{
		cursor: default;
	    background-color:#f47920;
	    border-color:#f47920;
	}
</style>
	
<script type="text/javascript">
	var totalPages = <%=totalPageLoaiSach%>;
	var currentPage = <%=currentPage%>;
	$(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: <%=Constant.CauHinh.GIA_TRI_SOTRANG_SP_NHIN_THAY_THEO_LOAISP%>,
            startPage: currentPage,
            onPageClick: function (event, page) {
            	if (currentPage != page) {
					$.ajax({
						url:  '<%=phanTrangSachTheoLoaiSachURL%>',
						type: 'GET',
						data:{
							page: page,
							limit: '<%=limit%>',
							MaLS: '<%=maLoaiSach %>',
						},
						success: function(data){
							$('#danhSachSPCungLoai').html(data);
						},
						error: function (jqXHR, exception) {
					        var msg = '';
					        if (jqXHR.status === 0) {
					            msg = 'Not connect.\n Verify Network.';
					        } else if (jqXHR.status == 404) {
					            msg = 'Requested page not found. [404]';
					        } else if (jqXHR.status == 500) {
					            msg = 'Internal Server Error [500].';
					        } else if (exception === 'parsererror') {
					            msg = 'Requested JSON parse failed.';
					        } else if (exception === 'timeout') {
					            msg = 'Time out error.';
					        } else if (exception === 'abort') {
					            msg = 'Ajax request aborted.';
					        } else {
					            msg = 'Uncaught Error.\n' + jqXHR.responseText;
					        }
					        $('#danhSachSPCungLoai').html(msg);
					    },
					});
            	}
            }
        });
    });
</script>