CREATE
DATABASE website_sell_shoes_niceshop
go
use website_sell_shoes_niceshop

create table VaiTro
(
    id        uniqueidentifier primary key,
	ma       nvarchar (50),
    ten      nvarchar(50) null
)
    go

CREATE Table TaiKhoan
(
    id UNIQUEIDENTIFIER PRIMARY KEY,
	ma nvarchar (50),
    username NVARCHAR(30) null,
    pass VARCHAR(50) null,
    hoten NVARCHAR(30) null,
    namsinh DATE null,
    email NVARCHAR(30) null,
    sdt NVARCHAR(30) null,
    avatar NVARCHAR(MAX) null,
    created_date DATE DEFAULT GETDATE(),
    update_date DATE null,
    is_deleted BIT null
)
go
CREATE TABLE VaiTroTaiKhoan
(
    id uniqueidentifier PRIMARY KEY,
    id_taikhoan uniqueidentifier,
    id_vaitro uniqueidentifier,
    FOREIGN KEY (id_taikhoan) REFERENCES TaiKhoan (id),
    FOREIGN KEY (id_vaitro) REFERENCES VaiTro (id)
);
GO


create table DiaChi
(
	id uniqueidentifier primary key,
	id_taikhoan uniqueidentifier,
	ma nvarchar (50),
	phuong nvarchar(100) null,
	quan nvarchar(100) null,
	thanhpho nvarchar(100) null,
	chitiet nvarchar (max) null,
    created_date DATE DEFAULT GETDATE(),
    ngaysua DATE null,
	foreign key(id_taikhoan) references TaiKhoan(id)
)
go
create table PhuongThucThanhToan
(
    id           uniqueidentifier primary key,
	ma nvarchar (50),
    phuongthuctt nvarchar(50) null,
    mota         nvarchar(100) null,
)
    go
create table HoaDon
(
    id              uniqueidentifier primary key,
    id_taikhoan     uniqueidentifier,
    id_phuongthuctt uniqueidentifier,
    id_diachi       uniqueidentifier,
	ma              nvarchar (50),
    name_user		nvarchar(50) null,
    sdt_user        nvarchar(50) null,
	diachi_user		nvarchar(1000) null,
    tongtien        DECIMAL null,
    tienthu         DECIMAL null,
    tiengiam        DECIMAL null,
    created_date DATE DEFAULT GETDATE(),
    trangthai       int null,
    ghichu          nvarchar( max) null,
    foreign key (id_taikhoan) references TaiKhoan (id),
    foreign key (id_phuongthuctt) references PhuongThucThanhToan (id),
    foreign key (id_diachi) references DiaChi (id)
)
    go
	

create table GiamGia
(
    id UNIQUEIDENTIFIER PRIMARY KEY,
	ma nvarchar (50),
    ten NVARCHAR(max) null,
    ngaytao DATETIME null,
    ngaybatdau DATETIME null,
    ngayketthuc DATETIME null,
    loaivoucher int null,
    status int null,
    -- 1: sap dien ra, 2: dang dien ra, 3: da ket thuc, 4: ngung 

)
go

CREATE TABLE SanPham
(
    id      UNIQUEIDENTIFIER PRIMARY KEY,
    masp    NVARCHAR(50) NULL,
    ten     NVARCHAR(50) NULL,
    created_date DATE DEFAULT GETDATE(),
    update_date DATE null,
    trangthai bit
)
    GO

create table Size
(
    id      uniqueidentifier primary key,
	ma nvarchar (50),
    ten     nvarchar(50) null,
    created_date DATE DEFAULT GETDATE(),
    update_date DATE null,
)
    go
