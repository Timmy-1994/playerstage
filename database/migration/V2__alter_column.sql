-- @block 
ALTER TABLE `products` CHANGE COLUMN `rate` `rating` FLOAT DEFAULT(0);

-- @block 
ALTER TABLE `products` MODIFY `description` VARCHAR(5000) NOT NULL ;
ALTER TABLE `products` ADD `free_shipping_mini_spend` INT NOT NULL ;

-- @block 
DROP TABLE IF EXISTS `products_crawlered_record`;
ALTER TABLE `products` ADD `origin_item_id` VARCHAR(45) NOT NULL;


-- @block 
ALTER TABLE `shipments` DROP IF EXISTS `price`;
ALTER TABLE `shipments` DROP IF EXISTS `estimated_days`;
ALTER TABLE `shipments` DROP IF EXISTS `free_price_limit`;
ALTER TABLE `shipments` ADD IF NOT EXISTS `max_price` INT NOT NULL;
ALTER TABLE `shipments` ADD IF NOT EXISTS `min_price` INT NOT NULL;
ALTER TABLE `shipments` ADD IF NOT EXISTS `estimated_max_days` INT;
ALTER TABLE `shipments` ADD IF NOT EXISTS `estimated_min_days` INT;


-- @block 
ALTER TABLE `products_categories_intermediary` DROP IF EXISTS `uuid`;
ALTER TABLE `prdoucts_shipments_intermediary` DROP IF EXISTS `uuid`;
ALTER TABLE `products_categories_intermediary` ADD IF NOT EXISTS `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT;
ALTER TABLE `prdoucts_shipments_intermediary` ADD IF NOT EXISTS `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT;

-- @block 
ALTER TABLE `product_models` DROP IF EXISTS `sold`;
ALTER TABLE `products` ADD IF NOT EXISTS `sold` INT NOT NULL;
ALTER TABLE `product_models` ADD IF NOT EXISTS `image_hash` VARCHAR(45) NOT NULL;

-- @block 
ALTER TABLE `product_images` DROP IF EXISTS `url`;
ALTER TABLE `product_images` DROP IF EXISTS `uuid`;
ALTER TABLE `product_images` DROP FOREIGN KEY IF EXISTS `fk_product_images_product_model_id`;
ALTER TABLE `product_images` DROP IF EXISTS `product_model_id`;
ALTER TABLE `product_images` ADD IF NOT EXISTS `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT;
ALTER TABLE `product_images` ADD IF NOT EXISTS `image_hash` VARCHAR(45) NOT NULL;

