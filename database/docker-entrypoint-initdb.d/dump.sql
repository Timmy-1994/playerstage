-- MariaDB dump 10.19  Distrib 10.4.20-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: playerstage
-- ------------------------------------------------------
-- Server version	10.4.20-MariaDB-1:10.4.20+maria~focal

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `playerstage`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `playerstage` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `playerstage`;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `uuid` binary(16) NOT NULL,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='所有商品分類';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT current_timestamp(),
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyway_schema_history`
--

LOCK TABLES `flyway_schema_history` WRITE;
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
INSERT INTO `flyway_schema_history` VALUES (1,'1','init','SQL','V1__init.sql',1423339247,'root','2021-10-07 11:26:45',132,1),(2,'2','alter column','SQL','V2__alter_column.sql',-1436337514,'root','2021-10-07 11:26:45',194,1);
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prdoucts_shipments_intermediary`
--

DROP TABLE IF EXISTS `prdoucts_shipments_intermediary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prdoucts_shipments_intermediary` (
  `shipments_id` binary(16) NOT NULL,
  `products_id` binary(16) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_prdoucts_shipments_intermediary_shipments_id` (`shipments_id`),
  KEY `fk_prdoucts_shipments_intermediary_products_id` (`products_id`),
  CONSTRAINT `fk_prdoucts_shipments_intermediary_products_id` FOREIGN KEY (`products_id`) REFERENCES `products` (`uuid`),
  CONSTRAINT `fk_prdoucts_shipments_intermediary_shipments_id` FOREIGN KEY (`shipments_id`) REFERENCES `shipments` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品、所有運送方式 中介';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prdoucts_shipments_intermediary`
--

LOCK TABLES `prdoucts_shipments_intermediary` WRITE;
/*!40000 ALTER TABLE `prdoucts_shipments_intermediary` DISABLE KEYS */;
/*!40000 ALTER TABLE `prdoucts_shipments_intermediary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_images`
--

DROP TABLE IF EXISTS `product_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_images` (
  `is_cover` tinyint(1) NOT NULL DEFAULT 0,
  `products_id` binary(16) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image_hash` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_images_products_id` (`products_id`),
  CONSTRAINT `fk_product_images_products_id` FOREIGN KEY (`products_id`) REFERENCES `products` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品影像';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_images`
--

LOCK TABLES `product_images` WRITE;
/*!40000 ALTER TABLE `product_images` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_models`
--

DROP TABLE IF EXISTS `product_models`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_models` (
  `uuid` binary(16) NOT NULL,
  `name` varchar(100) NOT NULL,
  `price` int(11) NOT NULL,
  `discount` float NOT NULL DEFAULT 0,
  `total_stock` int(11) NOT NULL,
  `promote_stock` int(11) NOT NULL,
  `products_id` binary(16) NOT NULL,
  `image_hash` varchar(45) NOT NULL,
  PRIMARY KEY (`uuid`),
  KEY `fk_product_models_products_id` (`products_id`),
  CONSTRAINT `fk_product_models_products_id` FOREIGN KEY (`products_id`) REFERENCES `products` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品規格資訊';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_models`
--

LOCK TABLES `product_models` WRITE;
/*!40000 ALTER TABLE `product_models` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_models` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `uuid` binary(16) NOT NULL,
  `name` varchar(100) NOT NULL,
  `ctime` datetime DEFAULT current_timestamp(),
  `utime` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `brand` varchar(80) NOT NULL,
  `is_pre_order` tinyint(1) NOT NULL DEFAULT 0,
  `rating` float DEFAULT 0,
  `description` varchar(5000) NOT NULL,
  `model_name` varchar(30) NOT NULL,
  `free_shipping_mini_spend` int(11) NOT NULL,
  `origin_item_id` varchar(45) NOT NULL,
  `sold` int(11) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='賣場商品';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products_categories_intermediary`
--

DROP TABLE IF EXISTS `products_categories_intermediary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products_categories_intermediary` (
  `categories_id` binary(16) NOT NULL,
  `products_id` binary(16) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_products_categories_intermediary_categories_id` (`categories_id`),
  KEY `fk_products_categories_intermediary_products_id` (`products_id`),
  CONSTRAINT `fk_products_categories_intermediary_categories_id` FOREIGN KEY (`categories_id`) REFERENCES `categories` (`uuid`),
  CONSTRAINT `fk_products_categories_intermediary_products_id` FOREIGN KEY (`products_id`) REFERENCES `products` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品、所有商品分類 中介';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products_categories_intermediary`
--

LOCK TABLES `products_categories_intermediary` WRITE;
/*!40000 ALTER TABLE `products_categories_intermediary` DISABLE KEYS */;
/*!40000 ALTER TABLE `products_categories_intermediary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipments`
--

DROP TABLE IF EXISTS `shipments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipments` (
  `uuid` binary(16) NOT NULL,
  `name` varchar(100) NOT NULL,
  `max_price` int(11) NOT NULL,
  `min_price` int(11) NOT NULL,
  `estimated_max_days` int(11) DEFAULT NULL,
  `estimated_min_days` int(11) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='所有運送方式';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipments`
--

LOCK TABLES `shipments` WRITE;
/*!40000 ALTER TABLE `shipments` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipments` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-07 19:26:53
