package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bookstore.config.GetDataSource;
import com.bookstore.dto.UsersDTO;

public class UsersDAO {
	public static UsersDTO findByUser(String userName) {
		if(userName!=null) {
			String sql="select * from  users where user_name=?";
			try(Connection  con=GetDataSource.getDataSource().getConnection();PreparedStatement ps=con.prepareStatement(sql)){
				ps.setString(1, userName);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					 UsersDTO user=new UsersDTO();
					user.setFullName(rs.getString("fullname"));
					user.setPassword(rs.getString("password"));
					user.setEmail(rs.getString("email"));
					user.setCreated_at(rs.getTimestamp("created_at"));
					user.setUpdated_at(rs.getTimestamp("updated_at"));
					user.setIs_active(rs.getBoolean("is_active"));
					return user;
				}
			}catch (Exception e) {
				return null;
			}
		}
		return null;
	}
	
	public static boolean addUser(UsersDTO user) {
		if(user!=null) {
			String sql="INSERT INTO users (fullName,password,email,created_at, updated_at,is_active) VALUES (?,?, ?, ?);";
			try(Connection con=GetDataSource.getDataSource().getConnection();PreparedStatement ps=con.prepareStatement(sql)){
				ps.setString(1, user.getFullName());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getEmail());
				ps.setTimestamp(4, user.getCreated_at());
				ps.setTimestamp(5,user.getUpdated_at());
				
				ps.executeUpdate();
				return true;
				
				
			}catch (Exception e) {
				return false;
				// TODO: handle exception
			}
		}
		return false;
	}
}
