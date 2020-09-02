package com.annguyen.kyanhbooks.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import com.annguyen.kyanhbooks.model.GioHang;
import com.annguyen.kyanhbooks.model.KhachHang;
import com.annguyen.kyanhbooks.service.GioHangService;
import com.annguyen.kyanhbooks.util.Constant;

@Controller
public class GioHangController {
	
	@Autowired
	private GioHangService gioHangService;
	
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_GIO_HANG_XEM)
	public String xemGioHang(HttpSession session) {
		KhachHang khachHang = (KhachHang)session.getAttribute("KhachHang");
		if( khachHang != null ) {
			int maKH = khachHang.getMaKH();
		}
		//GioHang gioHang = gioHangService.xemGioHang(sessionIdCookie, maKH);
		
//		if( gioHang == null ) {
//			return "xacnhan_dienthoai_email";
//		}
//		else {
//			return "gio_hang";
//		}
		
		return "gio_hang";
	}
	
	//Khi xem giỏ hàng/thêm sp giỏ hàng cần check sessionID trong Giỏ hàng/ hoặc check SDT (đã đăng nhập) 
	//=> Nếu chưa có SessionID thì yêu cầu 1. Đăng nhập (Nếu có TK)=> lại check giỏ hàng nếu chưa có tạo cho SessionID và giỏ hàng
	// 2. "Vui lòng xác nhận SĐT để mua sắm" => check SĐT trong giỏ hàng
	//=>Nếu có SĐT trong giỏ hàng rồi thì thông báo "Giỏ hàng của bạn đã tồn tại, xin mời tiếp tục mua hàng"
	//=> Nếu chưa có SDT thì Nhập Họ Tên + Nhập mã xác nhận gửi về đt/mail => Xác nhận thành công, xin mời tục mua hàng"
//	public String xemGioHangAA(@CookieValue(Constant.GioHang.JSESSIONID) String sessionIdCookie, HttpSession session) {
//		KhachHang khachHang = (KhachHang)session.getAttribute("KhachHang");
//		int maKH = khachHang.getMaKH();
//		GioHang gioHang = gioHangService.xemGioHang(sessionIdCookie, maKH);
//		
////		if( gioHang == null ) {
////			return "xacnhan_dienthoai_email";
////		}
////		else {
////			return "gio_hang";
////		}
//		
//		return "gio_hang";
//	}
	
//	@RequestMapping
//	public String taoGioHang() {
//		
//		return "";
//	}
	
	
}
