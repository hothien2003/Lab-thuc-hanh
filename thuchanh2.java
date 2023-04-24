import java.text.NumberFormat;
import java.util.Scanner;
 
 class Account 
{
    private long soTK;
    private String tenTK;
    private double soTienTrongTK;
    private String trangThai;
 
    Scanner sc = new Scanner(System.in);
 
    public Account() 
    {
    }
 
    public Account(long soTK, String tenTK, double soTienTrongTK, String trangThai) 
    {
        this.soTK = soTK;
        this.tenTK = tenTK;
        this.soTienTrongTK = soTienTrongTK;
        this.trangThai = trangThai;
    }
 
    public long getSoTK() 
    {
        return this.soTK;
    }
 
    public void setSoTK(long soTK) 
    {
        this.soTK = soTK;
    }
 
    public String getTenTK() 
    {
        return this.tenTK;
    }
 
    public void setTenTK(String tenTK) 
    {
        this.tenTK = tenTK;
    }
 
    public double getSoTienTrongTK() 
    {
        return this.soTienTrongTK;
    }
 
    public void setSoTienTrongTK(double soTienTrongTK) 
    {
        this.soTienTrongTK = soTienTrongTK;
    }

    public String getTrangThai()
    {
        return this.trangThai;
    }

    public void setTrangThai(String trangThai)
    {
        this.trangThai = trangThai;
    }
 
    public String toString() 
    {
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(soTienTrongTK);
        return soTK + "-" + tenTK + "-" + str1 + "-" + trangThai;
    }
 
    public double napTien() 
    {
        double nap;
        System.out.print("Nhap So Tien Can Nap: ");
        nap = sc.nextDouble();
        if (nap >= 0) 
        {
            soTienTrongTK = nap + soTienTrongTK;
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String str1 = currencyEN.format(nap);
            System.out.println("Da Nap " + str1 + " Vao Tai Khoan");
        } 
        else 
        {
            System.out.println("So Tien Can Nap Khong Hop Ly!");
        }
        return nap;
    }
 
    public double rutTien() 
    {
        double rut;
        System.out.print("Nhap So Tien Can Rut Ra: ");
        rut = sc.nextDouble();
        if (rut <= soTienTrongTK) 
        {
            soTienTrongTK = soTienTrongTK - rut;
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String str1 = currencyEN.format(rut);
            System.out.println("Da Rut" + str1 + "D Tu Tai Khoan");
        } 
        else 
        {
            System.out.println("So Tien Muon Rut Khong Hop Ly!");
            return rutTien();
        }
        return rut;
    }
 
    public double daoHan() 
    {
        double laiSuat = 0.035;
        soTienTrongTK = soTienTrongTK + soTienTrongTK * laiSuat;
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(soTienTrongTK);
        System.out.println("Da Duoc " + str1 + " Tu Dao Han 1 Thang");
        return soTienTrongTK;
    }
 
    void inTK() 
    {
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(soTienTrongTK);
        System.out.printf("%-10d %-20s %-20s \n", soTK, tenTK, str1);
    }
}
 class thuchanh2 
{
    static Scanner sc = new Scanner(System.in);
    static void nhapTK(Account tk) 
    {
        System.out.println("Nhap So Tai Khoan: ");
        tk.setSoTK(sc.nextInt());
        sc.nextLine();
        System.out.println("Nhap Ten Tai Khoan: ");
        tk.setTenTK(sc.nextLine());
        tk.setSoTienTrongTK(50);
    }
    public static void main(String[] args) 
    {
        Account a[] = null;
        int k, n = 0;
        int chon;
        long s, d, c, f;
        boolean flag = true;
        do 
        {
            System.out.println("Vui Long Chon: ");
            System.out.println("1.Nhap Thong Tin\n"
                             + "2.Xuat Danh Sach Thong Tin\n" + "3.Nap Tien\n" + "4.Rut Tien\n"
                             + "5.Chuyen Tien\n" + "Nhan Phim 0 De Exit!");
            chon = sc.nextInt();
            switch (chon) 
            {
                case 1:
                {
                    System.out.println("Nhap So Luong Muon Nhap Thong Tin: ");
                    n = sc.nextInt();
                    a = new Account[n];
                    for (int i = 0; i < n; i++) 
                    {
                        System.out.println("Khach Hang Thu : " + (i+1));
                        a[i] = new Account();
                        nhapTK(a[i]);
                    }
                } break;
                case 2:
                {
                    System.out.printf("%-10s %-20s %-20s\n", "So TK", "Ten TK", "So Tien Trong TK");
                    for (int i = 0; i < n; i++) 
                    {
                        a[i].inTK();
                    }
                } break;
                case 3:
                {
                    System.out.println("Nhap So Tai Khoan Can Nap: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) 
                    {
                        d = a[i].getSoTK();
                        if (s == d) 
                        {
                            System.out.println("Chon Tai Khoan: " + d);
                            a[i].napTien();
                        } 
                        else 
                        {
                            System.out.println("");
                        }
                    }
                } break;
                case 4:
                {
                    System.out.println("Nhap So Tai Khoan Can Rut: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) 
                    {
                        d = a[i].getSoTK();
                        if (s == d) 
                        {
                            System.out.println("Chon Tai Khoan: " + d);
                            a[i].rutTien();
                        }
                    }
                } break;
                case 5:
                {
                    double chuyen, nhan, tienChuyen;
                    System.out.print("Nhap So Tai Khoan Chuyen Tien: ");
                    s = sc.nextLong();
                    System.out.print("Nhap So Tai Khoan Nhan Tien: ");
                    c = sc.nextLong();
                    for (int i = 0; i < n; i++) 
                    {
                        d = a[i].getSoTK();
                        if (s == d) 
                        {
                            chuyen = a[i].getSoTienTrongTK();
                            for (int j = 0; j < n; j++) 
                            {
                                f = a[j].getSoTK();
                                if (c == f) 
                                {
                                    nhan = a[j].getSoTienTrongTK();
                                    System.out.println("Nhap So Tien: ");
                                    tienChuyen = sc.nextDouble();
                                    if (tienChuyen <= chuyen) 
                                    {
                                        chuyen = chuyen - tienChuyen;
                                        nhan = nhan + tienChuyen;
                                        a[i].setSoTienTrongTK(chuyen);
                                        a[j].setSoTienTrongTK(nhan);
                                        System.out.println("Tai Khoan " + d + " Vua Chuyen: $" + tienChuyen);
                                        System.out.println("Tai Khoan " + f + " Vua Nhan: $" + tienChuyen);
                                    } 
                                    else 
                                    {
                                        System.out.println("So Tien Nhap Khong Hop Ly!");
                                    }
                                } 
                                else 
                                {
                                    System.out.println("");
                                }
                            }
                        } 
                        else 
                        {
                            System.out.println("");
                        }
                    }
                } break;
            }
        } while (chon!=0);
    }
}