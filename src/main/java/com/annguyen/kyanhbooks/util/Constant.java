package com.annguyen.kyanhbooks.util;

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
		public static final String USER_VIEW_ROOT_PATH = "/WEB-INF/views/user/";
		public static final String USER_VIEW_BLOCK_PATH = USER_VIEW_ROOT_PATH + "block/";
		
		//Controller User
		public static final String USER_CONTROLLER_SACH_THEO_LOAISACH = "sachTheoLoaiSach";
		public static final String USER_CONTROLLER_PHAN_TRANG_SACH_THEO_LOAISACH = "phanTrangSachTheoLoaiSach";
		public static final String USER_CONTROLLER_MENU_NGANG = "menuNgang";
		public static final String USER_CONTROLLER_CHI_TIET_SP = "ChiTietSP";
		
		public static final String USER_CONTROLLER_KHACH_HANG_HIENTHI_DANGNHAP = "HienThiDangNhap";
		public static final String USER_CONTROLLER_KHACH_HANG_HIENTHI_DANGKY = "HienThiDangKy";
		public static final String USER_CONTROLLER_KHACH_HANG_DANGNHAP = "DangNhap";
		public static final String USER_CONTROLLER_KHACH_HANG_DANGKY = "DangKy";
		public static final String USER_CONTROLLER_KHACH_HANG_HIENTHI_CAPNHAT_TAIKHOAN = "HienThiCapNhatTaiKhoan";
		public static final String USER_CONTROLLER_KHACH_HANG_CAPNHAT_TAIKHOAN = "CapNhatTaiKhoan";
		public static final String USER_CONTROLLER_KHACH_HANG_XEM_LICHSU_MUAHANG = "XemLichSuMuaHang";
		public static final String USER_CONTROLLER_KHACH_HANG_DANG_XUAT = "DangXuat";
		public static final String USER_CONTROLLER_KHACH_HANG_QUEN_MATKHAU = "QuenMatKhau";
		public static final String USER_CONTROLLER_KHACH_HANG_LAY_MA_XN_EMAIL_QUEN_MATKHAU = "LayMaXnEmailQMK";
		public static final String USER_CONTROLLER_XAC_NHAN_EMAIL_QUEN_MATKHAU = "XacNhanEmailQMK";
		public static final String USER_CONTROLLER_KHACH_HANG_LAY_MA_XN_EMAIL_DANG_KY = "LayMaXnEmailDangKy";
		public static final String USER_CONTROLLER_XAC_NHAN_EMAIL_DANG_KY = "XacNhanEmailDangKy";
		
		public static final String USER_CONTROLLER_GIO_HANG_XEM = "XemGioHang";
		public static final String USER_CONTROLLER_GIO_HANG_XEM_RELOADING = "XemGioHangReloading";
		public static final String USER_CONTROLLER_GIO_HANG_DANGNHAP_XEM = "DangNhapXemGioHang";
		public static final String USER_CONTROLLER_GIO_HANG_GUI_MA_XACNHAN_SDT = "GuiMaXnSDTXemGioHang";
		public static final String USER_CONTROLLER_GIO_HANG_XACNHAN_SDT_XEM = "XacNhanSDTXemGioHang";
		public static final String USER_CONTROLLER_GIO_HANG_THEM_SP= "ThemSpVaoGioHang";
		public static final String USER_CONTROLLER_GIO_HANG_CAPNHAT_SP = "CapNhatSpGioHang";
		public static final String USER_CONTROLLER_GIO_HANG_XOA = "XoaGioHang";
		public static final String USER_CONTROLLER_GIO_HANG__THONGTIN_DAT_HANG = "ThongTinDatHang";
		public static final String USER_CONTROLLER_GIO_HANG_DAT_HANG = "DatHang";
		public static final String USER_CONTROLLER_GUI_EMAIL_KHI_DAT_HANG = "GuiEmailKhiDatHang";
		public static final String USER_CONTROLLER_THEO_DOI_DON_HANG = "TheoDoiDonHang";
		
		
		//CSS+JS User
		public static final String USER_STATIC_ROOT_PATH = "commonResources/user/static/";
		
		//================ ADMIN ================
		//View Admin
		public static final String ADMIN_VIEW_ROOT_PATH = "/WEB-INF/views/admin/";
		public static final String ADMIN_VIEW_BLOCK_PATH = ADMIN_VIEW_ROOT_PATH + "block/";
		
		//CSS+JS Admin
		public static final String ADMIN_STATIC_ROOT_PATH = "commonResources/admin/static/";
		
	}
	
	//Dùng trong chức năng cấu hình của Admin
	public interface CauHinh{
		
		//Thông tin shop
		public static final String TEN_THAMSO_SO_DIENTHOAI_CA_NHAN = "SoDienThoai_CaNhan";
		public static final String TEN_THAMSO_SO_DIENTHOAI_SHOP = "SoDienThoai_SHOP";
		public static final String TEN_THAMSO_EMAIL_CA_NHAN = "Email_CaNhan";
		public static final String TEN_THAMSO_EMAIL_SHOP = "Email_Shop";
		public static final String TEN_THAMSO_MATKHAU_EMAIL_SHOP = "Email_Shop";
		public static final String TEN_THAMSO_LINK_FB_CA_NHAN = "LinkFB_CaNhan";
		public static final String TEN_THAMSO_LINK_FB_SHOP = "LinkFB_Shop";
		public static final String TEN_THAMSO_DIA_CHI_SHOP_1 = "DiaChi_Shop1";
		public static final String TEN_THAMSO_DIA_CHI_SHOP_2 = "DiaChi_Shop2";
		
		//Email gửi thông tin từ shop
		public static final String TEN_THAMSO_EMAIL_XN_DANGKY_TIEU_DE = "XnEmailDangKy_TieuDe";
		public static final String TEN_THAMSO_EMAIL_XN_DANGKY_NOI_DUNG = "XnEmailDangKy_NoiDung";
		public static final String TEN_THAMSO_EMAIL_XN_QUEN_MATKHAU_TIEU_DE = "XnEmailQuenMK_TieuDe";
		public static final String TEN_THAMSO_EMAIL_XN_QUEN_MATKHAU_NOI_DUNG = "XnEmailQuenMK_NoiDung";
		public static final String TEN_THAMSO_EMAIL_GUI_HOADON_TIEU_DE = "XnEmailGuiHoaDon_TieuDe";
		public static final String TEN_THAMSO_EMAIL_GUI_HOADON_NOI_DUNG = "XnEmailGuiHoaDon_NoiDung";
		
		public static final String TEN_THAMSO_XN_SDT_XEM_GH_TIEU_DE = "XacNhanSdtXemGH_TieuDe";
		public static final String TEN_THAMSO_XN_SDT_XEM_GH_NOI_DUNG = "XacNhanSdtXemGH_NoiDung";
		
		//Phân trang
		public static final String TEN_THAMSO_LIMIT_SP_THEO_LOAISP = "SoSP_Theo_LoaiSP_Tren_Mot_Trang";
		public static final String TEN_THAMSO_SOTRANG_SP_NHIN_THAY_THEO_LOAISP = "SoTrangSP_NhinThay_Theo_LoaiSP";
		public static final String TEN_THAMSO_PAGE_FIRST_DEFAULT = "TrangSP_MacDinh_DauTien";
				
		//Get Trực tiếp từ Cấu hình ở DB chứ không cần so sánh (Ít khi so sánh - trừ một vài TH mặc định 0/1)
		public static final String GIA_TRI_SO_DIENTHOAI_CA_NHAN = "(84)34.724.4142";
		public static final String GIA_TRI_SO_DIENTHOAI_SHOP = "(84)92.910.9072";
		public static final String GIA_TRI_EMAIL_CA_NHAN = "annguyen.itworks@gmail.com";
		public static final String GIA_TRI_EMAIL_SHOP = "kyanhbooks@gmail.com";
		public static final String GIA_TRI_MATKHAU_EMAIL_SHOP = "Kab@1234";
//		public static final String GIA_TRI_LINK_FB_CA_NHAN = "";//Get Trực tiếp từ Cấu hình ở DB chứ không cần so sánh
//		public static final String GIA_TRI_LINK_FB_SHOP = "";
		public static final String GIA_TRI_DIA_CHI_SHOP_1 = "Phường Sông Trí, Tx. Kỳ anh, T. Hà Tĩnh";
//		public static final String GIA_TRI_DIA_CHI_SHOP_2 = "DiaChi_Shop2";
		
		//Email gửi thông tin từ shop
		public static final String GIA_TRI_EMAIL_XN_DANGKY_TIEU_DE = "Xác nhận đăng ký tài khoản tại [kyanhbooks.com]";
		public static final String GIA_TRI_EMAIL_XN_DANGKY_NOI_DUNG = "Mã xác nhận email đăng ký: ";
		public static final String GIA_TRI_EMAIL_XN_QUEN_MATKHAU_TIEU_DE = "Xác nhận đăng nhập tài khoản tại [kyanhbooks.com] khi quên mật khẩu";
		public static final String GIA_TRI_EMAIL_XN_QUEN_MATKHAU_NOI_DUNG = "Mã xác nhận email đăng nhập: ";
		public static final String GIA_TRI_EMAIL_GUI_HOADON_TIEU_DE = "";
		public static final String GIA_TRI_EMAIL_GUI_HOADON_NOI_DUNG = "";
		
		public static final String GIA_TRI_XN_SDT_XEM_GH_TIEU_DE = "Xác nhận sđt mua hàng tại [kyanhbooks.com]";
		public static final String GIA_TRI_XN_SDT_XEM_GH_NOI_DUNG = "Mã xác nhận sđt: ";
		
		//Phân trang
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
		public static final String TRANG_CHU = "Trang Chủ";
		public static final String GIOI_THIEU = "Giới thiệu";
		public static final String DICH_VU = "Dịch vụ";
		public static final String HUONG_DAN_MUA_HANG = "Hướng dẫn mua hàng";
		public static final String LIEN_HE = "Liên hệ";
		
		public static final int TRANG_CHU_NUMBER = 0;
		public static final int GIOI_THIEU_NUMBER = 1;
		public static final int DICH_VU_NUMBER = 2;
		public static final int HUONG_DAN_MUA_HANG_NUMBER = 3;
		public static final int LIEN_HE_NUMBER = 4;
	}
	
	//GioHang
	public interface GioHang{
		public static final String JSESSIONID = "JSESSIONID";
		public static final String TIENTO_JSESSIONID = "sessionid-";
		public static final String CHUA_TAO_GIOHANG = "ChuaTaoGioHang";
		public static final String GIOHANG_SESSION = "GioHangSession";
		public static final String GIOHANG_TONG_SP_TRONG_GH = "TongSpTrongGH";
	}
	
	//Định dạng tiền
	public interface TienTe{
		public static final String TIEN_COMMA_PATTERN = "###,###,###";
		public static final String DON_VI_TIEN_TE_VN = "đ";
	}
	
	public interface KyTuDacBiet{
		public static final String COMMA = ",";
		public static final String DOT = ".";
		public static final String DASH = "-";
	}
	
	//Định dạng ngày tháng
	public interface NgayThang{
		public static final String DATE_TIME_US = "yyyy-MM-dd";
		public static final String DATE_TIME_US_FULL = "yyyy-MM-dd HH:mm:ss";
		public static final String DATE_TIME_VN1 = "dd/MM/yyyy";
		public static final String DATE_TIME_VN1_FULL = "dd/MM/yyyy HH:mm:ss";
	}
	
	//Tên các nút - button
	public interface TenNut{
		public static final String THOAT = "Thoát";
		public static final String THEM_VAO_GIO_HANG = "Thêm vào giỏ hàng";
		public static final String CHI_TIET = "Chi Tiết";
		public static final String GIO_HANG = "Giỏ hàng";
		public static final String TIM_KIEM = "Tìm kiếm";
	}
	
	//Các thông báo
	public interface ThongBao{
		public static final String KHONG_CO_SP_TRONG_LOAISACH = "Không có sản phẩm nào trong loại sách này !";
	}
	
	//Form
	public interface RegularExpression{
		public static final String REG_MAIL = "/^[a-zA-Z0-9]+([_\\.\\-]?[A-Za-z0-9])*@[a-zA-Z0-9]+([_\\.\\-]?[A-Za-z0-9])*(\\.[A-Za-z]+)+$/";
		public static final String REG_SDT = "/^0[1-9]{1}[0-9]{8}$/";
	}
	
	//Các loại công việc gửi Email
	public interface LoaiCongViecGuiMaXN{
		public static final int LOAI_CONG_VIEC_GUI_MA_XN_EMAIL_QMK = 1;//Quên mật khẩu
		public static final int LOAI_CONG_VIEC_GUI_MA_XN_EMAIL_XNDK = 2;//Xác nhận đăng ký
		public static final int LOAI_CONG_VIEC_GUI_MA_XN_EMAIL_TTDH = 3;//Thông tin đơn hàng
		public static final int LOAI_CONG_VIEC_GUI_MA_XN_DIENTHOAI_XEM_GH = 4;//Xác nhận SĐT xem giỏ hàng
	}
	
}
