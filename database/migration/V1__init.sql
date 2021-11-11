CREATE TABLE IF NOT EXISTS `products` (
  `uuid` BINARY(16) NOT NULL PRIMARY KEY,
  `name` VARCHAR(100) NOT NULL,
  `ctime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
  `utime` TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(),
  `brand` VARCHAR(80) NOT NULL,
  `is_pre_order` BOOLEAN NOT NULL DEFAULT false,
  `rating` FLOAT DEFAULT 0,
  `description` VARCHAR(5000) NOT NULL,
  `origin_item_id` varchar(45) NOT NULL,
  `sold` INT NOT NULL,
  `edited` BOOLEAN NOT NULL DEFAULT false
) COMMENT = '賣場商品';

CREATE TABLE IF NOT EXISTS `product_models` (
  `uuid` BINARY(16) NOT NULL PRIMARY KEY,
  `products_id` BINARY(16) NOT NULL,
  CONSTRAINT `fk_product_models_products_id` FOREIGN KEY (`products_id`) REFERENCES `products`(`uuid`),
  `name` VARCHAR(100) NOT NULL,
  `price` INT NOT NULL,
  `discount` FLOAT NOT NULL DEFAULT 0,
  `total_stock` INT NOT NULL,
  `promote_stock` INT NOT NULL,
  `image_hash` varchar(45) NOT NULL
) COMMENT = '商品規格資訊';

CREATE TABLE IF NOT EXISTS `product_images` (
  `uuid` BINARY(16) NOT NULL PRIMARY KEY,
  `products_id` BINARY(16) NOT NULL,
  CONSTRAINT `fk_product_images_products_id` FOREIGN KEY (`products_id`) REFERENCES `products`(`uuid`),
  `is_cover` BOOLEAN NOT NULL DEFAULT false,
  `image_hash` varchar(45) NOT NULL
) COMMENT = '商品影像';

CREATE TABLE IF NOT EXISTS `shipments` (
  `uuid` BINARY(16) NOT NULL PRIMARY KEY ,
  `name` VARCHAR(100) NOT NULL,
  `max_price` INT NOT NULL,
  `min_price` INT NOT NULL,
  `estimated_max_days` INT DEFAULT NULL,
  `estimated_min_days` INT DEFAULT NULL
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