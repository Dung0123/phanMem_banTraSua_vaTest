package repositorys;

import domainmodel.NhanVienDomainModel;
import org.junit.Assert;
import org.junit.Test;
import repositorys.iRepository.INhanVienRepository;

import java.sql.Date;

import static org.junit.Assert.*;

public class NhanVienRepositoryTest {
    NhanVienDomainModel nhanVien = new NhanVienDomainModel();
    INhanVienRepository nhanVienRepository = new NhanVienRepository();
    @Test
    public void insert1() {
        // thêm nhân viên thất bại với sdt sai định dạng
        nhanVien.setHoVaTen("Lê thi g");
        nhanVien.setNgaySinh(Date.valueOf("2004-03-09"));
        nhanVien.setDiaChi("Thái bình");
        nhanVien.setCCCD("035432543");
        nhanVien.setTrangThai(1);
        nhanVien.setEmail("g@gmail.com");
        nhanVien.setSoDienThoai("032584");
        nhanVien.setGhiChu("khong");
        nhanVien.setAnh(null);
        nhanVien.setChucVu("Nhân viên");
        Boolean actualReult = nhanVienRepository.insertNhanVien(nhanVien);
        Boolean expected = false;
        Assert.assertEquals(expected, actualReult);
    }

    @Test
    public void update1() {
    }
}