create table XuatXu
(
    id      uniqueidentifier primary key,
	ma nvarchar (50),
    ten     nvarchar(50) null,/-strong/-heart:>:o:-((:-hcreated_date DATE DEFAULT GETDATE(),
    update_date DATE null,
)
    go
create table Hang
(
    id      uniqueidentifier primary key,
	ma nvarchar (50),
    ten     nvarchar(50) null,
    created_date DATE DEFAULT GETDATE(),
    update_date DATE null,
)
    go
create table TheLoai
(
    id      uniqueidentifier primary key,
	ma nvarchar (50),
    ten     nvarchar(50) null,
    created_date DATE DEFAULT GETDATE(),
    update_date DATE null,
)
    go
create table ChatLieu
(
    id      uniqueidentifier primary key,
	ma nvarchar (50),
    ten     nvarchar(50) null,
    created_date DATE DEFAULT GETDATE(),
    update_date DATE null,
)
    go
create table MauSac
(
    id      uniqueidentifier primary key,
	ma nvarchar (50),
    ten     nvarchar(50) null,
    created_date DATE DEFAULT GETDATE(),
    update_date DATE null,
)
    go

create table ChiTietSanPham
(
    id          uniqueidentifier primary key,
    id_sanpham  uniqueidentifier,
    id_size     uniqueidentifier,
    id_mausac   uniqueidentifier,
    id_chatlieu uniqueidentifier,
    id_xuatxu   uniqueidentifier,
    id_theloai  uniqueidentifier,
    id_hang     uniqueidentifier,
    giaban      DECIMAL null,
    gianhap     DECIMAL null,
    soluongton  BIGINT null,
    mota        nvarchar( max) null,
    trangthai   bit null,
    foreign key (id_sanpham) references SanPham (id),
    foreign key (id_size) references Size (id),
    foreign key (id_mausac) references MauSac (id),
    foreign key (id_chatlieu) references ChatLieu (id),
    foreign key (id_xuatxu) references XuatXu (id),
    foreign key (id_theloai) references TheLoai (id),
    foreign key (id_hang) references Hang (id),
)
    go
	create table Anh
(
    id           uniqueidentifier primary key,
    id_sanphamct uniqueidentifier,
    anh          nvarchar( max) null,
    foreign key (id_sanphamct) references ChiTietSanPham (id),
)
    go
	create table GiamGiaChiTiet
(
    id UNIQUEIDENTIFIER PRIMARY KEY,
    id_giamgia UNIQUEIDENTIFIER null,
    id_sanphamct UNIQUEIDENTIFIER null,
    giamgia int null,
    status int null,
    foreign key(id_giamgia) references GiamGia(id),
    foreign key(id_sanphamct) references ChiTietSanPham(id)
)
go
create table ChiTietHoaDon
(
    id           uniqueidentifier primary key,
    id_hoadon    uniqueidentifier,
    id_sanphamct uniqueidentifier,
    soluong      int null,
    dongia       DECIMAL null,
    tongtien     DECIMAL null,
    ghichu       nvarchar( max),
    trangthai    bit null,
    foreign key (id_hoadon) references HoaDon (id),
    foreign key (id_sanphamct) references ChiTietSanPham (id),
)
    go
create table GioHang
(
    id           uniqueidentifier primary key,
    id_sanphamct uniqueidentifier,
    id_taikhoan  uniqueidentifier,
	ma nvarchar (50),
    sanpham      nvarchar(50) null,
    soluong      int null,
    dongia       DECIMAL null,
    tongtien     DECIMAL null,/-strong/-heart:>:o:-((:-hforeign key (id_sanphamct) references ChiTietSanPham (id),
    foreign key (id_taikhoan) references TaiKhoan (id),
)
    go
CREATE TABLE DanhGia
(
    id uniqueidentifier PRIMARY KEY,  -- ID duy nhất cho mỗi đánh giá
    id_sanphamct uniqueidentifier,      -- ID của sản phẩm được đánh giá
    id_taikhoan uniqueidentifier,    -- ID của người dùng thực hiện đánh giá
    danhgia INT CHECK (danhgia >= 1 AND danhgia <= 5),  -- Điểm đánh giá từ 1 đến 5
    binhluan NVARCHAR(1000),          -- Bình luận của người dùng
    ngay_danhgia DATETIME DEFAULT GETDATE(),  -- Ngày đánh giá, mặc định là ngày hiện tại
    FOREIGN KEY (id_sanphamct) REFERENCES ChiTietSanPham (id),  -- Khoá ngoại tới bảng sản phẩm
    FOREIGN KEY (id_taikhoan) REFERENCES TaiKhoan (id)  -- Khoá ngoại tới bảng người dùng
)
go