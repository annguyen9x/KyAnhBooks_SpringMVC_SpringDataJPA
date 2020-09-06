package com.annguyen.kyanhbooks.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annguyen.kyanhbooks.model.ChiTietGioHang;
import com.annguyen.kyanhbooks.model.GioHang;
import com.annguyen.kyanhbooks.model.KhachHang;
import com.annguyen.kyanhbooks.repository.ChiTietGioHangRepository;
import com.annguyen.kyanhbooks.repository.GioHangRepository;
import com.annguyen.kyanhbooks.service.ChiTietGioHangService;
import com.annguyen.kyanhbooks.service.GioHangService;
import com.annguyen.kyanhbooks.service.KhachHangService;
import com.annguyen.kyanhbooks.util.Constant;
import com.annguyen.kyanhbooks.util.GuiMail;
import com.annguyen.kyanhbooks.util.RandomSoNguyen;
import com.annguyen.kyanhbooks.util.myexception.ErrorConnectByInternet;
import com.annguyen.kyanhbooks.util.myexception.NotFoundException;

@Service
public class GioHangServiceImpl implements GioHangService{
	
	@Autowired
	private GioHangRepository gioHangRepository;
	@Autowired
	private ChiTietGioHangRepository chiTietGioHangRepository;
	@Autowired
	private KhachHangService khachHangService;
	
//	@Override
//	public GioHang taoGioHang() {

		//Máy khách (client): Set Session Id to Cookie
//		HttpPost httppost = new HttpPost(postData); 
//		CookieStore cookieStore = new BasicCookieStore(); 
//		BasicClientCookie cookie = new BasicClientCookie("JSESSIONID", getSessionId());
//
//		//cookie.setDomain("your domain");
//		cookie.setPath("/");
//
//		cookieStore.addCookie(cookie); 
//		client.setCookieStore(cookieStore); 
//		response = client.execute(httppost);
		
		//Máy chủ(Server); Check sessionId từ request
		//public static final String JSESSIONID = "JSESSIONID";
//		Cookie[] cs = super.getCookies();
//        List<Cookie> cokRet = new ArrayList<Cookie>(cs.length);
//        for (Cookie c : cs)
//        {
//            if (c.getName().equalsIgnoreCase(JSESSIONID)) {
//            	//Có sessionid từ request
//            }
//        }
//		return null;
//	}
	
	//Set Cookie từ Client-sau phải dùng ở JSP ?
//	@RequestMapping(value = {"/news"}, method = RequestMethod.GET)
//	public ModelAndView news(Locale locale, Model model, HttpServletResponse response, HttpServletRequest request) throws Exception {
//
//	    ...
//	    response.setHeader("Set-Cookie", "test=value; Path=/");
//	    ...
//
//	    modelAndView.setViewName("path/to/my/view");
//	    return modelAndView;
//	}
	
	//Get COOKIE Ở Server
//	@RequestMapping("/hello")
//	public String hello(@CookieValue("foo") String fooCookie) {
//	    // ...
//	}
	
	@Override
	public boolean insertGioHang(GioHang gioHang) {
		//save() sẽ Select để lấy ra xem có Object không trước khi update, 
		//persist() thì insert luôn mà không select,
		//hoặc class GioHang kế thừa Persistable và hàm isNew trả về true để mặc định new Object
		//=> tăng hiệu suất, nhưng lại bị nhược điểm là không thể lưu Session nếu implement Persistable 
		gioHangRepository.save(gioHang);
		return true;
	}

	@Override
	public boolean updateGioHang(GioHang gioHang) {
		//save() sẽ Select để lấy ra xem có Object không trước khi update, 
		//persist() thì insert luôn mà không select,
		//hoặc class GioHang kế thừa Persistable và hàm isNew trả về true để mặc định new Object
		//=> tăng hiệu suất, nhưng lại bị nhược điểm là không thể lưu Session nếu implement Persistable
		gioHangRepository.save(gioHang);
		return true;
	}

