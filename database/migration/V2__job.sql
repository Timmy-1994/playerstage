USE `playerstage`;

CREATE TABLE IF NOT EXISTS `job` (
  `uuid` BINARY(16) NOT NULL PRIMARY KEY,

  `ctime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
  `dtime` TIMESTAMP

  `type` TINYINT(2) NOT NULL COMMENT = 'schdule=0,request=1',
  `status` TINYINT(6) NOT NULL COMMENT = 'DONE=0,PENDING=1',
  
) COMMENT = '工作任務主表';

CREATE TABLE IF NOT EXISTS `job_config` (
  
)

CREATE TABLE IF NOT EXISTS `product_crawling_repeat` (
  `uuid` BINARY(16) NOT NULL PRIMARY KEY,

  `job_id` BINARY(16) NOT NULL,
  CONSTRAINT `fk_product_crawling_repeat_job_id` FOREIGN KEY (`job_id`) REFERENCES `products`(`uuid`),

  `item_id`
  `name`
) COMMENT = '重複爬取商品，對應 item id 已經修改';