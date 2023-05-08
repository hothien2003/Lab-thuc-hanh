import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
abstract class Product {
    private String id;
    private String name;
    private int quantity;
    private double unitPrice;

    abstract float getTax();

    abstract double getPrice();

    public Product(int id, String name, int quantity, double unitPrice) {
        this.id = "sp" + id;
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    } 
    public String getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getUnitPrice(){
        return unitPrice;
    }
    public Product setID(String id) {
        this.id=id;
        return this;
    }
    public Product setName(String name){
        this.name=name;
        return this;
    }
    public Product setQuantity(int quantity){
        this.quantity=quantity;
        return this;
    }
    public Product setUnitPrice(double unitPrice){
        this.unitPrice=unitPrice;
        return this;
    }
    @Override
    public String toString(){
        return String.format("%5s %20s %10s %50s", this.id, this.name, this.quantity, this.unitPrice);
    }
}
class Date {
    private int day;
    private int month;
    private int year;
    public Date (int day, int month, int year){
        this.day=day;
        this.month=month;
        this.year=year;
    }
    public int getDay(){
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
    public Date setDay(int day){
        this.day=day;
        return this;
    }
    public Date setMonth(int month){
        this.month=month;
        return this;
    }
    public Date setYear(int year){
        this.year=year;
        return this;
    }
    public boolean checkDate(int day, int month, int year){
        boolean check= false;
        if(day != -1){
            check = day == this.day;
        }
        if (month != 1){
            check = month == this.month;
        }
        if (year != -1){
            check = year == this.year;
        }
        return check;
    }
@Override
    public String toString(){
        return day + "/" + month + "/" + year;
}
public long getTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(this.year, this.month, this.day, 0,0,0);
        return cal.getTimeInMillis();
}
}

