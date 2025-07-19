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

import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.NhanVien;
import entity.TaiKhoan;

public class NhanVien_DAO {

	// lay table QuanLyNhanVien:
	public ArrayList<NhanVien> getalltbQLNhanVien() {
		ArrayList<NhanVien> dsqlnv = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {// di chuyen con tro xuong ban ghi ke tiep
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				Date ngaySinh = rs.getDate(5);
				String ChucVu = rs.getString(8);
				TaiKhoan TaiKhoan = new TaiKhoan(rs.getString(1));
				NhanVien nv = new NhanVien(maNV, tenNV, ngaySinh, ChucVu, TaiKhoan);
				dsqlnv.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsqlnv;
	}

	// Phương thức để lấy tuoi từ mã NV:
	public String getAgeByCode(String maNV) throws SQLException {
		String tuoi = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.
			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();
			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT tuoiNV FROM NhanVien WHERE maNV = ?";
				statement = con.prepareStatement(sql);

				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maNV);

				// Thực hiện truy vấn
				rs = statement.executeQuery();

				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					tuoi = rs.getString("tuoiNV");
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
		return tuoi;
	}

	// Phương thức để lấy tenNV từ mã NV:
	public String gettenByCode(String maNV) throws SQLException {
		String tenNV = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.
			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();
			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT tenNV FROM NhanVien WHERE maNV = ?";
				statement = con.prepareStatement(sql);

				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maNV);

