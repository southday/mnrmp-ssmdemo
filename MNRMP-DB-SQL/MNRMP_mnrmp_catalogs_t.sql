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
-- Table structure for table `mnrmp_catalogs_t`
--

DROP TABLE IF EXISTS `mnrmp_catalogs_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mnrmp_catalogs_t` (
  `catalog_id` int(11) NOT NULL AUTO_INCREMENT,
  `catalog_name` varchar(25) NOT NULL,
  `parent_catalog_id` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`catalog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=901 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mnrmp_catalogs_t`
--

LOCK TABLES `mnrmp_catalogs_t` WRITE;
/*!40000 ALTER TABLE `mnrmp_catalogs_t` DISABLE KEYS */;
INSERT INTO `mnrmp_catalogs_t` VALUES (1,'默认精选集',NULL,1),(2,'Hello',NULL,1),(3,'World',NULL,1),(4,'污泥',2,1),(5,'积水',4,1),(6,'雷洛',1,1),(7,'阿里空间阿里',1,1),(9,'重命名者',1,1),(10,'得到',1,1),(11,'得到',1,1),(12,'FF',NULL,1),(13,'火星',1,1),(100,'默认精选集',NULL,2),(101,'嘿哟',NULL,2),(102,'嘿嘿',101,2),(200,'默认精选集',NULL,3),(201,'飞鱼',NULL,3),(202,'飞鸟',NULL,3),(203,'青鸟',202,3),(300,'默认精选集',NULL,4),(301,'走兽',NULL,4),(302,'狮子',301,4),(400,'默认精选集',NULL,5),(401,'青锁',NULL,5),(500,'默认精选集',NULL,6),(501,'风雨',NULL,6),(502,'万物',NULL,6),(503,'啥',502,6),(600,'默认精选集',NULL,16),(700,'默认精选集',NULL,17),(800,'默认精选集',NULL,23),(900,'默认精选集',NULL,24);
/*!40000 ALTER TABLE `mnrmp_catalogs_t` ENABLE KEYS */;
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
