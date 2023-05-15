import java.util.ArrayList;
import java.util.Date;

class KhachHang {
    protected String maKH;
    protected String hoTen;
    protected Date ngayRaHoaDon;

    public KhachHang(String maKH, String hoTen, Date ngayRaHoaDon) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.ngayRaHoaDon = ngayRaHoaDon;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgayRaHoaDon() {
        return ngayRaHoaDon;
    }

    public void setNgayRaHoaDon(Date ngayRaHoaDon) {
        this.ngayRaHoaDon = ngayRaHoaDon;
    }
}

class KhachHangVietNam extends KhachHang {
    private String doiTuongKH;
    private double soLuong;
    private double donGia;
    private double dinhMuc;

    public KhachHangVietNam(String maKH, String hoTen, Date ngayRaHoaDon, String doiTuongKH, double soLuong, double donGia, double dinhMuc) {
        super(maKH, hoTen, ngayRaHoaDon);
        this.doiTuongKH = doiTuongKH;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.dinhMuc = dinhMuc;
    }

    public String getDoiTuongKH() {
        return doiTuongKH;
    }

    public void setDoiTuongKH(String doiTuongKH) {
        this.doiTuongKH = doiTuongKH;
    }

    public double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getDinhMuc() {
        return dinhMuc;
    }

    public void setDinhMuc(double dinhMuc) {
        this.dinhMuc = dinhMuc;
    }

    public double thanhTien() {
        double thanhTien = 0;
        if (soLuong <= dinhMuc) {
            thanhTien = soLuong * donGia;
        } else {
            double vuotDinhMuc = soLuong - dinhMuc;
            thanhTien = dinhMuc * donGia + vuotDinhMuc * donGia * 2.5;
        }
        return thanhTien;
    }
}

class KhachHangNuocNgoai extends KhachHang {
    private String quocTich;
    private double soLuong;
    private double donGia;

    public KhachHangNuocNgoai(String maKH, String hoTen, Date ngayRaHoaDon, String quocTich, double soLuong, double donGia) {
        super(maKH, hoTen, ngayRaHoaDon);
        this.quocTich = quocTich;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double thanhTien() {
        return soLuong * donGia;
    }
}

class DanhSachHoaDon {
    private ArrayList<KhachHang> danhSachHoaDon;

    public DanhSachHoaDon() {
        danhSachHoaDon = new ArrayList<>();
    }

    public void themKhachHang(KhachHang khachHang) {
        danhSachHoaDon.add(khachHang);
    }

    public void xuatDanhSachHoaDon() {
        for (KhachHang khachHang : danhSachHoaDon) {
            if (khachHang instanceof KhachHangVietNam) {
                KhachHangVietNam khachHangVN = (KhachHangVietNam) khachHang;
                System.out.println("Khach hang Viet Nam: " + khachHangVN.getMaKH() + " - " + khachHangVN.getHoTen() + " - " + khachHangVN.getNgayRaHoaDon()
                        + " - " + khachHangVN.getDoiTuongKH() + " - " + khachHangVN.getSoLuong() + " - " + khachHangVN.thanhTien());
            } else if (khachHang instanceof KhachHangNuocNgoai) {
                KhachHangNuocNgoai khachHangNN = (KhachHangNuocNgoai) khachHang;
                System.out.println("Khach hang nuoc ngoai: " + khachHangNN.getMaKH() + " - " + khachHangNN.getHoTen() + " - " + khachHangNN.getNgayRaHoaDon()
                        + " - " + khachHangNN.getQuocTich() + " - " + khachHangNN.getSoLuong() + " - " + khachHangNN.thanhTien());
            }
        }
    }

    public double tinhTongSoLuong(String loaiKhachHang) {
        double tongSoLuong = 0;
        if (loaiKhachHang.equals("VN")) {
            for (KhachHang khachHang : danhSachHoaDon) {
                if (khachHang instanceof KhachHangVietNam) {
                    KhachHangVietNam khachHangVN = (KhachHangVietNam) khachHang;
                    tongSoLuong += khachHangVN.getSoLuong();
                }
            }
        } else if (loaiKhachHang.equals("NN")) {
            for (KhachHang khachHang : danhSachHoaDon) {
                if (khachHang instanceof KhachHangNuocNgoai) {
                    KhachHangNuocNgoai khachHangNN = (KhachHangNuocNgoai) khachHang;
                    tongSoLuong += khachHangNN.getSoLuong();
                }
            }
        }

        return tongSoLuong;
    }

