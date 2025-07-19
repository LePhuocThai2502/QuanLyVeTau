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
import entity.ChuyenTau;
import entity.KhachHang;

public class KhachHang_DAO {

	// lay table QuanLy:
	public ArrayList<KhachHang> getalltbQLKhachHang() {
		ArrayList<KhachHang> dsqlkh = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {// di chuyen con tro xuong ban ghi ke tiep
				String maKH = rs.getString(1);
				String tenKH = rs.getString(2);
				String SDT = rs.getString(3);
				Boolean phai = rs.getBoolean(5);
				KhachHang kh = new KhachHang(maKH, tenKH, SDT, phai);
				dsqlkh.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsqlkh;
	}

	// Phương thức để lấy email từ mã KH:
	public String getEmailByCode(String maKhachHang) throws SQLException {
		String email = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.

			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();

			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT email FROM KhachHang WHERE maKH = ?";
				statement = con.prepareStatement(sql);

				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maKhachHang);

				// Thực hiện truy vấn
				rs = statement.executeQuery();

				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					email = rs.getString("email");
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

		return email;
	}

	// Phương thức để lấy diaChi từ mã KH:
	public String getAddressbyCode(String maKhachHang) throws SQLException {
		String diaChi = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.

			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();

			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT diaChi FROM KhachHang WHERE maKH = ?";
				statement = con.prepareStatement(sql);

				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maKhachHang);

				// Thực hiện truy vấn
				rs = statement.executeQuery();

				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					diaChi = rs.getString("diaChi");
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

