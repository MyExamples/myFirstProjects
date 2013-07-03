package shop;

import java.util.ArrayList;
import logic.Product;

public class Basket {
 
    private ArrayList<Product> listProducts = new ArrayList<Product>();
    
       
    public Basket() {
    }

    public ArrayList<Product> getlistProducts() {
        return listProducts;
    }

    public void addProductToBasket(Product productObj) {
        this.listProducts.add(productObj);
        System.out.println("SizzZZZZZZZZZZZZZZZZZZZZZZZZZZZeee   = "+listProducts.size());
    }

    public void setListProducts(ArrayList<Product> listProducts) {
        this.listProducts = listProducts;
    }

    
    
    
}
