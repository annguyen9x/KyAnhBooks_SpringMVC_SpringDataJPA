package com.annguyen.kyanhbooks.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
		// TODO Auto-generated method stub
		return null;
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
	public List<Sach> dsSachTheoLoaiSach(String maLoaiSach) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sach> dsSachTheoTenSach(String tenSach) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Sach> dsTenSachTheoLoaiSach(String maLoaiSach) {
		
		return null;
	}

	@Override
	public Map<Integer, List<Sach>> hienThiSachTheoLoaiSach(String maLoaiSach) {
		List<Sach> sTen = this.dsTenSachTheoLoaiSach(maLoaiSach);
		if( sTen != null ) {
			Map<Integer, List<Sach>> mapSach = new HashMap<>();
			for(int i = 0; i < sTen.size(); i++ ) {
				List<Sach> sChiTiet = this.dsSachTheoTenSach(sTen.get(i).getTenSach());
				if(sChiTiet != null) {
					
					List<Sach> listSach = new ArrayList<>();
					for(int j = 0; j < sChiTiet.size(); j++) {
						Sach sach = new Sach();
						sach.setMaSach(sChiTiet.get(j).getMaSach());
						sach.setTenSach(sChiTiet.get(j).getTenSach());
						sach.setDonGia(sChiTiet.get(j).getDonGia());
						sach.setSoLuong(sChiTiet.get(j).getSoLuong());
						sach.setUrlHinh(sChiTiet.get(j).getUrlHinh());
						sach.setNoiDung(sChiTiet.get(j).getNoiDung());
						sach.setTacGia(sChiTiet.get(j).getTacGia());
						sach.setNamXB(sChiTiet.get(j).getNamXB());
						sach.setnXB(sChiTiet.get(j).getnXB());
						sach.setMaLoaiSach(sChiTiet.get(j).getMaLoaiSach());
						
						listSach.add(sach);
					}
					mapSach.put(i, listSach);
				}
			}
			return mapSach;
		}
		return null;
	}

	@Override
	public List<Sach> timKiemSach(String tenSach) {
		// TODO Auto-generated method stub
		return null;
	}

}
