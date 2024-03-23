/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodel.NhanVienDomainModel;
import interfaceservices.INhanVienService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import repositorys.iRepository.INhanVienRepository;
import repositorys.NhanVienRepository;
import viewmodel.NhanVienViewModel;

/**
 * @author Admin
 */
public class NhanVienService implements INhanVienService {

    public INhanVienRepository iNhanVienRepository = new NhanVienRepository();

    @Override
    public int getMaNhanVienByEmail(String email) {
        return iNhanVienRepository.getMaNhanVienByEmail(email);
    }

    @Override
    public String checkEmail(String email) {
        return iNhanVienRepository.checkEmail(email);
    }

    @Override
    public ArrayList<NhanVienViewModel> getAll() {
        ArrayList<NhanVienDomainModel> listNhanVienDomainModels = iNhanVienRepository.getAll();
        ArrayList<NhanVienViewModel> listNhanVienViewModels = new ArrayList<>();
        for (NhanVienDomainModel nhanVienDomainModel : listNhanVienDomainModels) {
            NhanVienViewModel nhanVienViewModel = new NhanVienViewModel();
            nhanVienViewModel.setMaNhanVien(nhanVienDomainModel.getMaNhanVien());
            nhanVienViewModel.setHoVaTen(nhanVienDomainModel.getHoVaTen());
            nhanVienViewModel.setNgaySinh(nhanVienDomainModel.getNgaySinh());
            nhanVienViewModel.setDiaChi(nhanVienDomainModel.getDiaChi());
            nhanVienViewModel.setCCCD(nhanVienDomainModel.getCCCD());
            nhanVienViewModel.setTrangThai(nhanVienDomainModel.getTrangThai());
            nhanVienViewModel.setEmail(nhanVienDomainModel.getEmail());
            nhanVienViewModel.setSoDienThoai(nhanVienDomainModel.getSoDienThoai());
            nhanVienViewModel.setGhiChu(nhanVienDomainModel.getGhiChu());
            nhanVienViewModel.setAnh(nhanVienDomainModel.getAnh());
            nhanVienViewModel.setChucVu(nhanVienDomainModel.getChucVu());
            listNhanVienViewModels.add(nhanVienViewModel);
        }
        return listNhanVienViewModels;
    }

