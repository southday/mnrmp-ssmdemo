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
-- Table structure for table `mnrmp_lookup_values_t`
--

DROP TABLE IF EXISTS `mnrmp_lookup_values_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mnrmp_lookup_values_t` (
  `lookup_value_id` int(11) NOT NULL AUTO_INCREMENT,
  `lookup_type_id` int(11) NOT NULL,
  `lookup_value_code` varchar(45) NOT NULL,
  `meaning` varchar(45) NOT NULL,
  PRIMARY KEY (`lookup_value_id`),
  UNIQUE KEY `lookup_value_code_UNIQUE` (`lookup_value_code`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mnrmp_lookup_values_t`
--

LOCK TABLES `mnrmp_lookup_values_t` WRITE;
/*!40000 ALTER TABLE `mnrmp_lookup_values_t` DISABLE KEYS */;
INSERT INTO `mnrmp_lookup_values_t` VALUES (1,1,'DELETE_VIDEO','删除视频'),(2,1,'UPLOAD_VIDEO','上传视频'),(3,1,'DOWNLOAD_VIDEO','下载视频'),(4,1,'COMMENT','评论'),(5,1,'AUDIT_VIDEO','审核视频'),(6,1,'NEW_VIDEO_CATAGORY','新建视频类别'),(7,1,'DELETE_VIDEO_CATAGORY','删除视频类别'),(8,1,'RENAME_VIDEO_CATAGORY','重命名视频类别'),(9,1,'FREEZE_USER','冻结用户'),(10,1,'ALLOW_USER_UPLOAD','允许用户上传'),(11,1,'DENY_USER_UPLOAD','拒绝用户上传'),(12,1,'ALLOW_USER_DOWNLOAD','允许用户下载'),(13,1,'DENY_USER_DOWNLOAD','拒绝用户上传'),(14,1,'ALLOW_USER_COMMENT','允许用户评论'),(15,1,'DENY_USER_COMMENT','拒绝用户评论'),(16,2,'COMMON_USER','普通用户'),(17,2,'VIP_USER','VIP用户'),(18,3,'ENTERTAINMENT','娱乐'),(19,3,'SCIENCE_TECHNOLOGY','科技'),(20,3,'DOCUMENTARY','纪实'),(21,3,'ORIGINAL','原创'),(22,3,'GAME','游戏'),(23,3,'TV_PLAY','电视剧'),(24,3,'FILM','电影'),(25,3,'CARTOON','动画片'),(26,3,'SPORTS','体育'),(27,3,'LIFE','生活'),(28,4,'PUBLIC','公开'),(29,4,'PRIVATE','个人'),(30,4,'ENCRYPTION','设置密码'),(31,5,'REVIEWING','审核中'),(32,5,'ACCEPTED','已接受'),(33,5,'REFUSED','已拒绝'),(34,3,'OTHER','其他');
/*!40000 ALTER TABLE `mnrmp_lookup_values_t` ENABLE KEYS */;
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
