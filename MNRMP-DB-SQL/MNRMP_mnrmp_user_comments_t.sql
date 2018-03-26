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
-- Table structure for table `mnrmp_user_comments_t`
--

DROP TABLE IF EXISTS `mnrmp_user_comments_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mnrmp_user_comments_t` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `reply_id` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `video_id` int(11) NOT NULL,
  `detail` varchar(100) NOT NULL,
  `comment_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `support_num` int(11) DEFAULT '0',
  `oppose_num` int(11) DEFAULT '0',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mnrmp_user_comments_t`
--

LOCK TABLES `mnrmp_user_comments_t` WRITE;
/*!40000 ALTER TABLE `mnrmp_user_comments_t` DISABLE KEYS */;
INSERT INTO `mnrmp_user_comments_t` VALUES (1,NULL,1,1,'感觉还是不行啊！','2016-09-18 15:39:27',30,13),(2,NULL,2,1,'画质有点差，创意不错','2016-09-18 15:40:02',13,1),(3,2,3,1,'同意','2016-09-18 15:40:27',0,0),(4,1,3,1,'后期处理要更精细点哈！','2016-09-18 15:41:10',1,0),(5,NULL,2,2,'太好笑了 :-)','2016-09-18 15:42:08',32,0),(6,4,1,1,'嗯，好的！','2016-09-18 15:42:49',0,0),(7,6,1,1,'是啊，看完就笑哭了','2016-09-18 15:43:41',2,0),(8,NULL,3,3,'不想吐槽','2016-09-18 15:44:49',0,12),(9,8,2,3,'你发这句话就是在吐槽！！','2016-09-18 15:45:16',13,0),(11,9,3,3,'有意见？','2016-09-18 15:45:47',0,0),(12,11,2,3,'不服来solo？','2016-09-18 15:46:45',0,0),(13,NULL,1,3,'哈哈，二位别闹了@ghost，@er','2016-09-18 15:47:13',0,0),(14,NULL,2,5,'好不容易和发布者拿到密码，还真值了！有意思！','2016-09-18 15:48:23',11,2),(15,14,1,5,'不客气喔，相互交流嘛','2016-09-18 15:48:47',0,0),(19,NULL,2,21,'我也哈哈哈哈','2016-09-27 16:39:53',0,0),(22,20,2,21,'傻子','2016-09-27 16:49:27',0,0),(23,22,2,21,'你也傻子','2016-09-27 16:50:14',0,0),(24,6,2,1,'哇啊','2016-09-27 16:54:43',0,0),(25,4,1,1,'呵呵呵呵','2016-09-28 10:05:00',0,0);
/*!40000 ALTER TABLE `mnrmp_user_comments_t` ENABLE KEYS */;
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
