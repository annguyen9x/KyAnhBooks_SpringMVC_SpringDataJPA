package com.annguyen.kyanhbooks.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.annguyen.kyanhbooks.model.KhachHang;
import com.annguyen.kyanhbooks.service.KhachHangService;
import com.annguyen.kyanhbooks.util.Constant;
import com.annguyen.kyanhbooks.util.myexception.ErrorConnectByInternet;
import com.annguyen.kyanhbooks.util.myexception.NotFoundException;

@Controller
public class KhachHangController {
	
	@Autowired
	private KhachHangService khachHangService;
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_KHACH_HANG_HIENTHI_DANGNHAP )
	public String hienThiTrangDangNhap() {
		
		return "dangnhap";
	}
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_KHACH_HANG_DANGNHAP)
	public String dangNhap(@RequestParam("email") String email, @RequestParam("matkhau") String matKhau, HttpSession session, Model model) {
		KhachHang khachHang = null;
		
		try {
			khachHang = khachHangService.dangNhap(email, matKhau, session);

			return "redirect:/";
		} catch (NotFoundException e) {
			model.addAttribute("errorLogin", e.getMessage());
		}
		
		return "dangnhap";
	}
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_KHACH_HANG_HIENTHI_DANGKY )
	public String hienThiDangKy() {
		
		return "dangky";
	}
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_KHACH_HANG_DANGKY )
	public String dangKy() {
		
		return "trangchu";
	}
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_KHACH_HANG_HIENTHI_CAPNHAT_TAIKHOAN )
	public String hienThiCapNhatTaiKkhoan() {
		
		return "capnhat_taikhoan";
	}
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_KHACH_HANG_CAPNHAT_TAIKHOAN )
	public String capNhatTaiKkhoan() {
		
		return "";
	}
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_KHACH_HANG_DANG_XUAT)
	public String dangXuatTaiKkhoan(HttpSession session) {
		khachHangService.dangXuat(session);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_KHACH_HANG_QUEN_MATKHAU )
	public String dangNhapKhiQuenMatKhau(HttpSession session) {
		if( session.getAttribute("KiemTraEmailDangNhap") != null ) {
			session.removeAttribute("KiemTraEmailDangNhap");
		}
		if( session.getAttribute("LoiGuiEmailXnTuServer") != null ) {
			session.removeAttribute("LoiGuiEmailXnTuServer");
		}
		
		return "quen_matkhau";
	}
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_KHACH_HANG_LAY_MA_XN_EMAIL )
	public String layMaXacNhanEmailKhiQuenMatKhau(@RequestParam("email") String email, HttpSession session) {
		
		String tieuDe = Constant.CauHinh.GIA_TRI_EMAIL_XN_QUEN_MATKHAU_TIEU_DE;
		String noiDung = Constant.CauHinh.GIA_TRI_EMAIL_XN_QUEN_MATKHAU_NOI_DUNG;
		int loaiCongViecGuiEmail = Constant.Email.LOAI_CONG_VIEC_GUI_EMAIL_QMK;
		try {
			khachHangService.layMaXacNhanEmail(tieuDe, noiDung, email, session, loaiCongViecGuiEmail);
		} catch (ErrorConnectByInternet e) {
			session.setAttribute("LoiGuiEmailXnTuServer", e.getMessage());
			e.printStackTrace();
		}
		return "quen_matkhau";
	}
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_XAC_NHAN_EMALI , method = RequestMethod.POST)
	public String xacNhanXacNhanEmailKhiQuenMatKhau(@RequestParam("maXN") String  maXacNhanTuClient, @RequestParam("emailHidden") String email, HttpSession session) {
		
		int loaiCongViecGuiEmail = Constant.Email.LOAI_CONG_VIEC_GUI_EMAIL_QMK;
		khachHangService.xacNhanMaXacNhanEmail(maXacNhanTuClient, email, session, loaiCongViecGuiEmail);
		
		return "quen_matkhau";
	}
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_KHACH_HANG_XEM_LICHSU_MUAHANG)
	public String xemLichSuMuaHang() {
		
		return "";
	}
}