	@Override
	public boolean deleteGioHang(String sessionIdGH) {
		gioHangRepository.delete(sessionIdGH);
		return true;
	}
	
	@Override
	public boolean setSessionIdForCookieGioHang(GioHang gioHang, HttpServletResponse response) {
		if( gioHang != null && gioHang.getSessionIdGH() != null ) {
			System.out.println("gioHang.getSessionIdGH(): " + gioHang.getSessionIdGH());
			String sessionIdGH = gioHang.getSessionIdGH();
			Cookie cookie = new Cookie(Constant.GioHang.JSESSIONID, sessionIdGH);
			response.addCookie(cookie);
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean taoGioHangSession(GioHang gioHang, List<Object[]> chiTietGioHangAndSanPhams, HttpSession session) {
		Map<String, Object> gioHangMap = new HashMap<>();
		int tongSLSptrongGH = 0;
		gioHangMap.put("GioHang", gioHang);
		gioHangMap.put("ChiTietGioHangAndSanPhams", chiTietGioHangAndSanPhams);
		for(int i = 0; chiTietGioHangAndSanPhams != null && i < chiTietGioHangAndSanPhams.size(); i++ ) {
			tongSLSptrongGH += Integer.parseInt(chiTietGioHangAndSanPhams.get(i)[2].toString());
		}
		gioHangMap.put(Constant.GioHang.GIOHANG_TONG_SP_TRONG_GH, tongSLSptrongGH);
		session.setAttribute(Constant.GioHang.GIOHANG_SESSION, gioHangMap);
		
		return true;
	}
	
	@Override
	public boolean taoGioHang(KhachHang khachHang, String dienThoaiKhachVangLai, String tenKhachVangLai, List<Object[]> chiTietGioHangAndSanPhams, HttpSession session, HttpServletResponse response) {
		GioHang gioHangNew = null;
		ChiTietGioHang chiTietGioHangNew = null;
		ChiTietGioHangService chiTietGioHangService = new ChiTietGioHangServiceImpl();
		String sessionIdGH = "";
		int maKH = 0;
		String tenKH = "";
		String dienThoai = "";
		Date ngayTao = new Date();
		String maSach = "";
		int soLuong = 0;
		float donGia = 0;
		boolean isMuaHangBangDienThoaiTrue = ( dienThoaiKhachVangLai != null && !dienThoaiKhachVangLai.equals("") && tenKhachVangLai != null && !tenKhachVangLai.equals("") ) ? true : false; 
		
		if( khachHang == null && isMuaHangBangDienThoaiTrue == false ){
			return false;
		}
		else if( khachHang != null && khachHang.getMaKH() != 0) {
			maKH = khachHang.getMaKH();
			tenKH = khachHang.getTenKH();
			dienThoai = khachHang.getDienThoai();
			
			sessionIdGH = Constant.GioHang.TIENTO_JSESSIONID + maKH;
			gioHangNew = new GioHang(sessionIdGH, maKH, tenKH, dienThoai, ngayTao);
		}
		else if( isMuaHangBangDienThoaiTrue == true ) {
			tenKH = tenKhachVangLai;
			dienThoai = dienThoaiKhachVangLai;
			
			sessionIdGH = Constant.GioHang.TIENTO_JSESSIONID + dienThoaiKhachVangLai;
			gioHangNew = new GioHang(sessionIdGH, maKH, tenKH, dienThoai, ngayTao);
		}
		
		//Insert GH to DB
		insertGioHang(gioHangNew);
		
		//Insert ChiTietGH to DB
		for(int i = 0; chiTietGioHangAndSanPhams != null && i < chiTietGioHangAndSanPhams.size(); i++ ) {
			Object[] objectChiTietGioHangAndSanPham = chiTietGioHangAndSanPhams.get(i);
			if( objectChiTietGioHangAndSanPham != null ) {
				maSach = objectChiTietGioHangAndSanPham[0].toString();
				donGia = Float.parseFloat(objectChiTietGioHangAndSanPham[1].toString());
				soLuong = Integer.parseInt(objectChiTietGioHangAndSanPham[2].toString());
				chiTietGioHangNew = new ChiTietGioHang(maSach, sessionIdGH, soLuong, donGia);
				chiTietGioHangService.insertChiTietGioHang(chiTietGioHangNew);
			}
		}
		
		//Hàm set SessionId cho Cookie, và Set GioHang vào Session
		setSessionIdForCookieGioHang(gioHangNew, response);
		taoGioHangSession(gioHangNew, chiTietGioHangAndSanPhams, session);
		
		return true;
	}
	
	public boolean themSpVaoGioHang(KhachHang khachHang, String jSessionIdGhCookie, HttpSession session) {
		//B1: Gọi hàm xemGioHang() để nếu chưa có GH thì hàm này sẽ gọi hàm taoGioHang() để có GH
		
		//B2: Thêm các sp vào GH đà có và gọi hàm updateGioHang() để cập nhật DB
		
		//B3: set lại GH trong Cookie
		return true;
	}

	@Override
	public GioHang capNhatGioHang(GioHang gioHang) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean xemGioHangTheoSessionIdOrLoginOrDienThoai(KhachHang khachHang, String sessionIdGhCookie, String dienThoaiKhachVangLai, String tenKhachVangLai,HttpSession session, HttpServletResponse response) {
		boolean isGioHang = false;
		String sessionIdGH = "";
		int maKH = 0;
		GioHang gioHang = null;
		List<Object[]> chiTietGioHangAndSanPhams = new ArrayList<>();
		
		//Lấy ra giỏ hàng nếu đã có trong session
		Map gioHangMap = (Map)session.getAttribute(Constant.GioHang.GIOHANG_SESSION);
		System.out.println("AAAAAAAAAA-gioHangMap: " + gioHangMap);
		System.out.println("AAAAAAAAAA-khachHang: " + khachHang);
		if( gioHangMap != null ) {
			isGioHang = true;
			gioHang = (GioHang)gioHangMap.get("GioHang");
			System.out.println("AAAAAAAAAA-gioHang: " + gioHang);
			setSessionIdForCookieGioHang(gioHang, response);
		}
		else {
			//=============== Kiểm tra và lấy ra GH theo "sessionIdGH"
			if( khachHang != null ) {//Nếu KH đăng nhập thì lấy giỏ hàng theo MaKH
				maKH = khachHang.getMaKH();
				sessionIdGH = Constant.GioHang.TIENTO_JSESSIONID + maKH;
			}
			else if( sessionIdGhCookie != null && !sessionIdGhCookie.equals("") ) {//Ngược lại thì lấy giỏ hàng theo "sessionIdGhCookie"
				sessionIdGH = sessionIdGhCookie;
			}
			else if( dienThoaiKhachVangLai != null && !dienThoaiKhachVangLai.equals("") ) {//Ngược lại thì lấy giỏ hàng theo "sdt"
				sessionIdGH = Constant.GioHang.TIENTO_JSESSIONID + dienThoaiKhachVangLai;
			}
			
			//================Lấy ra GH
			gioHang = gioHangRepository.findGioHangBySessionIdGH(sessionIdGH);
			chiTietGioHangAndSanPhams = chiTietGioHangRepository.findChiTietGioHangAndSanPhamsBySessionIdGH(sessionIdGH);
			
			//================= Nếu có GH thì kiểm tra nếu lấy GH bằng SessionId trong Cookie thì auto Login cho KH, gọi hàm lưu giỏ hàng bằng Session để hiển thị
			if(gioHang != null ) {
				isGioHang = true;
				//Hàm set SessionId cho Cookie, và Set GioHang vào Session
				setSessionIdForCookieGioHang(gioHang, response);
				taoGioHangSession(gioHang, chiTietGioHangAndSanPhams, session);
				
				//Nếu "sessionIdGhCookie" lưu theo MaKH thì đăng nhập cho KH luôn khi lấy ra GH của KH đó
				if( sessionIdGhCookie != null && !sessionIdGhCookie.equals("") ) {
					int maKhAutoLogin = gioHang.getMaKH();
					KhachHang khachHangAutoLogin = khachHangService.tuDongDangNhap(maKhAutoLogin, session);
				}
			}
			//================= Nếu chưa tồn tại GH => tạo mới GH khi đã: Login( co MaKH)
			else {
				if( khachHang != null || dienThoaiKhachVangLai != null ) {
					isGioHang = taoGioHang(khachHang, dienThoaiKhachVangLai, tenKhachVangLai, chiTietGioHangAndSanPhams, session, response);
				}
			}
		}
		
		return isGioHang;
	}

	@Override
	public void dangNhapXemGioHang(String email, String matKhau, HttpSession session, HttpServletResponse response) throws NotFoundException {
		khachHangService.dangNhap(email, matKhau, session);
		KhachHang khachHang = (KhachHang)session.getAttribute("KhachHang");
		if( khachHang != null ) {
			String sessionIdGhCookie = null;
			String dienThoaiKhachVangLai = "";
			String tenKhachVangLai = "";
			//======== Gọi hàm xem giỏ hàng
			xemGioHangTheoSessionIdOrLoginOrDienThoai(khachHang, sessionIdGhCookie, dienThoaiKhachVangLai, tenKhachVangLai, session, response);
		}
	}

	@Override
	public boolean guiMaXacNhanSDT(String tieuDe, String noiDung, String sdt, HttpSession session) throws ErrorConnectByInternet {
//		Tạm thời sẽ gửi mã xác nhận đến email(nào đó) thay cho việc gửi tin nhắn đến SĐT sẽ thực hiện trong version khác
		String emailShop = Constant.CauHinh.GIA_TRI_EMAIL_SHOP;
		String matKhauEmailShop = Constant.CauHinh.GIA_TRI_MATKHAU_EMAIL_SHOP;
		
		String maXacNhan = String.valueOf(RandomSoNguyen.randomSoNguyen());
		noiDung += maXacNhan;
		
		if( GuiMail.guiMail(sdt, tieuDe, noiDung, emailShop, matKhauEmailShop) == true ) {
			System.out.println("guiXacNhanSDT-maXacNhanTuServer: " + maXacNhan);
			session.setAttribute("MaXnSdtXemGH", maXacNhan);
		}else {
			throw new ErrorConnectByInternet("Lỗi (kết nối internet) khi gửi mã xác nhận từ server, thử lại sau !!!");
		}

		return true;
	}

	@Override
	public boolean xacNhanMaXnSdtXemGioHang(String maXnTuClient, String dienThoai, String tenKH, HttpSession session, HttpServletResponse response){
		KhachHang khachHang = null; 
		String sessionIdGH = "";
		GioHang gioHang = null;
		List<Object[]> chiTietGioHangAndSanPhams = new ArrayList<>();
		int loaiCongViecGuiMaXN = Constant.LoaiCongViecGuiMaXN.LOAI_CONG_VIEC_GUI_MA_XN_DIENTHOAI_XEM_GH;
		boolean isXacNhanMaXN = khachHangService.xacNhanMaXacNhanEmailHoacDienThoai(maXnTuClient, null, dienThoai, session, loaiCongViecGuiMaXN);
		if( isXacNhanMaXN == true ) {
			khachHang = (KhachHang)session.getAttribute("KhachHang");
			String sessionIdGhCookie = null;
			xemGioHangTheoSessionIdOrLoginOrDienThoai(khachHang, sessionIdGhCookie, dienThoai, tenKH, session, response);
		}

		return isXacNhanMaXN;
	}

}
