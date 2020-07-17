DROP TABLE IF EXISTS currency;
CREATE TABLE currency ( id INT AUTO_INCREMENT PRIMARY KEY, fromcountry VARCHAR(5) NOT NULL, 
tocountry VARCHAR(5) NOT NULL, conversionfactor INT NOT NULL, convertedamount INT);  
