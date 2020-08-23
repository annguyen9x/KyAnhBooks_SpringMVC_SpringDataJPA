package com.annguyen.kyanhbooks.util;

import org.springframework.stereotype.Controller;

public class Constant {
	
	//Các URL
	public interface Path{
		
		//================ USER ================
		//Root Path KyAnhBook
		//public static final String KYANHBOOKS_ROOT_PATH = "/KyAnhBooks/";
		//Đổi path="KyAnhBooks" thành path="/" trong "Servers/server.xml" (dòng  <Context docBase="KyAnhBooks" path="/" ...>)
		//để truy cập trực tiếp vào Controller khi run project
		public static final String KYANHBOOKS_ROOT_PATH = "/";

		//Root Path KyAnhBook + Menu LoaiSach
		public static final String KYANHBOOKS_ROOT_PATH_MENU_LOAISACH = KYANHBOOKS_ROOT_PATH + "MenuLoaiSach/";
		
		//View User
		public static String USER_VIEW_ROOT_PATH = "/WEB-INF/views/user/";
		public static String USER_VIEW_BLOCK_PATH = USER_VIEW_ROOT_PATH + "block/";
		
		public static String USER_CONTROLLER_SACH_THEO_LOAISACH = "sachTheoLoaiSach";
		public static String USER_CONTROLLER_PHAN_TRANG_SACH_THEO_LOAISACH = "phanTrangSachTheoLoaiSach";
		public static String USER_CONTROLLER_MENU_NGANG = "menuNgang";
		public static String USER_CONTROLLER_CHI_TIET_SP = "ChiTietSP";
		
		
		//================ ADMIN ================
		//View Admin
		public static String ADMIN_VIEW_ROOT_PATH = "/WEB-INF/views/admin/";
		public static String ADMIN_VIEW_BLOCK_PATH = ADMIN_VIEW_ROOT_PATH + "block/";
		
		//CSS+JS User
		public static String USER_STATIC_ROOT_PATH = "commonResources/user/static/";
		
		//CSS+JS Admin
		public static String ADMIN_STATIC_ROOT_PATH = "commonResources/admin/static/";
		
	}
	
	//Dùng trong chức năng cấu hình của Admin
	public interface CauHinh{
		public static final String TEN_THAMSO_SO_DIENTHOAI_CA_NHAN = "SoDienThoai_CaNhan";
		public static final String TEN_THAMSO_SO_DIENTHOAI_SHOP = "SoDienThoai_SHOP";
		public static final String TEN_THAMSO_EMAIL_CA_NHAN = "Email_CaNhan";
		public static final String TEN_THAMSO_EMAIL_SHOP = "Email_Shop";
		public static final String TEN_THAMSO_LINK_FB_CA_NHAN = "LinkFB_CaNhan";
		public static final String TEN_THAMSO_LINK_FB_SHOP = "LinkFB_Shop";
		public static final String TEN_THAMSO_DIA_CHI_SHOP_1 = "DiaChi_Shop1";
		public static final String TEN_THAMSO_DIA_CHI_SHOP_2 = "DiaChi_Shop2";
		public static final String TEN_THAMSO_LIMIT_SP_THEO_LOAISP = "SoSP_Theo_LoaiSP_Tren_Mot_Trang";
		public static final String TEN_THAMSO_SOTRANG_SP_NHIN_THAY_THEO_LOAISP = "SoTrangSP_NhinThay_Theo_LoaiSP";
		public static final String TEN_THAMSO_PAGE_FIRST_DEFAULT = "TrangSP_MacDinh_DauTien";
				
		//Get Trực tiếp từ Cấu hình ở DB chứ không cần so sánh (Ít khi so sánh - trừ một vài TH mặc định 0/1)
		public static final String GIA_TRI_SO_DIENTHOAI_CA_NHAN = "(84)34.724.4142";
		public static final String GIA_TRI_SO_DIENTHOAI_SHOP = "(84)92.910.9072";
		public static final String GIA_TRI_EMAIL_CA_NHAN = "annguyen.itworks@gmail.com";
		public static final String GIA_TRI_EMAIL_SHOP = "kyanhbooks@gmail.com";
//		public static final String GIA_TRI_LINK_FB_CA_NHAN = "";//Get Trực tiếp từ Cấu hình ở DB chứ không cần so sánh
//		public static final String GIA_TRI_LINK_FB_SHOP = "";
		public static final String GIA_TRI_DIA_CHI_SHOP_1 = "Phường Sông Trí, Tx. Kỳ anh, T. Hà Tĩnh";
//		public static final String GIA_TRI_DIA_CHI_SHOP_2 = "DiaChi_Shop2";
		public static final int GIA_TRI_LIMIT_SP_THEO_LOAISP = 2; 
		public static final int GIA_TRI_SOTRANG_SP_NHIN_THAY_THEO_LOAISP = 6; 
		public static final int GIA_TRI_PAGE_FIRST_DEFAULT = 1; 
	}
	
	//Trang chủ
	public interface TrangChu{
		public static final String SACH_NOI_BAT = "Sách nổi bật";
		public static final String SACH_MOI = "Sách mới";
		public static final String SACH_VAN_HOC = "Sách văn học";
		public static final String MA_LOAI_SACH_VAN_HOC = "LS06";
		
		public static final int SACH_NOI_BAT_NUMBER = 2;
		public static final int SACH_MOI_NUMBER  = 8;
		public static final int SACH_VAN_HOC_NUMBER = 6;
	}
	
	//Menu ngang
	public interface MenuNgang{
		public static String TRANG_CHU = "Trang Chủ";
		public static String GIOI_THIEU = "Giới thiệu";
		public static String DICH_VU = "Dịch vụ";
		public static String HUONG_DAN_MUA_HANG = "Hướng dẫn mua hàng";
		public static String LIEN_HE = "Liên hệ";
		
		public static int TRANG_CHU_NUMBER = 0;
		public static int GIOI_THIEU_NUMBER = 1;
		public static int DICH_VU_NUMBER = 2;
		public static int HUONG_DAN_MUA_HANG_NUMBER = 3;
		public static int LIEN_HE_NUMBER = 4;
	}
	
	//Định dạng tiền
	public interface TienTe{
		public static String TIEN_COMMA_PATTERN = "###,###,###";
		public static String DON_VI_TIEN_TE_VN = "đ";
	}
	
	//Tên các nút - button
	public interface TenNut{
		public static String THOAT = "Thoát";
		public static String THEM_VAO_GIO_HANG = "Thêm vào giỏ hàng";
		public static String CHI_TIET = "Chi Tiết";
		public static String GIO_HANG = "Giỏ hàng";
		public static String TIM_KIEM = "Tìm kiếm";
	}
	
	//Các thông báo
	public interface ThongBao{
		public static final String KHONG_CO_SP_TRONG_LOAISACH = "Không có sản phẩm nào trong loại sách này !";
	}
	
}
