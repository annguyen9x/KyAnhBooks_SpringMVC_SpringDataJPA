package com.annguyen.kyanhbooks.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.annguyen.kyanhbooks.model.KhachHang;
import com.annguyen.kyanhbooks.service.GioHangService;
import com.annguyen.kyanhbooks.util.Constant;
import com.annguyen.kyanhbooks.util.myexception.NotFoundException;

@Controller
public class GioHangController {
	
	@Autowired
	private GioHangService gioHangService;
	
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_GIO_HANG_XEM)
	public String xemGioHangTheoSessionIdOrLogin(@CookieValue(Constant.GioHang.JSESSIONID) String jSessionIdGhCookie, HttpSession session, Model model) {
		KhachHang khachHang = (KhachHang)session.getAttribute("KhachHang");
		System.out.println("jSessionIdGhCookie: " + jSessionIdGhCookie);
		
		if( khachHang == null && (jSessionIdGhCookie == null || jSessionIdGhCookie.equals("") ) ) {
			model.addAttribute(Constant.GioHang.CHUA_TAO_GIOHANG, true);
		}
		else {
			gioHangService.xemGioHangTheoSessionIdOrLogin(khachHang, jSessionIdGhCookie, session);
		}
		
		return "gio_hang";
	}
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_GIO_HANG_DANGNHAP_XEM)
	public String dangNhapXemGioHang(@RequestParam("email") String email, @RequestParam("matkhau") String matKhau, HttpSession session, Model model) {
		try {
			gioHangService.dangNhapXemGioHang(email, matKhau, session);
		} catch (NotFoundException e) {
			model.addAttribute("errorLogin", e.getMessage());
		}
		
		return "gio_hang";
	}
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_GIO_HANG_XACNHAN_SDT_XEM)
	public String xacNhanSdtXemGioHang(@RequestParam("email") String email, @RequestParam("matkhau") String matKhau, HttpSession session, Model model) {
		try {
			gioHangService.dangNhapXemGioHang(email, matKhau, session);
		} catch (NotFoundException e) {
			model.addAttribute("errorLogin", e.getMessage());
		}
		
		return "gio_hang";
	}
	
	//Khi xem giỏ hàng/thêm sp giỏ hàng cần check sessionID trong Giỏ hàng/ hoặc check SDT (đã đăng nhập) 
	//=> Nếu chưa có SessionID thì yêu cầu 1. Đăng nhập (Nếu có TK)=> lại check giỏ hàng nếu chưa có tạo cho SessionID và giỏ hàng
	// 2. "Vui lòng xác nhận SĐT để mua sắm" => check SĐT trong giỏ hàng
	//=>Nếu có SĐT trong giỏ hàng rồi thì thông báo "Giỏ hàng của bạn đã tồn tại, xin mời tiếp tục mua hàng"
	//=> Nếu chưa có SDT thì Nhập Họ Tên + Nhập mã xác nhận gửi về đt/mail => Xác nhận thành công, xin mời tục mua hàng"
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_GIO_HANG_THEM_SP)
	public String themSpVaoGioHang(@CookieValue(Constant.GioHang.JSESSIONID) String jSessionIdGhCookie, HttpSession session, Model model) {
		KhachHang khachHang = (KhachHang)session.getAttribute("KhachHang");
		if( khachHang == null && (jSessionIdGhCookie == null || jSessionIdGhCookie.equals("") ) ) {
			model.addAttribute(Constant.GioHang.CHUA_TAO_GIOHANG, true);
		}
		else {
			gioHangService.themSpVaoGioHang(khachHang, jSessionIdGhCookie, session);
		}
		
		return "gio_hang";
	}
	
}
