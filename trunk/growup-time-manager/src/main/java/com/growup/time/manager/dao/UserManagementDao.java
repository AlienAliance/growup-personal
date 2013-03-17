package com.growup.time.manager.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.growup.base.connection.ConnectionPool;
import com.growup.time.manager.entity.User;
import com.growup.time.manager.entity.UserInfo;
import com.growup.time.manager.exception.UserNotFoundException;

public class UserManagementDao {

	private Logger logger = Logger.getLogger(UserManagementDao.class);
	
	private ConnectionPool pool = ConnectionPool.getInstance();

	protected class Query {
		static final String SELECT_USER = "select u.mail, u.nickname, u.passcode i.id, i.first_name, i.last_name, i.birthday, i.address "
				+ "from user u inner join user_information i on u.id=i.user_id";
		static final String DELETE_USER = "delete from user u";
		static final String UPDATE_USER = "update user set (nickname=?, email=?, passcode=?) where id=?";
		static final String UPDATE_USER_INFO = "update user_information set (first_name=?,last_name=?,birthday=?,address=?) where user_id=?";
		static final String INSERT_USER = "insert into user u (u.mail, u.nickname, u.passcode) values (?, ?, ?)";
		static final String INSERT_USER_INFO = "insert into user_information i (i.user_id, i.first_name, i.last_name, i.birthday, i.address) values (?,?,?,?,?)";
	}	

	public User getUserById(Long userId) throws SQLException, UserNotFoundException {
		String query = Query.SELECT_USER + " where u.id=" + userId;
		Connection con = this.pool.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		User user = new User();
		if (rs.first()) {			
			UserInfo info = new UserInfo(userId);
			user.setId(userId);
			user.setEmail(rs.getString(2));
			user.setNickName(rs.getString(3));
			user.setPasscode(rs.getString(4));
			info.setId(rs.getLong(5));
			info.setFirstName(rs.getString(6));
			info.setLastName(rs.getString(7));
			info.setBirthday(rs.getTimestamp(8));
			info.setAddress(rs.getString(9));
			user.setUserInfo(info);			
		} else {
			throw new UserNotFoundException();
		}
		rs.close();
		stmt.close();
		con.close();
		return user;
	}
	
	public void insertUserInfo(UserInfo userInfo) throws SQLException {
		Connection con = this.pool.getConnection();
		PreparedStatement stmt = con.prepareStatement(Query.INSERT_USER_INFO);
		stmt.setLong(1, userInfo.getUserId());
		stmt.setString(2, userInfo.getFirstName());
		stmt.setString(3, userInfo.getLastName());
		stmt.setTimestamp(4, new java.sql.Timestamp(userInfo.getBirthday().getTime()));
		stmt.setString(5, userInfo.getAddress());
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public void insertUser(User user) throws SQLException {
		Connection con = this.pool.getConnection();
		PreparedStatement userStmt = con.prepareStatement(Query.INSERT_USER);
		userStmt.setString(1, user.getEmail());
		userStmt.setString(2, user.getNickName());
		userStmt.setString(3, user.getPasscode());
		userStmt.execute();
		userStmt.close();
		if (user.getUserInfo()!=null) {
			PreparedStatement userInfoStmt = con.prepareStatement(Query.INSERT_USER_INFO);
			userInfoStmt.setLong(1, user.getUserInfo().getUserId());
			userInfoStmt.setString(2, user.getUserInfo().getFirstName());
			userInfoStmt.setString(3, user.getUserInfo().getLastName());
			userInfoStmt.setTimestamp(4, new java.sql.Timestamp(user.getUserInfo().getBirthday().getTime()));
			userInfoStmt.setString(5, user.getUserInfo().getAddress());
			userInfoStmt.execute();
			userInfoStmt.close();
		}
		con.close();
	}
	
	public void updateUser(User user) throws SQLException {
		Connection con = this.pool.getConnection();
		PreparedStatement userStmt = con.prepareStatement(Query.UPDATE_USER);
		userStmt.setString(1, user.getEmail());
		userStmt.setString(2, user.getNickName());
		userStmt.setString(3, user.getPasscode());
		userStmt.setLong(4, user.getId());
		userStmt.executeUpdate();
		userStmt.close();
		UserInfo info = user.getUserInfo();
		if (info!=null) {			
			PreparedStatement userInfoStmt = con.prepareStatement(Query.UPDATE_USER_INFO);
			userInfoStmt.setString(1, info.getFirstName());
			userInfoStmt.setString(2, info.getLastName());
			userInfoStmt.setTimestamp(3, new java.sql.Timestamp(info.getBirthday().getTime()));
			userInfoStmt.setString(4, info.getAddress());
			userInfoStmt.setLong(5, info.getUserId());
			userInfoStmt.executeUpdate();
			userInfoStmt.close();
		}
		con.close();
	}
	
	public void updateUserInfo(UserInfo info) throws SQLException {
		Connection con = this.pool.getConnection();
		PreparedStatement stmt = con.prepareStatement(Query.UPDATE_USER_INFO);
		stmt.setString(1, info.getFirstName());
		stmt.setString(2, info.getLastName());
		stmt.setTimestamp(3, new java.sql.Timestamp(info.getBirthday().getTime()));
		stmt.setString(4, info.getAddress());
		stmt.setLong(5, info.getUserId());
		stmt.executeUpdate();
		stmt.close();
		con.close();
	}
}
