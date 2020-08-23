package com.annguyen.kyanhbooks.controller.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.annguyen.kyanhbooks.model.LoaiSach;
import com.annguyen.kyanhbooks.model.Sach;
import com.annguyen.kyanhbooks.service.LoaiSachService;
import com.annguyen.kyanhbooks.service.SachService;
import com.annguyen.kyanhbooks.util.Constant;

@Controller
public class TrangChuUserController {
	
	@Autowired
	private LoaiSachService loaiSachService;
	
	@Autowired
	private SachService sachService;
	
	@RequestMapping("/")
	public String trangChu(Model model) {
		List<LoaiSach> loaiSachs = loaiSachService.getDSLoaiSach();
		List<Sach> sachMoi = sachService.dsSachTheoLoaiDs( Constant.TrangChu.SACH_MOI_NUMBER, Constant.TrangChu.SACH_MOI);
		List<Sach> sachNoiBat = sachService.dsSachTheoLoaiDs( Constant.TrangChu.SACH_NOI_BAT_NUMBER, Constant.TrangChu.SACH_NOI_BAT);
		List<Sach> sachVanHocTrangChu = sachService.dsSachTheoLoaiDs( Constant.TrangChu.SACH_VAN_HOC_NUMBER, Constant.TrangChu.SACH_VAN_HOC);
		
		model.addAttribute("DSLoaiSach", loaiSachs);
		model.addAttribute("SachMoi", sachMoi);
		model.addAttribute("SachNoiBat", sachNoiBat);
		model.addAttribute("sachVanHocTrangChu", sachVanHocTrangChu);
		return "trangchu";
	}
	
	@RequestMapping(Constant.Path.KYANHBOOKS_ROOT_PATH_MENU_LOAISACH + Constant.Path.USER_CONTROLLER_MENU_NGANG + "/{menuNgangId}")
	public String chiTietMenuNgang(@PathVariable int  menuNgangId, Model model) {
		String viewResult = "";
		if(menuNgangId == Constant.MenuNgang.GIOI_THIEU_NUMBER ) {
			model.addAttribute("menuNgangId", Constant.MenuNgang.GIOI_THIEU_NUMBER);
			viewResult = "gioi_thieu";
		}
		if(menuNgangId == Constant.MenuNgang.DICH_VU_NUMBER ) {
			model.addAttribute("menuNgangId", Constant.MenuNgang.DICH_VU_NUMBER);
			viewResult = "dich_vu";
		}
		if(menuNgangId == Constant.MenuNgang.HUONG_DAN_MUA_HANG_NUMBER ) {
			model.addAttribute("menuNgangId", Constant.MenuNgang.HUONG_DAN_MUA_HANG_NUMBER);
			viewResult = "huongdan_muahang";
		}
		if(menuNgangId == Constant.MenuNgang.LIEN_HE_NUMBER ) {
			model.addAttribute("menuNgangId", Constant.MenuNgang.LIEN_HE_NUMBER);
			viewResult = "lien_he";
		}
		return viewResult;
	}
	
}
