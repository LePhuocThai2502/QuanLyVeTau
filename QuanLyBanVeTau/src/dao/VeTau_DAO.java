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
import entity.KhachHang;
import entity.LoaiGhe;
import entity.NhanVien;
import entity.TaiKhoan;
import entity.VeTau;

public class VeTau_DAO {

	public ArrayList<VeTau> getalltbQLVeTau() {
		ArrayList<VeTau> dsqlvetau = new ArrayList<VeTau>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT v.maVe, v.maChuyenTau, v.maLoaiGhe, v.giaVe, v.viTriGhe, l.tenLoaiGhe "
					+ "FROM VeTau v " + "INNER JOIN LoaiGhe l ON v.maLoaiGhe = l.maLoaiGhe";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maVe = rs.getString("maVe");
				String maChuyenTau = rs.getString("maChuyenTau");
				String maLoaiGhe = rs.getString("maLoaiGhe");
				String tenLoaiGhe = rs.getString("tenLoaiGhe"); // Lấy tên loại ghế từ bảng LoaiGhe
				double giaVe = rs.getDouble("giaVe");
				int viTriGhe = rs.getInt("viTriGhe");

				ChuyenTau ctau = new ChuyenTau(maChuyenTau);
				LoaiGhe loaighe = new LoaiGhe(maLoaiGhe, tenLoaiGhe); // Truyền tên loại ghế vào constructor
				VeTau veTau = new VeTau(maVe, giaVe, viTriGhe, ctau, loaighe);
				dsqlvetau.add(veTau);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsqlvetau;
	}

	// Phương thức để lấy tenChuyenTau từ mã CT:
	public String gettenCTByCode(String maChuyenTau) throws SQLException {
		String tenChuyenTau = null;
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
					tenChuyenTau = rs.getString("tenChuyenTau");
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

		return tenChuyenTau;
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

	// Phương thức để lấy gadi từ mã CT:
	public String getGaDiByCode(String maChuyenTau) throws SQLException {
		String GaDi = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.

			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();

			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT gaDi FROM ChuyenTau WHERE maChuyenTau = ?";
				statement = con.prepareStatement(sql);

				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maChuyenTau);

				// Thực hiện truy vấn
				rs = statement.executeQuery();

				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					GaDi = rs.getString("gaDi");
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

		return GaDi;
	}

	// Phương thức để lấy gaden từ mã CT:
	public String getGaDenByCode(String maChuyenTau) throws SQLException {
		String GaDen = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.

			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();

			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT gaDen FROM ChuyenTau WHERE maChuyenTau = ?";
				statement = con.prepareStatement(sql);

				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maChuyenTau);

				// Thực hiện truy vấn
				rs = statement.executeQuery();

				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					GaDen = rs.getString("gaDen");
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

		return GaDen;
	}

	public ArrayList<LoaiGhe> getalltableloaiGhe() {
		ArrayList<LoaiGhe> dsqlloaighe = new ArrayList<LoaiGhe>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from LoaiGhe";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maloaiGhe = rs.getString("maLoaiGhe");
				String tenLoaiGhe = rs.getString("tenLoaiGhe");

				LoaiGhe loaighe = new LoaiGhe(maloaiGhe, tenLoaiGhe);
				dsqlloaighe.add(loaighe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsqlloaighe;
	}

	// Phương thức để lấy gadi từ mã CT:
	public String getMaLoaiGheByCode(String maVeTau) throws SQLException {
		String maLoaiGhe = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.

			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();

			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT maLoaiGhe FROM VeTau WHERE maVe = ?";
				statement = con.prepareStatement(sql);

				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maVeTau);

				// Thực hiện truy vấn
				rs = statement.executeQuery();

				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					maLoaiGhe = rs.getString("maLoaiGhe");
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

		return maLoaiGhe;
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

	// Phương thức để lấy tenLoaiGhe từ mã loaiGHe:
	public String gettenLoaiGheByCode(String maLoaiGhe) throws SQLException {
		String tenLoaiGhe = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.

			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();

			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT tenLoaiGhe FROM LoaiGhe WHERE maLoaiGhe = ?";
				statement = con.prepareStatement(sql);

				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maLoaiGhe);

				// Thực hiện truy vấn
				rs = statement.executeQuery();

				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					tenLoaiGhe = rs.getString("tenLoaiGhe");
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

		return tenLoaiGhe;
	}

	// ham them Ve Tau:
	public void addVeTau(VeTau vetau) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "insert into VeTau values(?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vetau.getMaVe());
			stmt.setString(2, vetau.getChuyenTau().getMaChuyenTau());
			stmt.setString(3, vetau.getLoaiGhe().getMaLoaiGhe());
			stmt.setDouble(4, vetau.getGiaVe());
			stmt.setInt(5, vetau.getViTriGhe());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Ham Cap Nhat veTau:
		public void updateVTau(VeTau vetau) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			String sql = "update VeTau " + "set maChuyenTau= ?," + "maLoaiGhe = ?," + "giaVe= ?," + "viTriGhe= ?" + " where maVe= ?";
			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, vetau.getChuyenTau().getMaChuyenTau());
				stmt.setString(2, vetau.getLoaiGhe().getMaLoaiGhe());
				stmt.setDouble(3, vetau.getGiaVe());
				stmt.setInt(4, vetau.getViTriGhe());
				stmt.setString(5, vetau.getMaVe());
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
