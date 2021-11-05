DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uuid` BINARY(16) NOT NULL PRIMARY KEY,
  `username` varchar(36) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(36) NOT NULL,
  `birthday` date DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(36) DEFAULT NULL,
  `avatar` varchar(255),
  `enabled` tinyint(1) DEFAULT 1,
  `account_non_expired` tinyint(1) DEFAULT 1,
  `credentials_non_expired` tinyint(1) DEFAULT 1,
  `account_non_locked` tinyint(1) DEFAULT 1,
  `valid` tinyint(1) DEFAULT 1,
  `ctime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
  `utime` TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(),
  UNIQUE KEY `unique_user_username` (`username`)
) COMMENT='User Table';


DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `uuid` BINARY(16) NOT NULL PRIMARY KEY,
  `name` varchar(36) NOT NULL,
  `valid` tinyint(1) DEFAULT 0,
  `ctime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
  `utime` TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(),
  UNIQUE KEY `unique_role_name` (`name`)
) COMMENT='Role Table';

BEGIN;
INSERT INTO `role` VALUES (UNHEX(REPLACE(UUID(),'-','')),'SUPER', 1, NULL, NULL);
INSERT INTO `role` VALUES (UNHEX(REPLACE(UUID(),'-','')),'ADMIN', 1, NULL, NULL);
INSERT INTO `role` VALUES (UNHEX(REPLACE(UUID(),'-','')),'USER', 1, NULL, NULL);
COMMIT;


DROP TABLE IF EXISTS `user_role_intermediary`;
CREATE TABLE `user_role_intermediary` (
  `uuid` BINARY(16) NOT NULL PRIMARY KEY,
  `user_id` BINARY(16) NOT NULL,
  CONSTRAINT `fk_user_role_intermediary_user_id` FOREIGN KEY (`user_id`) REFERENCES `user`(`uuid`),
  `role_id` BINARY(16) NOT NULL,
  CONSTRAINT `fk_user_role_intermediary_role_id` FOREIGN KEY (`role_id`) REFERENCES `role`(`uuid`)
) COMMENT='User role relationship table';


DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `uuid` BINARY(16) NOT NULL PRIMARY KEY,
  `permission` varchar(255) NOT NULL
);

CREATE TABLE `role_permission_intermediary`(
  `uuid` BINARY(16) NOT NULL PRIMARY KEY,
  `role_id` BINARY(16) NOT NULL,
  CONSTRAINT `fk_role_permission_intermediary_role_id` FOREIGN KEY (`role_id`) REFERENCES `role`(`uuid`),
  `permission_id` BINARY(16) NOT NULL,
  CONSTRAINT `fk_role_permission_intermediary_permission_id` FOREIGN KEY (`permission_id`) REFERENCES `permission`(`uuid`)
);


DROP TABLE IF EXISTS `refresh_token`;
CREATE TABLE `refresh_token` (
  `uuid` BINARY(16) NOT NULL PRIMARY KEY,
  `expire` DATETIME NOT NULL,
  `token` VARCHAR(255),
  `ip` VARCHAR(255),
  `user_id` BINARY(16) NOT NULL,
  CONSTRAINT `fk_refresh_token_user_id` FOREIGN KEY (`user_id`) REFERENCES `user`(`uuid`)
)