package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logic.Category;
import logic.Product;

public class App {

     public static void main(String []args){
        Factory instance = Factory.getInstance();
        
        Category category = new Category();
        
        category.setCategoryName("notebooks");
        
        Product p1 = new Product();
        p1.setIdCategory(category);
        p1.setProductName("Asus");
        
        Product p2 = new Product();
        p2.setIdCategory(category);
        p2.setProductName("Acer");
        
        Product p3 = new Product();
        p3.setIdCategory(category);
        p3.setProductName("Apple");
        
        Product p4 = new Product();
        p4.setIdCategory(category);
        p4.setProductName("Dell");
        
        List<Product> lstProduct = new ArrayList<Product>();
        
        lstProduct.add(p1);
        lstProduct.add(p2);
        lstProduct.add(p3);
        lstProduct.add(p4);
        
        category.setProducts(lstProduct);
        
        try {
            instance.getCategoryDAO().addCategory(category);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
     
}
