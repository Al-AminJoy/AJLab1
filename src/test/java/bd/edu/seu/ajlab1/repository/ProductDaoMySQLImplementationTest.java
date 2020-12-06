package bd.edu.seu.ajlab1.repository;

import static org.junit.Assert.*;

import org.junit.Test;

import bd.edu.seu.ajlab1.model.Product;

public class ProductDaoMySQLImplementationTest {
 ProductDao productDao;
 
	public ProductDaoMySQLImplementationTest() {
	productDao=new ProductDaoMySQLImplementation();
}

	@Test
	public void testReadAll() {
		fail("Not yet implemented");
	}

	
	@Test
	public void testCreateProduct() {
		Product product = new Product(
                56,
                "Casio G-Shock",
                "1 per box",
                10_000,
                15,
                19,
                5,
                false);
        productDao.createProduct(product);
        Product productFromDatabase = productDao.readProduct(56);
        
        assertEquals(product.getProductID(), productFromDatabase.getProductID());
        assertEquals(product.getProductName(), productFromDatabase.getProductName());
        assertEquals(product.getQuantityPerUnit(), productFromDatabase.getQuantityPerUnit());
        assertEquals(product.getUnitPrice(), productFromDatabase.getUnitPrice());
        assertEquals(product.getUnitsInStock(), productFromDatabase.getUnitsInStock());
        assertEquals(product.getUnitsOnOrder(), productFromDatabase.getUnitsOnOrder());
        assertEquals(product.getReorderLevel(), productFromDatabase.getReorderLevel());
        assertEquals(product.isDiscontinued(), productFromDatabase.isDiscontinued());
	}

	@Test
	public void testDeleteProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateProduct() {
		fail("Not yet implemented");
	}

}
