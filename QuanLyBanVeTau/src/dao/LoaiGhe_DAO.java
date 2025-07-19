package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiGhe;

public class LoaiGhe_DAO {
	public ArrayList<LoaiGhe> getalltbLoaiGhe(){
		ArrayList<LoaiGhe> dsLoaiGhe = new ArrayList<LoaiGhe>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			
			String sql = "Select * from LoaiGhe";
			java.sql.Statement statement= con.createStatement();
			ResultSet rs= statement.executeQuery(sql);
			while (rs.next()) {
				String maPB= rs.getString("maLoaiGhe");
				String tenPB= rs.getString("tenLoaiGhe");
				LoaiGhe p= new LoaiGhe(maPB, tenPB);
				dsLoaiGhe.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsLoaiGhe;
	}
}
