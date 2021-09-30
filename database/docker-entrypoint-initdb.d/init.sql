CREATE DATABASE IF NOT EXISTS `playerstage`;
USE `playerstage`;

CREATE TABLE `products_crawlered_record` (
  `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `utime` DATETIME DEFAULT NOW() ON UPDATE NOW(),
  `product_id` BINARY(16) NOT NULL,
  `original_shopee_itemid` VARCHAR(45) NOT NULL,
  `has_been_edited` BOOLEAN NOT NULL DEFAULT false
);

CREATE TABLE IF NOT EXISTS `products` (
  `uuid` BINARY(16) NOT NULL PRIMARY KEY,
  `name` VARCHAR(100) NOT NULL,
  `ctime` DATETIME NOT NULL DEFAULT NOW(),
  `utime` DATETIME DEFAULT NOW() ON UPDATE NOW(),
  `brand` VARCHAR(80) NOT NULL,
  `is_pre_order` BOOLEAN NOT NULL DEFAULT false,
  `rate` FLOAT NOT NULL DEFAULT 0,
  `description` VARCHAR(1000) NOT NULL,

  `model_name` VARCHAR(30) NOT NULL
) COMMENT = '賣場商品';

CREATE TABLE IF NOT EXISTS `product_models` (
  `uuid` BINARY(16) NOT NULL PRIMARY KEY,
  `name` VARCHAR(100) NOT NULL,
  `price` INT NOT NULL,
  `discount` FLOAT NOT NULL DEFAULT 0,
  `total_stock` INT NOT NULL,
  `promote_stock` INT NOT NULL,
  `sold` INT NOT NULL,

  `products_id` BINARY(16) NOT NULL,
  CONSTRAINT `fk_product_models_products_id` FOREIGN KEY (`products_id`) REFERENCES `products`(`uuid`)
) COMMENT = '商品規格資訊';

CREATE TABLE IF NOT EXISTS `product_images` (
  `uuid` BINARY(16) NOT NULL PRIMARY KEY,
  `url` VARCHAR(100) NOT NULL,
  `is_cover` BOOLEAN NOT NULL DEFAULT false,

  `products_id` BINARY(16) NOT NULL,
  CONSTRAINT `fk_product_images_products_id` FOREIGN KEY (`products_id`) REFERENCES `products`(`uuid`),
  `product_model_id` BINARY(16) NOT NULL,
  CONSTRAINT `fk_product_images_product_model_id` FOREIGN KEY (`product_model_id`) REFERENCES `product_models`(`uuid`)
) COMMENT = '商品影像';

CREATE TABLE IF NOT EXISTS `shipments` (
  `uuid` BINARY(16) NOT NULL PRIMARY KEY,
  `estimated_days` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `price` INT NOT NULL DEFAULT 0,
  `free_price_limit` INT NOT NULL DEFAULT 0
) COMMENT = '所有運送方式';

CREATE TABLE IF NOT EXISTS `categories` (
  `uuid` BINARY(16) NOT NULL PRIMARY KEY,
  `name` VARCHAR(30) NOT NULL
) COMMENT = '所有商品分類';

CREATE TABLE IF NOT EXISTS `products_categories_intermediary` (
  `uuid` BINARY(16) NOT NULL PRIMARY KEY,
  `categories_id` BINARY(16) NOT NULL,
  CONSTRAINT `fk_products_categories_intermediary_categories_id` FOREIGN KEY (`categories_id`) REFERENCES `categories`(`uuid`),
  `products_id` BINARY(16) NOT NULL,
  CONSTRAINT `fk_products_categories_intermediary_products_id` FOREIGN KEY (`products_id`) REFERENCES `products`(`uuid`)
) COMMENT = '商品、所有商品分類 中介';

CREATE TABLE IF NOT EXISTS `prdoucts_shipments_intermediary` (
  `uuid` BINARY(16) NOT NULL PRIMARY KEY,
  `shipments_id`  BINARY(16) NOT NULL,
  CONSTRAINT `fk_prdoucts_shipments_intermediary_shipments_id` FOREIGN KEY (`shipments_id`) REFERENCES `shipments`(`uuid`),
  `products_id` BINARY(16) NOT NULL,
  CONSTRAINT `fk_prdoucts_shipments_intermediary_products_id` FOREIGN KEY (`products_id`) REFERENCES `products`(`uuid`)
) COMMENT = '商品、所有運送方式 中介';