    public boolean validateNhanVien(String hoVaTen, Date ngaySinh, String diaChi, String cccd, String soDienThoai, String email, String ghiChu, String chucVu) {
        if (soDienThoai == null || soDienThoai.trim().isEmpty()) {
            System.out.println("Lỗi: Số điện thoại không được để trống.");
            return false;
        } else if (!soDienThoai.matches("\\d{10}")) {
            System.out.println("Lỗi: Định dạng số điện thoại không hợp lệ. Số điện thoại phải có 10 chữ số.");
            return false;
        } else if (ngaySinh == null) {
            System.out.println("Lỗi: Ngày sinh không được để trống.");
            return false;
        } else if (email == null || email.trim().isEmpty() ||
                !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            System.out.println("Lỗi: Định dạng email không hợp lệ.");
            return false;
        } else if (cccd == null || cccd.trim().isEmpty()) {
            System.out.println("Lỗi: CCCD không được để trống.");
            return false;
        } else if (!cccd.matches("\\d{9}")) {
            System.out.println("Lỗi: Định dạng CCCD không hợp lệ. CCCD phải có 9 chữ số.");
            return false;
        }else if (hoVaTen==null||!hoVaTen.matches("^[a-zA-Z\\s]+$")) {
            System.out.println("Lỗi: Tên không được chứa ký tự đặc biệt hoặc để trống.");
            return false;
        }
        if (hoVaTen.length() > 40) {
            System.out.println("Lỗi: Tên quá dài. Độ dài tối đa là 40 ký tự.");
            return false;
        }
        // Validate date of birth format
        if (!isValidDateFormat(ngaySinh)) {
            System.out.println("Lỗi: Định dạng ngày sinh không hợp lệ. Sử dụng định dạng yyyy-MM-dd.");
            return false;
        }
        return true;
    }
    public boolean validateNhanVien2(String hoVaTen, Date ngaySinh, String diaChi, String cccd, String soDienThoai, String email, String ghiChu, String chucVu) {
        if (soDienThoai == null || soDienThoai.trim().isEmpty()) {
            System.out.println("Lỗi: Số điện thoại không được để trống.");
            return false;
        } else if (!soDienThoai.matches("\\d{10}")) {
            System.out.println("Lỗi: Định dạng số điện thoại không hợp lệ. Số điện thoại phải có 10 chữ số.");
            return false;
        } else if (ngaySinh == null) {
            System.out.println("Lỗi: Ngày sinh không được để trống.");
            return false;
        } else if (email == null || email.trim().isEmpty() ||
                !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            System.out.println("Lỗi: Định dạng email không hợp lệ.");
            return false;
        } else if (cccd == null || cccd.trim().isEmpty()) {
            System.out.println("Lỗi: CCCD không được để trống.");
            return false;
        } else if (!cccd.matches("\\d{9}")) {
            System.out.println("Lỗi: Định dạng CCCD không hợp lệ. CCCD phải có 9 chữ số.");
            return false;
        }else if (hoVaTen==null||!hoVaTen.matches("^[a-zA-Z\\s]+$")) {
            System.out.println("Lỗi: Tên không được chứa ký tự đặc biệt hoặc để trống.");
            return false;
        }
        if (hoVaTen.length() > 40) {
            System.out.println("Lỗi: Tên quá dài. Độ dài tối đa là 40 ký tự.");
            return false;
        }
        // Validate date of birth format
        if (!isValidDateFormat(ngaySinh)) {
            System.out.println("Lỗi: Định dạng ngày sinh không hợp lệ. Sử dụng định dạng yyyy-MM-dd.");
            return false;
        }
        return false;
    }
    private boolean validateDate(String dateString) {
        try {
            // Chuyển đổi chuỗi thành LocalDate
            LocalDate parsedDate = LocalDate.parse(dateString);

            // Kiểm tra năm, tháng và ngày
            int year = parsedDate.getYear();
            int month = parsedDate.getMonthValue();
            int day = parsedDate.getDayOfMonth();

            // Kiểm tra tính hợp lệ của năm, tháng và ngày
            if (year < 1900 || year > 2100) {
                return false; // Năm không hợp lệ
            }

            if (month < 1 || month > 12) {
                return false; // Tháng không hợp lệ
            }

            if (day < 1 || day > parsedDate.lengthOfMonth()) {
                return false; // Ngày không hợp lệ
            }

            return true; // Ngày sinh hợp lệ
        } catch (Exception e) {
            return false; // Lỗi chuyển đổi hoặc ngày không hợp lệ
        }
    }
    private static boolean isValidDateFormat(Date ngaySinh) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false); // Disable lenient parsing

        try {
            Date ngaDate = sdf.parse(String.valueOf(ngaySinh));
            // Date format is valid
            return true;
        } catch (ParseException e) {
            // Invalid date format
            return false;
        }
    }

    @Override
    public Boolean insertNhanVien(NhanVienViewModel nhanVienViewModel) {

        try {
            boolean flag1 = true;
            if (!nhanVienViewModel.getSoDienThoai().matches("\\d{10}")) {
                flag1 = false;
            }

            if (!flag1) {
                return false;
            }
            NhanVienDomainModel nhanVienDomainModel = new NhanVienDomainModel();
            nhanVienDomainModel.setHoVaTen(nhanVienViewModel.getHoVaTen());
            nhanVienDomainModel.setNgaySinh(nhanVienViewModel.getNgaySinh());
            nhanVienDomainModel.setDiaChi(nhanVienViewModel.getDiaChi());
            nhanVienDomainModel.setCCCD(nhanVienViewModel.getCCCD());
            nhanVienDomainModel.setTrangThai(nhanVienViewModel.getTrangThai());
            nhanVienDomainModel.setEmail(nhanVienViewModel.getEmail());
            nhanVienDomainModel.setSoDienThoai(nhanVienViewModel.getSoDienThoai());
            nhanVienDomainModel.setGhiChu(nhanVienViewModel.getGhiChu());
            nhanVienDomainModel.setAnh(nhanVienViewModel.getAnh());
            nhanVienDomainModel.setChucVu(nhanVienViewModel.getChucVu());

//            if (iNhanVienRepository.checkTrungEmail(nhanVienDomainModel.getEmail())) {
//                return "Email không được trùng";
//            }
            if (iNhanVienRepository.insertNhanVien(nhanVienDomainModel)) {
                return true;
            } else {
                return false;
            }


        } catch (Exception e) {

        }
        return false;

    }

    @Override
    public NhanVienViewModel loadMouseclicked(int maNhanVien) {
        NhanVienDomainModel nhanVienDomainModel = iNhanVienRepository.loadMouseClick(maNhanVien);
        NhanVienViewModel nhanVienViewModel = new NhanVienViewModel();
        nhanVienViewModel.setAnh(nhanVienDomainModel.getAnh());
        nhanVienViewModel.setNgaySinh(nhanVienDomainModel.getNgaySinh());
        nhanVienViewModel.setDiaChi(nhanVienDomainModel.getDiaChi());
        nhanVienViewModel.setTrangThai(nhanVienDomainModel.getTrangThai());
        nhanVienViewModel.setGhiChu(nhanVienDomainModel.getGhiChu());
        return nhanVienViewModel;
    }

    @Override
    public String update(int maNhanVien, NhanVienViewModel nhanVienViewModel) {
        NhanVienDomainModel nhanVienDomainModel = new NhanVienDomainModel();
        nhanVienDomainModel.setHoVaTen(nhanVienViewModel.getHoVaTen());
        nhanVienDomainModel.setNgaySinh(nhanVienViewModel.getNgaySinh());
        nhanVienDomainModel.setDiaChi(nhanVienViewModel.getDiaChi());
        nhanVienDomainModel.setCCCD(nhanVienViewModel.getCCCD());
        nhanVienDomainModel.setTrangThai(nhanVienViewModel.getTrangThai());
        nhanVienDomainModel.setEmail(nhanVienViewModel.getEmail());
        nhanVienDomainModel.setSoDienThoai(nhanVienViewModel.getSoDienThoai());
        nhanVienDomainModel.setGhiChu(nhanVienViewModel.getGhiChu());
        nhanVienDomainModel.setAnh(nhanVienViewModel.getAnh());
        nhanVienDomainModel.setChucVu(nhanVienViewModel.getChucVu());

        if (iNhanVienRepository.update(maNhanVien, nhanVienDomainModel)) {
            return "Cập nhật nhân viên thành công";
        } else {
            return "Cập nhật nhân viên thất bại";
        }
    }

    @Override
    public NhanVienViewModel getNhanVienById(int maNhanVien) {
        NhanVienDomainModel nhanVienDomainModel = iNhanVienRepository.getNhanVienById(maNhanVien);
        NhanVienViewModel nhanVienViewModel = new NhanVienViewModel();
        nhanVienViewModel.setMaNhanVien(nhanVienDomainModel.getMaNhanVien());
        nhanVienViewModel.setHoVaTen(nhanVienDomainModel.getHoVaTen());
        nhanVienViewModel.setNgaySinh(nhanVienDomainModel.getNgaySinh());
        nhanVienViewModel.setDiaChi(nhanVienDomainModel.getDiaChi());
        nhanVienViewModel.setCCCD(nhanVienDomainModel.getCCCD());
        nhanVienViewModel.setTrangThai(nhanVienDomainModel.getTrangThai());
        nhanVienViewModel.setEmail(nhanVienDomainModel.getEmail());
        nhanVienViewModel.setSoDienThoai(nhanVienDomainModel.getSoDienThoai());
        nhanVienViewModel.setGhiChu(nhanVienDomainModel.getGhiChu());
        nhanVienViewModel.setAnh(nhanVienDomainModel.getAnh());
        nhanVienViewModel.setChucVu(nhanVienDomainModel.getChucVu());
        return nhanVienViewModel;
    }

    @Override
    public ArrayList<NhanVienViewModel> getNhanVienByTen(String ten) {
        ArrayList<NhanVienDomainModel> getNhanVienDomainModels = iNhanVienRepository.getNhanVienByTen(ten);
        ArrayList<NhanVienViewModel> getNhanVienViewModels = new ArrayList<>();
        for (NhanVienDomainModel nhanVienDomainModel : getNhanVienDomainModels) {
            NhanVienViewModel nhanVienViewModel = new NhanVienViewModel();
            nhanVienViewModel.setMaNhanVien(nhanVienDomainModel.getMaNhanVien());
            nhanVienViewModel.setHoVaTen(nhanVienDomainModel.getHoVaTen());
            nhanVienViewModel.setCCCD(nhanVienDomainModel.getCCCD());
            nhanVienViewModel.setSoDienThoai(nhanVienDomainModel.getSoDienThoai());
            nhanVienViewModel.setEmail(nhanVienDomainModel.getEmail());
            nhanVienViewModel.setChucVu(nhanVienDomainModel.getChucVu());
            getNhanVienViewModels.add(nhanVienViewModel);
        }
        return getNhanVienViewModels;
    }

    @Override
    public ArrayList<NhanVienViewModel> getNhanVienByTrangThai(int trangThai) {
        ArrayList<NhanVienDomainModel> getNhanVienDomainModels = iNhanVienRepository.getNhanVienByTrangThai(trangThai);
        ArrayList<NhanVienViewModel> getNhanVienViewModels = new ArrayList<>();
        for (NhanVienDomainModel nhanVienDomainModel : getNhanVienDomainModels) {
            NhanVienViewModel nhanVienViewModel = new NhanVienViewModel();
            nhanVienViewModel.setMaNhanVien(nhanVienDomainModel.getMaNhanVien());
            nhanVienViewModel.setHoVaTen(nhanVienDomainModel.getHoVaTen());
            nhanVienViewModel.setCCCD(nhanVienDomainModel.getCCCD());
            nhanVienViewModel.setSoDienThoai(nhanVienDomainModel.getSoDienThoai());
            nhanVienViewModel.setEmail(nhanVienDomainModel.getEmail());
            nhanVienViewModel.setChucVu(nhanVienDomainModel.getChucVu());
            getNhanVienViewModels.add(nhanVienViewModel);
        }
        return getNhanVienViewModels;
    }

    @Override
    public String getNhanVienByCCCD(String cccd) {
        if (iNhanVienRepository.getNhanVienByCCCD(cccd)) {
            return "CCCD đã tồn tại";
        } else {
            return null;
        }
    }

    @Override
    public String getSoDienThoaiBySDT(String sdt) {
        return iNhanVienRepository.getSoDienThoaiBySDT(sdt);
    }

    public int getByIdAccount(String idAccount) {
        return iNhanVienRepository.getByIdAccount(idAccount);
    }

}
