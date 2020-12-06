/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.seu.ajlab1;

import bd.edu.seu.ajlab1.model.Product;
import bd.edu.seu.ajlab1.service.ProductService;


public class Main {
    private ProductService productService;
    
    public Main() {
        productService = new ProductService();
       productService.getAll().forEach(System.out::println);
      //  System.out.println("Find Product of Id 2 :");
     //  Product product= productService.getOne(1);
     //  System.out.println(product);
//        System.out.println("Discontinued products: " + productService.findAllDiscontinuedProducts().size());
//        
//        System.out.println("Reordered Products : ");
//        productService.findProductsThatNeedToBeReordered().forEach(System.out::println);
//        System.out.println("Sorted By Price Products : ");
//        productService.getProductListSortedByUnitPrice().forEach(System.out::println);
//        System.out.println("Sorted By Product Name Products : ");
//        productService.getProductListSortedByUnitProductName().forEach(System.out::println);
//        System.out.println("Sum of Total Price of All Stock Products : "+productService.getTotalPriceOfProductsInStock());
        
    }
    
    public static void main(String args[]) {
        new Main();
    }
}
