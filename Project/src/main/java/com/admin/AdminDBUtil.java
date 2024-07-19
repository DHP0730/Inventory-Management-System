package com.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	//validate
	public static boolean validate(String username, String password) {
		
		try {
			//create the DB connection
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			//retrieve from database
			String sql = "select * from admin where username='"+username+"' and password='"+password+"'";
		    rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static List<Admin> getAdmin(String userName) {
		
		ArrayList<Admin> admin = new ArrayList<>();
		
		try {
		    con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from admin where username='"+userName+"'";
			rs = stmt.executeQuery(sql);
			
			//getting details from the db col number
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String username = rs.getString(5);
				String password = rs.getString(6);
				
				Admin ad = new Admin(id,name,email,phone,username,password);
				admin.add(ad);
			}
			
		} catch (Exception e) {
			
		}
		
		return admin;	
	}
	
	//insert inventory manager details
	public static boolean insertIM(String name, String email, String phone, String username, String password) {
    	
    	boolean isSuccess = false;
    	
    	try {
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    	    String sql = "insert into inventorymanager values (0,'"+name+"','"+email+"','"+phone+"','"+username+"','"+password+"')";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		} else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
 	
    	return isSuccess;
    }
	
	

	//update ordered item details
	public static boolean updateitem(String orderno, String category, String name, String size, String quantity, String supplierid) {
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "update orderitem set category='"+category+"',name='"+name+"',size='"+size+"',quantity='"+quantity+"',supplierid='"+supplierid+"'"+ "where orderno='"+orderno+"'";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }
	
	public static List<orderitem> getitems() {
    	
    	
    	ArrayList<orderitem> oi = new ArrayList<>();
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "select * from orderitem";
    		rs = stmt.executeQuery(sql);
    		
    		while(rs.next()) {
    			int odno = rs.getInt(1);
    			String cat = rs.getString(2);
    			String name = rs.getString(3);
    			String size = rs.getString(4);
    			int qty = rs.getInt(5);
    			String suppid = rs.getString(6);
    			
    			orderitem c = new orderitem(odno, cat, name, size, qty, suppid);
    			oi.add(c);
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}	
    	return oi;	
    }
	
	public static List<orderitem> getorder(String orderno) {
    	
		int convertedID = Integer.parseInt(orderno);
		
    	ArrayList<orderitem> order = new ArrayList<>();
    	
    	try {
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "select * from orderitem where orderno='"+convertedID+"'";
    		rs = stmt.executeQuery(sql);
    		
    		while(rs.next()) {
    			int odno = rs.getInt(1);
    			String cat = rs.getString(2);
    			String name = rs.getString(3);
    			String size = rs.getString(4);
    			int qty = rs.getInt(5);
    			String suppid = rs.getString(6);
    			
    			orderitem i = new orderitem(odno, cat, name, size, qty, suppid);
    			order.add(i);
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}	
    	return order;	
    }
	
	//delete  saved orderitem details
	public static boolean deleteitems(String orderno) {
    	
    	int convId = Integer.parseInt(orderno);
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "delete from orderitem where orderno ='"+convId+"'";
    		int r = stmt.executeUpdate(sql);
    		
    		if (r > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }
	
	public static boolean insertorder(String category, String name, String size, String quantity, String supplierid) {
		int convid = Integer.parseInt(quantity);
    	boolean isSuccess = false;
    	
    	try {
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    	    String sql = "insert into orderitem values (0,'"+category+"','"+name+"','"+size+"','"+convid+"','"+supplierid+"')";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		} else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
 	
    	return isSuccess;
    }
}

