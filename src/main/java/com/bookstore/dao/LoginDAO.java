package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookstore.services.GetDataSource;

public class LoginDAO {
	public boolean isUserName(String userName) {
		if(userName!=null) {
			String sql="select 1 from users where user_name=?";
			try(Connection con=GetDataSource.getDataSource().getConnection();PreparedStatement ps=con.prepareStatement(sql)){
				ps.setString(1, userName);
				ResultSet rs=ps.executeQuery();
				return rs.next();
				
			}catch (Exception e1) {
				e1.printStackTrace();
				return false;
			}
		}
		return false;
		}

}
