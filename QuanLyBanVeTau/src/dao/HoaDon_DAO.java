package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import entity.CT_HoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.VeTau;

public class HoaDon_DAO {
	public HoaDon_DAO() {
		// TODO Auto-generated constructor stub
	}

	// ham lay toan bo bang HoaDon:
	public ArrayList<HoaDon> getalltbHoaDon() {
		ArrayList<HoaDon> dshD = new ArrayList<HoaDon>();
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
				NhanVien maNV = new NhanVien(rs.getString("maNV"));
				Double tongDoanhThu = rs.getDouble(5);
				HoaDon hd = new HoaDon(maHD, ngaylapHD, maNV, maKh, tongDoanhThu);
				dshD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dshD;
	}

	public List<Object[]> getInvoiceItemsByCodeFromDatabase(Object invoiceCode) {
		List<Object[]> invoiceItems = new ArrayList<>();
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		// Thực hiện kết nối đến cơ sở dữ liệu và truy vấn
		try {
			con = ConnectDB.getConnection();
			String sql = "SELECT * FROM CT_HoaDon WHERE maHD = ?";
			statement = con.prepareStatement(sql);
			// Thiết lập tham số cho truy vấn
			statement.setObject(1, invoiceCode);

			// Thực thi truy vấn và lấy kết quả
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				DecimalFormat formatter = new DecimalFormat("###,###,###,###.## ₫");
				String dongiatt=formatter.format(resultSet.getDouble("donGiaTruocThue"));
				String dongiast=formatter.format(resultSet.getDouble("donGiaSauThue"));
				
				
				
				// Lấy thông tin chi tiết của hóa đơn từ kết quả truy vấn
				Object[] item = { resultSet.getString("maVe"), dongiatt,
						dongiast, resultSet.getInt("soLuong") };
				invoiceItems.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Xử lý ngoại lệ hoặc báo cáo lỗi kết nối
		} finally {
			// Không đóng kết nối trong phương thức này
			// Chuyển việc đóng kết nối đến phía gọi phương thức
		}

		return invoiceItems;
	}

