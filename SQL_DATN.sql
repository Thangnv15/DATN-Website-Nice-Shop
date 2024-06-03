CREATE
DATABASE website_sell_shoes_niceshop
go
use website_sell_shoes_niceshop

create table NhanVien
(
    id        uniqueidentifier primary key,
    manv      nvarchar(20) null,
    hoten     nvarchar(50) null,
    namsinh   date null,
    chucvu    nvarchar(20) null,
    diachi    nvarchar(100) null,
    email     nvarchar(50) null,
    sdt       nvarchar(10) null,
    trangthai bit null,
)
    go
create table KhachHang
(
    id        uniqueidentifier primary key,
    makh      nvarchar(20) null,
    hoten     nvarchar(50) null,
    namsinh   date null,
    diachi    nvarchar(100) null,
    sdt       nvarchar(10) null,
    email     nvarchar(50) null,
    trangthai bit null,
)
    go
create table TaiKhoan
(
    id           uniqueidentifier primary key,
    id_nhanvien  uniqueidentifier,
    id_khachhang uniqueidentifier,
    tentaikhoan  nvarchar(50) null,
    matkhau      nvarchar(50) null,
    trangthai    bit,
    foreign key (id_nhanvien) references NhanVien (id),
    foreign key (id_khachhang) references KhachHang (id),
)

create table HoaDon
(
    id              uniqueidentifier primary key,
    id_taikhoan     uniqueidentifier not null,
    id_phuongthuctt uniqueidentifier,
    id_giamgia      uniqueidentifier,
    mahoadon        nvarchar(20) null,
    tenkh           nvarchar(50) null,
    tennv           nvarchar(50) null,
    tongtien        DECIMAL null,
    tienthu         DECIMAL null,
    tiengiam        DECIMAL null,
    ngaytao         datetime null,
    trangthai       bit null,
    ghichu          nvarchar( max) null,
    foreign key (id_taikhoan) references TaiKhoan (id),
    foreign key (id_phuongthuctt) references PhuongThucThanhToan (id),
    foreign key (id_giamgia) references GiamGia (id)
)
    go
create table LichSuHoaDon
(
    id        uniqueidentifier primary key,
    id_hoadon uniqueidentifier,
    mota      nvarchar( max) null,
    trangthai bit null,
    foreign key (id_hoadon) references HoaDon (id),
)
    go
create table PhuongThucThanhToan
(
    id           uniqueidentifier primary key,
    phuongthuctt nvarchar(50) null,
    mota         nvarchar(100) null,
)
    go
create table GiamGia
(
    id          uniqueidentifier primary key,
    ma          nvarchar(20) null,
    ten         nvarchar(50) null,
    ngaybatdau  date null,
    ngayketthuc date null,
    trangthai   bit null,
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
    sanpham      nvarchar(50) null,
    soluong      int null,
    dongia       DECIMAL null,
    tongtien     DECIMAL null,
    foreign key (id_sanphamct) references ChiTietSanPham (id),
    foreign key (id_taikhoan) references TaiKhoan (id),
)
    go
create table danhgia
(
    id           uniqueidentifier primary key,
    id_sanphamct uniqueidentifier,
    binhluan     nvarchar(200) null,
    diem         int null,
    anh1         NVARCHAR( MAX) null,
    anh2         NVARCHAR( MAX) null,
    anh3         NVARCHAR( MAX) null,
    foreign key (id_sanphamct) references ChiTietSanPham (id),
)
    go
CREATE TABLE SanPham
(
    id      UNIQUEIDENTIFIER PRIMARY KEY,
    masp    NVARCHAR(50) NULL,
    ten     NVARCHAR(50) NULL,
    mota    NVARCHAR( MAX) NULL,
    them    NVARCHAR(20) NULL,
    capnhat NVARCHAR(20) NULL
)
    GO

create table Size
(
    id      uniqueidentifier primary key,
    ten     nvarchar(50) null,
    them    nvarchar(20) null,
    capnhat nvarchar(20) null,
)
    go
create table XuatXu
(
    id      uniqueidentifier primary key,
    ten     nvarchar(50) null,
    them    nvarchar(20) null,
    capnhat nvarchar(20) null,
)
    go
create table Hang
(
    id      uniqueidentifier primary key,
    ten     nvarchar(50) null,
    them    nvarchar(20) null,
    capnhat nvarchar(20) null,
)
    go
create table TheLoai
(
    id      uniqueidentifier primary key,
    ten     nvarchar(50) null,
    them    nvarchar(20) null,
    capnhat nvarchar(20) null,
)
    go
create table ChatLieu
(
    id      uniqueidentifier primary key,
    ten     nvarchar(50) null,
    them    nvarchar(20) null,
    capnhat nvarchar(20) null,
)
    go
create table MauSac
(
    id      uniqueidentifier primary key,
    ten     nvarchar(50) null,
    them    nvarchar(20) null,
    capnhat nvarchar(20) null,
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
    soluongton  int null,
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
