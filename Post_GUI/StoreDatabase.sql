/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Travis
 * Created: Feb 16, 2018
 */

CREATE TABLE catalog(
  upc INTEGER NOT NULL,
  desc VARCHAR(20),
  price REAL NOT NULL,
  PRIMARY KEY (upc)
);

INSERT INTO catalog VALUES
(1111, "FIRST PRODUCT", 0.99),
(3541, "PRODUCT 2", 1.99),
(6518, "PRODUCT 3", 2.99),
(1432, "A PRODUCT", 3.99),
(6171, "PRODUCT", 4.99),
(9987, "SECOND PRODUCT", 5.99),
(7921, "THIRD PRODUCT", 6.99),
(4121, "BICYCLE", 179.99),
(1655, "SOMETHING SPECIAL", 3.99),
(7841, "PLACEHOLDER", 0.00);  