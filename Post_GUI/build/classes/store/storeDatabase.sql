/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Travis
 * Created: Feb 16, 2018
 */

CREATE TABLE productCatalog (
    upc CHAR(4) NOT NULL PRIMARY KEY,
    description CHAR(20),
    price REAL
);

INSERT INTO productCatalog
VALUES  ('1654', 'COUGAR', 150.0),
        ('4846', 'PRESSURE WASHER', 200.0),
        ('9443', 'TRICYCLE', 49.90),
        ('8461', 'BICYCLE', 150.0),
        ('7841', 'TOOL SET', 99.00),
        ('1367', 'PAINT GALLON', 35.0),
        ('1337', 'SPRAY PAINT', 4.95),
        ('9864', 'XBONE FORZA', 59.0);
        

CREATE TABLE salesRecord (
    id  INTEGER NOT NULL PRIMARY KEY
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
    transactionDate DATE,
    transactionTime TIME,
    customerName VARCHAR(50),
    transactionRecord VARCHAR(255),
    paymentType VARCHAR(6),
    paymentTotal REAL,
    paymentAmount REAL,
    paymentChange REAL,
    paymentCCNumber CHAR(5)
);
