package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import connectDB.ConnectDB;
import entity.CT_HoaDon;
import entity.ChuyenTau;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiGhe;
import entity.NhanVien;
import entity.VeTau;

public class BanVe_DAO {
	public BanVe_DAO() {
		// TODO Auto-generated constructor stub
	}

	// ham lay toan bo bang HoaDon:
	public ArrayList<HoaDon> getalltbHoaDon() {
		ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from HoaDon";
			Statement statement = con.createStatement();
			// Thuc thi cau lenh SL tra ve doi tuong resultset
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {// di chuyen con tro xuong ban ghi ke tiep
				String maHD = rs.getString(1);
				Date ngaylapHD = rs.getDate(2);
				KhachHang maKh = new KhachHang(rs.getString("maKH"));
				NhanVien manv = new NhanVien(rs.getString("maNV"));
				Double tongDoanhThu = rs.getDouble(5);
				HoaDon hd = new HoaDon(maHD, ngaylapHD, manv, maKh, tongDoanhThu);
				dshd.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// ham lay toan bo bang CTHoaDon:
	public ArrayList<CT_HoaDon> getalltbCTHoaDon() {
		ArrayList<CT_HoaDon> dscthd = new ArrayList<CT_HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from CT_HoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {// di chuyen con tro xuong ban ghi ke tiep
				VeTau mave = new VeTau(rs.getString("maVe"));
				int soLuongHD = rs.getInt("soLuong");
				double giaveTT = rs.getDouble("donGiaTruocThue");
				double giaveST = rs.getDouble("donGiaSauThue");
				CT_HoaDon cthd = new CT_HoaDon(mave,soLuongHD, giaveTT, giaveST);
				dscthd.add(cthd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dscthd;
	}

	// ham lay toan bo bang Ve Tau
	public ArrayList<VeTau> getAllTbVeTau() {
		ArrayList<VeTau> dsvetau = new ArrayList<VeTau>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from VeTau";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maVe = rs.getString("maVe");
				ChuyenTau maChuyenTau = new ChuyenTau(rs.getString("maChuyenTau"));
				LoaiGhe loaiGhe = new LoaiGhe(rs.getString("maLoaiGhe"));
				double giave = rs.getDouble("giaVe");
				int vitriGhe = rs.getInt("viTriGhe");
				VeTau veTau = new VeTau(maVe, giave, vitriGhe, maChuyenTau, loaiGhe);
				dsvetau.add(veTau);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsvetau;
	}
	

	
	
	
	public void addHoaDon(HoaDon hd, DefaultTableModel tableModel) {
	    Connection con = null;
	    PreparedStatement stmt = null;

	    try {
	        con = ConnectDB.getConnection();

	        // Thêm thông tin cơ bản của hóa đơn vào bảng HoaDon
	        String sqlHoaDon = "INSERT INTO HoaDon (maHD, maNV, maKH, ngayLapHD, tongDoanhThu) VALUES (?, ?, ?, ?, ?)";
	        stmt = con.prepareStatement(sqlHoaDon);
	        stmt.setString(1, hd.getMaHD());
	        stmt.setString(2, hd.getNhanVien().getMaNV()); // Thay vì lấy tên nhân viên, lấy mã nhân viên
	        stmt.setString(3, hd.getKhachHang().getMaKH());
	        stmt.setDate(4, new Date(hd.getNgayLapHD().getTime()));
	        stmt.setDouble(5, hd.getTongDoanhThu());
	        stmt.executeUpdate();

	        // Thêm thông tin chi tiết hóa đơn (danh sách vé) vào bảng HoaDon_ChiTietVe
	        String sqlChiTietHoaDon = "INSERT INTO CT_HoaDon (maHD, maVe, soLuong, donGiaTruocThue, donGiaSauThue) VALUES (?, ?, ?, ?, ?)";
	        stmt = con.prepareStatement(sqlChiTietHoaDon);
	        for (int i = 0; i < tableModel.getRowCount(); i++) {
	            String maVe = (String) tableModel.getValueAt(i, 0);
	            int soLuong = (int) tableModel.getValueAt(i, 2);
	            double giatruocthue=(double) tableModel.getValueAt(i,4);
	            double giasauthue=(double) tableModel.getValueAt(i,5);
	            stmt.setString(1, hd.getMaHD());
	            stmt.setString(2, maVe);
	            stmt.setInt(3, soLuong);
	            stmt.setDouble(4, giatruocthue);
	            stmt.setDouble(5, giasauthue);
	            stmt.executeUpdate();
	        }

	 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Không đóng tài nguyên ở đây
	    }
	}

	
	public String getMaHoaDonCuoiCung() {
	    String maHoaDonCuoiCung = null;
	    try {
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "SELECT TOP 1 maHD FROM HoaDon ORDER BY maHD DESC";
	        Statement statement = con.createStatement();
	        ResultSet rs = statement.executeQuery(sql);
	        if (rs.next()) {
	            maHoaDonCuoiCung = rs.getString("maHD");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return maHoaDonCuoiCung;
	}
	public String taoMaHoaDonTuDong() {
        String lastMaHoaDon = getMaHoaDonCuoiCung();
        if (lastMaHoaDon != null) {
            // Lấy phần số lượng từ mã hóa đơn cuối cùng
            String soLuongStr = lastMaHoaDon.substring(10);
            int soLuong = Integer.parseInt(soLuongStr) + 1;
            // Định dạng lại số lượng để có 4 chữ số
            String soLuongFormatted = String.format("%04d", soLuong);
            // Tạo mã hóa đơn mới bằng cách kết hợp phần ngày tháng và số lượng
            String ngayThang = lastMaHoaDon.substring(2, 10);
            return "HD" + ngayThang + soLuongFormatted;
        } else {
            // Nếu không có mã hóa đơn nào trong cơ sở dữ liệu, trả về mã đầu tiên
        	Calendar calendar = Calendar.getInstance();
        	return "HD" + new SimpleDateFormat("ddMMyyyy").format(calendar.getTime()) + "0001";

        }
    }
	
	
	
	
	
//======================================================================================KHACHHANG//============================================================================================================================================================================

	//Ham kiem tra
	public boolean isKhachHangExists(String maKH) {
		boolean exists = false;
		try (Connection con = ConnectDB.getConnection();
				PreparedStatement stmt = con
						.prepareStatement("SELECT COUNT(*) AS count FROM KhachHang WHERE maKH = ?")) {
			stmt.setString(1, maKH);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					int count = rs.getInt("count");
					exists = count > 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return exists;
	}
	
	// ham them khachHang:
	public void addKhachHangMoi(KhachHang khachHang) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "INSERT INTO KhachHang (maKH, tenKH, sdt, email, phai) VALUES (?, ?, ?, ?, ?)";
	    PreparedStatement stmt = null;
	    try {
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, khachHang.getMaKH());
	        stmt.setString(2, khachHang.getTenKH());
	        stmt.setString(3, khachHang.getSdt());
	        stmt.setString(4, khachHang.getEmail());
	        stmt.setBoolean(5, khachHang.isPhai());
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	}
	
	
	/// tang maKH them 1
			public int getMaKH() {
				int ma = 1;
				ConnectDB.getInstance();
				Connection con=(Connection) ConnectDB.getConnection();
				PreparedStatement statement=null;
				try {
					String sql="select max( CONVERT(int , SUBSTRING(maKH,3, 4))) from KhachHang";
					statement=con.prepareStatement(sql);
					ResultSet rs=statement.executeQuery();
					 if (rs.next() == false) {
						  return ma;
					 }
					 else {
						 	ma = rs.getInt(1);
					}
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally {
					try {
						statement.close();
					} catch (SQLException e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
				return ma + 1;
			}
	
}
