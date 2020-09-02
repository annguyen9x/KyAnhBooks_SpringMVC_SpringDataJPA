package com.annguyen.kyanhbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.annguyen.kyanhbooks.model.GioHang;

public interface GioHangRepository extends JpaRepository<GioHang, Integer>{
	
	GioHang findGioHangBySessionIdGH(String sessionIdGH);
}
