package com.shoppingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDao {
	
	

	public void writeOrder(int id, String username) {

		Connection con = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;

		try {

			con =ConnectionDao.getConnection();

			ps1 = con.prepareStatement("select * from ProductDetails where ProductID=?;");
			ps1.setInt(1, id);
			rs = ps1.executeQuery();

			if (rs.next()) {

				ps2 = con.prepareStatement(
						"insert into OrderDetails(UserName, ProductID,ProductName,Price,Quantity) values(?,?,?,?,?);");
				ps2.setString(1, username);
				ps2.setInt(2, rs.getInt("ProductID"));
				ps2.setString(3, rs.getString("ProductName"));
				ps2.setDouble(4, rs.getDouble("Price"));
				ps2.setInt(5, 1);
				ps2.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps1.close();
				ps2.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();}
			
		}

	}

}