class Common {
    public static Scanner scanner = new Scanner(System.in);
    public static int getInt(String str){
        System.out.println(str);
        return scanner.nextInt();
    }
    public static String getString (String str){
        System.out.println(str);
        return scanner.nextLine();
    }
    public static String getStrings (String str) {
        System.out.print(str);
        scanner.nextLine();
        return scanner.nextLine();
    }
    public static float getFloat (String srt) {
        System.out.print(srt);
        return scanner.nextFloat();
    }
    public static double getDouble(String srt){
        System.out.print(srt);
        return scanner.nextDouble();
    }
    public static char getChar(String srt){
        System.out.print(srt);
        return scanner.next().charAt(0);
    }
    public static boolean getBoolean(String srt){
        System.out.print(srt);
        return scanner.hasNextBoolean();
    }
    public static String toVND(Object money){
        DecimalFormat formatter = new DecimalFormat("fff,fff,fff");
        return formatter.format(money);
    }
    public static void clearScreen(){
    	System.out.print("\033|H\033|2J");
    	System.out.flush();
    }
    public static void anyPressKey(){
    	System.out.print("Nhan de tiep tuc...");
    	scanner.nextLine();
    	scanner.nextLine();
    }
    public static Date InputDate(String str){
    	System.out.println("Hay dat ngay thang nam");
    	String date = Common.getString(str).trim();
    	String[] dateArr = date.split("/");
    	return new Date(Integer.parseInt(dateArr[0]),Integer.parseInt(dateArr[1]),Integer.parseInt(dateArr[2]));
    }
    public static Date InputDates(String str){
    	System.out.println("Hay dat ngay thang nam");
    	String date = Common.getStrings(str).trim();
    	String[] dateArr = date.split("/");
    	return new Date(Integer.parseInt(dateArr[0]),Integer.parseInt(dateArr[1]),Integer.parseInt(dateArr[2]));
    }
}
class Check{
	public static final String RegexDate = "(0[1-9] |1 [0-9]|2[0-9]|3[0-1]|[1-9])/(0[1-9]|1[0-2]|[1-9])/([0-9]|4})";
	public static String inputSTR (String str, String strError, boolean ver) {
		String strInput = "";
		boolean check = false;
		while (!check) {
		try {
			if(!ver) {
				strInput = Common.getString(str+": ");
			}
			else{
				strInput = Common.getStrings (str + ": ");
			if(strInput.length() == 0) {
				System.out.println(strError);
			}else{
				check = true;
			}
		}
		} catch (Exception e) {
			System.out.println(strError);
		}
	}
		return strInput;
	}
	public static int inputINT(String str,String strError){
	int intInput = 0;
	boolean check = false;
	while(!check){
		try{
			intInput = Common.getInt(str + ": ");
			check = true;
		}catch (Exception e){
			System.out.println(strError);
		}
	}
	return intInput;
}
	public static float inputFLOAT(String str,String strError){
	float floatInput = 0;
	boolean check = false;
	while(!check){
		try{
			floatInput = Common.getFloat(str + ": ");
			check = true;
		}catch(Exception e){
			System.out.println(strError);
		}
	}
	return floatInput;
}
	public static double inputDOUBLE(String str,String strError){
	double doubleInput = 0;
	boolean check = false;
	while(!check){
		try{
			doubleInput = Common.getDouble(str + ": ");
			check = true;
		}catch(Exception e){
			System.out.println(strError);
		}
	}
	return doubleInput;
}
	public static char inputCHAR(String str, String strError){
	char charInput = ' ';
	boolean check = false;
	while(!check){
		try{
			charInput = Common.getChar(str + ": ");
		}catch(Exception e){
			System.out.println(strError);
		}
	}
	return charInput;
}
	public static boolean inputBOOLEAN(String str,String strError){
	boolean boolInput = false;
	boolean check = false;
	while(!check){
		try{
			boolInput = Common.getBoolean(str + ": ");
		}catch(Exception e){
			System.out.println(strError);
		}
	}
		return boolInput;
	}
	public static Date inputDATE(String str,String strError,boolean ver){
		Date dateInput = null;
		boolean check = false;
		while(!check){
			try{
				if(!ver){
					dateInput = Common.InputDate(str + ": ");
				}else{
					dateInput = Common.InputDates(str + ": ");
				}
				check = Pattern.matches(RegexDate, dateInput.toString());
			}catch(Exception e){
				System.out.println(strError);
			}
		}
		return dateInput;
	}
}
 class Food extends Product{
	private Date expiryDate;
	private Date dateOfManufacture;
	private String supplier;
	public Food(int id,String name,int quantity,double unitPrice,Date expiryDate,Date dateOfManufacture,String supplier){
		super(id,name,quantity,unitPrice);
		this.expiryDate = expiryDate;
		this.dateOfManufacture=dateOfManufacture;
		this.supplier=supplier;
	}
	@Override
	public double getPrice(){
		return(getUnitPrice() * getQuantity()) + ((getUnitPrice() * getQuantity()) * getTax());
	}
	@Override
	public float getTax(){
		return 0.05f;
	}
	public Date getExpiryDate(){
		return expiryDate;
	}
	public Date getDateOfManufacture(){
		return dateOfManufacture;
	}
	public String getSupplier(){
		return supplier;
	}
	public Food setExpiryDate(Date expiryDate){
		this.expiryDate = expiryDate;
		return this;
	}
	public Food setDateOfManufacture(Date dateOfManufacture){
		this.dateOfManufacture = dateOfManufacture;
		return this;
	}
	public Food setSupplier(String supplier){
		this.supplier = supplier;
		return this;
	}
	public static Food input(int id){
		Date expiryDate = null , dateOfManufacture = null;
		String name = Check.inputSTR("Nhap ten san pham","loi",true);
		int quantity = Check.inputINT("Nhap so luong","loi");
		double unitPrice = Check.inputDOUBLE("Nhap don gia","loi");
		do{
			dateOfManufacture = Check.inputDATE("Nhap ngay san xuat","loi",true);
			expiryDate = Check.inputDATE("Nhap ngay het han","loi",false);
		}while(expiryDate.getTime()<dateOfManufacture.getTime());
		String supplier = Check.inputSTR("Nhap nha cung cap","loi",false);
		return new Food(id,name,quantity,unitPrice,expiryDate,dateOfManufacture,supplier);
	}
}
 class Electronice extends Product{
	private int warrantyPeriod;
	private int wattage;
	public Electronice(int id,String name,int quantity,double unitPrice,int warrantyPeriod,int wattage){
		super(id,name,quantity,unitPrice);
		this.warrantyPeriod = warrantyPeriod;
		this.wattage = wattage;
	}	
	@Override
	public double getPrice(){
		return(getUnitPrice() * getQuantity()) + ((getUnitPrice()*getQuantity())*getTax());
	}
	@Override
	public float getTax(){
		return 0.1f;
	}
	public int getWarrantyPeriod(){
		return warrantyPeriod;
	}
	public int getWattage(){
		return wattage;
	}
	public Electronice setWarrantyPeriod(int warrantyPeriod){
		this.warrantyPeriod = warrantyPeriod;
		return this;
	}
	public Electronice setWattage(int wattage){
		this.wattage = wattage;
		return this;
	}
	public static Electronice input(int id){
		int warrantyPeriod = 0,wattage = 0;
		String name = Check.inputSTR("Nhap ten san pham","loi",true);
		int quantity = Check.inputINT("Nhap so luong","loi");
		double unitPrice = Check.inputDOUBLE("Nhap don gia","loi");
		warrantyPeriod = Check.inputINT("Nhap thoi han bao hanh","loi");
		wattage = Check.inputINT("Nhap cong suat","loi");
		return new Electronice(id,name,quantity,unitPrice,warrantyPeriod,wattage);
	}
}
 class Crockery extends Product{
	private String producer;
	private int inputDay;
	public Crockery(int id,String name,int quantity,double unitPrice,String producer,int inputDay){
		super(id,name,quantity,unitPrice);
		this.producer=producer;
		this.inputDay=inputDay;
	}
	@Override
	public double getPrice(){
		return(getUnitPrice() * getQuantity()) + ((getUnitPrice()*getQuantity())*getTax());
	}
	@Override
	public float getTax(){
		return 0.1f;
	}
	public String getProducer(){
		return producer;
	}	
	public int getInputDay(){
		return inputDay;
	}
	public Crockery setProducer(String producer){
		this.producer = producer;
		return this;
	}
	public Crockery setInputDay(int inputDay){
		this.inputDay=inputDay;
		return this;
	}
	public static Crockery input(int id){
		String producer= "";
		int inputDay = 0;
		String name = Check.inputSTR("Nhap ten san pham","loi",false);
		int quantity = Check.inputINT("Nhap so luong","loi");
		double unitPrice = Check.inputDOUBLE("Nhap don gia","loi");
		producer = Check.inputSTR("Nhap nha san xuat","loi",false);
		inputDay = Check.inputINT("Ngay nhap hang","loi");
		return new Crockery(id,name,quantity,unitPrice,producer,inputDay);
	}
}
 class Manager{
	public Manager(){}
	public List<Product> products = new ArrayList<>();
	public void start(){
		int choice = 0;
		while (choice !=4){
			System.out.println("1. Them san pham               ");
			System.out.println("2. Them san pham dien may      ");
			System.out.println("3. Them san pham bang su       ");
			System.out.println("4. Xem tat ca                  ");
			System.out.println("5. Thoat                       ");
			choice = Check.inputINT("Hay nhap su lua chon cua ban","loi");
			switch(choice){
			case 1:
				products.add(Food.input(products.size() +1));
				break;
			case 2:
				products.add(Electronice.input(products.size() +1));
				break;
			case 3:
				products.add(Crockery.input(products.size() +1));
				break;
			case 4:
				for(Product product : products){
					System.out.println(product);
				}
				Common.anyPressKey();
				break;
			case 5:
				System.exit(0);
				break;
			}
			Common.clearScreen();
		}
	}
}
class thuchanh31{
	public static void main(String[] args){
		Manager manager = new Manager();
		manager.start();
	}
}