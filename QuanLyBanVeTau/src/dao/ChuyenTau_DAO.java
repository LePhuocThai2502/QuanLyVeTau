package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChuyenTau;

public class ChuyenTau_DAO {
	public ChuyenTau_DAO() {
	}

	// Lay toan bo table:
	public ArrayList<ChuyenTau> getalltbChuyenTau() {
		ArrayList<ChuyenTau> dsct = new ArrayList<ChuyenTau>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from ChuyenTau";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {// di chuyen con tro xuong ban ghi ke tiep
				String maChuyenTau = rs.getString(1);
				String tenChuyenTau = rs.getString(2);
				Date ngayDi = rs.getDate(3);
				Date ngayDen = rs.getDate(4);
				Time gioKhoiHanh = rs.getTime(5);
				Time gioDen = rs.getTime(6);
				String gaDi = rs.getString(7);
				String gaDen = rs.getString(8);
				int soLuongVe = rs.getInt(9);
				ChuyenTau chuyentau = new ChuyenTau(maChuyenTau, tenChuyenTau, ngayDi, ngayDen, gioKhoiHanh, gioDen,
						gaDi, gaDen, soLuongVe);
				dsct.add(chuyentau);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsct;
	}

	// lay table QuanLy:
	public ArrayList<ChuyenTau> getalltbQLChuyenTau() {
		ArrayList<ChuyenTau> dsqlct = new ArrayList<ChuyenTau>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from ChuyenTau";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {// di chuyen con tro xuong ban ghi ke tiep
				String maChuyenTau = rs.getString(1);
				String tenChuyenTau = rs.getString(2);
				String gaDi = rs.getString(7);
				String gaDen = rs.getString(8);
				ChuyenTau ctau = new ChuyenTau(maChuyenTau, tenChuyenTau, gaDi, gaDen);
				dsqlct.add(ctau);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsqlct;
	}

	// Phương thức để lấy ngày đến từ mã chuyến tàu:
	public Date getNgayDenByCode(String maChuyenTau) throws SQLException {
		Date ngayDen = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.

			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();

			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT ngayDen FROM ChuyenTau WHERE maChuyenTau = ?";
				statement = con.prepareStatement(sql);

				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maChuyenTau);

