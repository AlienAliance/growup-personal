package com.personal.ui.dispatcher;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 7897242594515884762L;

	private boolean initJdbcConfig;

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException {		
		JSONObject jsonResponse = new JSONObject();
		try {
			jsonResponse.put("path",getServletContext().getRealPath(getInitParameter("init-config")));
			response.getWriter().write(jsonResponse.toString());								
		} catch (JSONException e) {
			response.getWriter().write("init-jdbc-config-failed");
		} finally {
			response.getWriter().close();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		this.processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		this.processRequest(request, response);
	}
}
