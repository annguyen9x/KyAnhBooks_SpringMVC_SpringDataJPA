package com.annguyen.kyanhbooks.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.annguyen.kyanhbooks.model.GioHang;
import com.annguyen.kyanhbooks.model.KhachHang;
import com.annguyen.kyanhbooks.util.myexception.ErrorConnectByInternet;
import com.annguyen.kyanhbooks.util.myexception.NotFoundException;

public interface GioHangService {
	
	boolean insertGioHang(GioHang gioHang);
	
	boolean updateGioHang(GioHang gioHang);
	
	boolean deleteGioHang(String sessionIdGH);
	
	boolean setSessionIdForCookieGioHang(GioHang gioHang, HttpServletResponse response);
	
	boolean taoGioHangSession(GioHang gioHang, List<Object[]> chiTietGioHangAndSanPhams, HttpSession session);
	
	boolean taoGioHang(KhachHang khachHang, String dienThoaiKhachVangLai, String tenKhachVangLai, List<Object[]> chiTietGioHangAndSanPhams, HttpSession session, HttpServletResponse response);
	
	boolean themSpVaoGioHang(KhachHang khachHang, String jSessionIdGhCookie, HttpSession session);
	
	GioHang capNhatGioHang(GioHang gioHang);
	
	boolean xemGioHangTheoSessionIdOrLoginOrDienThoai(KhachHang khachHang, String jSessionIdGhCookie, String dienThoaiKhachVangLai, String tenKhachVangLai, HttpSession session, HttpServletResponse response);
	
	void dangNhapXemGioHang(String email, String matKhau, HttpSession session, HttpServletResponse response) throws NotFoundException;
	
	boolean guiMaXacNhanSDT(String tieuDe, String noiDung, String sdt, HttpSession session) throws ErrorConnectByInternet;
	
	boolean xacNhanMaXnSdtXemGioHang(String maXnTuClient, String dienThoai, String tenKH, HttpSession session, HttpServletResponse response);
}
