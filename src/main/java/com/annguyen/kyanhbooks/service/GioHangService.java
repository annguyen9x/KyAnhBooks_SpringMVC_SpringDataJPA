package com.annguyen.kyanhbooks.service;

import javax.servlet.http.HttpSession;

import com.annguyen.kyanhbooks.model.GioHang;
import com.annguyen.kyanhbooks.model.KhachHang;
import com.annguyen.kyanhbooks.util.myexception.NotFoundException;

public interface GioHangService {
	
	boolean insertGioHang(GioHang gioHang);
	
	boolean updateGioHang(GioHang gioHang);
	
	boolean deleteGioHang(String sessionIdDienThoai);
	
	GioHang taoGioHang(KhachHang khachHang, String dienThoaiKhachVangLai, String tenKhachVangLai, GioHang gioHang);
	
	boolean themSpVaoGioHang(KhachHang khachHang, String jSessionIdGhCookie, HttpSession session);
	
	GioHang capNhatGioHang(GioHang gioHang);
	
	void xemGioHangTheoSessionIdOrLogin(KhachHang khachHang, String jSessionIdGhCookie, HttpSession session);
	
	void dangNhapXemGioHang(String email, String matKhau, HttpSession session) throws NotFoundException;
}
