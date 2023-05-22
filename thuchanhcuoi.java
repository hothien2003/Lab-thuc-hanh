import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Common{
    static Scanner sc = new Scanner(System.in);
    static int getInt(String s){
        System.out.print(s);
        int result = 0;
        try{
            result = sc.nextInt();
        } catch(NumberFormatException e){
            System.out.println("khong hop le: " + s);
        }
        return result;
    }
    static double getDouble(String s){
        System.out.print(s);
        double result = 0;
        try{
            result = sc.nextDouble();
        }catch(NumberFormatException e){
            System.out.println("khong hop le: " + s);
        }
        return result;
    }
    static String getString(String s){
        String result = "";
        System.out.print(s);
        try{
            result = sc.nextLine();
        }catch(NumberFormatException e){
            System.out.println("khong hop le: " + s);
        }
        return result;
    }
    public static String getStrings(String s){
        System.out.print(s);
        String result = "";
        try{
            sc.nextLine();
            result = sc.nextLine();
        } catch(NumberFormatException e){
            System.out.println("khong hop le: " + s);
        }
        return result;
    }
    static boolean getBoolean(String s){
        boolean result = false;
        try{
            result = sc.nextBoolean();
        }catch(NumberFormatException e){
            System.out.println("khong hop le: " + s);
        }
        return result;
    }
}
class PhongHoc{
    private String roomId;
    private int num;
    private double area;
    private int numberOfBulbs;

    public PhongHoc(String roomId,int num,double area,int numberOfBulbs){
        this.roomId=roomId;
        this.num=num;
        this.area=area;
        this.numberOfBulbs=numberOfBulbs;
    }
    public String getRoomId(){
        return roomId;
    }
    public void setRoomId(String roomId){
        this.roomId=roomId;
    }
    public int getNum(){
        return num;
    }
    public void setNum(int num){
        this.num=num;
    }
    public double getArea(){
        return area;
    }
    public void setArea(double area){
        this.area=area;
    }
    public int getNumberOfBulbs(){
        return numberOfBulbs;
    }
    public void setNumBerOfBulbs(int numberOfBulbs){
        this.numberOfBulbs=numberOfBulbs;
    }
    @Override
    public String toString(){
        return String.format("%20s %10s %15s %10s", roomId, num, area, numberOfBulbs);
    }
    public boolean DatChuan(){
        return(this.area / this.num) >= 10;
    }
    public static PhongHoc input(String roomId){
        int num = Common.getInt("Nhap so: ");
        double area = Common.getDouble("Nhap khu vuc: ");
        int numberOfBulbs = Common.getInt("Nhap so luong bong den: ");
        return new PhongHoc(roomId,num,area,numberOfBulbs);
    }
}
class PhongLyThuyet extends PhongHoc{
    private final static String label = "T";
    private boolean projector;

    public PhongLyThuyet(String roomId, int num, double area, int numberOfBulbs,boolean projector){
        super(label+roomId,num,area,numberOfBulbs);
        this.projector=projector;
    }
    @Override
    public boolean DatChuan(){
        return this.projector && super.DatChuan();
    }
    public void setProjector(boolean projector){
        this.projector=projector;
    }
    public boolean getProjector(){
        return projector;
    }
    public static PhongLyThuyet input(String roomId){
        PhongHoc ph = PhongHoc.input(roomId);
        boolean projector = Common.getBoolean("Nhap may chieu: ");
        return new PhongLyThuyet(roomId, ph.getNum(), ph.getArea(),ph.getNumberOfBulbs(), projector);
    }
}
class PhongThiNghiem extends PhongHoc{
    private String thongTin;
    private int size;
    private boolean bonruaTay;
    private final static String label = "L";

