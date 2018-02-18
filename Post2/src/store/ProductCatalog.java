package store;

import java.util.HashMap;

public class ProductCatalog {
private HashMap<String, ProductSpec> productCatalog;
private ProductSpec spec;
    
    ProductCatalog(){
        productCatalog = new HashMap();
    }
    
    void init(){
        // add initialization here
    }
    
    void addProduct(ProductSpec productSpec){
        if(productCatalog.containsKey(productSpec.getUpc())) return;
        productCatalog.put(productSpec.getUpc(), productSpec);
    }
    
    ProductSpec getProduct(String upc){
        return productCatalog.get(upc);
    }
    
    boolean validateUPC(String upc){
        if(productCatalog.containsKey(upc)) return true;
        return false;
    }

}
