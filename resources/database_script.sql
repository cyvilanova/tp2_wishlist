DROP DATABASE IF EXISTS wishlistdb; 

CREATE DATABASE wishlistdb; 

USE wishlistdb; 

CREATE TABLE IF NOT EXISTS user 
  ( 
     id_user  INT UNSIGNED NOT NULL auto_increment, 
     username CHAR(64) NOT NULL, 
     password CHAR(64) NOT NULL, 
     CONSTRAINT pk_user PRIMARY KEY (id_user) 
  ); 

CREATE TABLE IF NOT EXISTS item_category 
  ( 
     id_item_category INT UNSIGNED NOT NULL auto_increment, 
     name             CHAR(64) NOT NULL, 
     CONSTRAINT pk_item_category PRIMARY KEY (id_item_category) 
  ); 

CREATE TABLE IF NOT EXISTS wishlist_category 
  ( 
     id_wishlist_category INT UNSIGNED NOT NULL auto_increment, 
     name                 CHAR(64) NOT NULL, 
     CONSTRAINT pk_wishlist_category PRIMARY KEY (id_wishlist_category) 
  ); 

CREATE TABLE IF NOT EXISTS currency 
  ( 
     id_currency INT UNSIGNED NOT NULL auto_increment, 
     name        CHAR(32) NOT NULL, 
     symbol      CHAR(8) NOT NULL, 
     CONSTRAINT pk_currency PRIMARY KEY (id_currency) 
  ); 
  
CREATE TABLE IF NOT EXISTS wishlist 
  ( 
     id_wishlist INT UNSIGNED NOT NULL auto_increment, 
     name        CHAR(254) NOT NULL, 
     description CHAR(254), 
     id_user     INT UNSIGNED NOT NULL, 
     CONSTRAINT pk_wishlist PRIMARY KEY (id_wishlist), 
     FOREIGN KEY (id_user) REFERENCES user(id_user) 
  ); 

CREATE TABLE IF NOT EXISTS item 
  ( 
     id_item          INT UNSIGNED NOT NULL auto_increment, 
     name             CHAR(254) NOT NULL, 
     price            FLOAT, 
     link             TEXT, 
     description      CHAR(254), 
     id_currency      INT UNSIGNED, 
     id_item_category INT UNSIGNED, 
     CONSTRAINT pk_item PRIMARY KEY (id_item), 
     FOREIGN KEY (id_currency) REFERENCES currency(id_currency), 
     FOREIGN KEY (id_item_category) REFERENCES item_category(id_item_category) 
  ); 

CREATE TABLE IF NOT EXISTS ta_wishlist_item 
  ( 
     id_wishlist_item INT UNSIGNED NOT NULL auto_increment, 
     id_wishlist      INT UNSIGNED NOT NULL, 
     id_item          INT UNSIGNED NOT NULL, 
     CONSTRAINT pk_ta_wishlist_item PRIMARY KEY(id_wishlist_item), 
     FOREIGN KEY (id_wishlist) REFERENCES wishlist(id_wishlist),
     FOREIGN KEY (id_item) REFERENCES item(id_item)
  ); 

CREATE TABLE IF NOT EXISTS ta_category_wishlist 
  ( 
     id_category_wishlist INT UNSIGNED NOT NULL auto_increment, 
     id_wishlist_category INT UNSIGNED NOT NULL, 
     id_wishlist          INT UNSIGNED NOT NULL, 
     CONSTRAINT pk_ta_category_wishlist  PRIMARY KEY(id_category_wishlist), 
     FOREIGN KEY (id_wishlist_category) REFERENCES wishlist_category(id_wishlist_category), 
     FOREIGN KEY (id_wishlist) REFERENCES wishlist(id_wishlist) 
  ); 

INSERT INTO currency(name, symbol) VALUES("Canadian dollar", "CAD$");
INSERT INTO currency(name, symbol) VALUES("United States dollar", "US$");
INSERT INTO currency(name, symbol) VALUES("Euro", "€");

INSERT INTO item_category(name) VALUES("Clothing, Shoes & Accessories");
INSERT INTO item_category(name) VALUES("Grocery");
INSERT INTO item_category(name) VALUES("Health, Beauty & Pharmacy");
INSERT INTO item_category(name) VALUES("Electronics");
INSERT INTO item_category(name) VALUES("Video Games");
INSERT INTO item_category(name) VALUES("Home");
INSERT INTO item_category(name) VALUES("Outdoor");

INSERT INTO wishlist_category(name) VALUES("Christmas");
INSERT INTO wishlist_category(name) VALUES("Party");
INSERT INTO wishlist_category(name) VALUES("Birthday");
INSERT INTO wishlist_category(name) VALUES("Holiday");
INSERT INTO wishlist_category(name) VALUES("2019");
INSERT INTO wishlist_category(name) VALUES("Groceries");
  
