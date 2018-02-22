package store;

import post_gui.Mediator;

public class Store {

    public java.util.Date getDateAndTime() {
        return new java.util.Date();
    }

    private String name;
    private Manager manager;
    private Post post; // maybe array later
    private boolean isOpen;
//    private static String productsCatalog = "Post/testFiles/Products.txt";
//    private static String customerTransaction = "Post/testFiles/Transaction.txt";

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

        Store store = new Store("Costco");
        Manager manager = new Manager("John", store);
        PostNetworkInterface client = new PostNetworkInterface();
        // manager opens store
        Post post = manager.initPost(client);
        manager.openStore();

        if (store.isOpen) {
            Mediator gui = new Mediator(post);
            // make it open faster //
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Mediator(post).setVisible(true);
                }
            });
        }
    }
}
