package bd.edu.seu.ajlab1.repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import bd.edu.seu.ajlab1.model.Product;
import bd.edu.seu.ajlab1.service.ConnectionSingleton;

public class ProductDaoMySQLImplementation implements ProductDao {
private String INSERT_QUERY;
private String READ_QUERY;

	public ProductDaoMySQLImplementation() {
		FileReader fileReader;
		try {
			fileReader = new FileReader("query.properties");
			Properties properties=new Properties();
			properties.load(fileReader);
			INSERT_QUERY=properties.getProperty("insert_student");
			READ_QUERY=properties.getProperty("read_student");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}

	@Override
	public List<Product> readAll() {
		List<Product> productList = new ArrayList<>();
		
		// POST Data

		try {
			Connection connection = ConnectionSingleton.getConnection();
			//String query = "select * from product";
			//Statement statement = connection.createStatement();
			PreparedStatement preparedStatement=connection.prepareStatement(READ_QUERY);
			//ResultSet resultset = statement.executeQuery(query);
			ResultSet resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				int productId = resultset.getInt("productId");

				String productName = resultset.getString("productName");
				String quantityPerUnit = resultset.getString("quantityPerUnit");
				double unitPrice = resultset.getDouble("unitPrice");
				double unitInStock = resultset.getDouble("unitInStock");
				double unitsOnOrder = resultset.getDouble("unitsOnOrder");
				double reorderLevel = resultset.getDouble("reorderLevel");
				boolean discontinued = resultset.getBoolean("discontinued");

				// System.out.println(name);

				Product product = new Product(productId, productName, quantityPerUnit, unitPrice, unitInStock,
						unitsOnOrder, reorderLevel, discontinued);
				productList.add(product);
			
			}
		} catch (SQLException ex) {
			System.err.println("Failed");
			System.err.println(ex);
		}
		return productList;
	}

	@Override
	public void createProduct(Product product) {
		try  {
			Connection connection = ConnectionSingleton.getConnection();
			
			String query = String.format(INSERT_QUERY, 
					product.getProductID(),
					product.getProductName(),
					product.getQuantityPerUnit(),
					product.getUnitPrice(),
					product.getUnitsInStock(),
					product.getUnitsOnOrder(),
					product.getReorderLevel(),
					product.isDiscontinued()					
					);
			//Statement statement = connection.createStatement();
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			//int rows=statement.executeUpdate(query);
			int rows=preparedStatement.executeUpdate();
		}
		catch (SQLException ex) {
			// TODO: handle exception
		}
	}

	@Override
	public void deleteProduct(int id) {
		
	}

	@Override
	public void updateProduct(int id, Product product) {
		
	}

	
}
