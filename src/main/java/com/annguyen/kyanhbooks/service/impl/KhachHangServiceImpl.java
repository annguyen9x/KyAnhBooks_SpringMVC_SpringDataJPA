package com.annguyen.kyanhbooks.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.annguyen.kyanhbooks.model.KhachHang;
import com.annguyen.kyanhbooks.repository.KhachHangRepository;
import com.annguyen.kyanhbooks.service.KhachHangService;
import com.annguyen.kyanhbooks.util.Constant;
import com.annguyen.kyanhbooks.util.DinhDang;
import com.annguyen.kyanhbooks.util.GuiMail;
import com.annguyen.kyanhbooks.util.KiemTraNgayThang;
import com.annguyen.kyanhbooks.util.MaHoaMD5;
import com.annguyen.kyanhbooks.util.RandomSoNguyen;
import com.annguyen.kyanhbooks.util.myexception.ErrorConnectByInternet;
import com.annguyen.kyanhbooks.util.myexception.NotFoundException;

@Service
public class KhachHangServiceImpl implements KhachHangService {
	
	@Autowired
	private KhachHangRepository khachHangRepository;
	
	@Override
	public boolean insertKhachHang(KhachHang khachHang) {
			khachHangRepository.save(khachHang);
		return true;
	}

	@Override
	public boolean updateKhachHang(KhachHang khachHang) {
			khachHangRepository.save(khachHang);
		return true;
	}
	
	@Override
	public KhachHang dangNhap(String email, String matKhau, HttpSession session) throws NotFoundException {
		String matKhauMD5 = MaHoaMD5.MahoaMD5(matKhau);
		KhachHang khachHang = khachHangRepository.findKhachHangByEmail(email);
		if(khachHang == null ) {
			throw new NotFoundException("Email không chính xác !");
		}
		else if(khachHang != null && !khachHang.getMatKhau().equals(matKhauMD5) ) {
			throw new NotFoundException("Mật khẩu không đúng !");
		}
		else {
			session.setAttribute("KhachHang", khachHang);
		}
		
		return khachHang;
	}
	
	@Override
	public KhachHang tuDongDangNhap(int maKH, HttpSession session) {
		KhachHang khachHang = khachHangRepository.getOne(maKH);
		session.setAttribute("KhachHang", khachHang);
		
		return khachHang;
	}

	@Override
	public boolean dangKy(KhachHang khachHang, String namSinh, String thangSinh, String ngaySinh, HttpSession session, Model model) {
		
		Date ngaySinhDate = null;
		String tenKH = khachHang.getTenKH();
		String matKhau = MaHoaMD5.MahoaMD5(khachHang.getMatKhau());
		String email = khachHang.getEmail();
		String dienThoai = khachHang.getDienThoai();
		String gioiTinh = khachHang.getGioiTinh();
		String diaChi = khachHang.getDiaChi();	
		String strNgaySinh = namSinh+ "-" + thangSinh + "-" + ngaySinh;

		if(khachHangRepository.findKhachHangByEmail(email) != null) {
			session.setAttribute("errorEmail", "Email \""+email +"\" đã đăng ký tài khoản, vui lòng nhập email khác !");
			return false;
		}
		else if(khachHangRepository.findKhachHangByDienThoai(dienThoai) != null) {
			session.setAttribute("errorDienthoai", "Điện thoại \""+ dienThoai +"\" đã đăng ký tài khoản, vui lòng chọn số khác !");
			return false;
		}
		else {
			if( tenKH.length() >= 2 && matKhau.length() >= 6 && email.length() > 0 && dienThoai.length() >= 10 && !gioiTinh.equals("") 
				&& KiemTraNgayThang.ktNgayThang(strNgaySinh, Constant.NgayThang.DATE_TIME_US) == true && !diaChi.equals("")) {
				
				ngaySinhDate = DinhDang.MyDateFormat(strNgaySinh, Constant.NgayThang.DATE_TIME_US);
				khachHang.setNgaySinh(ngaySinhDate);
				khachHang.setMatKhau(matKhau);
				
				session.setAttribute("TaiKhoanDK", khachHang);

				return true;
			}
			else {
				session.setAttribute("errorThongTinDangKy", "Thông tin đăng ký không chính xác, vui lòng thử lại !");
				return false;
			}
		}
			
	}

	@Override
	public void dangXuat(HttpSession session) {
		if( session.getAttribute("KhachHang") != null ) {
			session.removeAttribute("KhachHang");
		}
	}

	@Override
	public boolean capNhatTaiKhoan(KhachHang khachHang, String namSinh, String thangSinh, String ngaySinh, HttpSession session, Model model) {
		Date ngaySinhDate = null;
		String tenKH = khachHang.getTenKH();
		String matKhau = MaHoaMD5.MahoaMD5(khachHang.getMatKhau());
		String email = khachHang.getEmail();
		String dienThoai = khachHang.getDienThoai();
		String gioiTinh = khachHang.getGioiTinh();
		String diaChi = khachHang.getDiaChi();	
		String strNgaySinh = namSinh+ "-" + thangSinh + "-" + ngaySinh;
		
		if( session.getAttribute("errorThongTinCapNhat") != null ){
			session.removeAttribute("errorThongTinCapNhat");
		}
		if( session.getAttribute("thanhCong") != null ){
			session.removeAttribute("thatBai");
		}
		if( session.getAttribute("thatBai") != null ){
			session.removeAttribute("thatBai");
		}

		if( tenKH.length() >= 2 && matKhau.length() >= 6 && email.length() > 0 && dienThoai.length() >= 10 && !gioiTinh.equals("") 
			&& KiemTraNgayThang.ktNgayThang(strNgaySinh, Constant.NgayThang.DATE_TIME_US) == true && !diaChi.equals("")) {
			
			ngaySinhDate = DinhDang.MyDateFormat(strNgaySinh, Constant.NgayThang.DATE_TIME_US);
			khachHang.setNgaySinh(ngaySinhDate);
			khachHang.setMatKhau(matKhau);
			
			if( updateKhachHang(khachHang) == true ) {
				session.setAttribute("thanhCong", "Cập nhật thông tin tài khoản thành công.");
				session.setAttribute("KhachHang", khachHang);
			}else {
				session.setAttribute("thatBai", "Cập nhật thông tin tài khoản thất bại !!!");
			}

			return true;
		}
		else {
			session.setAttribute("errorThongTinCapNhat", "Thông tin cập nhật không chính xác, vui lòng thử lại !");
			return false;
		}
		
	}

