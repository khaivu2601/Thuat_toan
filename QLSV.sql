CREATE DATABASE QLSV
USE QLSV

CREATE TABLE Sinhvien(

MaSV VARCHAR(10) NOT NULL PRIMARY KEY, 
hotenSV NVARCHAR(40), 
gioitinh VARCHAR(3) , 
ngaysinh DATE , 
quequan NVARCHAR(40), 
lop VARCHAR(10)

)

CREATE TABLE Monhoc(

MaMH VARCHAR(10) NOT NULL PRIMARY KEY, 
TenMH NVARCHAR(30), 
DVHT INT

)

CREATE TABLE Ketqua(

MaSV VARCHAR(10) NOT NULL , 
maMH VARCHAR(10) NOT NULL , 
Diem INT CHECK (Diem BETWEEN 0 AND 10) 

) 
ALTER TABLE dbo.Ketqua ADD  CONSTRAINT r1 FOREIGN KEY (MaSV) REFERENCES dbo.Sinhvien(MaSV)

ALTER TABLE dbo.Ketqua ADD  CONSTRAINT r2 FOREIGN KEY (maMH) REFERENCES dbo.Monhoc(MaMH)
INSERT INTO dbo.Sinhvien
(
    MaSV,
    hotenSV,
    gioitinh,
    ngaysinh,
    quequan,
    lop
)
VALUES
(   'at160527',        -- MaSV - varchar(10)
    N'vũ xuân khải',       -- hotenSV - nvarchar(40)
    'nam',        -- gioitinh - varchar(3)
    '20010126', -- ngaysinh - datetime
    N'Nam Định',       -- quequan - nvarchar(40)
    'at16e'         -- lop - varchar(10)
    ),
	('ct2648',N'Vũ Công Thức','nam','20010223',N'Nam Định','ct4a'),
	('at157283',N'Vũ văn a','nam','19990325',N'Nghệ an','ct5c'),
	('dt62784',N'Vũ Huy Hoàn','nam','20070709',N'Hà nội','at16d'),
	('ct5248',N'Vũ cao hoan ','nam','20030426',N'quảng nam ','ct4a'),
	('at16782',N'nguyễn binh bong','nu','20020928',N'tphcm','dt4b'),
	('dt16092',N'Đinh văn nơi','nam','19860206',N'quảng bình','at13a'),
	('at140289',N'đặng thị ngọc thịnh','nu','20070604',N'quảng trị','ct5d'),
	('ct030506',N'triệu thị huệ','nu','19980108',N'thái bình','at14e'),
	('at160525',N'hoàng ngọc phong','nam','20030208',N'hải phòng','ct5c')
INSERT INTO dbo.Monhoc
(
    MaMH,
    TenMH,
    DVHT
)
VALUES
('159',N'mạng máy tính',2),
('357',N'tin đại cương',2),
(   '123',  -- MaMH - varchar(10)
    N'lý thuyết csdl', -- TenMH - nvarchar(30)
    3    -- DVHT - int
    ),
	('456',N'mật mã học',3),
	('789',N'Thể chất cô hoa',15)
INSERT INTO dbo.Ketqua
(
    MaSV,
    maMH,
    Diem
)
VALUES
('at16782','357',3),
('at16782','159',6),
('dt16092','456',8),
(   'at160527', -- MaSV - varchar(10)
    '789', -- maMH - varchar(10)
    7   -- Diem - int
    ),
	('at160525','456',6),
	('at160527','456',8),
	('at160525','789',3),
	('ct030506','123',7),
	('ct030506','789',3),
	('at16782','123',5),
	('at16782','456',6),
	('at16782','789',5),
	('ct2648','123',7),
	('ct2648','456',6),
	('ct2648','789',4)
SELECT*FROM dbo.Ketqua
SELECT*FROM dbo.Monhoc 
SELECT*FROM dbo.Sinhvien

--Cho biết mã môn học, tên môn học, điểm thi tất cả các môn của sinh viên tên Thức

SELECT dbo.Monhoc.MaMH , dbo.Monhoc.TenMH , dbo.Ketqua.Diem 
FROM dbo.Sinhvien,dbo.Monhoc,dbo.Ketqua
WHERE dbo.Sinhvien.MaSV=dbo.Ketqua.MaSV AND dbo.Monhoc.MaMH=dbo.Ketqua.maMH AND hotenSV LIKE N'% thức'

--Cho biết mã môn học, tên môn và điểm thi ở những môn mà sinh viên tên huệ phải thi lại
--(điểm<5)
SELECT dbo.Monhoc.MaMH , dbo.Monhoc.TenMH , dbo.Ketqua.Diem
FROM dbo.Sinhvien , dbo.Monhoc , dbo.Ketqua
WHERE dbo.Sinhvien.MaSV=dbo.Ketqua.MaSV AND dbo.Monhoc.MaMH=dbo.Ketqua.maMH AND hotenSV LIKE N'% huệ' AND Diem<=5

--Cho biết mã sinh viên, tên những sinh viên đã thi ít nhất là 1 trong 3 môn Lý thuyết Cơ sở dữ
--liệu, Tin học đại cương, mạng máy tính.
select sv.Masv, sv.hotenSV, mh.TenMH
from Sinhvien sv, Monhoc mh, Ketqua kq
where sv.Masv = kq.Masv and mh.Mamh = kq.Mamh and Tenmh in (N'tin đại cương', N'lý thuyết csdl', N'Mạng máy tính')
--Cho biết mã môn học, tên môn mà sinh viên có mã số 1 chưa có điểm
SELECT dbo.Monhoc.MaMH,dbo.Monhoc.TenMH
FROM dbo.Monhoc,dbo.Sinhvien,dbo.Ketqua
EXCEPT
SELECT dbo.Monhoc.MaMH,dbo.Monhoc.TenMH
FROM dbo.Monhoc,dbo.Sinhvien,dbo.Ketqua
WHERE dbo.Sinhvien.MaSV=dbo.Ketqua.MaSV AND dbo.Monhoc.MaMH=dbo.Ketqua.maMH AND Ketqua.MaSV='at160525' 

--Cho biết điểm cao nhất môn 1 mà các sinh viên đạt được
SELECT MAX(Diem)
FROM dbo.Ketqua,dbo.Monhoc
WHERE TenMH=N'thể chất cô hoa'
--Cho biết mã sinh viên, tên những sinh viên có điểm thi môn 2 không thấp nhất khoa
SELECT dbo.Sinhvien.hotenSV,dbo.Sinhvien.MaSV
FROM dbo.Ketqua,dbo.Monhoc,dbo.Sinhvien
WHERE dbo.Sinhvien.MaSV=dbo.Ketqua.MaSV AND dbo.Monhoc.MaMH=dbo.Ketqua.maMH AND TenMH=N'thể chất cô hoa' 
AND Diem > (SELECT MIN(Diem) FROM dbo.Ketqua WHERE TenMH=N'thể chất cô hoa')
--Cho biết mã sinh viên và tên những sinh viên có điểm thi môn 1 lớn hơn điểm thi môn 1 của
--sinh viên có mã số 3






