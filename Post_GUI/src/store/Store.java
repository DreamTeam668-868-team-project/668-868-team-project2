package store;

import post_gui.*;
import java.io.FileNotFoundException;

public class Store {

    public java.util.Date getDateAndTime() {
        return new java.util.Date();
    }

    private String name;
    private Manager manager;
    private Post post; // maybe array later
    private boolean isOpen;
//    private static String productsCatalog = "Products.txt";

    public Store(String name) {
        // have a store name

        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    void open() {
        isOpen = true;
    }

    void close() {
        isOpen = false;
    }

    public boolean isStoreOpen() {
        return isOpen;
    }

    public static void main(String[] args) {
        String filePath = "src/testFiles/Products.txt"; // will be replace by file path in SQL
        Store store = new Store("Costco");
        Manager manager = new Manager("John", store);
        Post post = manager.openStore(filePath);
        
        if (store.isOpen) {
            GUI gui = new GUI(post);
            // make it open faster //
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new GUI(post).setVisible(true);
                }
            });
        }
        
        /*
        reads the file (for testing)
         */
//        String filePath = "src/testFiles/Products.txt";
//        ProductReader pr = new ProductReader(filePath);
//        while(pr.hasMoreProducts()){
//            ProductSpec product = pr.nextProduct();
//           
//        }
        /**/
        // manager opens store
//        post.updateProductCatalog();
//        if (store.isOpen) {
//            // loads products spec from database
//
//            manager.closeStore();
//        }

        // customers buy things
        // customer interacts with POST to process transactions
        // manager closes store
        /*
        while ( TransactionReader.hasMoreTransactons )
        {
            Customer customer = new Customer(TransactionReader.nextTransaction());
        
        
        }
         */
    }
}
