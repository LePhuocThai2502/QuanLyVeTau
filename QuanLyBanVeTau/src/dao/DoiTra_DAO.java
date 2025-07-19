package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import entity.CT_HoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDoiTra;
import entity.VeTau;

public class DoiTra_DAO {

	public DoiTra_DAO() {
		// TODO Auto-generated constructor stub
	}

	// ham lay toan bo bang CTHoaDon:
	public ArrayList<CT_HoaDon> getalltbCTHoaDon() {
		ArrayList<CT_HoaDon> dshCTHD = new ArrayList<CT_HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT CT_HoaDon.*, HoaDon.maHD, VeTau.maVe\r\n" + "FROM CT_HoaDon\r\n"
					+ "JOIN HoaDon ON CT_HoaDon.maHD = HoaDon.maHD\r\n" + "JOIN VeTau ON CT_HoaDon.maVe = VeTau.maVe";
			Statement statement = con.createStatement();
			// Thuc thi cau lenh SL tra ve doi tuong resultset
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {// di chuyen con tro xuong ban ghi ke tiep
				HoaDon mahd = new HoaDon(rs.getString("maHD"));
				VeTau mave = new VeTau(rs.getString("maVe"));
				int soLuong = rs.getInt(3);
				double dongiatruocthue = rs.getDouble(4);
				double dongiasauthue = rs.getDouble(5);
				CT_HoaDon cthd = new CT_HoaDon(mahd, mave, soLuong, dongiatruocthue, dongiasauthue);
				dshCTHD.add(cthd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dshCTHD;
	}

	// ham lay ma nhanvien tu maHD
	public String getMaNVByIdHoaDon(String maHD) {
		String maNV = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			con = ConnectDB.getConnection();
			String sql = "SELECT maNV FROM HoaDon WHERE maHD = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maHD);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				maNV = resultSet.getString("maNV");
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Xử lý ngoại lệ hoặc báo cáo lỗi kết nối
		}
		return maNV;
	}

	// ham lay ten nhanvien tu maNV
	public String getTenNVByIdNV(String maNV) {
		String tenNV = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			con = ConnectDB.getConnection();
			String sql = "SELECT tenNV FROM NhanVien WHERE maNV = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maNV);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				tenNV = resultSet.getString("tenNV");
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Xử lý ngoại lệ hoặc báo cáo lỗi kết nối
		}
		return tenNV;
	}

	public String getMaHoaDonDTCuoiCung() {
		String maHoaDonDTCuoiCung = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT TOP 1 maPhieuDT FROM PhieuDoiTra ORDER BY maPhieuDT DESC";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				maHoaDonDTCuoiCung = rs.getString("maPhieuDT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maHoaDonDTCuoiCung;
	}

	public String taoMaHoaDonTuDong() {
		String lastMaHoaDon = getMaHoaDonDTCuoiCung();
		if (lastMaHoaDon != null) {
			// Lấy phần số lượng từ mã hóa đơn cuối cùng
			String soLuongStr = lastMaHoaDon.substring(10);
			int soLuong = Integer.parseInt(soLuongStr) + 1;
			// Định dạng lại số lượng để có 4 chữ số
			String soLuongFormatted = String.format("%04d", soLuong);
			// Tạo mã hóa đơn mới bằng cách kết hợp phần ngày tháng và số lượng
			String ngayThang = lastMaHoaDon.substring(4, 10);
			return "HDDT" + ngayThang + soLuongFormatted;
		} else {
			// Nếu không có mã hóa đơn nào trong cơ sở dữ liệu, trả về mã đầu tiên
			Calendar calendar = Calendar.getInstance();
			return "HDDT" + new SimpleDateFormat("ddMMyyyy").format(calendar.getTime()) + "0001";

		}
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
				String dongiatt = formatter.format(resultSet.getDouble("donGiaTruocThue"));
				String dongiast = formatter.format(resultSet.getDouble("donGiaSauThue"));

				// Lấy thông tin chi tiết của hóa đơn từ kết quả truy vấn
				Object[] item = { resultSet.getString("maVe"), dongiatt, dongiast, resultSet.getInt("soLuong") };
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

//	// ham them phieu doi tra:
//	public void addPhieuDoiTra(PhieuDoiTra phieuDT) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "insert into PhieuDoiTra values(?,?,?,?,?,?,?)";
//		PreparedStatement stmt = null;
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, phieuDT.getMaPhieuDT());
//			stmt.setString(2, phieuDT.getHoaDon().getMaHD());
//			stmt.setDate(3, phieuDT.getThoiGianTaoDonDT());
//			stmt.setBoolean(4, phieuDT.isLoai());
//			stmt.setDouble(5, phieuDT.getTienHoan());
//			stmt.setString(6, phieuDT.getLyDo());
//			// Chuyển đổi enum TrangThai thành chuỗi trước khi gán vào câu lệnh SQL
//			stmt.setString(7, phieuDT.getTrangThai().toString());
//			stmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	// Phương thức để lấy maKH đến từ mã hóa đơn:
	public String getMaKHByCode(String maHD) throws SQLException {
		String maKH = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.

			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();

			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT maKH FROM HoaDon WHERE maHD = ?";
				statement = con.prepareStatement(sql);

				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maHD);