	@Override
	public boolean layMaXacNhanEmail(String tieuDe, String noiDung, String email, HttpSession session, int loaiCongViecGuiEmail) throws ErrorConnectByInternet {
		
		KhachHang khachHang	= null;
		if( loaiCongViecGuiEmail == Constant.Email.LOAI_CONG_VIEC_GUI_EMAIL_QMK ) {
			khachHang	= khachHangRepository.findKhachHangByEmail(email);
			if( khachHang == null ) {
				session.setAttribute("KiemTraEmailDangNhap", "EmailKhongTonTai");
				return false;
			}
		}
		
		String emailShop = Constant.CauHinh.GIA_TRI_EMAIL_SHOP;
		String matKhauEmailShop = Constant.CauHinh.GIA_TRI_MATKHAU_EMAIL_SHOP;
		
		String maXacNhan = String.valueOf(RandomSoNguyen.randomSoNguyen());
		noiDung += maXacNhan;
		
		if( GuiMail.guiMail(email, tieuDe, noiDung, emailShop, matKhauEmailShop) == true ) {
			System.out.println("layMaXacNhanEmail-maXacNhanTuServer: " + maXacNhan);
			
			if( loaiCongViecGuiEmail == Constant.Email.LOAI_CONG_VIEC_GUI_EMAIL_QMK ) {
				session.setAttribute("MaXacNhanQMK", maXacNhan);
				session.setAttribute("Email", email);
				session.setAttribute("KhachHang"+ maXacNhan, khachHang);
				session.setAttribute("KiemTraEmailDangNhap", "EmailTonTai");
			}
			else if( loaiCongViecGuiEmail == Constant.Email.LOAI_CONG_VIEC_GUI_EMAIL_XNDK ) {
				session.setAttribute("MaXacNhan", maXacNhan);
			}
		}else {
			throw new ErrorConnectByInternet("Lỗi (kết nối internet) khi gửi mail xác nhận từ server !!!");
		}
		
		return true;
	}

	@Override
	public boolean xacNhanMaXacNhanEmail(String maXacNhanTuClient, String email, HttpSession session, int loaiCongViecGuiEmail) {
		String maXacNhanTuServer = "";
		if( loaiCongViecGuiEmail == Constant.Email.LOAI_CONG_VIEC_GUI_EMAIL_QMK ) {
			maXacNhanTuServer = (String)session.getAttribute("MaXacNhanQMK");
		}
		else if( loaiCongViecGuiEmail == Constant.Email.LOAI_CONG_VIEC_GUI_EMAIL_XNDK ) {
			maXacNhanTuServer = (String)session.getAttribute("MaXacNhan");
		}
		
		if(maXacNhanTuServer.equals(maXacNhanTuClient)) {
			
			if( loaiCongViecGuiEmail == Constant.Email.LOAI_CONG_VIEC_GUI_EMAIL_QMK ) {
				session.setAttribute("xacNhanDangNhapQMK", "mxnChinhXac");
				if( session.getAttribute("KhachHang" + maXacNhanTuServer) != null ) {
					KhachHang khachHang = (KhachHang)session.getAttribute("KhachHang" + maXacNhanTuServer);
					session.setAttribute("KhachHang", khachHang);
					session.removeAttribute("KhachHang" + maXacNhanTuServer);
				}
				
				if( session.getAttribute("KiemTraEmailDangNhap") != null ) {
					session.removeAttribute("KiemTraEmailDangNhap");
				}
			}
			else if( loaiCongViecGuiEmail == Constant.Email.LOAI_CONG_VIEC_GUI_EMAIL_XNDK ) {
				KhachHang khachHang = (KhachHang)session.getAttribute("TaiKhoanDK");
				if( insertKhachHang(khachHang) == true ) {
					session.setAttribute("dKThanhCong", "Đăng ký tài khoản khách hàng thành công.");
					session.removeAttribute("TaiKhoanDK");
				}else {
					session.setAttribute("dKThatBai", "Đăng ký tài khoản khách hàng thất bại !!!");
				}
				session.removeAttribute("MaXacNhan");
			}
		}
		else {
			if( loaiCongViecGuiEmail == Constant.Email.LOAI_CONG_VIEC_GUI_EMAIL_QMK ) {
				session.setAttribute("xacNhanDangNhapQMK", "mxnSai");
			}
			else if( loaiCongViecGuiEmail == Constant.Email.LOAI_CONG_VIEC_GUI_EMAIL_XNDK ) {
				session.setAttribute("maXacNhanDKSai", "Mã xác nhận không chính xác, mời nhập lại !");
			}
		}
		
		return true;
	}

	@Override
	public List<Object[]> xemLichSuMuaHang(HttpSession session) {
		List<Object[]> list = null;
		KhachHang khachHang = (KhachHang)session.getAttribute("KhachHang");
		int maKH = khachHang.getMaKH();
		list = khachHangRepository.findHoaDonAndKhachHangByMaKH(maKH);
		
		return list;
	}

}
