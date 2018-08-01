package com.shoppingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoppingapp.pojos.ProductDetails;


public class ProductDao {
	
	Connection connection = null;
    PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public List<ProductDetails> readProduct() {
		
		   List<ProductDetails> productDetails = new ArrayList<ProductDetails>();
		   
	          
		try {
   
			connection=ConnectionDao.getConnection();
			
        	preparedStatement=connection.prepareStatement("select * from ProductDetails");  
        	resultSet=preparedStatement.executeQuery();
            
           
    		while(resultSet.next())
    		{	
    			ProductDetails productDetail = new ProductDetails(
    					resultSet.getInt("ProductID"),
    					resultSet.getString("ProductName"),
    					resultSet.getDouble("Price"),
    					resultSet.getInt("Quantity")
    					);
    			
    			productDetails.add(productDetail);
    			
    		}
    		  	
 
    		}catch(Exception e){
    			System.out.println(e);
			}finally {
			    try { resultSet.close(); } catch (Exception e) { e.printStackTrace(); }
			    try { preparedStatement.close(); } catch (Exception e) { e.printStackTrace(); }
			    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
			}  
    		
		return productDetails;
		
	}
	
	
	
	public void updateProduct(int productID) {
		
		try { 
			
		 connection=ConnectionDao.getConnection();
         
         preparedStatement=connection.prepareStatement("update ProductDetails set Quantity = Quantity-1 where ProductID=? AND Quantity>0");
         preparedStatement.setInt(1, productID);
         preparedStatement.executeUpdate();


 		}catch(Exception e){
 			System.out.println(e);
 			
 			
			}finally {
			    try { preparedStatement.close(); } catch (Exception e) { /* ignored */ }
			    try { connection.close(); } catch (Exception e) { /* ignored */ }
			} 
 		
		
	}
	


}
