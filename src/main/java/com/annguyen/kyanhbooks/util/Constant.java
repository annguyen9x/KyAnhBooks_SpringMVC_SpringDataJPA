package com.annguyen.kyanhbooks.util;

public class Constant {
	
	//Các URL
	public interface Path{
		//Root Path KyAnhBook
		public static final String KYANHBOOKS_ROOT_PATH = "/KyAnhBooks/";
		
		//View User
		public static String USER_VIEW_ROOT_PATH = "/WEB-INF/views/user/";
		public static String USER_VIEW_BLOCK_PATH = USER_VIEW_ROOT_PATH + "block/";
		
		//View Admin
		public static String ADMIN_VIEW_ROOT_PATH = "/WEB-INF/views/admin/";
		public static String ADMIN_VIEW_BLOCK_PATH = ADMIN_VIEW_ROOT_PATH + "block/";
		
		//CSS+JS User
		public static String USER_STATIC_ROOT_PATH = "commonResources/user/static/";
		
		//CSS+JS Admin
		public static String ADMIN_STATIC_ROOT_PATH = "commonResources/admin/static/";
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
	
}
