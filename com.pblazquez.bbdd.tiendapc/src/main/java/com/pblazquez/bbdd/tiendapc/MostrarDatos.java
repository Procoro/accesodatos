package com.pblazquez.bbdd.tiendapc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MostrarDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;

		String sql = "SELECT * FROM productos";
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/tiendapc", "root", "");
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				int id=rs.getInt("id");
				String nombre=rs.getString("nombreProduct");
				String fabricante=rs.getString("fabricante");
				System.out.println("ID: "+id+"\nNombre: "+nombre+"\nFabricante: "+fabricante);
				
			}
			conn.close();
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}