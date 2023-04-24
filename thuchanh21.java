import java.util.Scanner;
import java.util.ArrayList;
class CD{
	private int maCD;
	private String tuaCD;
	private int soBaiHat;
	private double giaThanh;

	public CD(){
		this.maCD=999999;
		this.tuaCD="Chua xac dinh";
		this.soBaiHat=0;
		this.giaThanh=0.0;
	}
	public CD(int maCD,String tuaCD,int soBaiHat,double giaThanh){
		this.maCD=maCD;
		this.tuaCD=tuaCD;
		this.soBaiHat=soBaiHat;
		this.giaThanh=giaThanh;
	}
	public int getMaCD(){
		return maCD;
	}
	public void setMaCD(int maCD){
		if(maCD>0){
			this.maCD=maCD;
		}
	}
	public String getTuaCD(){
		return tuaCD;
	}
	public void setTuaCD(String tuaCD){
		if(!tuaCD.isEmpty()){
			this.tuaCD=tuaCD;
		}
	}
	public int getSoBaiHat(){
		return soBaiHat;
	}
	public void setSoBaiHat(int soBaiHat){
		if(soBaiHat>0){
			this.soBaiHat=soBaiHat;
		}
	}
	public double getGiaThanh(){
		return giaThanh;
	}
	public void setGiaThanh(double giaThanh){
		if(giaThanh>0){
			this.giaThanh=giaThanh;
		}
	}
	public String getInfo(){
		return"Ma CD:" +this.maCD+",Tua CD:" +this.tuaCD+",So bai hat:" +this.soBaiHat+",Gia thanh:"+this.giaThanh;
	}
	@Override
	public String toString(){
		return "CD{" + "maCD=" +maCD +",tuaCD=" +tuaCD +",soBaiHat=" +soBaiHat +",giaThanh=" +giaThanh +'}';
	}
}
class QLCD{
	private CD[] cdList;
	private int size;

	public QLCD(int capacity){
		cdList=new CD[capacity];
		size=0;
	}
	public boolean addCD(CD cd){
		if(size==cdList.length){
			System.out.println("Danh sach da day!");
			return false;
		}else{
			for(int i=0;i<size;i++){
				if(cd.getMaCD().equals(cdList[i].getMaCD())){
					System.out.println("CD da ton tai trong danh sach!");
					return false;
				}
			}
			cdList[size]=cd;
			size++;
			System.out.println("Them CD thanh cong!");
			return true;
		}
	}
	public int countCD(){
		return size;
	}
	public double sumGiaThanh(){
		double tong=0;
		for(int i=0;i<size;i++){
			tong += cdList[i].getGiaThanh();
		}
		return tong;
	}
	public void DSGiamTheoGia(){
		for(int i=0;i<size-1;i++){
			for(int j=i+1;j<size;j++){
				if(cdList[j].getGiaThanh()>cdList[i].getGiaThanh()){
					CD temp=cdList[i];
					cdList[i]=cdList[j];
					cdList[j]=temp;
				}
			}
		}
		System.out.println("Sap xep thanh cong!");
	}
	public void DSTangTheoTuaCD(){
		for(int i=0;i<size-1;i++){
			for(int j=i+1;j<size;j++){
				if(cdList[j].getTuaCD().compareTo(cdList[i].getTuaCD())<0){
					CD temp=cdList[i];
					cdList[i]=cdList[j];
					cdList[j]=temp;
				}
			}
		}
		System.out.println("Sap xep thanh cong!");
	}
	public void ThongTinCD(){
		if(size==0){
			System.out.println("Danh sach rong!");
		}else{
			for(int i=0;i<size;i++){
				System.out.println(cdList[i].getInfo());
			}
		}
	}
}
class thuchanh21{
	public static void main(String[] args) {
		Scanner scanner	=new Scanner(System.in);
		QLCD qlcd=new QLCD(10);
		int chon;
		do{
			System.out.println("----Quan ly danh sach CD----");
			System.out.println("1.Them CD");
			System.out.println("2.Tinh so luong CD");
			System.out.println("3.Tinh tong gia thanh CD");
			System.out.println("4.Sap xep danh sach giam dan theo gia thanh");
			System.out.println("5.Sap xep danh sach tang dan theo tua CD");
			System.out.println("6.Hien thi danh sach CD");
			System.out.println("7.Thoat");
			System.out.println("Chon chuc nang(1-7):");
			chon=scanner.nextInt();
			switch(chon){
			case 1:
				System.out.println("Nhap ma CD:");
				int maCD=scanner.nextInt();
				System.out.println("Nhap tua CD:");
				String tuaCD=scanner.nextLine();
				System.out.println("Nhap so bai hat:");
				int soBaiHat=scanner.nextInt();
				System.out.println("Nhap gia thanh:");
				double giaThanh=scanner.nextDouble();
				CD cd=new CD(maCD,tuaCD,soBaiHat,giaThanh);
				qlcd.addCD(cd);
				break;
			case 2:
				int count=qlcd.countCD();
				System.out.println("So luong CD trong danh sach: "+count);
				break;
			case 3:
				double tong=qlcd.sumGiaThanh();
				System.out.println("Tong gia thanh cua cac CD trong danh sach: "+tong);
				break;
			case 4:
				qlcd.DSGiamTheoGia();
				break;
			case 5:
				qlcd.DSTangTheoTuaCD();
				break;
			case 6:
				qlcd.ThongTinCD();
				break;
			case 7:
				System.out.println("Hen gap lai!");
				break;
			default:
				System.out.println("Chuc nang khong hop le!");
				break;
			}
		}while(chon !=7);
	}
}