		return diaChi;
	}

	// Phương thức để lấy gioitinh từ mã KH:
	public Boolean getPhaiByCode(String maKhachHang) throws SQLException {
		boolean phai = false;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			ConnectDB.getInstance(); // Chắc chắn rằng ConnectDB.getInstance() đã được triệu gọi một lần trước đó.

			// Lấy connection mà không đóng nó
			con = ConnectDB.getConnection();

			if (con != null) {
				// Nếu kết nối không null, thì tiếp tục thực hiện truy vấn
				String sql = "SELECT phai FROM KhachHang WHERE maKH = ?";
				statement = con.prepareStatement(sql);

				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maKhachHang);

				// Thực hiện truy vấn
				rs = statement.executeQuery();

				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					phai = rs.getBoolean("phai");
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

		return phai;
	}

	// Phương thức để lấy tenKH từ mã KH:
	public String gettenKHbyCode(String maKhachHang) throws SQLException {
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

	// Phương thức để lấy sdt từ mã KH:
	public String getsdtbyCode(String maKhachHang) throws SQLException {
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
				String sql = "SELECT sdt FROM KhachHang WHERE maKH = ?";
				statement = con.prepareStatement(sql);

				// Thiết lập tham số cho PreparedStatement
				statement.setString(1, maKhachHang);

				// Thực hiện truy vấn
				rs = statement.executeQuery();

				// Kiểm tra xem có bản ghi nào hay không
				if (rs.next()) {
					// Lấy tên nhân viên từ kết quả truy vấn
					sdt = rs.getString("sdt");
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

	// Hàm tìm kiếm hóa đơn theo tên khách hàng
	public DefaultTableModel searchCustomerByName(String tenKH) {
		DefaultTableModel modelTimKiemTheoTenKH = new DefaultTableModel();
		modelTimKiemTheoTenKH.addColumn("Mã khách hàng");
		modelTimKiemTheoTenKH.addColumn("Họ tên");
		modelTimKiemTheoTenKH.addColumn("Số điện thoại");
		modelTimKiemTheoTenKH.addColumn("Giới tính");

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = ConnectDB.getConnection();
			// Tạo câu truy vấn SQL
			String query = "SELECT * FROM KhachHang WHERE tenKH = ?";
			statement = con.prepareStatement(query);
			statement.setString(1, tenKH);
			// Thực thi truy vấn
			resultSet = statement.executeQuery();
			// Lấy dữ liệu từ ResultSet và thêm vào model của JTable
			while (resultSet.next()) {
				String maKH = resultSet.getString("maKH");
				String tenKH1 = resultSet.getString("tenKH");
				String sdt = resultSet.getString("sdt");
				boolean phai = resultSet.getBoolean("phai");
				String gioiTinh = phai ? "Nam" : "Nữ"; // Kiểm tra giới tính và gán giá trị tương ứng
				modelTimKiemTheoTenKH.addRow(new Object[] { maKH, tenKH1, sdt, gioiTinh });
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return modelTimKiemTheoTenKH;
	}

	// Hàm tìm kiếm hóa đơn theo tên sdt
	public DefaultTableModel searchCustomerBySDT(String sdt) {
		DefaultTableModel modelTimKiemTheoTenSDT = new DefaultTableModel();
		modelTimKiemTheoTenSDT.addColumn("Mã khách hàng");
		modelTimKiemTheoTenSDT.addColumn("Họ tên");
		modelTimKiemTheoTenSDT.addColumn("Số điện thoại");
		modelTimKiemTheoTenSDT.addColumn("Giới tính");

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = ConnectDB.getConnection();
			// Tạo câu truy vấn SQL
			String query = "SELECT * FROM KhachHang WHERE sdt = ?";
			statement = con.prepareStatement(query);
			statement.setString(1, sdt);
			// Thực thi truy vấn
			resultSet = statement.executeQuery();
			// Lấy dữ liệu từ ResultSet và thêm vào model của JTable
			while (resultSet.next()) {
				String maKH = resultSet.getString("maKH");
				String tenKH = resultSet.getString("tenKH");
				String SDT = resultSet.getString("sdt");
				boolean phai = resultSet.getBoolean("phai");
				String gioiTinh = phai ? "Nam" : "Nữ"; // Kiểm tra giới tính và gán giá trị tương ứng
				modelTimKiemTheoTenSDT.addRow(new Object[] { maKH, tenKH, sdt, gioiTinh });
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return modelTimKiemTheoTenSDT;
	}

	// Hàm tìm kiếm hóa đơn theo tên sdt
	public DefaultTableModel searchCustomerByEmail(String email) {
		DefaultTableModel modelTimKiemTheoTenEmail = new DefaultTableModel();
		modelTimKiemTheoTenEmail.addColumn("Mã khách hàng");
		modelTimKiemTheoTenEmail.addColumn("Họ tên");
		modelTimKiemTheoTenEmail.addColumn("Số điện thoại");
		modelTimKiemTheoTenEmail.addColumn("Giới tính");

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = ConnectDB.getConnection();
			// Tạo câu truy vấn SQL
			String query = "SELECT * FROM KhachHang WHERE email = ?";
			statement = con.prepareStatement(query);
			statement.setString(1, email);
			// Thực thi truy vấn
			resultSet = statement.executeQuery();
			// Lấy dữ liệu từ ResultSet và thêm vào model của JTable
			while (resultSet.next()) {
				String maKH = resultSet.getString("maKH");
				String tenKH = resultSet.getString("tenKH");
				String SDT = resultSet.getString("sdt");
				boolean phai = resultSet.getBoolean("phai");
				String gioiTinh = phai ? "Nam" : "Nữ"; // Kiểm tra giới tính và gán giá trị tương ứng
				modelTimKiemTheoTenEmail.addRow(new Object[] { maKH, tenKH, SDT, gioiTinh });
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return modelTimKiemTheoTenEmail;
	}

	public String getMaKHCuoiCung() {
		String maKHCuoiCung = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT TOP 1 maKH FROM KhachHang ORDER BY maKH DESC";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				maKHCuoiCung = rs.getString("maKH");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maKHCuoiCung;
	}

	public String taoMaKHTuDong() {
		String lastMaKH = getMaKHCuoiCung();
		if (lastMaKH != null) {
			// Lấy phần số lượng từ mã hóa đơn cuối cùng
			String soLuongStr = lastMaKH.substring(10);
			int soLuong = Integer.parseInt(soLuongStr) + 1;
			// Định dạng lại số lượng để có 4 chữ số
			String soLuongFormatted = String.format("%05d", soLuong);
			// Tạo mã hóa đơn mới bằng cách kết hợp phần ngày tháng và số lượng
			String ngayThang = lastMaKH.substring(2, 10);
			return "KH" + ngayThang + soLuongFormatted;
		} else {
			// Nếu không có mã hóa đơn nào trong cơ sở dữ liệu, trả về mã đầu tiên
			Calendar calendar = Calendar.getInstance();
			return "KH" + new SimpleDateFormat("ddMMyyyy").format(calendar.getTime()) + "00001";

		}
	}

	// ham them Khach Hang:
	public void addKhachHang(KhachHang KH) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "insert into KhachHang values(?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, KH.getMaKH());
			stmt.setString(2, KH.getTenKH());
			stmt.setString(3, KH.getSdt());
			stmt.setString(4, KH.getEmail());
			stmt.setBoolean(5, KH.isPhai());
			stmt.setString(6, KH.getDiaChi());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Ham Cap Nhat KhachHang:
	public void updateKH(KhachHang KH) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		String sql = "update KhachHang " + "set tenKH= ?," + "sdt = ?," + "email= ?," + "phai= ?," + "diaChi= ?"
				+ " where maKH= ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, KH.getTenKH());
			stmt.setString(2, KH.getSdt());
			stmt.setString(3, KH.getEmail());
			stmt.setBoolean(4, KH.isPhai());
			stmt.setString(5, KH.getDiaChi());
			stmt.setString(6, KH.getMaKH());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
