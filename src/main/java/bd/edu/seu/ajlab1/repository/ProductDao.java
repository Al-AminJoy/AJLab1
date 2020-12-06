/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.seu.ajlab1.repository;

import bd.edu.seu.ajlab1.model.Product;
import java.util.List;


public interface ProductDao {
    public List<Product> readAll();
    default public Product readProduct(int id) 
    {  	
    	 
    	 return readAll()
    			 .stream()
    			 .filter(product->product.getProductID()==id)
    			 .findFirst()
    			 .orElse(null);
    			 
    }
    default public void createProduct(Product product) {};
    default public void deleteProduct(int id) {};
    default public void updateProduct(int id,Product product) {};
    
    		
    		
}

