package com.pblazquez.bbdd.tiendapc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;

		String sql = "CREATE TABLE productos (id INT PRIMARY KEY," + "nombreProduct VARCHAR(20) NOT NULL,"
				+ "fabricante VARCHAR(25) NOT NULL)";
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/tiendapc", "root", "");
			stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("Tabla creada con éxito");
			conn.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}