CREATE DATABASE Thu_Vien
-- tạo bảng 
CREATE TABLE BANDOC(
maBD INT  NOT NULL PRIMARY KEY, 
hotenBD NVARCHAR(30) NOT NULL, 
ngaySinh DATE CHECK (ngaySinh < GETDATE()), 
lop CHAR(5), 
quequan NVARCHAR(50), 
sdt INT 
) 

CREATE TABLE SACH(
maS VARCHAR(10) NOT NULL PRIMARY KEY, 
TenS NVARCHAR(30) NOT NULL, 
TheLoai VARCHAR(30), 
Tacgia NVARCHAR(30), 
NamXB INT, 
NhaXB NVARCHAR(30)
)
CREATE TABLE PHIEUMUON(
maBD INT  NOT NULL PRIMARY KEY, 
maS VARCHAR(10) NOT NULL , 
Ngaymuon DATETIME, 
Ngayhentra DATETIME, 
TraSach INT  
)
ALTER TABLE dbo.PHIEUMUON
ADD CONSTRAINT r1 FOREIGN KEY (maBD) REFERENCES dbo.BANDOC
ALTER TABLE dbo.PHIEUMUON
ADD CONSTRAINT r2 FOREIGN KEY (maS) REFERENCES dbo.Sach

INSERT INTO dbo.BANDOC
(
    maBD,
    hotenBD,
    ngaySinh,
    lop,
    quequan,
    sdt
)
VALUES
(   123,
    N'vũ Xuân Khải',       -- hotenBD - nvarchar(30)
    '20010126', -- ngaySinh - date
    'at16e',        -- lop - char(5)
    N'Nam Định',       -- quequan - nvarchar(50)
    0869969623          -- sdt - int
    ),
	(124,N'Vũ Công Thức','20010223','at16c',N'Nam Định',1325465),
	(125,N'Vũ văn a','19990325','at15b',N'Nghệ an',116462317),
	(126,N'Vũ Huy Hoàn','20070709','at20b',N'Hà nội',3465464),
	(127,N'Vũ cao hoan ','20030426','at19d',N'quảng nam ',3456465),
	(128,N'nguyễn binh bong','20020928','at14g',N'tphcm',464251),
	(129,N'Đinh văn nơi','19860206','at5d',N'quảng bình',4765415),
	(130,N'đặng thị ngọc thịnh','20070604','ct4a',N'quảng trị',346546),
	(131,N'triệu thị huệ','19980108','at15a',N'thái bình',3134684),
	(132,N'hoàng ngọc phong','20030208','ct6d',N'hải phòng',87545132)
INSERT INTO dbo.SACH
(
    maS,
    TenS,
    TheLoai,
    Tacgia,
    NamXB,
    NhaXB
)
VALUES
(   'c95b',  -- maS - varchar(10)
    N'cơ sở dữ liệu', -- TenS - nvarchar(30)
    'giáo trình',  -- TheLoai - varchar(30)
    N'Đào Minh tấn', -- Tacgia - nvarchar(30)
    2013,   -- NamXB - int
    N'Giáo Dục'  -- NhaXB - nvarchar(30)
    ),
	('a531',N'Giải thuật lập trình','giáo trình',N'Nguyễn Văn Phác',2015,N'Quốc Gia'),
	('c95a',N'tâm lý học','Tiểu thuyết',N'Đào tố Uyên',2009,N'Giáo Dục')
INSERT INTO dbo.PHIEUMUON
(	maBD,
    maS,
    Ngaymuon,
    Ngayhentra,
    TraSach
)
VALUES
(   123,
    'c95b',        -- maS - varchar(10)
    '20210528', -- Ngaymuon - datetime
    '20210603', -- Ngayhentra - datetime
    1          -- TraSach - int
    ),
	(124,'c95a','20211106','20211111',1),
	(129,'a531','20211012','20211015',1),
	(130,'c95b','20210604','20210612',0),
	(128,'a531','20201206','20210101',0)

SELECT*FROM dbo.BANDOC
SELECT*FROM dbo.SACH
SELECT *FROM dbo.PHIEUMUON