				// Thực hiện truy vấn
				rs = statement.executeQuery();

				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					maKH = rs.getString("maKH");
				}
			}
		} catch (SQLException e) {
			// Xử lý ngoại lệ một cách chính xác, có thể in log hoặc ném lại ngoại lệ
			e.printStackTrace();
			throw e; // Ném lại ngoại lệ để xử lý ở lớp gọi
		} finally {
			// Đảm bảo rằng tất cả các tài nguyên đều được giải phóng
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return maKH;
	}

	// Phương thức để lấy tenKH từ mã KH:
	public String getTenKHtuMaKH(String maKhachHang) throws SQLException {
		String tenKH = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.

			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();

			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT tenKH FROM KhachHang WHERE maKH = ?";
				statement = con.prepareStatement(sql);

				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maKhachHang);

				// Thực hiện truy vấn
				rs = statement.executeQuery();

				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					tenKH = rs.getString("tenKH");
				}
			}
		} catch (SQLException e) {
			// Xử lý ngoại lệ một cách chính xác, có thể in log hoặc ném lại ngoại lệ
			e.printStackTrace();
			throw e; // Ném lại ngoại lệ để xử lý ở lớp gọi
		} finally {
			// Đảm bảo rằng tất cả các tài nguyên đều được giải phóng
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return tenKH;
	}

	//ham Tao Phieu doi tra
	public void addPhieuDT(PhieuDoiTra pdt, DefaultTableModel tableModel) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectDB.getConnection();
			// Thêm thông tin cơ bản của hóa đơn vào bảng HoaDon
			String sqlHoaDonDT = "insert into PhieuDoiTra values(?,?,?,?,?,?,?)";
			stmt = con.prepareStatement(sqlHoaDonDT);
			stmt.setString(1, pdt.getMaPhieuDT());
			stmt.setString(2, pdt.getHoaDon().getMaHD());
			stmt.setDate(3, pdt.getThoiGianTaoDonDT());
			stmt.setBoolean(4, pdt.isLoai());
			stmt.setDouble(5, pdt.getTienHoan());
			stmt.setString(6, pdt.getLyDo());
			// Chuyển đổi enum TrangThai thành chuỗi trước khi gán vào câu lệnh SQL
			stmt.setString(7, pdt.getTrangThai().toString());
			stmt.executeUpdate();

			// Thêm thông tin chi tiết doi tra (danh sách vé) vào bảng
			// HoaDonDoiTra_ChiTietVe
			String sqlChiTietHoaDonDT = "INSERT INTO CT_PhieuDoiTra values(?,?,?,?,?)";
			stmt = con.prepareStatement(sqlChiTietHoaDonDT);
			for (int i = 0; i < tableModel.getRowCount(); i++) {
				String maVe = (String) tableModel.getValueAt(i, 0);
				int soLuong = (int) tableModel.getValueAt(i, 1);
				
				String stringValue1 = tableModel.getValueAt(i, 2).toString();
				String stringValue2 = tableModel.getValueAt(i, 3).toString();
				// Loại bỏ dấu phân cách hàng nghìn và ký tự "₫" từ chuỗi
				stringValue1 = stringValue1.replace(",", "").replace(" ₫", "");
				// Loại bỏ dấu phân cách hàng nghìn và ký tự "₫" từ chuỗi
				stringValue2 = stringValue2.replace(",", "").replace(" ₫", "");
				double giatruocthue = Double.parseDouble(stringValue1);;
				double giasauthue = Double.parseDouble(stringValue2);
				stmt.setString(1, pdt.getMaPhieuDT());
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

}
