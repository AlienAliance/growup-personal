package com.personal.ui.controller.handler;

import java.util.Properties;

import org.json.JSONObject;

import com.personal.ui.controller.AbstractController;
import com.personal.ui.controller.impl.AuthController;
public class ControllerHandler {
	
	private static final ControllerHandler HANDLER = new ControllerHandler();
	
	private ControllerHandler() {}
	
	public static final ControllerHandler getInstance() {		
		return HANDLER;
	}
	
	public static final ControllerHandler initInstance(Properties connectionProperties) {
		return HANDLER;
	}
	
	
	public void process() {
		
	}
		
}
