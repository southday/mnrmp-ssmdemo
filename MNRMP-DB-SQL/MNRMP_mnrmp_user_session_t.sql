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
-- Table structure for table `mnrmp_user_session_t`
--

DROP TABLE IF EXISTS `mnrmp_user_session_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mnrmp_user_session_t` (
  `allot_id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(25) NOT NULL,
  `session_id` varchar(45) NOT NULL DEFAULT '0',
  `user_type_code` varchar(45) NOT NULL,
  PRIMARY KEY (`allot_id`),
  UNIQUE KEY `account_UNIQUE` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mnrmp_user_session_t`
--

LOCK TABLES `mnrmp_user_session_t` WRITE;
/*!40000 ALTER TABLE `mnrmp_user_session_t` DISABLE KEYS */;
INSERT INTO `mnrmp_user_session_t` VALUES (1,'southday','A17C411C5BB888D957E3423C12746460','COMMON_USER'),(2,'ghost','963A284D0D75A787F988B447AC88418B','COMMON_USER'),(3,'er','0','COMMON_USER'),(4,'dog','0','COMMON_USER'),(5,'pig','0','COMMON_USER'),(6,'cat','0','COMMON_USER'),(7,'manager1','94620F8A82DAAC19EB14CBE730AD260C','RES_MANAGER'),(8,'manager2','0','RES_MANAGER'),(9,'manager3','0','RES_MANAGER'),(10,'admin1','0','SYS_ADMIN'),(11,'admin2','0','SYS_ADMIN'),(14,'panda','0','COMMON_USER'),(17,'aobama','0','COMMON_USER'),(32,'mama','0','COMMON_USER'),(33,'www','0','COMMON_USER');
/*!40000 ALTER TABLE `mnrmp_user_session_t` ENABLE KEYS */;
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