	// Phương thức để lấy tên của khách hàng từ mã khách hàng
	public String getCustomerNameById(String customerId) {
		String customerName = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			con = ConnectDB.getConnection();
			String sql = "SELECT tenKH FROM KhachHang WHERE maKH = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, customerId);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				customerName = resultSet.getString("tenKH");
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Xử lý ngoại lệ hoặc báo cáo lỗi kết nối
		}
		return customerName;
	}

	// Phương thức để lấy tên của khách hàng từ mã khách hàng
	public String getSDTbyID(String customerId) {
		String SDT = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			con = ConnectDB.getConnection();
			String sql = "SELECT sdt FROM KhachHang WHERE maKH = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, customerId);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				SDT = resultSet.getString("sdt");
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Xử lý ngoại lệ hoặc báo cáo lỗi kết nối
		}
		return SDT;
	}

	public String getTenNV(String EmployeeID) {
		String tenNV = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			con = ConnectDB.getConnection();
			String sql = "SELECT tenNV FROM NhanVien WHERE maNV = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, EmployeeID);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				tenNV = resultSet.getString("tenNV");
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Xử lý ngoại lệ hoặc báo cáo lỗi kết nối
		}
		return tenNV;
	}

	// Hàm tìm kiếm hóa đơn theo mã hóa đơn
	public DefaultTableModel searchInvoiceByTicketCode(String maHoaDon) {
		DefaultTableModel modelTimKiemTheoMaHD = new DefaultTableModel();
		modelTimKiemTheoMaHD.addColumn("Mã hóa đơn");
		modelTimKiemTheoMaHD.addColumn("Nhân viên");
		modelTimKiemTheoMaHD.addColumn("Khách hàng");
		modelTimKiemTheoMaHD.addColumn("Ngày mua");
		modelTimKiemTheoMaHD.addColumn("Thành tiền");
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = ConnectDB.getConnection();
			// Tạo câu truy vấn SQL
			String query = "SELECT * FROM HoaDon WHERE maHD = ?";
			statement = con.prepareStatement(query);
			statement.setString(1, maHoaDon);
			// Thực thi truy vấn
			resultSet = statement.executeQuery();
			// Lấy dữ liệu từ ResultSet và thêm vào model của JTable
			while (resultSet.next()) {
				String maHD = resultSet.getString("maHD");
				String tenNV = resultSet.getString("maNV");
				String maKH = resultSet.getString("maKH");
				Date ngayMua = resultSet.getDate("ngayLapHD");
				double TTien = resultSet.getDouble("tongDoanhThu");
				modelTimKiemTheoMaHD.addRow(new Object[] { maHD, tenNV, maKH, ngayMua, TTien });
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return modelTimKiemTheoMaHD;
	}

	
	// Hàm tìm kiếm hóa đơn theo ngày lập HD
	public DefaultTableModel searchInvoiceByNgayLap(Date ngaylapHD) {
		DefaultTableModel modelTimKiemTheoNgayMua = new DefaultTableModel();
		modelTimKiemTheoNgayMua.addColumn("Mã hóa đơn");
		modelTimKiemTheoNgayMua.addColumn("Nhân viên");
		modelTimKiemTheoNgayMua.addColumn("Khách hàng");
		modelTimKiemTheoNgayMua.addColumn("Ngày mua");
		modelTimKiemTheoNgayMua.addColumn("Thành tiền");
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = ConnectDB.getConnection();
			// Tạo câu truy vấn SQL
			String query = "SELECT * FROM HoaDon WHERE ngayLapHD = ?";
			statement = con.prepareStatement(query);
			statement.setDate(1, ngaylapHD);
			// Thực thi truy vấn
			resultSet = statement.executeQuery();
			// Lấy dữ liệu từ ResultSet và thêm vào model của JTable
			while (resultSet.next()) {
				String maHD = resultSet.getString("maHD");
				String tenNV = resultSet.getString("maNV");
				String maKH = resultSet.getString("maKH");
				Date ngayMua = resultSet.getDate("ngayLapHD");
				double TTien = resultSet.getDouble("tongDoanhThu");
				modelTimKiemTheoNgayMua.addRow(new Object[] { maHD, tenNV, maKH, ngayMua, TTien });
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return modelTimKiemTheoNgayMua;
	}
	
	
	
	// Hàm tìm kiếm hóa đơn theo mã	KH
		public DefaultTableModel searchInvoiceByCusID(String maKhachHang) {
			DefaultTableModel modelTimKiemTheoMaKH = new DefaultTableModel();
			modelTimKiemTheoMaKH.addColumn("Mã hóa đơn");
			modelTimKiemTheoMaKH.addColumn("Nhân viên");
			modelTimKiemTheoMaKH.addColumn("Khách hàng");
			modelTimKiemTheoMaKH.addColumn("Ngày mua");
			modelTimKiemTheoMaKH.addColumn("Thành tiền");
			Connection con = null;
			PreparedStatement statement = null;
			ResultSet resultSet = null;
			try {
				con = ConnectDB.getConnection();
				// Tạo câu truy vấn SQL
				String query = "SELECT * FROM HoaDon WHERE maHD = ?";
				statement = con.prepareStatement(query);
				statement.setString(1, maKhachHang);
				// Thực thi truy vấn
				resultSet = statement.executeQuery();
				// Lấy dữ liệu từ ResultSet và thêm vào model của JTable
				while (resultSet.next()) {
					String maHD = resultSet.getString("maHD");
					String tenNV = resultSet.getString("maNV");
					String maKH = resultSet.getString("maKH");
					Date ngayMua = resultSet.getDate("ngayLapHD");
					double TTien = resultSet.getDouble("tongDoanhThu");
					modelTimKiemTheoMaKH.addRow(new Object[] { maHD, tenNV, maKH, ngayMua, TTien });
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			return modelTimKiemTheoMaKH;
		}
	

}
