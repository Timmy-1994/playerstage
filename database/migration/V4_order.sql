
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
    `uuid` BINARY(16) NOT NULL PRIMARY KEY,
    `user_id` BINARY(16) NOT NULL,
    CONSTRAINT `fk_order_user_id` FOREIGN KEY (`user_id`) REFERENCES `user`(`uuid`)
    `payment_id` BINARY(16) NOT NULL,
    CONSTRAINT `fk_order_payment_id` FOREIGN KEY (`payment_id`) REFERENCES `payment`(`uuid`)
    `shipments_id` BINARY(16) NOT NULL,
    CONSTRAINT `fk_order_shipments_id` FOREIGN KEY (`shipments_id`) REFERENCES `shipments`(`uuid`)

    `ctime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    `utime` TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(),

    `status` TINYINT(10) DEFAULT 0 COMMENT="0:訂單已成立,1:訂單已付款,2: 待出貨,3:代簽收,4:已完成,5:已取消",
    `remark` VARCHAR(255)
)

DROP TABLE IF EXISTS `order_product`;
CREATE TABLE `order` (
    `uuid` BINARY(16) NOT NULL PRIMARY KEY,
    `order_id` BINARY(16) NOT NULL,
    CONSTRAINT `fk_order_product_order_id` FOREIGN KEY (`order_id`) REFERENCES `order`(`uuid`)
    `product_id` BINARY(16) NOT NULL,
    CONSTRAINT `fk_order_product_id` FOREIGN KEY (`product_id`) REFERENCES `products`(`uuid`)
    `product_model_id` BINARY(16) NOT NULL,
    CONSTRAINT `fk_order_product_model_id` FOREIGN KEY (`product_model_id`) REFERENCES `product_models`(`uuid`)
    `amount` INT NOT NULL
)
