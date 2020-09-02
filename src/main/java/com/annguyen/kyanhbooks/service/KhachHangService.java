package com.annguyen.kyanhbooks.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.annguyen.kyanhbooks.model.KhachHang;
import com.annguyen.kyanhbooks.util.myexception.ErrorConnectByInternet;
import com.annguyen.kyanhbooks.util.myexception.NotFoundException;

public interface KhachHangService {
	
	KhachHang dangNhap(String email, String matKhau, HttpSession session) throws NotFoundException;
	
	KhachHang tuDongDangNhap(int maKH, HttpSession session);
	
	boolean insertKhachHang(KhachHang khachHang);
	
	boolean updateKhachHang(KhachHang khachHang);
	
	boolean dangKy(KhachHang khachHang, String namSinh, String thangSinh, String ngaySinh, HttpSession session, Model model);
	
	boolean capNhatTaiKhoan(KhachHang khachHang, String namSinh, String thangSinh, String ngaySinh, HttpSession session, Model model);
	
	void dangXuat(HttpSession session);
	
	boolean layMaXacNhanEmail(String tieuDe, String noiDung, String email, HttpSession session, int loaiCongViecGuiEmail) throws ErrorConnectByInternet; 
	
	boolean xacNhanMaXacNhanEmail(String  maXacNhanTuClient, String email, HttpSession session, int loaiCongViecGuiEmail); 
	
	List<Object[]> xemLichSuMuaHang(HttpSession session);
	
}
