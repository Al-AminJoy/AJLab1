/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.seu.ajlab1.service;

import bd.edu.seu.ajlab1.model.Product;
import bd.edu.seu.ajlab1.repository.ProductDao;
import bd.edu.seu.ajlab1.repository.ProductDaoCsvImplementation;
import bd.edu.seu.ajlab1.repository.ProductDaoMySQLImplementation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ProductService {
    private ProductDao productDao;
    
    public ProductService() {
        // we can switch out the implementation just by changing one line here
        // that's the beauty of using DAO pattern here
        //productDao = new ProductDaoCsvImplementation();
    	productDao=new ProductDaoMySQLImplementation();
    }
    public List<Product>getAll() {
        List<Product> productList = productDao.readAll();
               
        return productList;
    }
    public Product getOne(int id) {
        Product product= productDao.readProduct(id);
               
        return product;
    }

 // a sample implementation
    public List<Product> findAllDiscontinuedProducts() {
        List<Product> productList = productDao.readAll()
                .stream()
                .filter((product) -> product.isDiscontinued())
                .collect(Collectors.toList());
        return productList;
    }
    
    // TODO write your code here
    public List<Product> findProductsThatNeedToBeReordered() {
        List<Product> productList = productDao.readAll()
                .stream()
                .filter((product) -> product.getUnitsInStock()<product.getReorderLevel())
                .collect(Collectors.toList());
        return productList;
    }
    
    // TODO write your code here
    public List<Product> getProductListSortedByUnitPrice() {
        List<Product> productList = productDao.readAll()
                .stream()
                .sorted(Comparator.comparing(Product::getUnitPrice))
                .collect(Collectors.toList());
        return productList;
    }

    // TODO write your code here
    public List<Product> getProductListSortedByUnitProductName() {
        List<Product> productList = productDao.readAll()
                .stream()
                .sorted(Comparator.comparing(Product::getProductName))
                .collect(Collectors.toList());
        return productList;
    }
 // TODO write your code here
    public double getTotalPriceOfProductsInStock() {
        double sum=productDao.readAll()
                .stream()
                .filter(product->product.getUnitsInStock()>0)
                .mapToDouble(product->(product.getUnitsInStock()*product.getUnitPrice()))
                .sum();
        return sum;
    }
}
