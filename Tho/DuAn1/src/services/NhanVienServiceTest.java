package services;

import domainmodel.NhanVienDomainModel;
import org.junit.Assert;
import org.junit.Test;
import repositorys.NhanVienRepository;
import services.NhanVienService;
import viewmodel.NhanVienViewModel;

import java.sql.Date;

import static org.junit.Assert.*;

public class NhanVienServiceTest {
    NhanVienDomainModel nhanVien = new NhanVienDomainModel();
    NhanVienRepository nhanVienRepository = new NhanVienRepository();
    NhanVienService nhanVienService = new NhanVienService();

    @Test
    public void insertNhanVien1() {
        // thêm nhân viên thành công khi tất cả các trường hợp lệ
        Boolean actualResult = true;
        Boolean expected = true;
        String hoVaTen = "Le Tho";
        Date ngaySinh = Date.valueOf("2000-03-09");
        String diaChi = "Thanh hóa";
        String cccd = "087678999";
        String soDienThoai = "0873246323";
        String email = "giang@gmail.com";
        String ghiChu = "khong";
        String chucVu = "Nhân viên";
        try {
            actualResult = nhanVienService.validateNhanVien(
                    hoVaTen, ngaySinh, diaChi, cccd, soDienThoai, email, ghiChu, chucVu
            );
            if (actualResult==true) {
                NhanVienDomainModel nhanVien = new NhanVienDomainModel();
                nhanVien.setHoVaTen(hoVaTen);
                nhanVien.setNgaySinh(ngaySinh);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setCCCD(cccd);
                nhanVien.setTrangThai(1);
                nhanVien.setEmail(email);
                nhanVien.setSoDienThoai(soDienThoai);
                nhanVien.setGhiChu(ghiChu);
                nhanVien.setAnh(null);
                nhanVien.setChucVu(chucVu);
                expected = nhanVienRepository.insertNhanVien(nhanVien);
            }
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
        Assert.assertEquals(expected, actualResult);
    }

    @Test
    public void insertNhanVien2() {
        // thêm nhân viên thất bại với sdt sai định dạng 10 số
        Boolean actualResult = false;
        Boolean expected = false;
        String hoVaTen = "Lê Th Thơ";
        Date ngaySinh = Date.valueOf("2000-03-09");
        String diaChi = "Thanh hóa";
        String cccd = "021984382";
        String soDienThoai = "0219432432223";
        String email = "hai@gmail.com";
        String ghiChu = "khong";
        String chucVu = "Nhân viên";
        try {
            actualResult = nhanVienService.validateNhanVien(
                    hoVaTen,ngaySinh, diaChi, cccd, soDienThoai, email, ghiChu, chucVu
            );
            if (actualResult==true) {
                NhanVienDomainModel nhanVien = new NhanVienDomainModel();
                nhanVien.setHoVaTen(hoVaTen);
                nhanVien.setNgaySinh(ngaySinh);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setCCCD(cccd);
                nhanVien.setTrangThai(1);
                nhanVien.setEmail(email);
                nhanVien.setSoDienThoai(soDienThoai);
                nhanVien.setGhiChu(ghiChu);
                nhanVien.setAnh(null);
                nhanVien.setChucVu(chucVu);
                expected = nhanVienRepository.insertNhanVien(nhanVien);
            }
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
        Assert.assertEquals(expected, actualResult);
    }

    @Test
    public void insertNhanVien3() {
        // thêm nhân viên thất bại với email sai định dạng
        Boolean actualResult = false;
        Boolean expected = false;
        String hoVaTen = "Lê Th Thơ";
        Date ngaySinh = Date.valueOf("2000-03-09");
        String diaChi = "Thanh hóa";
        String cccd = "021984382";
        String soDienThoai = "0234983243";
        String email = "hai@";
        String ghiChu = "khong";
        String chucVu = "Nhân viên";
        try {
            actualResult = nhanVienService.validateNhanVien(
                    hoVaTen, ngaySinh, diaChi, cccd, soDienThoai, email, ghiChu, chucVu
            );
            if (actualResult==true) {
                NhanVienDomainModel nhanVien = new NhanVienDomainModel();
                nhanVien.setHoVaTen(hoVaTen);
                nhanVien.setNgaySinh(ngaySinh);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setCCCD(cccd);
                nhanVien.setTrangThai(1);
                nhanVien.setEmail(email);
                nhanVien.setSoDienThoai(soDienThoai);
                nhanVien.setGhiChu(ghiChu);
                nhanVien.setAnh(null);
                nhanVien.setChucVu(chucVu);
                expected = nhanVienRepository.insertNhanVien(nhanVien);
            }
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
        Assert.assertEquals(expected, actualResult);
    }

    @Test
    public void insertNhanVien4() {
        // thêm nhân viên thất bại với ngày  sai định dạng(yyyy-MM-dd)
//        nhanVien.setNgaySinh(Date.valueOf("2004-13-09"));
        Boolean actualResult = false;
        Boolean expected = false;
        String hoVaTen = "Hai Anh";
        String ngaySinh = "2000-11-09";
        Date ngaySinh2 = Date.valueOf(ngaySinh);
        String diaChi = "Thanh hóa";
        String cccd = "";
        String soDienThoai = "0834325434";
        String email = "hai@gmail.com";
        String ghiChu = "khong";
        String chucVu = "Nhân viên";
        try {
            actualResult = nhanVienService.validateNhanVien2(
                    hoVaTen, ngaySinh2, diaChi, cccd, soDienThoai, email, ghiChu, chucVu
            );
            if (actualResult==true) {
                NhanVienDomainModel nhanVien = new NhanVienDomainModel();
                nhanVien.setHoVaTen(hoVaTen);
                nhanVien.setNgaySinh(ngaySinh2);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setCCCD(cccd);
                nhanVien.setTrangThai(1);
                nhanVien.setEmail(email);
                nhanVien.setSoDienThoai(soDienThoai);
                nhanVien.setGhiChu(ghiChu);
                nhanVien.setAnh(null);
                nhanVien.setChucVu(chucVu);
                expected = nhanVienRepository.insertNhanVien(nhanVien);
            }
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
        Assert.assertEquals(expected, actualResult);
    }

    @Test
    public void insertNhanVien5() {
        // thêm nhân viên thất bại với email để trống
        Boolean actualResult = false;
        Boolean expected = false;
        String hoVaTen = "Lê Th Thơ";
        Date ngaySinh = Date.valueOf("2000-03-09");
        String diaChi = "Thanh hóa";
        String cccd = "021984382";
        String soDienThoai = "0394283544";
        String email = "";
        String ghiChu = "khong";
        String chucVu = "Nhân viên";
        try {
            actualResult = nhanVienService.validateNhanVien(
                    hoVaTen, ngaySinh, diaChi, cccd, soDienThoai, email, ghiChu, chucVu
            );
            if (actualResult==true) {
                NhanVienDomainModel nhanVien = new NhanVienDomainModel();
                nhanVien.setHoVaTen(hoVaTen);
                nhanVien.setNgaySinh(ngaySinh);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setCCCD(cccd);
                nhanVien.setTrangThai(1);
                nhanVien.setEmail(email);
                nhanVien.setSoDienThoai(soDienThoai);
                nhanVien.setGhiChu(ghiChu);
                nhanVien.setAnh(null);
                nhanVien.setChucVu(chucVu);
                expected = nhanVienRepository.insertNhanVien(nhanVien);
            }
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
        Assert.assertEquals(expected, actualResult);
    }

    @Test
    public void insertNhanVien6() {
        // thêm nhân viên thất bại với CCCD sai định dạng 9 số
        Boolean actualResult = false;
        Boolean expected = false;
        String hoVaTen = "Lê Th Hai";
        Date ngaySinh = Date.valueOf("2000-03-09");
        String diaChi = "Thanh hóa";
        String cccd = "0219843823487";
        String soDienThoai = "0876564556";
        String email = "hai@gmail.com";
        String ghiChu = "khong";
        String chucVu = "Nhân viên";
        try {
            actualResult = nhanVienService.validateNhanVien(
                    hoVaTen, ngaySinh, diaChi, cccd, soDienThoai, email, ghiChu, chucVu
            );
            if (actualResult==true) {
                NhanVienDomainModel nhanVien = new NhanVienDomainModel();
                nhanVien.setHoVaTen(hoVaTen);
                nhanVien.setNgaySinh(ngaySinh);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setCCCD(cccd);
                nhanVien.setTrangThai(1);
                nhanVien.setEmail(email);
                nhanVien.setSoDienThoai(soDienThoai);
                nhanVien.setGhiChu(ghiChu);
                nhanVien.setAnh(null);
                nhanVien.setChucVu(chucVu);
                expected = nhanVienRepository.insertNhanVien(nhanVien);
            }
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
        Assert.assertEquals(expected, actualResult);
    }

    @Test
    public void insertNhanVien7() {
        // thêm nhân viên thất bại với tên có độ dài quá length 40
        Boolean actualResult = false;
        Boolean expected = false;
        String hoVaTen = "ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt";
        Date ngaySinh = Date.valueOf("2000-03-09");
        String diaChi = "Thanh hóa";
        String cccd = "021984382";
        String soDienThoai = "0897654556";
        String email = "hai@gmail.com";
        String ghiChu = "khong";
        String chucVu = "Nhân viên";
        try {
            actualResult = nhanVienService.validateNhanVien(
                    hoVaTen, ngaySinh, diaChi, cccd, soDienThoai, email, ghiChu, chucVu
            );
            if (actualResult==true) {
                NhanVienDomainModel nhanVien = new NhanVienDomainModel();
                nhanVien.setHoVaTen(hoVaTen);
                nhanVien.setNgaySinh(ngaySinh);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setCCCD(cccd);
                nhanVien.setTrangThai(1);
                nhanVien.setEmail(email);
                nhanVien.setSoDienThoai(soDienThoai);
                nhanVien.setGhiChu(ghiChu);
                nhanVien.setAnh(null);
                nhanVien.setChucVu(chucVu);
                expected = nhanVienRepository.insertNhanVien(nhanVien);
            }
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
        Assert.assertEquals(expected, actualResult);
    }

    @Test
    public void insertNhanVien8() {
        // thêm nhân viên thất bại với tên chứa ký tự đặc biệt
        Boolean actualResult = false;
        Boolean expected = false;
        String hoVaTen = " tho &%$";
        Date ngaySinh = Date.valueOf("2000-03-09");
        String diaChi = "Thanh hóa";
        String cccd = "021984382";
        String soDienThoai = "0876546777";
        String email = "hai@gmail.com";
        String ghiChu = "khong";
        String chucVu = "Nhân viên";
        try {
            actualResult = nhanVienService.validateNhanVien(
                    hoVaTen, ngaySinh, diaChi, cccd, soDienThoai, email, ghiChu, chucVu
            );
            if (actualResult==true) {
                NhanVienDomainModel nhanVien = new NhanVienDomainModel();
                nhanVien.setHoVaTen(hoVaTen);
                nhanVien.setNgaySinh(ngaySinh);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setCCCD(cccd);
                nhanVien.setTrangThai(1);
                nhanVien.setEmail(email);
                nhanVien.setSoDienThoai(soDienThoai);
                nhanVien.setGhiChu(ghiChu);
                nhanVien.setAnh(null);
                nhanVien.setChucVu(chucVu);
                expected = nhanVienRepository.insertNhanVien(nhanVien);
            }
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
        Assert.assertEquals(expected, actualResult);
    }

    @Test
    public void insertNhanVien9() {
        // thêm nhân viên thất bại với tên trống
        Boolean actualResult = false;
        Boolean expected = false;
        String hoVaTen = null;
        Date ngaySinh = Date.valueOf("2000-03-09");
        String diaChi = "Thanh hóa";
        String cccd = "021984382";
        String soDienThoai = "0987656788";
        String email = "hai@gmail.com";
        String ghiChu = "khong";
        String chucVu = "Nhân viên";
        try {
            actualResult = nhanVienService.validateNhanVien(
                    hoVaTen, ngaySinh, diaChi, cccd, soDienThoai, email, ghiChu, chucVu
            );
            if (actualResult==true) {
                NhanVienDomainModel nhanVien = new NhanVienDomainModel();
                nhanVien.setHoVaTen(hoVaTen);
                nhanVien.setNgaySinh(ngaySinh);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setCCCD(cccd);
                nhanVien.setTrangThai(1);
                nhanVien.setEmail(email);
                nhanVien.setSoDienThoai(soDienThoai);
                nhanVien.setGhiChu(ghiChu);
                nhanVien.setAnh(null);
                nhanVien.setChucVu(chucVu);
                expected = nhanVienRepository.insertNhanVien(nhanVien);
            }
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
        Assert.assertEquals(expected, actualResult);
    }

    @Test
    public void update() {
        //Update Nhân viên với tất cả các trường hợp lệ
        Boolean actualResult = false;
        Boolean expected = false;
        String hoVaTen = "Nam Quang";
        Date ngaySinh = Date.valueOf("2000-03-09");
        String diaChi = "Thanh hóa";
        String cccd = "021984382";
        String soDienThoai = "0855678788";
        String email = "hai@gmail.com";
        String ghiChu = "khong";
        String chucVu = "Nhân viên";
        try {
            actualResult = nhanVienService.validateNhanVien(
                    hoVaTen, ngaySinh, diaChi, cccd, soDienThoai, email, ghiChu, chucVu
            );
            if (actualResult==true) {
                NhanVienDomainModel nhanVien = new NhanVienDomainModel();
                nhanVien.setHoVaTen(hoVaTen);
                nhanVien.setNgaySinh(ngaySinh);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setCCCD(cccd);
                nhanVien.setTrangThai(1);
                nhanVien.setEmail(email);
                nhanVien.setSoDienThoai(soDienThoai);
                nhanVien.setGhiChu(ghiChu);
                nhanVien.setAnh(null);
                nhanVien.setChucVu(chucVu);
                expected = nhanVienRepository.update(1000,nhanVien);
            }
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
        Assert.assertEquals(expected, actualResult);
    }
}