				// Thực hiện truy vấn
				rs = statement.executeQuery();

				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					ngayDen = rs.getDate("ngayDen");
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
		return ngayDen;
	}

	// Phương thức để lấy ngày đi từ mã chuyến tàu:
	public Date getNgayDiByCode(String maChuyenTau) throws SQLException {
		Date ngayDi = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.

			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();

			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT ngayDi FROM ChuyenTau WHERE maChuyenTau = ?";
				statement = con.prepareStatement(sql);

				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maChuyenTau);

				// Thực hiện truy vấn
				rs = statement.executeQuery();

				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					ngayDi = rs.getDate("ngayDi");
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

		return ngayDi;
	}

	// lay thoi gian khoi hanh tu ma chuyen tau:
	public Time getTGByCode(String maChuyenTau) throws SQLException {
		Time thoigianKH = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.

			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();

			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT gioKhoiHanh FROM ChuyenTau WHERE maChuyenTau = ?";
				statement = con.prepareStatement(sql);

				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maChuyenTau);

				// Thực hiện truy vấn
				rs = statement.executeQuery();

				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					thoigianKH = rs.getTime("gioKhoiHanh");
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

		return thoigianKH;
	}

	// lay thoi gian den tu ma chuyen tau:
	public Time getTGDenByCode(String maChuyenTau) throws SQLException {
		Time thoigianden = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.

			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();

			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT gioDen FROM ChuyenTau WHERE maChuyenTau = ?";
				statement = con.prepareStatement(sql);

				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maChuyenTau);

				// Thực hiện truy vấn
				rs = statement.executeQuery();

				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					thoigianden = rs.getTime("gioDen");
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
		return thoigianden;
	}

	// ham them Chuyen Tau:
	public void addCTau(ChuyenTau ctau) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "insert into ChuyenTau values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ctau.getMaChuyenTau());
			stmt.setString(2, ctau.getTenChuyenTau());
			stmt.setDate(3, (Date) ctau.getNgayDi());
			stmt.setDate(4, (Date) ctau.getNgayDen());
			stmt.setTime(5, ctau.getGioKhoiHanh());
			stmt.setTime(6, ctau.getGioDen());
			stmt.setString(7, ctau.getGaDi());
			stmt.setString(8, ctau.getGaDen());
			stmt.setInt(9, ctau.getSoLuongVe());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Ham huy ChuyenTau:
	public void deleteCTau(String maChuyenTau) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "delete from ChuyenTau where maChuyenTau=?";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maChuyenTau);
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// Ham Cap Nhat ChuyenTau:
	public void updateCTau(ChuyenTau ChuyenTau) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		String sql = "update ChuyenTau " + "set tenChuyenTau= ?," + "ngayDi = ?," + "ngayDen=?," + "gioKhoiHanh=?,"
				+ "gioDen=?," + "gaDi=?," + "gaDen=?," + "soLuongVe=?" + " where maChuyenTau= ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ChuyenTau.getTenChuyenTau());
			stmt.setDate(2, (Date) ChuyenTau.getNgayDi());
			stmt.setDate(3, (Date) ChuyenTau.getNgayDen());
			stmt.setTime(4, ChuyenTau.getGioKhoiHanh());
			stmt.setTime(5, ChuyenTau.getGioDen());
			stmt.setString(6, ChuyenTau.getGaDi());
			stmt.setString(7, ChuyenTau.getGaDen());
			stmt.setInt(8, ChuyenTau.getSoLuongVe());
			stmt.setString(9, ChuyenTau.getMaChuyenTau());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Ham tim kiem theo maCT:
	public void searchAndDisplayTrainByCode(String maChuyenTau) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM ChuyenTau WHERE maChuyenTau = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maChuyenTau);
			stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Ham lay danh sach cac maCTau:
	public ArrayList<String> getAllMaCTau() {
		ArrayList<String> dsMaChuyenTau = new ArrayList<>();
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			ConnectDB.getInstance();
			con = ConnectDB.getConnection();

			if (con != null) {
				String sql = "SELECT maChuyenTau FROM ChuyenTau";
				statement = con.prepareStatement(sql);
				rs = statement.executeQuery();

				while (rs.next()) {
					String maChuyenTau = rs.getString("maChuyenTau");
					dsMaChuyenTau.add(maChuyenTau);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Xử lý ngoại lệ một cách chính xác, có thể in log hoặc ném lại ngoại lệ
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

		return dsMaChuyenTau;
	}

	// soluongve
	public int getSoLuongVeByCode(String maChuyenTau) throws SQLException {
		int soluongve = 0;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.

			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();

			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT soLuongVe FROM ChuyenTau WHERE maChuyenTau = ?";
				statement = con.prepareStatement(sql);

				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maChuyenTau);

				// Thực hiện truy vấn
				rs = statement.executeQuery();

				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					soluongve = rs.getInt("soLuongVe");
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
		return soluongve;
	}

	/// tang maChuyenTau them 1
	public int getMaCTau() {
		int ma = 1;
		ConnectDB.getInstance();
		Connection con = (Connection) ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select max( CONVERT(int , SUBSTRING(maChuyenTau,3, 4))) from ChuyenTau";
			statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			if (rs.next() == false) {
				return ma;
			} else {
				ma = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return ma + 1;
	}

	// Phương thức để lấy tenCT đến từ mã chuyến tàu:
	public String getTenCTByCode(String maChuyenTau) throws SQLException {
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
				String sql = "SELECT tenChuyenTau FROM ChuyenTau WHERE maChuyenTau = ?";
				statement = con.prepareStatement(sql);

				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maChuyenTau);

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

}
