CREATE DATABASE  IF NOT EXISTS `rgftc_inventory` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `rgftc_inventory`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: rgftc_inventory
-- ------------------------------------------------------
-- Server version	5.6.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `inventory_table`
--

DROP TABLE IF EXISTS `inventory_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory_table` (
  `inventoryID` int(11) NOT NULL AUTO_INCREMENT,
  `productID` int(11) NOT NULL,
  `person` varchar(45) NOT NULL,
  `product` varchar(45) NOT NULL,
  `depwith` varchar(1) NOT NULL,
  `qty` int(6) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`inventoryID`),
  KEY `productKey_idx` (`productID`),
  CONSTRAINT `productKey` FOREIGN KEY (`productID`) REFERENCES `products_table` (`productID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory_table`
--

LOCK TABLES `inventory_table` WRITE;
/*!40000 ALTER TABLE `inventory_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineitems_table`
--

DROP TABLE IF EXISTS `lineitems_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lineitems_table` (
  `lineID` int(11) NOT NULL AUTO_INCREMENT,
  `purchase_orderID` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `pricePerKilo` float NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`lineID`),
  KEY `orderKey_idx` (`purchase_orderID`),
  KEY `productKey_idx` (`productID`),
  CONSTRAINT `orderKey` FOREIGN KEY (`purchase_orderID`) REFERENCES `orders_table` (`purchase_orderID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `productsKey` FOREIGN KEY (`productID`) REFERENCES `products_table` (`productID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineitems_table`
--

LOCK TABLES `lineitems_table` WRITE;
/*!40000 ALTER TABLE `lineitems_table` DISABLE KEYS */;
INSERT INTO `lineitems_table` VALUES (1,1,1,430,2),(2,2,2,650,1),(3,3,3,110,1),(4,4,1,430,2),(5,5,1,430,2),(6,6,3,110,2),(7,7,2,430,1),(34,31,1,1,1);
/*!40000 ALTER TABLE `lineitems_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_table`
--

DROP TABLE IF EXISTS `orders_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders_table` (
  `purchase_orderID` int(11) NOT NULL AUTO_INCREMENT,
  `clientName` varchar(45) NOT NULL,
  `price` float NOT NULL,
  `orderReceiver` varchar(45) NOT NULL,
  `deliveryDueDate` date NOT NULL,
  `notes` varchar(45) NOT NULL,
  `deliveryStatus` tinyint(1) NOT NULL,
  PRIMARY KEY (`purchase_orderID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_table`
--

LOCK TABLES `orders_table` WRITE;
/*!40000 ALTER TABLE `orders_table` DISABLE KEYS */;
INSERT INTO `orders_table` VALUES (1,'Waye',10,'Rod','2016-03-04','1',1),(2,'Waye',20,'Rod','2016-03-04','2',1),(3,'Waye',30,'Rod','2016-03-05','3',1),(4,'Thomas',40,'JP','2016-03-04','4',1),(5,'Thomas',50,'Rod','2016-03-05','5',1),(6,'Dane',60,'JP','2016-03-04','6',1),(7,'Dane',70,'Rod','2016-03-05','7',1),(8,'Dane',80,'Rod','2016-03-06','8',1),(31,'Waye',1,'HILAARY','2016-02-02','HELLO',0);
/*!40000 ALTER TABLE `orders_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products_table`
--

DROP TABLE IF EXISTS `products_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products_table` (
  `productID` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(45) NOT NULL,
  `category` varchar(45) NOT NULL,
  `subtype` varchar(45) NOT NULL,
  `brand` varchar(45) NOT NULL,
  `packaging` varchar(45) NOT NULL,
  `pricePerKilo` float NOT NULL,
  `stocks` int(11) NOT NULL DEFAULT '0',
  `weight` int(10) unsigned zerofill NOT NULL DEFAULT '0000000000',
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products_table`
--

LOCK TABLES `products_table` WRITE;
/*!40000 ALTER TABLE `products_table` DISABLE KEYS */;
INSERT INTO `products_table` VALUES (1,'Baby back ribs','Prok','Beef','Patel',' ',420,10,0000000000),(2,'Brisket','Beef',' Beef','Excel / US',' ',650,5,0000000000),(3,'Cream Dory Trimmed','Cream Dory','Beef',' ','10/box',110,2,0000000000),(5,'Beeeeef','Meat','Beef','BEF','BP',2,0,0000000000),(6,'RODIKHULUS','Meat','Cuts','SUPER CUTS','CUTLORD',999,0,0000000000),(7,'HElo','Meat','Beef','123`12','sdf',4,0,0000000000),(8,'1','Seafood','Nobashi','123','11',3,0,0000000000),(9,'SALMIN','Seafood','Fish (Whole, Fillet, Steak)','','',600,0,0000000000);
/*!40000 ALTER TABLE `products_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-11  0:53:37
