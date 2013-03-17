package com.personal.ui.controller;

import java.util.Properties;

import org.json.JSONObject;

import com.growup.base.connection.ConnectionPool;

public abstract class AbstractController {
	
	protected static ConnectionPool pool;
	
	public static final void initConnectionPool(Properties props) {
		pool = ConnectionPool.getInstance();
		pool.initConnectionProperties(props);
	}
	
	public AbstractController(Properties connectionProps) {
		pool.initConnectionProperties(connectionProps);		
	}
	
	public abstract JSONObject handleResponse(JSONObject request);
}
