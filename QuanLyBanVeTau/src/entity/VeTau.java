package entity;

import java.util.Objects;

public class VeTau {
	private String maVe;
	private double giaVe;
	private int viTriGhe;
	private ChuyenTau chuyenTau;
	private LoaiGhe loaiGhe;
	
	public VeTau(String maVe, double giaVe, int viTriGhe, ChuyenTau chuyenTau, LoaiGhe loaiGhe) {
		super();
		this.maVe = maVe;
		this.giaVe = giaVe;
		this.viTriGhe = viTriGhe;
		this.chuyenTau = chuyenTau;
		this.loaiGhe = loaiGhe;
	}
	public VeTau() {
		super();
	}
	public VeTau(String maVe) {
		super();
		this.maVe = maVe;
	}
	
	public VeTau(String maVe2, ChuyenTau ctau, LoaiGhe loaighe2, double giaVE2, int viTriGhe2) {
		// TODO Auto-generated constructor stub
	}
	public String getMaVe() {
		return maVe;
	}
	public void setMaVe(String maVe) {
		this.maVe = maVe;
	}
	public double getGiaVe() {
		return giaVe;
	}
	public void setGiaVe(double giaVe) {
		this.giaVe = giaVe;
	}
	public int getViTriGhe() {
		return viTriGhe;
	}
	public void setViTriGhe(int viTriGhe) {
		this.viTriGhe = viTriGhe;
	}
	public ChuyenTau getChuyenTau() {
		return chuyenTau;
	}
	public void setChuyenTau(ChuyenTau chuyenTau) {
		this.chuyenTau = chuyenTau;
	}
	public LoaiGhe getLoaiGhe() {
		return loaiGhe;
	}
	public void setLoaiGhe(LoaiGhe loaiGhe) {
		this.loaiGhe = loaiGhe;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maVe);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VeTau other = (VeTau) obj;
		return Objects.equals(maVe, other.maVe);
	}
	@Override
	public String toString() {
		return "VeTau [maVe=" + maVe + ", giaVe=" + giaVe + ", viTriGhe=" + viTriGhe + ", chuyenTau=" + chuyenTau
				+ ", loaiGhe=" + loaiGhe + "]";
	}
	
	
	

}
