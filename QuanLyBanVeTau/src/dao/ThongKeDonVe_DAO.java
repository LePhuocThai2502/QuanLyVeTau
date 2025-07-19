package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import entity.CT_HoaDon;
import entity.ChuyenTau;
import entity.VeTau;

public class ThongKeDonVe_DAO {

	// Lay toan bo table:
	public ArrayList<CT_HoaDon> getalltbCTHoaDon() {
		ArrayList<CT_HoaDon> dshdvetau = new ArrayList<CT_HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from CT_HoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {// di chuyen con tro xuong ban ghi ke tiep

				String maVe = rs.getString(2);
				VeTau mave = new VeTau(maVe);
				int soLuong = rs.getInt(3);
				double dongiaTruocThue = rs.getDouble(4);
				double dongiaSauThue = rs.getDouble(5);
				CT_HoaDon ct_hd = new CT_HoaDon(mave, soLuong, dongiaTruocThue, dongiaSauThue);
				dshdvetau.add(ct_hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dshdvetau;
	}

	// Phương thức để lấy tenCT đến từ mã vé tàu:
	public String getTenCTByCode(String maVe) throws SQLException {
		String tenCTau = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.

			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();

			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT ChuyenTau.tenChuyenTau\r\n" + "FROM VeTau\r\n"
						+ "JOIN ChuyenTau ON VeTau.maChuyenTau = ChuyenTau.maChuyenTau\r\n" + "WHERE VeTau.maVe = ?;";
				statement = con.prepareStatement(sql);

				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maVe);

				// Thực hiện truy vấn
				rs = statement.executeQuery();

				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					tenCTau = rs.getString("tenChuyenTau");
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
		return tenCTau;
	}

	// Phương thức để lấy tenloaighe đến từ mã vé tàu:
	public String getTenLGByCode(String maVe) throws SQLException {
		String tenLG = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.

			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();

			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT LoaiGhe.tenLoaiGhe\r\n" + "FROM VeTau\r\n"
						+ "JOIN LoaiGhe ON VeTau.maLoaiGhe = LoaiGhe.maLoaiGhe\r\n" + "WHERE VeTau.maVe = ?;";
				statement = con.prepareStatement(sql);

				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maVe);

				// Thực hiện truy vấn
				rs = statement.executeQuery();

				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					tenLG = rs.getString("tenLoaiGhe");
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
		return tenLG;
	}

	// tim kiem CT_hoaDon theo ngay lap:
	public DefaultTableModel getChiTietHoaDonByNgayLap(Date ngaylapHD) {
		DefaultTableModel tableModel = new DefaultTableModel(
				new Object[] { "Mã Vé", "Số Lượng", "Giá Vé", "Giá Vé Sau Thuế", "Tổng Doanh Thu" }, 0);

		// Tạo một NumberFormat instance cho định dạng tiền tệ Việt Nam
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

		// Kết nối đến database và thực hiện truy vấn
        try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLVeTau", "sa", "sapassword")) {
            String sql = "SELECT CT_HoaDon.maVe, CT_HoaDon.soLuong, CT_HoaDon.donGiaTruocThue, CT_HoaDon.donGiaSauThue " +
                         "FROM CT_HoaDon " +
                         "INNER JOIN HoaDon ON CT_HoaDon.maHD = HoaDon.maHD " +
                         "WHERE HoaDon.ngayLapHD = ?";

			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setDate(1, ngaylapHD);

				try (ResultSet rs = statement.executeQuery()) {
					while (rs.next()) {
						String maVe = rs.getString("maVe");
						int soLuong = rs.getInt("soLuong");
						double donGiaTruocThue = rs.getDouble("donGiaTruocThue");
						double donGiaSauThue = rs.getDouble("donGiaSauThue");

						// Tính tổng doanh thu cho mỗi hàng
						double tongDoanhThu = donGiaSauThue * soLuong;

						// Định dạng tiền tệ
						String formattedDonGiaTruocThue = currencyFormat.format(donGiaTruocThue);
						String formattedDonGiaSauThue = currencyFormat.format(donGiaSauThue);
						String formattedTongDoanhThu = currencyFormat.format(tongDoanhThu);

						// Thêm hàng mới vào table model
						tableModel.addRow(new Object[] { maVe, soLuong, formattedDonGiaTruocThue,
								formattedDonGiaSauThue, formattedTongDoanhThu });
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tableModel;
	}

}
