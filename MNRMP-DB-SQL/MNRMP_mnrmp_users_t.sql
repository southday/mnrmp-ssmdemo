-- MySQL dump 10.13  Distrib 5.7.9, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: MNRMP
-- ------------------------------------------------------
-- Server version	5.7.11

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
-- Table structure for table `mnrmp_users_t`
--

DROP TABLE IF EXISTS `mnrmp_users_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mnrmp_users_t` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `account` varchar(25) NOT NULL,
  `user_name` varchar(25) NOT NULL,
  `birthday` date NOT NULL,
  `sex` tinyint(1) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `password` varchar(32) NOT NULL,
  `regist_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `head_portrait_name` varchar(45) NOT NULL DEFAULT 'default.png',
  `is_valid` tinyint(1) NOT NULL DEFAULT '1',
  `is_activated` tinyint(1) NOT NULL DEFAULT '0',
  `activate_code` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `account_UNIQUE` (`account`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mnrmp_users_t`
--

LOCK TABLES `mnrmp_users_t` WRITE;
/*!40000 ALTER TABLE `mnrmp_users_t` DISABLE KEYS */;
INSERT INTO `mnrmp_users_t` VALUES (1,1,'southday','南天南','2016-09-20',1,'lichaoxi7@163.com','123456789','3860ca6cf8e9d51a02c907dc36cc2da4','2016-09-10 00:00:00','default.png',1,1,'d077f244def8a70e5ea758bd8352fcd8'),(2,1,'ghost','鼬灵','2016-09-13',0,'ghost@163.com','18383229532','d28103ac45557dd60a38d838839222f0','2016-09-10 00:00:00','default.png',1,1,'06d80eb0c50b49a509b49f2424e8c805'),(3,1,'er','艺耳','2016-09-13',1,'er@qq.com','19833249324','ddd7dfd38664d9e1c3932b97f494826d','2016-09-10 00:00:00','default.png',1,1,'818f9c45cfa30eeff277ef38bcbe9910'),(4,1,'dog','多哥','2016-09-13',1,'dog@163.com','13899281223','33d7a70732faa37572fe3ec3bea1cb29','2016-09-10 00:00:00','default.png',0,1,'71144850f4fb4cc55fc0ee6935badddf'),(5,1,'pig','琵戈','2016-09-13',0,'pig@gmail.com','18232341293','d87b39b52279ae40012a03cdb5c87ab3','2016-09-10 00:00:00','default.png',0,0,'f74c6af46a78becb2f1bd3f95bbd5858'),(6,1,'cat','凯特','2016-09-13',1,'cat@qq.com','14598329457','b473786cdfdde29ee248457a6603904c','2016-09-13 15:01:49','default.png',1,0,'8f1f10733c5b8d8415948d297be54f0b'),(16,1,'panda','熊猫','2016-09-19',1,'panda@163.com','1838743998','3840c994e76852f3d778778879ed4749','2016-09-19 23:36:55','default.png',1,0,'ce61649168c4550c2f7acab92354dc6e'),(17,1,'aobama','奥巴马','2016-09-20',1,'lichaoxi77@qq.com','2928449283','8e0dd7c149ab1be7c4cacd7de89d0ce9','2016-09-20 09:22:07','default.png',1,0,'cf618890b64993e717869584fe9d99db'),(20,1,'dawang','大王','2016-09-20',1,'dawang@163.com','2928449283','e61e8ada10632597220865b0e6280f6c','2016-09-26 11:07:18','default.png',1,0,'13b08f4e45e27f23a078a9683b0bc38b'),(23,1,'mama','麻麻','2016-09-20',0,'lichaoxi78@qq.com','123456789','1591f6093dc5d324c5daf581128e1442','2016-09-26 11:26:30','default.png',1,1,'eeafbf4d9b3957b139da7b7f2e7f2d4a'),(24,1,'www','xiaoxiao','2016-09-29',1,'yanghong_qiang@yeah.net','12131313131','600a384b186da2664548ceb05a2b9d88','2016-09-29 09:56:58','default.png',1,0,'4eae35f1b35977a00ebd8086c259d4c9');
/*!40000 ALTER TABLE `mnrmp_users_t` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-29 10:45:18
