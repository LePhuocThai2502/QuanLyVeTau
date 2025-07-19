package entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Objects;

public class HoaDon {
	private String maHD;
	private Date ngayLapHD;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private double tongDoanhThu;
	
	public HoaDon(String maHD, Date ngayLapHD, NhanVien nhanVien, KhachHang khachHang, double tongDoanhThu) {
		super();
		this.maHD = maHD;
		this.ngayLapHD = ngayLapHD;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.tongDoanhThu = tongDoanhThu;
	}
	public HoaDon() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(maHD);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHD, other.maHD);
	}
	public HoaDon(String maHD) {
		super();
		this.maHD = maHD;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public Date getNgayLapHD() {
		return ngayLapHD;
	}
	public void setNgayLapHD(Date ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public double getTongDoanhThu() {
		return tongDoanhThu;
	}
	public void setTongDoanhThu(double tongDoanhThu) {
		this.tongDoanhThu = tongDoanhThu;
	}
	public HoaDon(String maHD, Date ngayLapHD, KhachHang khachHang) {
		super();
		this.maHD = maHD;
		this.ngayLapHD = ngayLapHD;
		this.khachHang = khachHang;
	}
	
	
	
	

}
