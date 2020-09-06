package com.annguyen.kyanhbooks.service;

import com.annguyen.kyanhbooks.model.ChiTietGioHang;
import com.annguyen.kyanhbooks.model.ChiTietGioHangPrimaryKey;

public interface ChiTietGioHangService {
	
	boolean insertChiTietGioHang(ChiTietGioHang chiTietGioHang);
	
	boolean updateChiTietGioHang(ChiTietGioHang chiTietGioHang);
	
	boolean deleteChiTietGioHang(ChiTietGioHangPrimaryKey chiTietGioHangPrimaryKey);
}
