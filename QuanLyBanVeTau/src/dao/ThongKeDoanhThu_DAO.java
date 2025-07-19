package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.ConnectDB;

public class ThongKeDoanhThu_DAO {

	// Phương thức để lấy tongDoanhThu từ ngayLapHD:
	public Double getTongDoanhThuByDate(Date ngaylapHD) throws SQLException {
		double tongDoanhThu = 0;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.
			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();
			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT tongDoanhThu FROM HoaDon WHERE ngayLapHD = ?";
				statement = con.prepareStatement(sql);

				// Thiết lập tham số cho PreparedStatement
				statement.setDate(1, ngaylapHD);

				// Thực hiện truy vấn
				rs = statement.executeQuery();

				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					tongDoanhThu = rs.getDouble("tongDoanhThu");
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
		return tongDoanhThu;
	}

	

	// Phương thức để lấy số lượng phiếu đổi trả từ ngày lập phiếu
	public int getSoLuongPhieuDoiTraByDate(Date ngayLapPhieuDT) throws SQLException {
		int soLuongPhieuDoiTra = 0;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			// Đảm bảo ConnectDB.getInstance() đã được gọi trước đó
			ConnectDB.getInstance();
			// Lấy connection từ ConnectDB
			con = ConnectDB.getConnection();
			if (con != null) {
				// Nếu kết nối không null, tiếp tục thực hiện truy vấn
				String sql = "SELECT COUNT(*) AS SoLuongPhieuDoiTra FROM PhieuDoiTra WHERE thoiGianTaoDonDT = ?";
				statement = con.prepareStatement(sql);

				// Thiết lập tham số cho PreparedStatement
				statement.setDate(1, ngayLapPhieuDT);

				// Thực hiện truy vấn
				rs = statement.executeQuery();

				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy số lượng phiếu đổi trả từ kết quả truy vấn
					soLuongPhieuDoiTra = rs.getInt("SoLuongPhieuDoiTra");
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
		return soLuongPhieuDoiTra;
	}
	
	
	
	// Phương thức để lấy số lượng hoa don từ ngày lập phiếu
		public int getSoLuongHoaDonByDate(Date ngayLapPhieuDT) throws SQLException {
			int soLuongHoaDon = 0;
			Connection con = null;
			PreparedStatement statement = null;
			ResultSet rs = null;

			try {
				// Đảm bảo ConnectDB.getInstance() đã được gọi trước đó
				ConnectDB.getInstance();
				// Lấy connection từ ConnectDB
				con = ConnectDB.getConnection();
				if (con != null) {
					// Nếu kết nối không null, tiếp tục thực hiện truy vấn
					String sql = "SELECT COUNT(*) AS soLuongHoaDon FROM HoaDon WHERE ngayLapHD = ?";
					statement = con.prepareStatement(sql);

					// Thiết lập tham số cho PreparedStatement
					statement.setDate(1, ngayLapPhieuDT);

					// Thực hiện truy vấn
					rs = statement.executeQuery();

					// Kiểm tra xem có bản ghi nào hay không
					if (rs.next()) {
						// Lấy số lượng phiếu đổi trả từ kết quả truy vấn
						soLuongHoaDon = rs.getInt("soLuongHoaDon");
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
			return soLuongHoaDon;
		}

}
