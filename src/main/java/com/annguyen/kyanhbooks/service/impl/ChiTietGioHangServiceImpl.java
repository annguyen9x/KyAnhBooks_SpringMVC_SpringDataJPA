package com.annguyen.kyanhbooks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annguyen.kyanhbooks.model.ChiTietGioHang;
import com.annguyen.kyanhbooks.model.ChiTietGioHangPrimaryKey;
import com.annguyen.kyanhbooks.repository.ChiTietGioHangRepository;
import com.annguyen.kyanhbooks.service.ChiTietGioHangService;

@Service
public class ChiTietGioHangServiceImpl implements ChiTietGioHangService{

	@Autowired
	private ChiTietGioHangRepository chiTietGioHangRepository;
	
	@Override
	public boolean insertChiTietGioHang(ChiTietGioHang chiTietGioHang) {
		chiTietGioHangRepository.save(chiTietGioHang);
		return true;
	}

	@Override
	public boolean updateChiTietGioHang(ChiTietGioHang chiTietGioHang) {
		chiTietGioHangRepository.save(chiTietGioHang);
		return true;
	}

	@Override
	public boolean deleteChiTietGioHang(ChiTietGioHangPrimaryKey chiTietGioHangPrimaryKey) {
		chiTietGioHangRepository.delete(chiTietGioHangPrimaryKey);
		return true;
	}

}
