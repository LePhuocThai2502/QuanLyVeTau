package entity;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class PhieuDoiTra {
	
	public enum TrangThai {
		DANG_CHO,
		DA_XAC_NHAN,
		DA_TU_CHOI
	}	
	
	private String maPhieuDT;
	private HoaDon hoaDon;
	private Date thoiGianTaoDonDT;
	private boolean loai;
	private double tienHoan;
	private String lyDo;
	private TrangThai trangThai;
	public PhieuDoiTra(String maPhieuDT, HoaDon hoaDon, Date thoiGianTaoDonDT, boolean loai, double tienHoan,
			String lyDo, TrangThai trangThai) {
		super();
		this.maPhieuDT = maPhieuDT;
		this.hoaDon = hoaDon;
		this.thoiGianTaoDonDT = thoiGianTaoDonDT;
		this.loai = loai;
		this.tienHoan = tienHoan;
		this.lyDo = lyDo;
		this.trangThai = trangThai;
	}
	public PhieuDoiTra(String maPhieuDT) {
		super();
		this.maPhieuDT = maPhieuDT;
	}
	public PhieuDoiTra() {
		super();
	}
	public String getMaPhieuDT() {
		return maPhieuDT;
	}
	public void setMaPhieuDT(String maPhieuDT) {
		this.maPhieuDT = maPhieuDT;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public Date getThoiGianTaoDonDT() {
		return thoiGianTaoDonDT;
	}
	public void setThoiGianTaoDonDT(Date thoiGianTaoDonDT) {
		this.thoiGianTaoDonDT = thoiGianTaoDonDT;
	}
	public boolean isLoai() {
		return loai;
	}
	public void setLoai(boolean loai) {
		this.loai = loai;
	}
	public double getTienHoan() {
		return tienHoan;
	}
	public void setTienHoan(double tienHoan) {
		this.tienHoan = tienHoan;
	}
	public String getLyDo() {
		return lyDo;
	}
	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}
	public TrangThai getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(TrangThai trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public String toString() {
		return "PhieuDoiTra [maPhieuDT=" + maPhieuDT + ", hoaDon=" + hoaDon + ", thoiGianTaoDonDT=" + thoiGianTaoDonDT
				+ ", loai=" + loai + ", tienHoan=" + tienHoan + ", lyDo=" + lyDo + ", trangThai=" + trangThai + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maPhieuDT);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhieuDoiTra other = (PhieuDoiTra) obj;
		return Objects.equals(maPhieuDT, other.maPhieuDT);
	}
	
	
	
	
	
}
