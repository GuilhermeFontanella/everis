package com.projeto.estacionamento.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Service {
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("org.h2.Driver");
			return DriverManager.getConnection("jdbc:h1://localhost:8080/carros/todosCarros", "root", "root");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getException());
		}
		
	}
}