    public PhongThiNghiem(String roomId, int num, double area, int numberOfBulbs, String thongTin,int size, boolean bonruaTay){
        super(label+roomId,num,area,numberOfBulbs);
        this.thongTin=thongTin;
        this.size=size;
        this.bonruaTay=bonruaTay;
    }
    @Override
    public boolean DatChuan(){
        return this.bonruaTay && super.DatChuan();
    }
    public void setThongTin(String thongTin){
        this.thongTin=thongTin;
    }
    public void setSize(int size){
        this.size=size;
    }
    public void setBonRuaTay(boolean bonruaTay){
        this.bonruaTay=bonruaTay;
    }
    public String getThongTin(){
        return thongTin;
    }
    public int getSize(){
        return size;
    }
    public boolean getBonRuaTay(){
        return bonruaTay;
    }
    public static PhongThiNghiem input(String roomId){
        PhongHoc ph = PhongHoc.input(roomId);
        String thongTin = Common.getString("Nhap thong tin dac biet: ");
        int size = Common.getInt("Nhap size: ");
        boolean bonruaTay = Common.getBoolean("Nhap bon rua tay: ");
        return new PhongThiNghiem(roomId,ph.getNum(),ph.getArea(),ph.getNumberOfBulbs(),thongTin,size,bonruaTay);
    }
}
class PhongMayTinh extends PhongHoc{
    private int soMay;
    private final static String label = "C";
    public PhongMayTinh(String roomId, int num, double area, int numberOfBulbs, int soMay){
        super(label+roomId,num,area,numberOfBulbs);
        this.soMay=soMay;
    }
    @Override
    public boolean DatChuan(){
        return(this.getArea()/this.soMay) >= 1.5f && super.DatChuan();
    }
    public void setSoMay(int soMay){
        this.soMay=soMay;
    }
    public int getSoMay(){
        return soMay;
    }
    public static PhongMayTinh input(String roomId){
        PhongHoc ph = PhongHoc.input(roomId);
        int soMay=Common.getInt("Nhap so luong may tinh: ");
        return new PhongMayTinh(roomId,ph.getNum(),ph.getArea(),ph.getNumberOfBulbs(),soMay);
    }
}
class QuanLy{
    private List<PhongHoc> listPhong = new ArrayList<PhongHoc>();
    private PhongHoc findById(String roomId){
        for (PhongHoc ph : listPhong){
            if(ph.getRoomId().equals(roomId)){
                return ph;
            }
        }
        return null;
    }
    private List<PhongHoc> sortByNum(){
        List<PhongHoc> listPhongHoc = this.listPhong;
        listPhongHoc.sort ((o1,o2) -> o1.getNum()- o2.getNum());
        this.listPhong = listPhongHoc;
        return listPhongHoc;
    }
    private List<PhongHoc> sortByArea(){
        List<PhongHoc> listPhongHoc = this.listPhong;
        listPhongHoc.sort((o1,o2) -> (int) (o1.getArea()-o2.getArea()));
        this.listPhong = listPhongHoc;
        return listPhongHoc;
    }
    private List<PhongHoc> sortByBulbs(){
        List<PhongHoc> listPhongHoc = this.listPhong;
        listPhongHoc.sort((o1,o2) -> o1.getNumberOfBulbs() - o2.getNumberOfBulbs());
        this.listPhong = listPhongHoc;
        return listPhongHoc;
    }
    private void xuat(List<PhongHoc> listPhongHoc){
        System.out.println(String.format("%20s %10s %15s %10s","ma phong","so","khu vuc","so luong bong den"));
        for(PhongHoc ph : listPhong){
            System.out.println(ph);
        }
    }
    private void CheckdsDatChuan(){
        System.out.println("Danh sach phong dat chuan: ");
        System.out.println(String.format("%20s %10s %15s %10s","ma phong","so","khu vuc","so luong bong den"));
        for(PhongHoc ph : this.listPhong){
            if(ph.DatChuan()){
                System.out.println(ph);
            }
        }
    }
    private void updatePhongMay(String roomId, int soMay){
        PhongMayTinh ph = (PhongMayTinh)this.findById(roomId);
        if(roomId != null)
        {
            ph.setSoMay(soMay);
            for(int i = 0; i < listPhong.size(); i++)
            {
                if(listPhong.get(i).getRoomId().equals(roomId))
                {
                    listPhong.remove(i);
                    listPhong.add(i, ph);
                }
            }
        }
    }
    public void init(){
        this.listPhong.add(new PhongMayTinh("1",1,100,10,2));
        this.listPhong.add(new PhongMayTinh("2",2,200,20,4));
        this.listPhong.add(new PhongMayTinh("3",3,300,30,6));
        this.listPhong.add(new PhongMayTinh("4",4,400,40,8));
        this.listPhong.add(new PhongThiNghiem("5",1,100,10,"TECH",1,true));
        this.listPhong.add(new PhongThiNghiem("6",2,200,20,"TECH",2,true));
        this.listPhong.add(new PhongThiNghiem("7",3,300,30,"TECH",3,true));
        this.listPhong.add(new PhongThiNghiem("8",4,400,40,"TECH",4,true));
        this.listPhong.add(new PhongLyThuyet("9",1,100,10,true));
        this.listPhong.add(new PhongLyThuyet("10",2,200,20,true));
        this.listPhong.add(new PhongLyThuyet("11",3,300,30,true));
        this.listPhong.add(new PhongLyThuyet("12",4,400,40,true));
    }
    private void menu(){
        System.out.println("1.  them phong may tinh             ");
        System.out.println("2.  them phong thi nghiem           ");
        System.out.println("3.  them phong ly thuyet            ");
        System.out.println("4.  Sua so luong may tinh           ");
        System.out.println("5.  phan loai theo so luong         ");
        System.out.println("6.  phan loai theo khu vuc          ");
        System.out.println("7.  phan loai theo so               ");
        System.out.println("8.  phan loai theo so luong bong den");
        System.out.println("9.  xuat tat ca phong"               );
        System.out.println("10. xuat cac phong dat chuan        ");
        System.out.println("11. exit                            ");
        int choice = Common.getInt("lua chon cua ban la: ");
        menu(choice);
    }
    private void menu(int choice){
        switch(choice){
        case 1:
            this.listPhong.add(PhongMayTinh.input((listPhong.size()+"")));
            break;
        case 2:
            this.listPhong.add(PhongThiNghiem.input((listPhong.size()+"")));
            break;
        case 3:
            this.listPhong.add(PhongLyThuyet.input((listPhong.size()+"")));
            break;
        case 4:
            String roomId = Common.getString("nhap ma phong: ");
            int soMay = Common.getInt("Nhap so luong may: ");
            this.updatePhongMay(roomId, soMay);
            break;
        case 5: 
            this.xuat(this.sortByNum());
            break;
        case 6:
            this.xuat(this.sortByArea());
            break;
        case 7:
            this.xuat(this.sortByNum());
            break;
        case 8:
            this.xuat(this.sortByBulbs());
            break;
        case 9:
            this.xuat(this.listPhong);
            break;
        case 10:
            this.CheckdsDatChuan();
            break;
        case 11:
            System.exit(0);
            break;
        }
    }
    public void start(){
        this.init();
        while(true){
            this.menu();
        }
    }
}
class main{
    public static void main(String[] args) {
        new QuanLy().start();
    }
}