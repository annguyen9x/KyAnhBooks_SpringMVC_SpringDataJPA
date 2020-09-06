package com.annguyen.kyanhbooks.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.annguyen.kyanhbooks.model.GioHang;

public interface GioHangRepository extends JpaRepository<GioHang, String>{
	
	GioHang findGioHangBySessionIdGH(String sessionIdGH);
	
	@Query(nativeQuery = true, value = "INSERT INTO GioHang "
			+ "Values(?, ?, ?, ?, ?, ?, ?, ?, ?) ")
	boolean insertGioHang(String SessionIdGH, boolean DaXoa, String DiaChi, String DienThoai, int MaKH, Date NgayCapNhat, Date NgayTao, int SoHD, String TenKH);
}
