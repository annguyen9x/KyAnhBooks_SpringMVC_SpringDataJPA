package com.annguyen.kyanhbooks.service;

import com.annguyen.kyanhbooks.model.GioHang;
import com.annguyen.kyanhbooks.model.KhachHang;
import com.annguyen.kyanhbooks.repository.GioHangRepository;

public interface GioHangService {
	
	GioHang xemGioHang(String sessionIdCookie, int maKH);
	
	boolean taoGioHang();
}
