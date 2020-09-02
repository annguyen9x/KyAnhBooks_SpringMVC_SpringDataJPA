package com.annguyen.kyanhbooks.service.impl;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annguyen.kyanhbooks.model.GioHang;
import com.annguyen.kyanhbooks.model.KhachHang;
import com.annguyen.kyanhbooks.repository.GioHangRepository;
import com.annguyen.kyanhbooks.service.GioHangService;
import com.annguyen.kyanhbooks.service.KhachHangService;
import com.annguyen.kyanhbooks.util.Constant;
import com.annguyen.kyanhbooks.util.myexception.NotFoundException;

@Service
public class GioHangServiceImpl implements GioHangService{
	
	@Autowired
	private GioHangRepository gioHangRepository;
	
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateGioHang(GioHang gioHang) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteGioHang(String sessionIdDienThoai) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public GioHang taoGioHang(KhachHang khachHang, String dienThoaiKhachVangLai, String tenKhachVangLai, GioHang gioHang) {
		GioHang gioHangNew = null;
		String sessionIdGH = "";
		int maKH = 0;
		String tenKH = "";
		String dienThoai = "";
		String maSach = "";
		int soLuong = 0;
		float donGia = 0;
		Date ngayTao = new Date();
		
		if( khachHang != null && khachHang.getMaKH() != 0) {
			maKH = khachHang.getMaKH();
			tenKH = khachHang.getTenKH();
			dienThoai = khachHang.getDienThoai();
			if( gioHang != null ) {
				maSach = gioHang.getMaSach();
				soLuong = gioHang.getSoLuong();
				donGia = gioHang.getDonGia();
			}
			sessionIdGH = Constant.GioHang.TIENTO_JSESSIONID + maKH;
		}
		else if( dienThoaiKhachVangLai != null && !dienThoaiKhachVangLai.equals("") ) {
			tenKH = tenKhachVangLai;
			dienThoai = dienThoaiKhachVangLai;
			if( gioHang != null ) {
				maSach = gioHang.getMaSach();
				soLuong = gioHang.getSoLuong();
				donGia = gioHang.getDonGia();
			}
			sessionIdGH = Constant.GioHang.TIENTO_JSESSIONID + dienThoaiKhachVangLai;
			
		}
		
		//Insert GH to DB
		gioHangNew = new GioHang(sessionIdGH, maKH, tenKH, dienThoai, maSach, soLuong, donGia, ngayTao);
		insertGioHang(gioHangNew);
		
		return gioHangNew;
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
	public void xemGioHangTheoSessionIdOrLogin(KhachHang khachHang, String sessionIdGhCookie, HttpSession session) {
		String sessionIdGH = "";
		int maKH = 0;
		GioHang gioHang = null;
		
		//=============== Kiểm tra và lấy ra GH theo "sessionIdGH"
		if( khachHang != null ) {//Nếu KH đăng nhập thì lấy giỏ hàng theo MaKH
			maKH = khachHang.getMaKH();
			sessionIdGH = Constant.GioHang.TIENTO_JSESSIONID + maKH;
		}
		else if( sessionIdGhCookie != null && !sessionIdGhCookie.equals("") ) {//Ngược lại thì lấy giỏ hàng theo "sessionIdGhCookie"
			sessionIdGH = sessionIdGhCookie;
		}
		
		//================Lấy ra GH
		gioHang = gioHangRepository.findGioHangBySessionIdGH(sessionIdGH);
		
		//================= Nếu chưa có GH thì gọi hàm taoGioHang, Nếu đã có GH thì kiểm tra nếu lấy GH bằng SessionId trong Cookie thì auto Login cho KH
		if(gioHang != null ) {
			//Nếu "sessionIdGhCookie" lưu theo MaKH thì đăng nhập cho KH luôn khi lấy ra GH của KH đó
			if( sessionIdGhCookie != null && !sessionIdGhCookie.equals("") ) {
				int maKhAutoLogin = gioHang.getMaKH();
				KhachHangService khachHangService = new KhachHangServiceImpl();
				KhachHang khachHangAutoLogin = khachHangService.tuDongDangNhap(maKhAutoLogin, session);
			}
		}
		else {//Nếu chưa tồn tại GH => tạo mới GH khi đã: Login( co MaKH)
			GioHang gioHang2 = new GioHang();
			String dienThoaiKhachVangLai = "";
			String tenKhachVangLai = "";
			
			gioHang = taoGioHang(khachHang, dienThoaiKhachVangLai, tenKhachVangLai, gioHang2);
		}
		
		session.setAttribute("GioHang", gioHang);
	}

	@Override
	public void dangNhapXemGioHang(String email, String matKhau, HttpSession session) throws NotFoundException {
		KhachHangService khachHangService = new KhachHangServiceImpl();
		khachHangService.dangNhap(email, matKhau, session);
		KhachHang khachHang = (KhachHang)session.getAttribute("KhachHang");
		String sessionIdGhCookie = null;
		
		//======== Gọi hàm xem giỏ hàng
		xemGioHangTheoSessionIdOrLogin(khachHang, sessionIdGhCookie, session);
		
	}
}
