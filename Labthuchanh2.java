import java.util.Scanner;
class ThongTinDangKyXe {
    private String chuXe;
    private String loaiXe;
    private float triGia;
    private int dungTich;

    public ThongTinDangKyXe(String chuXe, String loaiXe, float triGia, int dungTich) {
        this.setChuXe(chuXe);
        this.setLoaiXe(loaiXe);
        this.setTriGia(triGia);
        this.setDungTich(dungTich);
    }

    // Setter methods
    public void setChuXe(String chuXe) {
        if (chuXe == null || chuXe.trim().isEmpty()) {
            throw new IllegalArgumentException("Chu xe khong hop le");
        }
        this.chuXe = chuXe.trim();
    }

    public void setLoaiXe(String loaiXe) {
        if (loaiXe == null || loaiXe.trim().isEmpty()) {
            throw new IllegalArgumentException("Loai xe khong hop le");
        }
        this.loaiXe = loaiXe.trim();
    }

    public void setTriGia(float triGia) {
        if (triGia < 0) {
            throw new IllegalArgumentException("Tri gia khong hop le");
        }
        this.triGia = triGia;
    }

    public void setDungTich(int dungTich) {
        if (dungTich < 0) {
            throw new IllegalArgumentException("Dung tich xy lanh khong hop le");
        }
        this.dungTich = dungTich;
    }

    // Getter methods
    public String getChuXe() {
        return chuXe;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public float getTriGia() {
        return triGia;
    }

    public int getDungTich() {
        return dungTich;
    }

    // Method to calculate registration tax
    public float calculateTax() {
        if (this.dungTich < 100) {
          return this.triGia * 0.01f;
        } else if (this.dungTich >= 100 && this.dungTich <= 200) {
          return this.triGia * 0.03f;
        } else {
          return this.triGia * 0.05f;
        }
    }
}
class Labthuchanh2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array of 3 ThongTinDangKyXe objects
        ThongTinDangKyXe[] danhSachXe = new ThongTinDangKyXe[3];
        for (int i = 0; i < danhSachXe.length; i++) {
            System.out.println("Nhap thong tin xe thu " + (i+1) + ":");
            System.out.print(" - Chu xe: ");
            String chuXe = scanner.nextLine();
            System.out.print(" - Loai xe: ");
            String loaiXe = scanner.nextLine();
            System.out.print(" - Tri gia: ");
            float triGia = scanner.nextFloat();
            scanner.nextLine(); // Consume the remaining \n character
            System.out.print(" - Dung tich: ");
            int dungTich = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining \n character

            danhSachXe[i] = new ThongTinDangKyXe(chuXe, loaiXe, triGia, dungTich);
        }

        // Print the registration tax table
        System.out.println("\nBANG KE KHAI TIEN THUE TRUOC BA:");
        System.out.println("Chu xe\t\tLoai xe\t\tTri gia\t\tDung tich xy lanh\tThue truoc ba");
        for (ThongTinDangKyXe xe : danhSachXe) {
            System.out.printf("%-16s %-16s %-14.0f %-24d %.2f\n", 
                xe.getChuXe(), xe.getLoaiXe(), xe.getTriGia(), xe.getDungTich(), xe.calculateTax());
        }
    }
}
