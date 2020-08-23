package com.annguyen.kyanhbooks.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.annguyen.kyanhbooks.model.Sach;
import com.annguyen.kyanhbooks.repository.SachRepository;
import com.annguyen.kyanhbooks.service.SachService;
import com.annguyen.kyanhbooks.util.Constant;

@Service
public class SachServiceImpl implements SachService {
	
	@Autowired
	private SachRepository sachRepository;
	
	@Override
	public boolean insert(Sach sach) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Sach sach) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateSoLuong(int soLuong, String maSach) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String maSach) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Sach getSachTheoMaSach(String maSach) {
		Sach sach = sachRepository.findSachByMaSach(maSach);
		return sach;
	}

	@Override
	public List<Sach> dsSach() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sach> dsSachTheoLoaiDs(int soLuong, String loaiDsSach) {
		List<Sach> sachs = null;
		if( loaiDsSach.equals(Constant.TrangChu.SACH_MOI) ) {
			sachs = sachRepository.dsSachMoiTrangChu(soLuong);
		}
		else if( loaiDsSach.equals(Constant.TrangChu.SACH_NOI_BAT) ) {
			sachs = sachRepository.dsSachNoiBatTrangChu(soLuong);
		}
		else if( loaiDsSach.equals(Constant.TrangChu.SACH_VAN_HOC) ) {
			sachs = sachRepository.dsSachTheoMaLoaiSach(Constant.TrangChu.MA_LOAI_SACH_VAN_HOC, soLuong);
		}
		
		return sachs;
	}
	
	@Override
	public long conutSachTheoLoaiSach(String maLoaiSach) {
		long totalSachTheoLoaiSach = 0;
		totalSachTheoLoaiSach = sachRepository.countSachByMaLoaiSach(maLoaiSach);
		
		return totalSachTheoLoaiSach;
	}

	@Override
	public List<Sach> dsSachTheoLoaiSach(String maLoaiSach, Pageable pageable) {
		List<Sach> sachs = null;
		sachs = sachRepository.findSachByMaLoaiSach(maLoaiSach, pageable);
		return sachs;
	}

	@Override
	public List<Sach> dsSachTheoTenSach(String tenSach) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Sach> timKiemSach(String tenSach) {
		// TODO Auto-generated method stub
		return null;
	}

}
