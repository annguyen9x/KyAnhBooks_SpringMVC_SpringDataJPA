package com.annguyen.kyanhbooks.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annguyen.kyanhbooks.model.KhachHang;
import com.annguyen.kyanhbooks.repository.KhachHangRepository;
import com.annguyen.kyanhbooks.service.KhachHangService;
import com.annguyen.kyanhbooks.util.Constant;
import com.annguyen.kyanhbooks.util.GuiMail;
import com.annguyen.kyanhbooks.util.MaHoaMD5;
import com.annguyen.kyanhbooks.util.RandomSoNguyen;
import com.annguyen.kyanhbooks.util.myexception.ErrorConnectByInternet;
import com.annguyen.kyanhbooks.util.myexception.NotFoundException;

@Service
public class KhachHangServiceImpl implements KhachHangService {
	
	@Autowired
	private KhachHangRepository khachHangRepository;

	@Override
	public KhachHang dangNhap(String email, String matKhau, HttpSession session) throws NotFoundException {
		String matKhauMD5 = MaHoaMD5.mahoaMD5(matKhau);
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
	public boolean dangKy(KhachHang khachHang) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public KhachHang dangNhapKhiQuenMatKhau(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dangXuat(HttpSession session) {
		if( session.getAttribute("KhachHang") != null ) {
			session.removeAttribute("KhachHang");
		}
	}

	@Override
	public boolean capNhatTaiKhoan(KhachHang khachHang) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void layMaXacNhanEmail(String tieuDe, String noiDung, String email, HttpSession session, int loaiCongViecGuiEmail) throws ErrorConnectByInternet {
		
		KhachHang khachHang	= khachHangRepository.findKhachHangByEmail(email);
		
		if( khachHang != null ) {
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
			}else {
				throw new ErrorConnectByInternet("Lỗi (kết nối internet) khi gửi mail xác nhận từ server !!!");
			}
		}else {
			if( loaiCongViecGuiEmail == Constant.Email.LOAI_CONG_VIEC_GUI_EMAIL_QMK ) {
				session.setAttribute("KiemTraEmailDangNhap", "EmailKhongTonTai");
			}
		}
	}

	@Override
	public void xacNhanMaXacNhanEmail(String maXacNhanTuClient, String email, HttpSession session, int loaiCongViecGuiEmail) {
		String maXacNhanTuServer = (String)session.getAttribute("MaXacNhanQMK");
		
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
		}
		else {
			if( loaiCongViecGuiEmail == Constant.Email.LOAI_CONG_VIEC_GUI_EMAIL_QMK ) {
				session.setAttribute("xacNhanDangNhapQMK", "mxnSai");
			}
		}
		
	}

}
