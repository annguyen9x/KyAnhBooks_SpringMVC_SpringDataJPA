package com.annguyen.kyanhbooks.controller.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.annguyen.kyanhbooks.model.KhachHang;
import com.annguyen.kyanhbooks.repository.KhachHangRepository;
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
	public String hienThiDangKy(Model model, HttpSession session) {
		if( session.getAttribute("errorThongTinDangKy") != null ) {
			session.removeAttribute("errorThongTinDangKy");
		}
		model.addAttribute("KhachHang", new KhachHang());
		
		return "dangky";
	}
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_KHACH_HANG_DANGKY )
	public String dangKy(@ModelAttribute("KhachHang") KhachHang khachHang,@RequestParam("namsinh") String namSinh, @RequestParam("thangsinh") String thangSinh,
						@RequestParam("ngaysinh") String ngaySinh, HttpSession session, Model model) {
		
		boolean isDangKy = khachHangService.dangKy(khachHang, namSinh, thangSinh, ngaySinh, session, model);
		if( isDangKy == true ) {
			//return "redirect:/" + Constant.Path.USER_CONTROLLER_KHACH_HANG_LAY_MA_XN_EMAIL_DANG_KY;
			return layMaXacNhanEmailKhiDangKy(khachHang, session);
		}
		else {
			model.addAttribute("KhachHang", new KhachHang());
			return "dangky";
		}
	}
		
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_KHACH_HANG_LAY_MA_XN_EMAIL_DANG_KY )
	public String layMaXacNhanEmailKhiDangKy(KhachHang khachHang, HttpSession session) {
		String tieuDe = Constant.CauHinh.GIA_TRI_EMAIL_XN_DANGKY_TIEU_DE;
		String noiDung = Constant.CauHinh.GIA_TRI_EMAIL_XN_DANGKY_NOI_DUNG;
		int loaiCongViecGuiEmail = Constant.LoaiCongViecGuiMaXN.LOAI_CONG_VIEC_GUI_MA_XN_EMAIL_XNDK;
		String email = khachHang.getEmail();
		
		try {
			khachHangService.guiMaXacNhanEmail(tieuDe, noiDung, email, session, loaiCongViecGuiEmail);
		} catch (ErrorConnectByInternet e) {
			session.setAttribute("LoiGuiEmailXnTuServer", e.getMessage());
			e.printStackTrace();
		}
		
		return "xacthuc_dangky";
	}
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_XAC_NHAN_EMAIL_DANG_KY , method = RequestMethod.POST)
	public String xacNhanXacNhanEmailKhiDangKy(@RequestParam("maXN") String  maXacNhanTuClient, @RequestParam("email") String email, HttpSession session) {
		
		int loaiCongViecGuiEmail = Constant.LoaiCongViecGuiMaXN.LOAI_CONG_VIEC_GUI_MA_XN_EMAIL_XNDK;
		khachHangService.xacNhanMaXacNhanEmailHoacDienThoai(maXacNhanTuClient, email, null,session, loaiCongViecGuiEmail);
		
		return "xacthuc_dangky";
	}
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_KHACH_HANG_HIENTHI_CAPNHAT_TAIKHOAN )
	public String hienThiCapNhatTaiKkhoan(Model model, HttpSession session) {
		KhachHang khachHang = (KhachHang)session.getAttribute("KhachHang");
		if(khachHang != null ) {
			//Xóa không hiển thị mật khẩu để nhập lại vì đã mã hóa MD5 không thể dịch ngược
			khachHang.setMatKhau("");
			model.addAttribute("KhachHang", khachHang);
		}
		
		if( session.getAttribute("errorThongTinCapNhat") != null ){
			session.removeAttribute("errorThongTinCapNhat");
		}
		return "capnhat_taikhoan";
	}
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_KHACH_HANG_CAPNHAT_TAIKHOAN )
	public String capNhatTaiKkhoan(@ModelAttribute("KhachHang") KhachHang khachHang, @RequestParam("namsinh") String namSinh, @RequestParam("thangsinh") String thangSinh,
			@RequestParam("ngaysinh") String ngaySinh, HttpSession session, Model model) {
		
		boolean isCapNhatTaiKhoan = khachHangService.capNhatTaiKhoan(khachHang, namSinh, thangSinh, ngaySinh, session, model);
		return "capnhat_taikhoan";
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
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_KHACH_HANG_LAY_MA_XN_EMAIL_QUEN_MATKHAU )
	public String layMaXacNhanEmailKhiQuenMatKhau(@RequestParam("email") String email, HttpSession session) {
		
		String tieuDe = Constant.CauHinh.GIA_TRI_EMAIL_XN_QUEN_MATKHAU_TIEU_DE;
		String noiDung = Constant.CauHinh.GIA_TRI_EMAIL_XN_QUEN_MATKHAU_NOI_DUNG;
		int loaiCongViecGuiEmail = Constant.LoaiCongViecGuiMaXN.LOAI_CONG_VIEC_GUI_MA_XN_EMAIL_QMK;
		try {
			khachHangService.guiMaXacNhanEmail(tieuDe, noiDung, email, session, loaiCongViecGuiEmail);
		} catch (ErrorConnectByInternet e) {
			session.setAttribute("LoiGuiEmailXnTuServer", e.getMessage());
			e.printStackTrace();
		}
		return "quen_matkhau";
	}
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_XAC_NHAN_EMAIL_QUEN_MATKHAU , method = RequestMethod.POST)
	public String xacNhanXacNhanEmailKhiQuenMatKhau(@RequestParam("maXN") String  maXacNhanTuClient, @RequestParam("emailHidden") String email, HttpSession session) {
		
		int loaiCongViecGuiEmail = Constant.LoaiCongViecGuiMaXN.LOAI_CONG_VIEC_GUI_MA_XN_EMAIL_QMK;
		khachHangService.xacNhanMaXacNhanEmailHoacDienThoai(maXacNhanTuClient, email, null,session, loaiCongViecGuiEmail);
		
		return "quen_matkhau";
	}
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_KHACH_HANG_XEM_LICHSU_MUAHANG)
	public String xemLichSuMuaHang(HttpSession session, Model model) {
		
		List<Object[]> listHoaDonAndKhachHang = khachHangService.xemLichSuMuaHang(session);
		model.addAttribute("ListHoaDonAndKhachHang", listHoaDonAndKhachHang);
		
		return "lichsu_muahang";
	}
}
