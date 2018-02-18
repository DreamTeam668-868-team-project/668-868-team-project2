/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import transaction.Transaction;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import transaction.CashPayment;
import transaction.TransactionHeader;
import transaction.TransactionItem;

/**
 * This class integrates with Post to send/receive network requests
 *
 * @author Travis
 */
public class PostNetworkInterface {

    public PostNetworkInterface()  {
        networkLog = "";
    }

    /*
        GET 
        product catalog
     */
    public ProductCatalog getCatalog() throws ParserConfigurationException, SAXException {
        ProductCatalog catalog = new ProductCatalog();
        try {
            URL storeConnectionURL = new URL("http://localhost:8080/StoreServer/webresources/com.storeentity.productcatalog");
            HttpURLConnection getConnection = (HttpURLConnection) storeConnectionURL.openConnection();
            getConnection.setRequestMethod("GET");
            getConnection.setRequestProperty("Accept", "application/xml");

            if (getConnection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + getConnection.getResponseCode());
            }

            // Read the network response into a string           
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (getConnection.getInputStream())));

            String output, msg = "";

            networkLog += "---- start GET request response";
            while ((output = br.readLine()) != null) {
                msg += output;
                networkLog += output;
            }
            networkLog += "---- end GET request response\n";

            // Conver the string into an xml document            
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(msg.getBytes()));
            NodeList upcList = doc.getElementsByTagName("upc");
            NodeList descList = doc.getElementsByTagName("description");
            NodeList priceList = doc.getElementsByTagName("price");

            String upc, desc;
            double price;
            for (int i = 0; i < upcList.getLength(); i++) {
                upc = upcList.item(i).getTextContent();
                desc = descList.item(i).getTextContent();
                price = Double.valueOf(priceList.item(i).getTextContent());
                catalog.addProduct(new ProductSpec(upc, desc, price));
            }

            getConnection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return catalog;
    }

    /*
        POST
        send invoice
     */
    public void postInvoice(Transaction transaction) {
        try {
            URL storeConnectionURL = new URL("http://localhost:8080/StoreServer/webresources/com.storeentity.salesrecord");
            HttpURLConnection postConnection = (HttpURLConnection) storeConnectionURL.openConnection();
            postConnection.setDoOutput(true);
            postConnection.setRequestMethod("POST");
            postConnection.setRequestProperty("Content-Type", "application/xml");

            OutputStream postOutputStream = postConnection.getOutputStream();
            postOutputStream.write(transaction.getTransactionXML().getBytes());
            postOutputStream.flush();
            
            if (postConnection.getResponseCode() >= 400) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + postConnection.getResponseCode());
            }
            
            String output;
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (postConnection.getInputStream())));
            networkLog += "---- start POST request response";
            while ((output = br.readLine()) != null) {
                networkLog += output;
            }
            networkLog += "---- end POST request response\n";


            postConnection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: exception handling
        } 
    }

    public String getNetworkLog() {
        return this.networkLog;
    }

    private String networkLog;

    
    // test main class
    public static void main(String[] args) {
        Transaction testTrans = new Transaction();
        testTrans.setHeader(new TransactionHeader("John Doe", new Date()));
        for (int i = 1; i <= 10; i++) {
            testTrans.addTransactionItem(new TransactionItem("" + (1234 + i), 1));
        }
        testTrans.setPayment(new CashPayment(600, 580));
        PostNetworkInterface netInterface = new PostNetworkInterface();
        
        netInterface.postInvoice(testTrans);

        
        
        ProductCatalog cat = new ProductCatalog();
        try {
            cat = netInterface.getCatalog();
        } catch(ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        
        System.out.println(cat.getProduct("1234").toString());
    }
}
