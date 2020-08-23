package com.annguyen.kyanhbooks.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
		int page = Constant.CauHinh.GIA_TRI_PAGE_FIRST_DEFAULT;
		int limit = Constant.CauHinh.GIA_TRI_LIMIT_SP_THEO_LOAISP;
		Pageable pageable = new PageRequest(page - 1, limit);
		long totalCountLoaiSach = sachService.conutSachTheoLoaiSach(maLoaiSach);
		long totalPageLoaiSach = (totalCountLoaiSach%limit) == 0 ? (totalCountLoaiSach/limit) : (totalCountLoaiSach/limit) + 1;
		
		List<Sach> sachs = sachService.dsSachTheoLoaiSach(maLoaiSach, pageable);
		List<Sach> sachNoiBat = sachService.dsSachTheoLoaiDs(Constant.TrangChu.SACH_NOI_BAT_NUMBER, Constant.TrangChu.SACH_NOI_BAT);
		LoaiSach loaiSach = loaiSachService.getLoaiSach(maLoaiSach);
		
		model.addAttribute("TotalCountLoaiSach", totalCountLoaiSach);
		model.addAttribute("TotalPageLoaiSach", totalPageLoaiSach);
		model.addAttribute("CurrentPage", page);
		model.addAttribute("Limit", limit);
		
		model.addAttribute("SachTheoLoaiSach", sachs);
		model.addAttribute("SachNoiBat", sachNoiBat);
		model.addAttribute("LoaiSach", loaiSach);
		
		return "sp_cungloai";
	}
	
	@RequestMapping(Constant.Path.USER_CONTROLLER_PHAN_TRANG_SACH_THEO_LOAISACH)
	public String phanTrangSPTheoLoaiSP(@RequestParam("MaLS") String maLoaiSach, @RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
		if(limit == 0 ) {
			limit = Constant.CauHinh.GIA_TRI_LIMIT_SP_THEO_LOAISP;
		}
		
		Pageable pageable = new PageRequest(page - 1, limit);
		long totalCountLoaiSach = sachService.conutSachTheoLoaiSach(maLoaiSach);
		long totalPageLoaiSach = (totalCountLoaiSach%limit) == 0 ? (totalCountLoaiSach/limit) : (totalCountLoaiSach/limit) + 1;
		
		List<Sach> sachs = sachService.dsSachTheoLoaiSach(maLoaiSach, pageable);
		
		model.addAttribute("TotalCountLoaiSach", totalCountLoaiSach);
		model.addAttribute("TotalPageLoaiSach", totalPageLoaiSach);
		model.addAttribute("CurrentPage", page);
		model.addAttribute("Limit", limit);
		
		model.addAttribute("SachTheoLoaiSach", sachs);

		return "block_danhsach_sp_cungloai";
	}
	
	@RequestMapping(value = "/" + Constant.Path.USER_CONTROLLER_CHI_TIET_SP) 
	public String chiTietSanPham(@RequestParam("MaSach") String maSach, Model model) {
		Sach sach = sachService.getSachTheoMaSach(maSach);
		model.addAttribute("Sach", sach);
		
		return "chitiet_sp";
	}
}