				// Thực hiện truy vấn
				rs = statement.executeQuery();

				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					tenNV = rs.getString("tenNV");
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
		return tenNV;
	}

	// Phương thức để lấy sdt từ mã NV:
	public String getSDTByCode(String maNV) throws SQLException {
		String sdt = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.
			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();
			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT sdtNV FROM NhanVien WHERE maNV = ?";
				statement = con.prepareStatement(sql);
				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maNV);
				// Thực hiện truy vấn
				rs = statement.executeQuery();
				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					sdt = rs.getString("sdtNV");
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
		return sdt;
	}

	// Phương thức để lấy cmnd từ mã NV:
	public String getCMNDByCode(String maNV) throws SQLException {
		String cmnd = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.
			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();
			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT cmnd FROM NhanVien WHERE maNV = ?";
				statement = con.prepareStatement(sql);
				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maNV);
				// Thực hiện truy vấn
				rs = statement.executeQuery();
				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					cmnd = rs.getString("cmnd");
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
		return cmnd;
	}

	// Phương thức để lấy password từ tenTK :
	public String getPassByNameTK(String tenTK) throws SQLException {
		String pass = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.
			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();
			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT matKhau FROM TaiKhoan WHERE tenTK = ?";
				statement = con.prepareStatement(sql);
				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, tenTK);
				// Thực hiện truy vấn
				rs = statement.executeQuery();
				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					pass = rs.getString("matKhau");
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
		return pass;
	}

	// Phương thức để lấy luong từ mã NV:
	public Float getLuongByCode(String maNV) throws SQLException {
		float Luong = 0;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.
			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();
			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT luong FROM NhanVien WHERE maNV = ?";
				statement = con.prepareStatement(sql);
				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maNV);
				// Thực hiện truy vấn
				rs = statement.executeQuery();
				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					Luong = rs.getFloat("luong");
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
		return Luong;
	}

	// Phương thức để lấy ngayvaolam từ mã NV:
	public Date getDateByCode(String maNV) throws SQLException {
		Date ngayvaolam = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.
			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();
			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT ngayLamViec FROM NhanVien WHERE maNV = ?";
				statement = con.prepareStatement(sql);
				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maNV);
				// Thực hiện truy vấn
				rs = statement.executeQuery();
				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					ngayvaolam = rs.getDate("ngayLamViec");
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
		return ngayvaolam;
	}

	// Phương thức để lấy gioiTinh từ mã NV:
	public Boolean getPhaiByCode(String maNV) throws SQLException {
		Boolean gioiTinh = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.
			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();
			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT phai FROM NhanVien WHERE maNV = ?";
				statement = con.prepareStatement(sql);
				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maNV);
				// Thực hiện truy vấn
				rs = statement.executeQuery();
				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					gioiTinh = rs.getBoolean("phai");
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
		return gioiTinh;
	}

	// Hàm tìm kiếm NV theo tên NV
	public DefaultTableModel searchCustomerByName(String tenNV) {
		DefaultTableModel modelTimKiemTheoTenNV = new DefaultTableModel();
		modelTimKiemTheoTenNV.addColumn("Mã nhân viên");
		modelTimKiemTheoTenNV.addColumn("Họ tên");
		modelTimKiemTheoTenNV.addColumn("Ngày sinh");
		modelTimKiemTheoTenNV.addColumn("Chức vụ");
		modelTimKiemTheoTenNV.addColumn("Tài khoản");
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = ConnectDB.getConnection();
			// Tạo câu truy vấn SQL
			String query = "SELECT * FROM NhanVien INNER JOIN TaiKhoan ON NhanVien.taiKhoan = TaiKhoan.tenTK  WHERE tenNV = ? ";
			statement = con.prepareStatement(query);
			statement.setString(1, tenNV);
			// Thực thi truy vấn
			resultSet = statement.executeQuery();
			// Lấy dữ liệu từ ResultSet và thêm vào model của JTable
			while (resultSet.next()) {
				String maNV = resultSet.getString("maNV");
				String tenNV1 = resultSet.getString("tenNV");
				Date ngaySinh = resultSet.getDate("ngaySinh");
				String chucvu = resultSet.getString("chucVu");
				TaiKhoan tenTK = new TaiKhoan(resultSet.getString(1));
				modelTimKiemTheoTenNV.addRow(new Object[] { maNV, tenNV1, ngaySinh, chucvu, tenTK.getTenTK() });
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return modelTimKiemTheoTenNV;
	}

	// Hàm tìm kiếm NV theo tên TK
	public DefaultTableModel searchCustomerByNameTK(String tenTK) {
		DefaultTableModel modelTimKiemTheoTenTK = new DefaultTableModel();
		modelTimKiemTheoTenTK.addColumn("Mã nhân viên");
		modelTimKiemTheoTenTK.addColumn("Họ tên");
		modelTimKiemTheoTenTK.addColumn("Ngày sinh");
		modelTimKiemTheoTenTK.addColumn("Chức vụ");
		modelTimKiemTheoTenTK.addColumn("Tài khoản");
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = ConnectDB.getConnection();
			// Tạo câu truy vấn SQL
			String query = "SELECT * FROM NhanVien INNER JOIN TaiKhoan ON NhanVien.taiKhoan = TaiKhoan.tenTK  WHERE tenTK = ? ";
			statement = con.prepareStatement(query);
			statement.setString(1, tenTK);
			// Thực thi truy vấn
			resultSet = statement.executeQuery();
			// Lấy dữ liệu từ ResultSet và thêm vào model của JTable
			while (resultSet.next()) {
				String maNV = resultSet.getString("maNV");
				String tenNV1 = resultSet.getString("tenNV");
				Date ngaySinh = resultSet.getDate("ngaySinh");
				String chucvu = resultSet.getString("chucVu");
				TaiKhoan tenTK1 = new TaiKhoan(resultSet.getString(1));
				modelTimKiemTheoTenTK.addRow(new Object[] { maNV, tenNV1, ngaySinh, chucvu, tenTK1.getTenTK() });
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return modelTimKiemTheoTenTK;
	}

	// Hàm tìm kiếm NV theo tên chucvu
	public DefaultTableModel searchCustomerByNameCV(String tenChucVu) {
		DefaultTableModel modelTimKiemTheoCV = new DefaultTableModel();
		modelTimKiemTheoCV.addColumn("Mã nhân viên");
		modelTimKiemTheoCV.addColumn("Họ tên");
		modelTimKiemTheoCV.addColumn("Ngày sinh");
		modelTimKiemTheoCV.addColumn("Chức vụ");
		modelTimKiemTheoCV.addColumn("Tài khoản");
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = ConnectDB.getConnection();
			// Tạo câu truy vấn SQL
			String query = "SELECT * FROM NhanVien INNER JOIN TaiKhoan ON NhanVien.taiKhoan = TaiKhoan.tenTK  WHERE chucVu = ? ";
			statement = con.prepareStatement(query);
			statement.setString(1, tenChucVu);
			// Thực thi truy vấn
			resultSet = statement.executeQuery();
			// Lấy dữ liệu từ ResultSet và thêm vào model của JTable
			while (resultSet.next()) {
				String maNV = resultSet.getString("maNV");
				String tenNV1 = resultSet.getString("tenNV");
				Date ngaySinh = resultSet.getDate("ngaySinh");
				String chucvu = resultSet.getString("chucVu");
				TaiKhoan tenTK1 = new TaiKhoan(resultSet.getString(1));
				modelTimKiemTheoCV.addRow(new Object[] { maNV, tenNV1, ngaySinh, chucvu, tenTK1.getTenTK() });
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return modelTimKiemTheoCV;
	}

	/// tang maNV them 1
	public int getMaNV() {
		int ma = 1;
		ConnectDB.getInstance();
		Connection con = (Connection) ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select max( CONVERT(int , SUBSTRING(maNV,3, 4))) from NhanVien";
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

	// ham them NhanVien:
	public void addNhanVien(NhanVien NV) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "insert into NhanVien values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, NV.getMaNV());
			stmt.setString(2, NV.getTenNV());
			stmt.setInt(3, NV.getTuoiNV());
			stmt.setString(4, NV.getSdtNV());
			stmt.setDate(5, NV.getNamSinh());
			stmt.setBoolean(6, NV.isPhai());
			stmt.setString(7, NV.getCMND());
			stmt.setString(8, NV.getChucVu());
			stmt.setFloat(9, NV.getLuong());
			stmt.setDate(10, NV.getNgayLamViec());
			stmt.setString(11, NV.getTaiKhoan().getTenTK());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Ham Cap Nhat NhanVien:
	public void updateKH(NhanVien NV) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		String sql = "UPDATE NhanVien\r\n" + "SET tenNV = ?,\r\n" + "    tuoiNV = ?,\r\n" + "    sdtNV = ?,\r\n"
				+ "    ngaySinh = ?,\r\n" + "    phai = ?,\r\n" + "    cmnd = ?,\r\n" + "    chucVu = ?,\r\n"
				+ "    luong = ?,\r\n" + "    ngayLamViec = ?,\r\n" + "    taiKhoan = ?\r\n" + "WHERE maNV = ?;";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, NV.getTenNV());
			stmt.setInt(2, NV.getTuoiNV());
			stmt.setString(3, NV.getSdtNV());
			stmt.setDate(4, NV.getNamSinh());
			stmt.setBoolean(5, NV.isPhai());
			stmt.setString(6, NV.getCMND());
			stmt.setString(7, NV.getChucVu());
			stmt.setFloat(8, NV.getLuong());
			stmt.setDate(9, NV.getNgayLamViec());
			stmt.setString(10, NV.getTaiKhoan().getTenTK());
			stmt.setString(11, NV.getMaNV());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Ham Cap Nhat password:
	public void updatePassword(TaiKhoan TK) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		String sql = "UPDATE TaiKhoan\r\n" + "SET matKhau = ?\r\n" + "WHERE tenTK = ?;";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, TK.getMatKhau());
			stmt.setString(2, TK.getTenTK());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Ham lay account:
	public ArrayList<TaiKhoan> getalltbQLTaiKhoan() {
		ArrayList<TaiKhoan> dsqltk = new ArrayList<TaiKhoan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from TaiKhoan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {// di chuyen con tro xuong ban ghi ke tiep
				String tenTK = rs.getString(1);
				String matKhau = rs.getString(2);
				String loaiTK = rs.getString(3);
				TaiKhoan acc = new TaiKhoan(tenTK, matKhau, loaiTK);
				dsqltk.add(acc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsqltk;
	}

}
