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
-- Table structure for table `mnrmp_menus_t`
--

DROP TABLE IF EXISTS `mnrmp_menus_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mnrmp_menus_t` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_menu_id` int(11) DEFAULT NULL,
  `menu_code` varchar(25) NOT NULL,
  `menu_name` varchar(25) NOT NULL,
  `menu_url` varchar(45) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3008 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mnrmp_menus_t`
--

LOCK TABLES `mnrmp_menus_t` WRITE;
/*!40000 ALTER TABLE `mnrmp_menus_t` DISABLE KEYS */;
INSERT INTO `mnrmp_menus_t` VALUES (1,NULL,'COMMON_OPERATION','通用操作',NULL,'通用操作'),(2,1,'DELETE_VIDEO','删除视频',NULL,'删除视频'),(1000,NULL,'USER_OPERATION','用户操作',NULL,'用户操作'),(1001,1000,'UPLOAD_VIDEO','上传视频',NULL,'上传视频'),(1002,1000,'DOWNLOAD_VIDEO','下载视频',NULL,'下载视频'),(1003,1000,'COMMENT','评论',NULL,'评论'),(2000,NULL,'MANAGER_OPERATION','资源管理员操作',NULL,'资源管理员操作'),(2001,2000,'AUDIT_VIDEO','审核视频',NULL,'审核视频'),(2002,2000,'NEW_VIDEO_CATAGORY','新建视频类别',NULL,'新建视频类别'),(2003,2000,'DELETE_VIDEO_CATAGORY','删除视频类别',NULL,'删除视频类别'),(2004,2000,'RENAME_VIDEO_CATAGORY','重命名视频类别',NULL,'重命名视频类别'),(3000,NULL,'ADMIN_OPERATION','系统管理员操作',NULL,'系统管理员操作'),(3001,3000,'FREEZE_USER','冻结用户',NULL,'冻结用户'),(3002,3000,'ALLOW_USER_UPLOAD','允许用户上传',NULL,'允许用户上传'),(3003,3000,'DENY_USER_UPLOAD','拒绝用户上传',NULL,'拒绝用户上传'),(3004,3000,'ALLOW_USER_DOWNLOAD','允许用户下载',NULL,'允许用户下载'),(3005,3000,'DENY_USER_DOWNLOAD','拒绝用户下载',NULL,'拒绝用户下载'),(3006,3000,'ALLOW_USER_COMMENT','允许用户评论',NULL,'允许用户评论'),(3007,3000,'DENY_USER_COMMENT','拒绝用户评论',NULL,'拒绝用户评论');
/*!40000 ALTER TABLE `mnrmp_menus_t` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-29 10:45:19
