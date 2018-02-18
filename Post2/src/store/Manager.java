package store;

public class Manager {

    Manager(String name, Store store) {
        this.name = name;
        this.store = store;
    }

    public void initPost(Post post, PostNetworkInterface client){
        post = new Post(store, client);
    }
    
    public void openStore() {
        // init product catalog
        // store.getCatalog().init();
        // setup Post -- store.getPost().init();
        String procatalog = "Post/testFiles/Products.txt";
        ProductCatalog productCatalog = new ProductCatalog();
        productCatalog.init();
        store.open();
    }

    public void closeStore() {
        store.close();
    }

    private String name;
    private Store store;

}
