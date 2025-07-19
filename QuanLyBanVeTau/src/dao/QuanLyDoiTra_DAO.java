package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.CT_HoaDon;
import entity.HoaDon;
import entity.PhieuDoiTra;
import entity.VeTau;

public class QuanLyDoiTra_DAO {

	// ham lay toan bo bang HDDoitra:
	public ArrayList<PhieuDoiTra> getalltbDoiTra() {
		ArrayList<PhieuDoiTra> dsphieuDT = new ArrayList<PhieuDoiTra>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from PhieuDoiTra";
			Statement statement = con.createStatement();
			// Thuc thi cau lenh SL tra ve doi tuong resultset
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {// di chuyen con tro xuong ban ghi ke tiep
				String maphieuDT = rs.getString(1);
				HoaDon mahd = new HoaDon(rs.getString("maHD"));
				Date thoigiantaophieu = rs.getDate(3);
				boolean loai = rs.getBoolean(4);
				double tongtienHoan = rs.getDouble(5);
				String lydo = rs.getString(6);
				String trangthai = rs.getString(7);

				// Chuyển đổi chuỗi trạng thái thành enum TrangThai
				PhieuDoiTra.TrangThai trangThaiEnum = PhieuDoiTra.TrangThai.valueOf(trangthai);

				PhieuDoiTra phieuDT = new PhieuDoiTra(maphieuDT, mahd, thoigiantaophieu, loai, tongtienHoan, lydo,
						trangThaiEnum);
				dsphieuDT.add(phieuDT);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsphieuDT;
	}

	public String getmaNV(String maHD) {
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

	public String gettenNV(String maNV) {
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

	// phuong thuc lay ly do tu maphieu dT
	public String getLyDo(String maDT) {
		String lyDo = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			con = ConnectDB.getConnection();
			String sql = "SELECT lyDo FROM PhieuDoiTra WHERE maPhieuDT = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maDT);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				lyDo = resultSet.getString("lyDo");
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Xử lý ngoại lệ hoặc báo cáo lỗi kết nối
		}
		return lyDo;
	}

	// phuong thuc lay tienHoan tu maphieu dT
	public Double getTienHoan(String maDT) {
		Double tienHoan = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			con = ConnectDB.getConnection();
			String sql = "SELECT tongTien FROM PhieuDoiTra WHERE maPhieuDT = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maDT);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				tienHoan = resultSet.getDouble("tongTien");
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Xử lý ngoại lệ hoặc báo cáo lỗi kết nối
		}
		return tienHoan;
	}

	public List<Object[]> getInvoiceItemsByCodeFromDatabase(Object invoiceCode) {
		List<Object[]> invoiceItems = new ArrayList<>();
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		// Thực hiện kết nối đến cơ sở dữ liệu và truy vấn
		try {
			con = ConnectDB.getConnection();
			String sql = "SELECT * FROM CT_PhieuDoiTra WHERE maPhieuDT = ?";
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

	// Ham Cap Nhat veTau:
	public void updateVTau(PhieuDoiTra phieuDoiTra) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		String sql = "update PhieuDoiTra " + "set maHD= ?," + "thoiGianTaoDonDT = ?," + "loai= ?," + "tongTien= ?," +"lyDo= ?,"+ "trangThai= ?"
				+ " where maPhieuDT= ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, phieuDoiTra.getHoaDon().getMaHD());
			stmt.setDate(2, phieuDoiTra.getThoiGianTaoDonDT());
			stmt.setBoolean(3, phieuDoiTra.isLoai());
			stmt.setDouble(4, phieuDoiTra.getTienHoan());
			stmt.setString(5, phieuDoiTra.getLyDo());
			stmt.setString(6, phieuDoiTra.getTrangThai().toString());
			stmt.setString(7, phieuDoiTra.getMaPhieuDT());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
