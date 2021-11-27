
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
    `uuid` BINARY(16) NOT NULL PRIMARY KEY,
    `name` BINARY(16) NOT NULL,
    `enabled` TINYINT(1) DEFAULT(1)
)

INSERT INTO `payment` VALUES(
    UNHEX(REPLACE(UUID(),'-','')),'貨到付款', 1
)