    public void xuatHoaDonThang9Nam2013() {
        for (KhachHang khachHang : danhSachHoaDon) {
            if (khachHang.getNgayRaHoaDon().getYear() == 2013 && khachHang.getNgayRaHoaDon().getMonth() + 1 == 9) {
                if (khachHang instanceof KhachHangVietNam) {
                    KhachHangVietNam khachHangVN = (KhachHangVietNam) khachHang;
                    System.out.println("Khach hang Viet Nam: " + khachHangVN.getMaKH() + " - " + khachHangVN.getHoTen() + " - " + khachHangVN.getNgayRaHoaDon()
                            + " - " + khachHangVN.getDoiTuongKH() + " - " + khachHangVN.getSoLuong() + " - " + khachHangVN.thanhTien());
                } else if (khachHang instanceof KhachHangNuocNgoai) {
                    KhachHangNuocNgoai khachHangNN = (KhachHangNuocNgoai) khachHang;
                    System.out.println("Khach hang nuoc ngoai: " + khachHangNN.getMaKH() + " - " + khachHangNN.getHoTen() + " - " + khachHangNN.getNgayRaHoaDon()
                            + " - " + khachHangNN.getQuocTich() + " - " + khachHangNN.getSoLuong() + " - " + khachHangNN.thanhTien());
                }
            }
        }
    }

    public double tinhTrungBinhThanhTienKhachHangNuocNgoai() {
        int soKhachHangNN = 0;
        double tongThanhTienNN = 0;
        for (KhachHang khachHang : danhSachHoaDon) {
            if (khachHang instanceof KhachHangNuocNgoai) {
                KhachHangNuocNgoai khachHangNN = (KhachHangNuocNgoai) khachHang;
                tongThanhTienNN += khachHangNN.thanhTien();
                soKhachHangNN++;
            }
        }
        return tongThanhTienNN / soKhachHangNN;
    }
}

public class thuchanh41 {
    public static void main(String[] args) {
        DanhSachHoaDon danhSachHoaDon = new DanhSachHoaDon();

        KhachHang khachHang1 = new KhachHangVietNam("KH1", "Nguyen Van A", new Date(2013 - 1900, 8, 1), "Sinh hoat", 100, 3000, 50);
        KhachHang khachHang2 = new KhachHangVietNam("KH2", "Tran Thi B", new Date(2013 - 1900, 8, 10), "Kinh doanh", 500, 3500, 200);
        KhachHang khachHang3 = new KhachHangNuocNgoai("KH3", "John Smith", new Date(2013 - 1900, 8, 15), "USA", 200, 4000);
        KhachHang khachHang4 = new KhachHangNuocNgoai("KH4", "Taro Yamada", new Date(2013 - 1900, 8, 20), "Japan", 300, 5000);

        danhSachHoaDon.themKhachHang(khachHang1);
        danhSachHoaDon.themKhachHang(khachHang2);
        danhSachHoaDon.themKhachHang(khachHang3);
        danhSachHoaDon.themKhachHang(khachHang4);

        System.out.println("Danh sach hoa don:");
        danhSachHoaDon.xuatDanhSachHoaDon();

        System.out.println("Tong so luong khach hang Viet Nam: " + danhSachHoaDon.tinhTongSoLuong("VN"));
        System.out.println("Tong so luong khach hang nuoc ngoai: " + danhSachHoaDon.tinhTongSoLuong("NN"));

        System.out.println("Hoa don trong thang 9 nam 2013:");
        danhSachHoaDon.xuatHoaDonThang9Nam2013();

        System.out.println("Trung binh thanh tien cua khach hang nuoc ngoai: " + danhSachHoaDon.tinhTrungBinhThanhTienKhachHangNuocNgoai());
    }
}
