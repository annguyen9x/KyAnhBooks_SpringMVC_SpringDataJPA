# <p align="center">KyAnhBooks-SpringMvc-SpringDataJPA (version 1.0)</p>

# Mục tiêu
Mục tiêu của đề tài là “Xây dựng website bán sách cho hiệu sách nhân dân Kỳ Anh, Hà Tĩnh” góp phần đáp ứng nhu cầu đặt sách trực tuyến của khách hàng. Website giúp nhà sách quản lý quá trình nhập sách, bán sách, thông tin khách hàng, nhân viên một cách tiện lợi, chính xác, nhằm tiết kiệm thời gian, chi phí cho cửa hàng.

# Công nghệ sử dụng
- Ngôn ngữ lập trình: Java 8 (SpringMVC 4.3.13.RELEASE - SpirngDataJPA 1.11.5.RELEASE - Hibernate 4.3.6.Final)
- html5, css3
- javascript (ajax, jquery, ...)
- Bootstrap 3 framework


# Công cụ xây dựng chương trình
- IDE: Eclipse
- Database: SQL server 2014
- Web Server: Apache Tomcat v9.0

# Sơ đồ Usecase
<p align="center"><img src="image_test/csdl/usecase.PNG"></p>

# Sơ đồ quan hệ giữa các bảng trong SQL Server
<p align="center"><img src="image_test/csdl/db.png"></p>

# Chức năng của các tác nhân

## Note: 
#Version 1.0: 1. Khách hàng
#Version 1.1: 2. Người quản trị, 3. Nhân viên kho, 4. Nhân viên giao hàng; thêm 2 table: MenuDanhMuc[phân quyền đối tượng sử dụng các menu], CauHinh[cấu hình các tham số như:sđt, email, ..của shop]

## 1. Khách hàng ##
- Đăng ký thành viên<br/>
- Đăng nhập<br/>
- Cập nhật thông tin tài khoản<br/>
- Tìm kiếm sách<br/>
- Xem thông tin sách<br/>
- Đặt hàng<br/>
- Xem đơn hàng<br/>
- Cập nhật đơn hàng<br/>
- Xem lịch sử mua hàng<br/>

## 2. Người quản trị (admin) ##
- Đăng nhập<br/>
- Xem danh sách đơn hàng<br/>
- Xử lý đơn hàng<br/>
- Cập nhật nhân viên<br/>
- Cập nhật sách<br/>

## 3. Nhân viên kho ##
- Đăng nhập<br/>
- Xem danh sách đơn hàng cần chuẩn bị<br/>
- Xem thông tin đơn hàng<br/>
- Cập nhật tình trạng đơn hàng<br/>
- Nhập sách<br/>

## 4. Nhân viên giao hàng ##
- Đăng nhập<br/>
- Xem danh sách đơn hàng cần giao<br/>
- Xem thông tin đơn hàng	<br/>
- Cập nhật tình trạng đơn hàng<br/>

# Một số giao diện
## a. Giao diện người dùng ##

#### 1. Trang chủ

<p align="left">
	<img src="image_test/giaoDien/trangchu.png">
</p>

#### 2. Trang sản phẩm cùng loại

<p align="left">
	<kbd>
		<img src="image_test/giaoDien/sp_cungloai.png">
	</kbd>
</p>

#### 3. Chi tiết sản phẩm

<p align="left">
	<kbd>
		<img src="image_test/giaoDien/chitiet_sp.png">
	</kbd>
</p>

#### 4. Giỏ hàng

<p align="left">
	<kbd>
		<img src="image_test/giaoDien/giohang.png">
	</kbd>
</p>

#### 5. Thông tin giao hàng, đặt hàng

<p align="left">
	<kbd>
		<img src="image_test/giaoDien/dathang.png">
	</kbd>
</p>

#### 6. Xem đơn hàng

<p align="left">
	<kbd>
		<img src="image_test/giaoDien/xem_dh.png">
	</kbd>
</p>

## b. Giao diện quản trị ##

#### 1. Xử lý đơn hàng(admin)

<p align="left">
	<kbd>
		<img src="image_test/giaoDien/xuly_dh.png">
	</kbd>
</p>

#### 2. Cập nhật (thêm,sửa,xóa) sách (admin)

<p align="left">
	<kbd>
		<img src="image_test/giaoDien/cn_sach.PNG">
	</kbd>
</p>

#### 3. Cập nhật tình trạng đơn hàng(nv kho)
<p align="left">
	<kbd>
		<img src="image_test/giaoDien/cn_tt_dh_kho.png">
	</kbd>
</p>

#### 4. Nhập sách (nv kho)

<p align="left">
	<kbd>
		<img src="image_test/giaoDien/nhap_sach.png">
	</kbd>
</p>

#### 5. In hóa đơn bán hàng (nv kho)

<p align="left">
	<kbd>
		<img src="image_test/giaoDien/in_hoadon_banhang.PNG">
	</kbd>
</p>
