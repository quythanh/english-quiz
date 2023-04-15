package main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class NguoiDung {
	public static int dem;
	private int id;
	private String username;
	private String password;
	private String hoTen;
	private String queQuan;
	private boolean gioiTinh;
	private Calendar ngaySinh;
	private Calendar ngayGiaNhap;
	private List<LuyenTap> baiLuyenTap;
        private boolean admin;

    public NguoiDung() {
        this.baiLuyenTap = new ArrayList<>();
    }

	public NguoiDung(String hoTen, String username, String password, String queQuan, boolean gioiTinh,
			Calendar ngaySinh) {
		this.id = ++dem;
		this.hoTen = hoTen;
                this.username = username;
                this.password = password;
		this.queQuan = queQuan;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.ngayGiaNhap = new GregorianCalendar();
		this.baiLuyenTap = new ArrayList<>();
	}
        
        public void hienThi(){
                
                String role = this.isAdmin()==true ? "ADMIN" : "HOC VIEN";
                String birth = Config.fomatter.format(this.getNgaySinh().getTime());
                String join = Config.fomatter.format(this.getNgayGiaNhap().getTime());
                System.out.println("|____|_____________|______|_____________|_____________|_______________|___________|");
                System.out.println("|    |             |      |             |             |               |           |");
             System.out.printf("| %2d | %11s | %4s | %11s | %11s | %13s | %9s |\n", this.getId(), this.hoTen, this.gioiTinh==true?"Nam":"Nu", this.getQueQuan(), birth, join, role);
//            System.out.printf("id: %d\nHo va ten: %s\nQue Quan: %s\nVai tro: %s\n\n",this.id, this.hoTen, this.queQuan, this.admin==true?"ADMIN" : "HOC VIEN");
        }

	
	private void nhap() throws ParseException {
            System.out.print("1. Username: ");
            this.username = Config.sc.nextLine();
            System.out.print("2. Password: ");
            this.password = Config.sc.nextLine();
            System.out.print("3. Họ và tên: ");
            this.hoTen = Config.sc.nextLine();
            System.out.print("4. Gioi Tinh: ");
            this.gioiTinh = Config.sc.nextLine().toUpperCase().equals("NAM");
            System.out.print("5. Que Quan: ");
            this.queQuan = Config.sc.nextLine();
            System.out.print("6. Ngày sinh: ");
            this.ngaySinh=Config.toCalendar(Config.sc.nextLine());
	}
        public void dangKi() throws ParseException
        {
            this.id = ++dem;
            this.nhap();
            this.ngayGiaNhap = new GregorianCalendar();
            this.admin = false;
        }
        public void capNhat() throws ParseException
        {
            this.nhap();
            System.out.print("7. Ngày gia nhap: ");
            this.ngayGiaNhap = Config.toCalendar(Config.sc.nextLine());
        }
 
 
        public void thongKeLuyenTap() {

	}
    
        public void lamBaiLuyenTap() {
		Arrays.asList(DangCauHoi.values()).forEach(dch -> System.out.println(dch));
		System.out.println("Chọn dạng câu hỏi:\t");
		int choice = Integer.parseInt(Config.sc.nextLine());
        
        LuyenTap practice = new LuyenTap(DangCauHoi.valueOf(choice), this);
        this.baiLuyenTap.add(practice);
	}
        
        
    public String getHoTen() {
		return this.hoTen;
	}
    public String getPassword(){
            return this.password;
        }
    public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
    public boolean getGioiTinh() {
		return this.gioiTinh;
	}
    public List<LuyenTap> getBaiLuyenTap() {
		return this.baiLuyenTap;
	}    
    public void setNgayGiaNhap(Calendar s){
            this.ngayGiaNhap = s;
        }    
    public void setAdmin(boolean b){
            this.admin = b;
        }
    public int getId() {
        return id;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getQueQuan() {
        return queQuan;
    }
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }
    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public Calendar getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(Calendar ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public Calendar getNgayGiaNhap() {
        return ngayGiaNhap;
    }
    public boolean isAdmin() {
        return admin;
    }
}

