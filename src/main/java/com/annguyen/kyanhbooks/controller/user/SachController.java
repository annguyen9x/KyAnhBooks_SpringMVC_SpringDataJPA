package com.annguyen.kyanhbooks.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.annguyen.kyanhbooks.model.LoaiSach;
import com.annguyen.kyanhbooks.model.Sach;
import com.annguyen.kyanhbooks.service.LoaiSachService;
import com.annguyen.kyanhbooks.service.SachService;
import com.annguyen.kyanhbooks.util.Constant;

@Controller
@RequestMapping(value = Constant.Path.KYANHBOOKS_ROOT_PATH_MENU_LOAISACH)
public class SachController {
	
	@Autowired
	private SachService sachService;
	
	@Autowired
	private LoaiSachService loaiSachService;
	
	@RequestMapping(Constant.Path.USER_CONTROLLER_SACH_THEO_LOAISACH)
	public String sachTheoLoaiSach(@RequestParam("MaLS") String maLoaiSach, Model model) {
		List<Sach> sachs = sachService.dsSachTheoLoaiSach(maLoaiSach);
		List<Sach> sachNoiBat = sachService.dsSachTheoLoaiDs( Constant.TrangChu.SACH_NOI_BAT_NUMBER, Constant.TrangChu.SACH_NOI_BAT);
		LoaiSach loaiSach = loaiSachService.getLoaiSach(maLoaiSach);
		
		model.addAttribute("SachTheoLoaiSach", sachs);
		model.addAttribute("SachNoiBat", sachNoiBat);
		model.addAttribute("LoaiSach", loaiSach);
		
		return "sp_cungloai";
	}
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_CHI_TIET_SP) 
	public String chiTietSanPham(@RequestParam("MaSach") String maSach, Model model) {
		Sach sach = sachService.getSachTheoMaSach(maSach);
		List<Sach> sachNoiBat = sachService.dsSachTheoLoaiDs( Constant.TrangChu.SACH_NOI_BAT_NUMBER, Constant.TrangChu.SACH_NOI_BAT);
		LoaiSach loaiSach = loaiSachService.getLoaiSach(sach.getMaLoaiSach());
		
		model.addAttribute("Sach", sach);
		model.addAttribute("SachNoiBat", sachNoiBat);
		model.addAttribute("LoaiSach", loaiSach);
		
		return "chitiet_sp";
	}
}
