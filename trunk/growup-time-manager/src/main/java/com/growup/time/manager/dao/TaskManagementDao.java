package com.growup.time.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.growup.base.connection.ConnectionPool;
import com.growup.time.manager.entity.Task;

public class TaskManagementDao {
	
	private Logger logger = Logger.getLogger(TaskManagementDao.class);
	
	private ConnectionPool pool = ConnectionPool.getInstance();
	
	protected class Query {		
		static final String GET_TASK = "select * from task t";
		static final String ADD_TASK = "insert into task (user_id, theme, creation_date, start_date, end_date, points) values (?,?,?,?,?,?)";
		static final String DELETE_TASK_BY_ID = "delete from task where task.id=?";
		static final String UPDATE_TASK = "update task t set(theme, creation_date, start_date, end_date, points) values (?,?,?,?,?)";
	}
	
	public List<Task> getUserTasks(Long userId) throws SQLException {
		Connection con = this.pool.getConnection();
		PreparedStatement stmt = con.prepareStatement(Query.GET_TASK + " where t.user_id=?");
		List<Task> userTasks = new ArrayList<Task>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Task task = new Task();
			task.setId(rs.getLong(1));
			task.setUserId(rs.getLong(2));
			task.setTheme(rs.getString(3));
			task.setCreationDate(rs.getTimestamp(4));
			task.setStartDate(rs.getTimestamp(5));
			task.setEndDate(rs.getTimestamp(6));
			task.setPoints(rs.getInt(7));
			userTasks.add(task);
		}
		rs.close();
		stmt.close();
		con.close();
		return userTasks;
	}
	
	
}
