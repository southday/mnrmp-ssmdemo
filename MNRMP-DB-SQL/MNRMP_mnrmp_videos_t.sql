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
-- Table structure for table `mnrmp_videos_t`
--

DROP TABLE IF EXISTS `mnrmp_videos_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mnrmp_videos_t` (
  `video_id` int(11) NOT NULL AUTO_INCREMENT,
  `video_title` varchar(45) NOT NULL,
  `video_name` varchar(45) NOT NULL,
  `status_code` varchar(25) NOT NULL DEFAULT 'ACCEPTED',
  `user_id` int(11) NOT NULL,
  `upload_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `catalog_id` int(11) NOT NULL,
  `praised_num` int(11) DEFAULT '0',
  `download_num` int(11) DEFAULT '0',
  `collected_num` int(11) DEFAULT '0',
  `intro` varchar(100) DEFAULT NULL,
  `miniature_name` varchar(45) NOT NULL,
  `privacy_code` varchar(25) NOT NULL DEFAULT 'PUBLIC',
  `see_password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`video_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mnrmp_videos_t`
--

LOCK TABLES `mnrmp_videos_t` WRITE;
/*!40000 ALTER TABLE `mnrmp_videos_t` DISABLE KEYS */;
INSERT INTO `mnrmp_videos_t` VALUES (1,'冬瓜','72c717b9-0090-4b91-9565-e041b1a15ec3.mp4','ACCEPTED',1,'2016-09-17 00:00:00',2,3,4,2,'冬瓜冬瓜冬瓜','72c717b9-0090-4b91-9565-e041b1a15ec3.png','PUBLIC',NULL),(2,'西瓜','85c2b9d7-363d-4042-9dfc-60b4fddf5a9a.mp4','ACCEPTED',1,'2016-09-17 00:00:00',3,1,3,1,'西瓜西瓜西瓜','85c2b9d7-363d-4042-9dfc-60b4fddf5a9a.png','PUBLIC',NULL),(3,'南瓜','111b8bc5-fccf-4b54-b569-f3cf1c9d5440.mp4','ACCEPTED',1,'2016-09-17 00:00:00',2,1,0,0,'南瓜南瓜南瓜','111b8bc5-fccf-4b54-b569-f3cf1c9d5440.png','PUBLIC',NULL),(4,'小瓜','468c0ac5-9fc6-4f6d-8061-a648ff6caca8.mp4','ACCEPTED',1,'2016-09-17 00:00:00',3,0,0,0,'小瓜小瓜小瓜','468c0ac5-9fc6-4f6d-8061-a648ff6caca8.png','PRIVATE',NULL),(5,'黄瓜','5367623f-4675-498e-84ca-2c0f7ab79543.mp4','ACCEPTED',1,'2016-09-17 00:00:00',3,0,0,0,'黄瓜黄瓜黄瓜','5367623f-4675-498e-84ca-2c0f7ab79543.png','ENCRYPTION','8f1f10733c5b8d8415948d297be54f0b'),(6,'哈密瓜','c61a6f7d-dd34-477d-a61d-c16d226a9043.mp4','REFUSED',1,'2016-09-17 00:00:00',1,0,0,0,'哈密瓜哈密瓜哈密瓜','c61a6f7d-dd34-477d-a61d-c16d226a9043.png','PRIVATE','8f1f10733c5b8d8415948d297be54f0b'),(7,'牛奶','d32e4833-4506-4d32-96ac-6f5c0c1534dd.mp4','ACCEPTED',2,'2016-09-17 00:00:00',100,3,3,2,'牛奶牛奶牛奶','d32e4833-4506-4d32-96ac-6f5c0c1534dd.png','PUBLIC',NULL),(8,'果粒橙','6ef36e81-aad5-496a-a57b-5c8ebf9618f5.mp4','ACCEPTED',2,'2016-09-17 00:00:00',100,2,4,3,'果粒橙果粒橙果粒橙','6ef36e81-aad5-496a-a57b-5c8ebf9618f5.png','PUBLIC',NULL),(11,'拖鞋','70a01eac-bb9f-4fd2-99a9-39477b5f9944.mp4','ACCEPTED',3,'2016-09-17 00:00:00',201,2,2,2,'拖鞋拖鞋拖鞋','70a01eac-bb9f-4fd2-99a9-39477b5f9944.png','PUBLIC',NULL),(12,'球鞋','b2e7863c-4443-4a6c-ad11-68e9419578ac.mp4','REVIEWING',3,'2016-09-17 00:00:00',202,0,0,0,'球鞋球鞋球鞋','b2e7863c-4443-4a6c-ad11-68e9419578ac.png','PRIVATE',NULL),(13,'雨鞋','80732f90-4702-449d-ac2a-307f4a3a8cf4.mp4','REFUSED',3,'2016-09-17 00:00:00',203,0,0,1,'雨鞋雨鞋雨鞋','80732f90-4702-449d-ac2a-307f4a3a8cf4.png','ENCRYPTION','818f9c45cfa30eeff277ef38bcbe9910'),(19,'哈哈哈','eec2f86a-91b3-4d1e-978d-a31301b467b1.mp4','ACCEPTED',1,'2016-09-22 00:24:40',5,0,1,0,'呵呵呵呵呵呵','eec2f86a-91b3-4d1e-978d-a31301b467b1.png','PUBLIC',NULL),(20,'鼬鼬鼬','a8754498-226e-4649-8b59-412294028ba4.mp4','REVIEWING',1,'2016-09-25 23:42:03',3,0,0,0,'火影忍者-宇智波-鼬','a8754498-226e-4649-8b59-412294028ba4.png','PUBLIC',NULL),(21,'我的小视频','68df7ed5-102d-4c1e-b8c8-32900831a86e.mp4','ACCEPTED',1,'2016-09-26 15:48:15',1,0,0,0,'萨达发送啊啊','68df7ed5-102d-4c1e-b8c8-32900831a86e.png','PUBLIC',NULL),(22,'将萨达来开发空间','97fb1a44-d782-46f3-b200-e8c15890e78e.mp4','REVIEWING',1,'2016-09-26 15:56:22',12,0,0,0,'三大件父类大声叫','97fb1a44-d782-46f3-b200-e8c15890e78e.png','PUBLIC',NULL),(23,'qtfaststart测试','4ee15873-d41c-41ea-8fc7-82e78dd2e0db.mp4','ACCEPTED',1,'2016-09-27 09:40:57',1,0,1,0,'qtfast测试','4ee15873-d41c-41ea-8fc7-82e78dd2e0db.png','PUBLIC',NULL),(24,'qtfaststart测试2222','1d71ff18-a077-4ced-9e77-2cb3c748ee3b.mp4','ACCEPTED',1,'2016-09-27 10:08:27',13,0,2,0,'qtfast测试sdf','1d71ff18-a077-4ced-9e77-2cb3c748ee3b.png','PUBLIC',NULL),(25,'www','07977433-2051-4786-a45c-65dc5a4e9570.mp4','ACCEPTED',3,'2016-09-29 09:45:29',201,0,0,0,'wwwwwwwwwwwwwwww','07977433-2051-4786-a45c-65dc5a4e9570.png','PUBLIC',NULL),(26,'xiaoxiaode','6cb2f643-f8cf-42e7-886a-39382ad8d9d8.mp4','ACCEPTED',24,'2016-09-29 09:58:55',900,0,0,0,'xiaoxiaoxiaoxiao','6cb2f643-f8cf-42e7-886a-39382ad8d9d8.png','PRIVATE','111');
/*!40000 ALTER TABLE `mnrmp_videos_t` ENABLE KEYS */;
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
