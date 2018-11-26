package com.vi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.vi.beans.Users;

public class DBHelper {

	public int getLoginStatus(String uname, String pword) {
		int status= 0;
		ArrayList<Users> a = new ArrayList<>();
		DatabaseConnection db = new DatabaseConnection();
		Users u = null;
		Connection con= db.getConnection();
		String query= "select username,password from usersinfo1" ;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			ResultSet rs= ps.executeQuery();

			while(rs.next()) {
			u = new Users();
			u.setUsername(rs.getString(1));
			u.setPassword(rs.getString(2));
			a.add(u);
			}
			
			for(Users u1 :a) {
				if(u1.getUsername().equals(uname)) {
					if(u1.getPassword().equals(pword)) {
						status= 1; // successful login
					}else {
						status= -2;//password did not match
					}
				}else {
					status=-1; //user not found
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return status;
	}

	public int newUser(String fname, String lname, String uname, String pword, String dob, String gender) {
		int status=0;
		DatabaseConnection db = new DatabaseConnection();
		Users u = null;
		Connection con= db.getConnection();
		String query="insert into usersinfo1 values('"+fname+"','"+lname+"','"+uname+"','"+pword+"','"+dob+"','"+gender+"')";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			status=ps.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return status;
	}
}
