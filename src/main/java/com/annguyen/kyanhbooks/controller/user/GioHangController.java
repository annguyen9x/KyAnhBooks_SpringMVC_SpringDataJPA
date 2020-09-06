package com.annguyen.kyanhbooks.controller.user;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.annguyen.kyanhbooks.model.KhachHang;
import com.annguyen.kyanhbooks.service.GioHangService;
import com.annguyen.kyanhbooks.util.Constant;
import com.annguyen.kyanhbooks.util.myexception.ErrorConnectByInternet;
import com.annguyen.kyanhbooks.util.myexception.NotFoundException;

@Controller
public class GioHangController {
	
	@Autowired
	private GioHangService gioHangService;
	
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_GIO_HANG_XEM)
	public String xemGioHangTheoSessionIdOrLogin(@CookieValue(Constant.GioHang.JSESSIONID) String jSessionIdGhCookie, HttpSession session, Model model, HttpServletResponse response) {
		KhachHang khachHang = (KhachHang)session.getAttribute("KhachHang");
		System.out.println("xemGioHangTheoSessionIdOrLogin-JSESSIONID: " + jSessionIdGhCookie);
		System.out.println("xemGioHangTheoSessionIdOrLogin-khachHang: " + khachHang);
		
		boolean isGioHang = gioHangService.xemGioHangTheoSessionIdOrLoginOrDienThoai(khachHang, jSessionIdGhCookie, null, null, session, response);
		if( isGioHang == false ) {
			model.addAttribute(Constant.GioHang.CHUA_TAO_GIOHANG, true);
		}
		KhachHang khachHang2 = (KhachHang)session.getAttribute("KhachHang");
		System.out.println("xemGioHangTheoSessionIdOrLogin-khachHang2: " + khachHang2);
		
		return "gio_hang";
	}
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_GIO_HANG_XEM_RELOADING)
	public String xemGioHangTheoSessionIdOrLoginReloading(@CookieValue(Constant.GioHang.JSESSIONID) String jSessionIdGhCookie, HttpSession session, HttpServletResponse response) {
		System.out.println("xemGioHangTheoSessionIdOrLoginReloading-JSESSIONID: " + jSessionIdGhCookie);
		KhachHang khachHang = (KhachHang)session.getAttribute("KhachHang");
		System.out.println("xemGioHangTheoSessionIdOrLoginReloading-khachHang: " + khachHang);
		boolean isGioHang = gioHangService.xemGioHangTheoSessionIdOrLoginOrDienThoai(null, jSessionIdGhCookie, null, null, session, response);
		return "gio_hang";
	}
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_GIO_HANG_DANGNHAP_XEM, produces = "application/json; charset=UTF-8")
	public @ResponseBody String dangNhapXemGioHang(@RequestParam("email") String email, @RequestParam("matkhau") String matKhau, HttpSession session, HttpServletResponse response) {
		JSONObject jsonObject = new JSONObject();
		try {
			gioHangService.dangNhapXemGioHang(email, matKhau, session, response);
			jsonObject.put("successLogin", "Đăng nhập thành công, tồn tại giỏ hàng");
		} catch (NotFoundException e) {
			jsonObject.put("errorLogin", e.getMessage());
		}

		return jsonObject.toString();
	}
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_GIO_HANG_GUI_MA_XACNHAN_SDT, produces = "application/json; charset=UTF-8")
	public @ResponseBody String guiMaXacNhanSdt(@RequestParam("dienThoai") String dienThoai, HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		
//		Tạm thời sẽ gửi mã xác nhận đến email(nào đó) thay cho việc gửi tin nhắn đến SĐT sẽ thực hiện trong version khác
		System.out.println("guiMaXacNhanSdt-dienThoai: " + dienThoai);
		String tieuDe = Constant.CauHinh.GIA_TRI_XN_SDT_XEM_GH_TIEU_DE;
		String noiDung = Constant.CauHinh.GIA_TRI_XN_SDT_XEM_GH_NOI_DUNG;
		String sdt = "nguyenva09@gmail.com";
		
		try {
			gioHangService.guiMaXacNhanSDT(tieuDe, noiDung, sdt, session);
			jsonObject.put("successMaXN", "Mã xác nhận đã gửi về sđt (tạm thời gửi về email: nguyenva09@gmail.com), vui lòng kiểm tra !");
		} catch (ErrorConnectByInternet e) {
			jsonObject.put("errorGuiMaXn", e.getMessage());
			e.printStackTrace();
		}
		
		return jsonObject.toString();
	}
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_GIO_HANG_XACNHAN_SDT_XEM, produces = "application/json; charset=UTF-8")
	public @ResponseBody String xacNhanMaXnSdtXemGioHang(@RequestParam("maXnSdt") String maXnSdt, @RequestParam("dienThoai") String dienThoai, @RequestParam("hoTen") String tenKH, HttpSession session, HttpServletResponse response) {
		JSONObject jsonObject = new JSONObject();
		boolean isMaXN = gioHangService.xacNhanMaXnSdtXemGioHang(maXnSdt, dienThoai, tenKH, session, response);
		if( isMaXN == true ) {
			jsonObject.put("successMaXN", "Xác nhận thành công");
		}
		else {
			jsonObject.put("errorMaXN", "Mã xác nhận không đúng !");
		}
		
		return jsonObject.toString();
	}
	
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
