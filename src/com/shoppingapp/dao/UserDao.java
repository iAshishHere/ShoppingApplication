package com.shoppingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shoppingapp.pojos.UserDetails;


public class UserDao {
	
	public boolean readUserDetails(UserDetails UserDetails) {
		
		boolean status=false;
		
		Connection con = null;
	    PreparedStatement ps = null;
		ResultSet rs = null;

        try {        	
        	con = ConnectionDao.getConnection();
            ps=con.prepareStatement("select Username, Password from LoginDetails where Username=? and Password=?");  
    		ps.setString(1,UserDetails.getUsername());  
    		ps.setString(2,UserDetails.getPassword());
            
    		rs=ps.executeQuery();  
    		status=rs.next();  
    		          
    		}catch(Exception e){
    			System.out.println(e);
			}finally {
			    try { rs.close(); } catch (Exception e) { /* ignored */ }
			    try { ps.close(); } catch (Exception e) { /* ignored */ }
			    try { con.close(); } catch (Exception e) { /* ignored */ }
			}  
    		return status;  
    		
    		} 

}
