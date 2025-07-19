package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.ChuyenTau;
import entity.TaiKhoan;
import gui.TrangChuNVKeToan_GUI;
import gui.TrangChuNVien_GUI;
import gui.TrangChuQuanLy_GUI;

public class LogIn_DAO {

	
	//Ham kiem tra dang nhap
	public String CheckLogin(String username, String password) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		String role = null;

		try {
			ConnectDB.getInstance();
			con = ConnectDB.getConnection();
			if (con != null) {
				String sql = "SELECT loaiTK FROM  TaiKhoan where tenTK= ? AND matKhau = ?";
				statement = con.prepareStatement(sql);

				statement.setString(1, username);
				statement.setString(2, password);
				
				rs = statement.executeQuery();
				if (rs.next()) {
					role = rs.getString("loaiTK");
				}

			}
		} catch (SQLException e) {
			System.out.println("Lỗi khi kiểm tra đăng nhập: " + e.getMessage());

		}

		return role;

	}
	
	
//	//Ham kiem tra dang ky
//		public void addTaiKhoan(TaiKhoan tk) {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "insert into TaiKhoan values(?,?,?)";
//			PreparedStatement stmt = null;
//			try {
//				stmt = con.prepareStatement(sql);
//				stmt.setString(1, tk.getTenTK());
//				stmt.setString(2, tk.getMatKhau());
//				stmt.setString(3, tk.getLoaiTK());
//				stmt.executeUpdate();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
	
	


	// Phương thức hiển thị giao diện tương ứng
	public void showGUI(String role) {
		if (role != null) {
			switch (role) {
			case "Tài khoản quản lý":
				try {
					new TrangChuQuanLy_GUI().setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "Tài khoản nhân viên":
				try {
					new TrangChuNVien_GUI().setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "Tài khoản kế toán":
				try {
					new TrangChuNVKeToan_GUI().setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Vai trò không hợp lệ.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Tên tài khoản hoặc mật khẩu không đúng!!!");
			
		}
	}

}
