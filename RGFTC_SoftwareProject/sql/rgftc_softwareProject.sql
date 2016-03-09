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
  `person` varchar(45) NOT NULL,
  `product` varchar(45) NOT NULL,
  `deposits` int(11) NOT NULL,
  `withdrawals` int(11) NOT NULL,
  `date` date NOT NULL,
  `productID` int(11) NOT NULL,
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
  `lineID` int(11) NOT NULL,
  `purchase_orderID` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `pricePerKilo` float NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`lineID`),
  KEY `orderKey_idx` (`purchase_orderID`),
  KEY `productKey_idx` (`productID`),
  CONSTRAINT `orderKey` FOREIGN KEY (`purchase_orderID`) REFERENCES `orders_table` (`purchase_orderID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `productsKey` FOREIGN KEY (`productID`) REFERENCES `products_table` (`productID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineitems_table`
--

LOCK TABLES `lineitems_table` WRITE;
/*!40000 ALTER TABLE `lineitems_table` DISABLE KEYS */;
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
  `deliveryStatus` tinyint(1) NOT NULL,
  `notes` varchar(45) NOT NULL,
  PRIMARY KEY (`purchase_orderID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_table`
--

LOCK TABLES `orders_table` WRITE;
/*!40000 ALTER TABLE `orders_table` DISABLE KEYS */;
INSERT INTO `orders_table` VALUES (1,'Rod',12,'Eya','2016-12-12',0,'wala');
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
  `brand` varchar(45) DEFAULT NULL,
  `packaging` varchar(45) DEFAULT NULL,
  `pricePerKilo` float NOT NULL,
  `stocks` int(11) unsigned zerofill DEFAULT NULL,
  `weight` int(10) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products_table`
--

LOCK TABLES `products_table` WRITE;
/*!40000 ALTER TABLE `products_table` DISABLE KEYS */;
INSERT INTO `products_table` VALUES (7,'Wagyu Rib Lifter Meat','Meat','Beef','SRF',NULL,900,NULL,NULL),(8,'Baby Back Ribs','Meat','Pork','Patel',NULL,420,NULL,NULL),(9,'Omi Beef','Meat','Japanese Wagyu',NULL,NULL,9500,NULL,NULL),(10,'Shabu-shabu','Meat','Cuts',NULL,NULL,7200,NULL,NULL),(11,'Black Tiger','Seafood','Shrimp',NULL,NULL,760,NULL,NULL),(12,'Abomasum','Meat','Beef','Swift',NULL,420,NULL,NULL),(13,'Tuna Sashimi','Seafood','Tuna',NULL,NULL,265,NULL,NULL),(14,'Baby Squid','Seafood','Squid/Octopus',NULL,NULL,160,NULL,NULL),(15,'Mussels (whole)','Seafood','Scallops & Shellfish',NULL,NULL,370,NULL,NULL),(16,'Gindara HGT','Seafood','Fish ',NULL,NULL,1650,NULL,NULL),(19,'Ground Beef 80/20','Meat','Beef','','',24,NULL,NULL),(20,'Vannamei','Seafood','Shrimps','','1kg/pack; 10kgs/box',65,NULL,NULL);
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

-- Dump completed on 2016-03-04 18:57:59
