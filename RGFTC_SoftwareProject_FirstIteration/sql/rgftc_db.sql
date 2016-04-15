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
  `action` varchar(45) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineitems_table`
--

LOCK TABLES `lineitems_table` WRITE;
/*!40000 ALTER TABLE `lineitems_table` DISABLE KEYS */;
INSERT INTO `lineitems_table` VALUES (3,3,3,110,1),(6,6,3,110,2),(7,7,2,430,1),(8,8,3,650,1),(9,9,3,110,1),(21,22,3,2,4),(22,23,2,1,1),(26,26,3,100,2),(31,31,3,50,1),(35,35,5,50,1),(36,36,7,5760,1);
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
  `notes` varchar(45) DEFAULT NULL,
  `deliveryStatus` tinyint(1) NOT NULL,
  PRIMARY KEY (`purchase_orderID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_table`
--

LOCK TABLES `orders_table` WRITE;
/*!40000 ALTER TABLE `orders_table` DISABLE KEYS */;
INSERT INTO `orders_table` VALUES (3,'Waye',30,'Rod','2016-03-05','3',0),(5,'Thomas',50,'Rod','2016-03-05','5',0),(6,'Dane',60,'JP','2016-03-04','6',0),(7,'Dane',70,'Rod','2016-03-05','7',0),(8,'Dane',80,'Rod','2016-03-06','8',0),(9,'Thomas',90,'JP','2016-03-07','9',0),(21,'W',2,'R','2016-03-07','',0),(22,'W',2,'R','2016-03-07','',0),(23,'W',1,'R','2016-03-07','',0),(24,'adasd',900,'asdsad','2016-06-03','',0),(25,'asd',100,'asd','2016-04-15','asd	',0),(26,'Waye',260,'Franco','2016-04-17','1 BBR - 30\r\n2 CDT - 100',0),(27,'Thomas',50,'Rod','2016-04-15','1 WT - 50',0),(28,'HEllo',50,'haha','2016-04-17','hgasdg',0),(29,'wer',50,'werefa','2016-04-15','asdgvr',0),(30,'Thomas',50,'Rod','2016-04-15','1 WT - 50',0),(31,'Thomas',50,'Rod','2016-04-15','1 WT - 50',0),(32,'Thomas',50,'Rod','2016-04-15','1 WT - 50',0),(33,'Thomas',50,'Rod','2016-04-15','1 WT - 50',0),(34,'Thomas',50,'Rod','2016-04-15','1 WT - 50',0),(35,'Thomas',50,'Rod','2016-04-15','1 WT - 50',0),(36,'Max\'s',5760,'Waye','2016-04-16','',0);
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
  `brand` varchar(45) DEFAULT '""',
  `packaging` varchar(45) DEFAULT '""',
  `pricePerKilo` float NOT NULL,
  `stocks` int(11) unsigned zerofill NOT NULL DEFAULT '00000000000',
  `weight` float unsigned zerofill NOT NULL DEFAULT '000000000000',
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products_table`
--

LOCK TABLES `products_table` WRITE;
/*!40000 ALTER TABLE `products_table` DISABLE KEYS */;
INSERT INTO `products_table` VALUES (2,'Brisket','Meat','Beef','Excel/US','',650,00000000000,000000000000),(3,'Cream Dory Trimmed','Seafood','Cream Dory',' ','10kg/box',110,00000000002,000000000000),(4,'Rib Eye Roll','Meat','Beef','Cargill/US','',860,00000000000,000000000000),(5,'Shank, Fore Tarsus On','Meat','Beef','Wilson Hellaby/NZ','10kg/box',216,00000000000,000000000000),(6,'Matsusaka Beef','Meat','Japanese Wagyu',NULL,'10kg/box',12000,00000000000,000000000000),(7,'Wagyu Tenderloin','Meat','Beef','SRF/US','10kg/box',5760,00000000000,000000000000),(8,'Vannamei','Seafood','Shrimp',NULL,'10kg/box',660,00000000000,000000000000),(9,'Squid Rings','Seafood','Squid/Octopus',NULL,'10kg/box',220,00000000000,000000000000),(10,'Mussels Half Shell','Seafood','Scallops and Shellfish',NULL,'10kg/box',500,00000000000,000000000000),(11,'Tuna Panga','Seafood','Tuna',NULL,'10kg/box',150,00000000000,000000000000),(12,'Gindara Steak','Seafood','Fish (Whole, Fillet, Steak)',NULL,'10kg/box',1700,00000000000,000000000000),(13,'Tilapia Fillet','Seafood','Fish (Whole, Fillet, Steak)',NULL,'10kg/box',450,00000000000,000000000000),(14,'Salmon Fillet Slab','Seafood','Norwegian Salmon',NULL,'10kg/box',635,00000000000,000000000000),(15,'Cream Dory Untrimmed','Seafood','Cream Dory',NULL,'10kg/box',110,00000000000,000000000000),(16,'Vannamei','Seafood','Shrimps',NULL,'10kg/box',650,00000000000,000000000000),(17,'Chicken Wingette/Lollipop','Meat','Poultry',NULL,'10kg/box',245,00000000000,000000000000),(18,'Jowls','Meat','Pork','Westvlees/Belgium','10kg/box',156,00000000000,000000000000),(19,'Striploin','Meat','Pork',NULL,'10kg/box',245,00000000000,000000000000),(20,'Tripes','Meat','Pork',NULL,'10kg/box',245,00000000000,000000000000),(21,'Shortribs Bone In','Meat','Beef','St. Helens/US','10kg/box',1600,00000000000,000000000000);
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

-- Dump completed on 2016-04-15 19:49:20
