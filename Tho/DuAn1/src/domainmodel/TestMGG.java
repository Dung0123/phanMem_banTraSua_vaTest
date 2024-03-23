package domainmodel;
import org.junit.Test;
import repositorys.MaGiamGiaRepository;

import java.math.BigDecimal;
import java.sql.Date;

import static junit.framework.TestCase.assertEquals;

public class TestMGG {
    MaGiamGiaRepository repository= new MaGiamGiaRepository();
    MaGiamGiaDomainModel giamGia= new MaGiamGiaDomainModel();
    @Test
    public void testInsert1(){
        giamGia.setPhanTramGiam(5);
        giamGia.setDonToiThieu(1);
        giamGia.setGiamToiDa(new BigDecimal(25000));
        giamGia.setNgayBatDau(new Date(2023-11-15));
        giamGia.setNgayKetThuc(new Date(2023-11-30));
        giamGia.setMaNguoiTao(1000);
        giamGia.setSoLuong(30);
        Boolean rs=repository.insertMaGiamGia(giamGia);
        Boolean expectedRS=true;
        assertEquals(rs,expectedRS);
    }

    @Test
    public void testInsert2(){
        giamGia.setPhanTramGiam(-1);
        giamGia.setDonToiThieu(1);
        giamGia.setGiamToiDa(new BigDecimal(25000));
        giamGia.setNgayBatDau(new Date(2023-11-15));
        giamGia.setNgayKetThuc(new Date(2023-11-30));
        giamGia.setMaNguoiTao(1000);
        giamGia.setSoLuong(30);
        Boolean rs=repository.insertMaGiamGia(giamGia);
        Boolean expectedRS=true;
        assertEquals(rs,expectedRS);
    }

    @Test
    public void testInsert3(){
        giamGia.setPhanTramGiam(-50);
        giamGia.setDonToiThieu(1);
        giamGia.setGiamToiDa(new BigDecimal(25000));
        giamGia.setNgayBatDau(new Date(2023-11-15));
        giamGia.setNgayKetThuc(new Date(2023-11-30));
        giamGia.setMaNguoiTao(1000);
        giamGia.setSoLuong(30);
        Boolean rs=repository.insertMaGiamGia(giamGia);
        Boolean expectedRS=true;
        assertEquals(rs,expectedRS);
    }

    @Test
    public void testInsert4(){
        giamGia.setPhanTramGiam(5);
        giamGia.setDonToiThieu(-1);
        giamGia.setGiamToiDa(new BigDecimal(25000));
        giamGia.setNgayBatDau(new Date(2023-11-15));
        giamGia.setNgayKetThuc(new Date(2023-11-30));
        giamGia.setMaNguoiTao(1000);
        giamGia.setSoLuong(30);
        Boolean rs=repository.insertMaGiamGia(giamGia);
        Boolean expectedRS=true;
        assertEquals(rs,expectedRS);
    }

    @Test
    public void testInsert5(){
        giamGia.setPhanTramGiam(5);
        giamGia.setDonToiThieu(-20);
        giamGia.setGiamToiDa(new BigDecimal(25000));
        giamGia.setNgayBatDau(new Date(2023-11-15));
        giamGia.setNgayKetThuc(new Date(2023-11-30));
        giamGia.setMaNguoiTao(1000);
        giamGia.setSoLuong(30);
        Boolean rs=repository.insertMaGiamGia(giamGia);
        Boolean expectedRS=true;
        assertEquals(rs,expectedRS);
    }

    @Test
    public void testInsert6(){
        giamGia.setPhanTramGiam(5);
        giamGia.setDonToiThieu(1);
        giamGia.setGiamToiDa(new BigDecimal(25000));
        giamGia.setNgayBatDau(new Date(2023-11-15));
        giamGia.setNgayKetThuc(new Date(2023-11-30));
        giamGia.setMaNguoiTao(-1);
        giamGia.setSoLuong(30);
        Boolean rs=repository.insertMaGiamGia(giamGia);
        Boolean expectedRS=true;
        assertEquals(rs,expectedRS);
    }

    @Test
    public void testInsert7(){
        giamGia.setPhanTramGiam(5);
        giamGia.setDonToiThieu(1);
        giamGia.setGiamToiDa(new BigDecimal(25000));
        giamGia.setNgayBatDau(new Date(2023-11-15));
        giamGia.setNgayKetThuc(new Date(2023-11-30));
        giamGia.setMaNguoiTao(-10);
        giamGia.setSoLuong(30);
        Boolean rs=repository.insertMaGiamGia(giamGia);
        Boolean expectedRS=true;
        assertEquals(rs,expectedRS);
    }

    @Test
    public void testInsert8(){
        giamGia.setPhanTramGiam(5);
        giamGia.setDonToiThieu(1);
        giamGia.setGiamToiDa(new BigDecimal(25000));
        giamGia.setNgayBatDau(new Date(2023-11-15));
        giamGia.setNgayKetThuc(new Date(2023-11-30));
        giamGia.setMaNguoiTao(1000);
        giamGia.setSoLuong(-1);
        Boolean rs=repository.insertMaGiamGia(giamGia);
        Boolean expectedRS=true;
        assertEquals(rs,expectedRS);
    }

    @Test
    public void testInsert9(){
        giamGia.setPhanTramGiam(5);
        giamGia.setDonToiThieu(1);
        giamGia.setGiamToiDa(new BigDecimal(25000));
        giamGia.setNgayBatDau(new Date(2023-11-15));
        giamGia.setNgayKetThuc(new Date(2023-11-30));
        giamGia.setMaNguoiTao(1000);
        giamGia.setSoLuong(-50);
        Boolean rs=repository.insertMaGiamGia(giamGia);
        Boolean expectedRS=true;
        assertEquals(rs,expectedRS);
    }

    @Test
    public void testInsert10(){
        giamGia.setPhanTramGiam(5);
        giamGia.setDonToiThieu(1);
        giamGia.setGiamToiDa(new BigDecimal(25000));
        giamGia.setNgayBatDau(new Date(2023-11-15));
        giamGia.setNgayKetThuc(new Date(2023-11-30));
        giamGia.setMaNguoiTao(1000);
        giamGia.setSoLuong(-100);
        Boolean rs=repository.insertMaGiamGia(giamGia);
        Boolean expectedRS=true;
        assertEquals(rs,expectedRS);
    }
}
