import java.util.Scanner;

class SinhVien{
	private int maSV;
	private String hoTen;
	private String diaChi;
	private int sdt;

	public SinhVien(){}

	public SinhVien(int maSV,String hoTen,String diaChi,int sdt){
		this.maSV=maSV;
		this.hoTen=hoTen;
		this.diaChi=diaChi;
		this.sdt=sdt;
	}
	public int getMaSV(){
		return maSV;
	}
	public void setMaSV(int maSV){
		this.maSV=maSV;
	}
	public String getHoTen(){
		return hoTen;
	}
	public void setHoTen(String hoTen){
		this.hoTen=hoTen;
	}
	public String getDiaChi(){
		return diaChi;
	}
	public void setDiaChi(String diaChi){
		this.diaChi=diaChi;
	}
	public int getSDT(){
		return sdt;
	}
	public void setSDT(int sdt){
		this.sdt=sdt;
	}
	@Override
	public String toString(){
		return "SinhVien{" + "maSV=" + maSV + ",hoTen=" + hoTen + ",diaChi" + diaChi +",sdt" + sdt + '}';
	}
}
class QuanlySinhVien{
	private SinhVien[] danhSachSinhVien;
	private int soLuongSinhVien;

	public QuanlySinhVien(){
	}
	public QuanlySinhVien(int soLuongSinhVien){
		this.soLuongSinhVien=soLuongSinhVien;
		danhSachSinhVien=new SinhVien[soLuongSinhVien];
	}
	public void nhapSanhSachSinhVien(){
		Scanner scanner=new Scanner(System.in);
		for(int i=0;i<soLuongSinhVien;i++){
		System.out.println("Nhap thong tin sinh vien"+(i+1)+":");
		System.out.println("Ma sinh vien: ");
		int maSV=scanner.nextInt();
		scanner.nextLine();
		System.out.print("Ho ten: ");
		String hoTen=scanner.nextLine();
		System.out.print("Dia chi: ");
		String diaChi=scanner.nextLine();
		System.out.print("So dien thoai:");
		int sdt=scanner.nextInt();
		danhSachSinhVien[i]=new SinhVien(maSV,hoTen,diaChi,sdt);
	}
}
public void xuatDanhSachSinhVien(){
	for(int i=0;i<soLuongSinhVien;i++){
		System.out.println("Thong tin sinh vien"+(i+1)+":");
		System.out.println(danhSachSinhVien[i]);
	}
}
public void sapXep(){
	for(int i=0;i<soLuongSinhVien-1;i++){
		for(int j=0;i<soLuongSinhVien;j++){
			if(danhSachSinhVien[i].getMaSV()>danhSachSinhVien[j].getMaSV()){
				SinhVien temp=danhSachSinhVien[i];
				danhSachSinhVien[i]=danhSachSinhVien[j];
				danhSachSinhVien[j]=temp;
			}
		}
	}
}
}
class thuchanh{
	public static void main(String[]args){
		QuanlySinhVien ql=new QuanlySinhVien(3);
		ql.nhapSanhSachSinhVien();
		ql.sapXep();
		ql.xuatDanhSachSinhVien();
	}
}