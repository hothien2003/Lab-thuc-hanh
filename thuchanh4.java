import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GiaoDich{
	private String maGiaoDich;
	private LocalDate ngayGiaoDich;
	private double donGia;
	private double thanhTien;

	public GiaoDich(String maGiaoDich,LocalDate ngayGiaoDich,double donGia,double thanhTien){
		this.maGiaoDich=maGiaoDich;
		this.ngayGiaoDich=ngayGiaoDich;
		this.donGia=donGia;
		this.thanhTien=0;
	}
	public String getMaGiaoDich(){
		return maGiaoDich;
	}
	public void setMaGiaoDich(String maGiaoDich){
		this.maGiaoDich=maGiaoDich;
	}
	public LocalDate getNgayGiaoDich(){
		return ngayGiaoDich;
	}
	public void setNgayGiaoDich(LocalDate ngayGiaoDich){
		this.ngayGiaoDich=ngayGiaoDich;
	}
	public double getDonGia(){
		return donGia;
	}
	public void setDonGia(double donGia){
		this.donGia=donGia;
	}
	public double getThanhTien(){
		return thanhTien;
	}
	public void setThanhTien(double thanhTien){
		this.thanhTien=thanhTien;
	}
}
class GiaoDichDat extends GiaoDich{
	private String loaiDat;
	private double dienTich;

	public GiaoDichDat(String maGiaoDich,LocalDate ngayGiaoDich,double donGia,double thanhTien,String loaiDat,double dienTich){
		super(maGiaoDich,ngayGiaoDich,donGia,thanhTien);
		this.loaiDat=loaiDat;
		this.dienTich=dienTich;
		tinhThanhTien();
	}
	public String getLoaiDat(){
		return loaiDat;
	}
	public void setLoaiDat(String loaiDat){
		this.loaiDat=loaiDat;
	}
	public double getDienTich(){
		return dienTich;
	}
	public void setDienTich(){
		this.dienTich=dienTich;
	}
	public void tinhThanhTien(){
		if(loaiDat.equals("A")){
			setThanhTien(dienTich*getDonGia()*1.5);
		}else{
			setThanhTien(dienTich*getDonGia());
		}
	}
}
class GiaoDichNha extends GiaoDich{
	private String loaiNha;
	private String diaChi;
	private double dienTich;

	public GiaoDichNha(String maGiaoDich,LocalDate ngayGiaoDich,double donGia,double thanhTien,String loaiNha,String diaChi,double dienTich){
		super(maGiaoDich,ngayGiaoDich,donGia,thanhTien);
		this.loaiNha=loaiNha;
		this.diaChi=diaChi;
		this.dienTich=dienTich;
		tinhThanhTien();
	}
	public String getLoaiNha(){
		return loaiNha;
	}
	public void setLoaiNha(String loaiNha){
		this.loaiNha=loaiNha;
	}
	public String getDiaChi(){
		return diaChi;
	}
	public void setDiaChi(String diaChi){
		this.diaChi=diaChi;
	}
	public double getDienTich(){
		return dienTich;
	}
	public void setDienTich(double dienTich){
		this.dienTich=dienTich;
	}
	private void tinhThanhTien(){
		if(loaiNha.equals("cao cap")){
			setThanhTien(dienTich*getDonGia());
		}else{
			setThanhTien(dienTich*getDonGia()*0.9);
		}
	}
}
class QuanLyGiaoDich{
	private List<GiaoDich> danhsachGiaoDich;

	public QuanLyGiaoDich(){
		danhsachGiaoDich=new ArrayList<>();
	}
	public void themGiaoDich(GiaoDich giaoDich){
		danhsachGiaoDich.add(giaoDich);
	}
	public void xoaGiaoDich(GiaoDich giaoDich){
		danhsachGiaoDich.remove(giaoDich);
	}
	public List<GiaoDich> getDanhSachGiaoDich(){
		return danhsachGiaoDich;
	}
	public void setDanhSachGiaoDich(List<GiaoDich> danhsachGiaoDich){
		this.danhsachGiaoDich=danhsachGiaoDich;
	}
	public double tinhTongLuongGiaoDichTheoLoai(String loai){
		double tongLuong = 0;
		for(GiaoDich gd : danhsachGiaoDich){
			if(gd instanceof GiaoDichDat){
				GiaoDichDat gdd=(GiaoDichDat)gd;
				if(gdd.getLoaiDat().equals(loai)){
					tongLuong += gdd.getDienTich();
				}
			}else if(gd instanceof GiaoDichNha){
				GiaoDichNha gdn=(GiaoDichNha)gd;
				if(gdn.getLoaiNha().equals(loai)){
					tongLuong += gdn.getDienTich();
				}
			}
		}
		return tongLuong;
	}
	public double tinhTrungBinhThanhTienGiaoDichDat(){
		double tongThanhTien=0;
		int soGiaoDichDat=0;
		for(GiaoDich gd : danhsachGiaoDich){
			if(gd instanceof GiaoDichDat){
				tongThanhTien += gd.getThanhTien();
				soGiaoDichDat++;
			}
		}
		if(soGiaoDichDat==0){
			return 0;
		}
		return tongThanhTien / soGiaoDichDat;
	}
	public List<GiaoDich>danhsachGiaoDichThang9Nam2013(){
		List<GiaoDich>dsGiaoDich=new ArrayList<>();
		for(GiaoDich gd : danhsachGiaoDich){
			if(gd.getNgayGiaoDich().getMonthValue()==9 && gd.getNgayGiaoDich().getYear()==2013){
				dsGiaoDich.add(gd);
			}
		}
		return dsGiaoDich;
	}
}
class thuchanh4{
	public static void main(String[] args) {
		QuanLyGiaoDich quanLyGiaoDich=new QuanLyGiaoDich();

		GiaoDichDat gdd1=new GiaoDichDat("A001",LocalDate.now(),1000000,00,"A",500);
		quanLyGiaoDich.themGiaoDich(gdd1);

		GiaoDichDat gdd2=new GiaoDichDat("B001",LocalDate.now().minusMonths(1),5000000,00,"B",800);
		quanLyGiaoDich.themGiaoDich(gdd2);

		GiaoDichNha gdn1=new GiaoDichNha("C001",LocalDate.now().minusWeeks(1),2000000,00,"Cao cap","123 duong ABC",200);
		quanLyGiaoDich.themGiaoDich(gdn1);

		for(GiaoDich giaoDich : quanLyGiaoDich.getDanhSachGiaoDich()){
			System.out.println(giaoDich.getMaGiaoDich() + "-" + giaoDich.getNgayGiaoDich() + "-" + giaoDich.getDonGia() + "-" + giaoDich.getThanhTien());
		}
	}
}