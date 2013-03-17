package com.growup.base.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class ConnectionPool {
	
	private BasicDataSource dataSource;
	public static final ConnectionPool INSTANCE = new ConnectionPool(); 
	
	private ConnectionPool() {}
	public void initConnectionProperties(Properties connectionProps) {
		INSTANCE.dataSource = new BasicDataSource();
		INSTANCE.dataSource.setDriverClassName(connectionProps.getProperty("db.driver.class.name"));
		INSTANCE.dataSource.setUrl(connectionProps.getProperty("db.connection.url"));
		INSTANCE.dataSource.setUsername(connectionProps.getProperty("db.user.name"));
		INSTANCE.dataSource.setPassword(connectionProps.getProperty("db.password"));
	}
	
	public static final ConnectionPool getInstance() {
		return INSTANCE;
	}
	
	public Connection getConnection() throws SQLException {
		return INSTANCE.dataSource.getConnection();
	}
	
}
