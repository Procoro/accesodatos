package com.pblazquez.bbdd.tiendapc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CrearBBDD {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stmt=null;
		String sql="CREATE DATABASE TiendaPc";
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/","root","");
			stmt=conn.createStatement();
			stmt.execute(sql);
			System.out.println("La base de datos TiendaPc ok");
			conn.close();
			stmt.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}

}