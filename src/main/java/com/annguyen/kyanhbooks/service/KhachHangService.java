package com.annguyen.kyanhbooks.service;

import javax.servlet.http.HttpSession;

import com.annguyen.kyanhbooks.model.KhachHang;
import com.annguyen.kyanhbooks.util.myexception.ErrorConnectByInternet;
import com.annguyen.kyanhbooks.util.myexception.NotFoundException;

public interface KhachHangService {
	
	KhachHang dangNhap(String email, String matKhau, HttpSession session) throws NotFoundException;
	
	boolean dangKy(KhachHang khachHang);
	
	void dangXuat(HttpSession session);
	
	boolean capNhatTaiKhoan(KhachHang khachHang);
	
	void layMaXacNhanEmail(String tieuDe, String noiDung, String email, HttpSession session, int loaiCongViecGuiEmail) throws ErrorConnectByInternet; 
	
	void xacNhanMaXacNhanEmail(String  maXacNhanTuClient, String email, HttpSession session, int loaiCongViecGuiEmail); 
	
	KhachHang dangNhapKhiQuenMatKhau(String email);
}