INSERT INTO user(username, password) VALUES("Pitz", "pass123");
INSERT INTO user(username, password) VALUES("Thia", "pass123");

INSERT INTO item(name, price, link, description, id_currency, id_item_category) VALUES("Plaid Blanket Scarf", 15.99, "http://abc.com", "Perfectly plaid blanket scarf by UO. Fuzzy and soft knit construction cut long + wide with two tassel ends that wrap around the neck like a blanket. Finished with raw edges for added texture.",1, 1);
INSERT INTO item(name, price, link, id_currency, id_item_category) VALUES("Household Slippers", 17.99, "http://abc.com", 1, 1);
INSERT INTO item(name, price, link, id_currency, id_item_category) VALUES("Beau Striped Boat Neck Sweater", 82.00, "http://abc.com", 1, 1);
INSERT INTO item(name, price, link, id_currency, id_item_category) VALUES("Beauty Elixir Mist", 58.99, "http://abc.com", 1, 3);
INSERT INTO item(name, price, link, id_currency, id_item_category) VALUES("Butter Popcorn", 11.99, "http://abc.com", 1, 2);
INSERT INTO item(name, price, link, id_currency, id_item_category) VALUES("REESE PUFFS Cereal", 3.97, "http://abc.com", 1, 2);
INSERT INTO item(name, price, link, id_currency, id_item_category) VALUES("Nestea Lemon", 6.47, "http://abc.com", 1, 2);
INSERT INTO item(name, price, link, id_currency, id_item_category) VALUES("Britney Spears Fantasy for Women", 37.19, "http://abc.com", 1, 3);
INSERT INTO item(name, price, link, id_currency, id_item_category) VALUES("Super Smash Bros Ultimate", 78.99, "http://abc.com", 1, 5);
INSERT INTO item(name, price, link, id_currency, id_item_category) VALUES("Microfiber Sheet Set - Queen, Cream", 26.85, "http://abc.com", 1, 6);
INSERT INTO item(name, price, link, id_currency, id_item_category) VALUES("Portable Propane Bbq Gas Grill", 139.99, "http://abc.com", 1, 7);
INSERT INTO item(name, price, link, id_currency, id_item_category) VALUES("Assorted Decorative Faux Succulent", 26.99, "http://abc.com", 1, 6);
INSERT INTO item(name, price, link, id_currency, id_item_category) VALUES("Instant Pot Ultra 6 Qt 10-in-1 Multi- Use", 99.00, "http://abc.com", 2, 6);

INSERT INTO wishlist(name, description, id_user) VALUES("Noël 2019", "Cadeaux pour noël cette année", 1);
INSERT INTO wishlist(name, description, id_user) VALUES("Epicerie 02/03", "Épicerie de la semaine", 2);
INSERT INTO wishlist(name, id_user) VALUES("Party Noël 2019", 2);

INSERT INTO ta_category_wishlist(id_wishlist_category, id_wishlist) VALUES(1,1);
INSERT INTO ta_category_wishlist(id_wishlist_category, id_wishlist) VALUES(4,1);
INSERT INTO ta_category_wishlist(id_wishlist_category, id_wishlist) VALUES(5,1);
INSERT INTO ta_category_wishlist(id_wishlist_category, id_wishlist) VALUES(5,2);
INSERT INTO ta_category_wishlist(id_wishlist_category, id_wishlist) VALUES(6,2);
INSERT INTO ta_category_wishlist(id_wishlist_category, id_wishlist) VALUES(1,3);
INSERT INTO ta_category_wishlist(id_wishlist_category, id_wishlist) VALUES(2,3);
INSERT INTO ta_category_wishlist(id_wishlist_category, id_wishlist) VALUES(5,3);

INSERT INTO ta_wishlist_item(id_wishlist, id_item) VALUES(1,1);
INSERT INTO ta_wishlist_item(id_wishlist, id_item) VALUES(1,9);
INSERT INTO ta_wishlist_item(id_wishlist, id_item) VALUES(1,4);
INSERT INTO ta_wishlist_item(id_wishlist, id_item) VALUES(2,5);
INSERT INTO ta_wishlist_item(id_wishlist, id_item) VALUES(2,6);
INSERT INTO ta_wishlist_item(id_wishlist, id_item) VALUES(2,7);
INSERT INTO ta_wishlist_item(id_wishlist, id_item) VALUES(3,1);
INSERT INTO ta_wishlist_item(id_wishlist, id_item) VALUES(3,10);
INSERT INTO ta_wishlist_item(id_wishlist, id_item) VALUES(3,12);


