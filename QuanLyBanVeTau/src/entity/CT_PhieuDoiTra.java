package entity;

public class CT_PhieuDoiTra {
	private PhieuDoiTra phieuDoiTra;
	private VeTau veTau;
	private int soLuong;
	private double donGiaTruocThue;
	private double donGiaSauThue;
	public CT_PhieuDoiTra() {
		super();
	}
	public CT_PhieuDoiTra(PhieuDoiTra phieuDoiTra, VeTau veTau, int soLuong, double donGiaTruocThue,
			double donGiaSauThue) {
		super();
		this.phieuDoiTra = phieuDoiTra;
		this.veTau = veTau;
		this.soLuong = soLuong;
		this.donGiaTruocThue = donGiaTruocThue;
		this.donGiaSauThue = donGiaSauThue;
	}
	
	public CT_PhieuDoiTra(PhieuDoiTra phieuDoiTra, VeTau veTau, double donGiaTruocThue, double donGiaSauThue) {
		super();
		this.phieuDoiTra = phieuDoiTra;
		this.veTau = veTau;
		this.donGiaTruocThue = donGiaTruocThue;
		this.donGiaSauThue = donGiaSauThue;
	}
	
	public PhieuDoiTra getPhieuDoiTra() {
		return phieuDoiTra;
	}
	public void setPhieuDoiTra(PhieuDoiTra phieuDoiTra) {
		this.phieuDoiTra = phieuDoiTra;
	}
	public VeTau getVeTau() {
		return veTau;
	}
	public void setVeTau(VeTau veTau) {
		this.veTau = veTau;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGiaTruocThue() {
		return donGiaTruocThue;
	}
	public void setDonGiaTruocThue(double donGiaTruocThue) {
		this.donGiaTruocThue = donGiaTruocThue;
	}
	public double getDonGiaSauThue() {
		return donGiaSauThue;
	}
	public void setDonGiaSauThue(double donGiaSauThue) {
		this.donGiaSauThue = donGiaSauThue;
	}
	
	public double TinhThanhTien() {
		return soLuong*donGiaSauThue;
	}
	
	
	
}
