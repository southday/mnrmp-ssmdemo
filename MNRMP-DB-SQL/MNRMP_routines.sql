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
-- Temporary view structure for view `mnrmp_manager_audits_v`
--

DROP TABLE IF EXISTS `mnrmp_manager_audits_v`;
/*!50001 DROP VIEW IF EXISTS `mnrmp_manager_audits_v`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `mnrmp_manager_audits_v` AS SELECT 
 1 AS `audit_id`,
 1 AS `manager_id`,
 1 AS `status_code`,
 1 AS `audit_date`,
 1 AS `description`,
 1 AS `video_id`,
 1 AS `video_title`,
 1 AS `video_name`,
 1 AS `miniature_name`,
 1 AS `upload_date`,
 1 AS `user_id`,
 1 AS `user_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `mnrmp_lookup_values_v`
--

DROP TABLE IF EXISTS `mnrmp_lookup_values_v`;
/*!50001 DROP VIEW IF EXISTS `mnrmp_lookup_values_v`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `mnrmp_lookup_values_v` AS SELECT 
 1 AS `lookup_type_id`,
 1 AS `lookup_type_code`,
 1 AS `lookup_type_meaning`,
 1 AS `lookup_value_id`,
 1 AS `lookup_value_code`,
 1 AS `lookup_value_meaning`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `mnrmp_manager_audits_v`
--

/*!50001 DROP VIEW IF EXISTS `mnrmp_manager_audits_v`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`mnrmp`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `mnrmp_manager_audits_v` AS select `mmat`.`audit_id` AS `audit_id`,`mmat`.`manager_id` AS `manager_id`,`mmat`.`status_code` AS `status_code`,`mmat`.`audit_date` AS `audit_date`,`mmat`.`description` AS `description`,`mvt`.`video_id` AS `video_id`,`mvt`.`video_title` AS `video_title`,`mvt`.`video_name` AS `video_name`,`mvt`.`miniature_name` AS `miniature_name`,`mvt`.`upload_date` AS `upload_date`,`mut`.`user_id` AS `user_id`,`mut`.`user_name` AS `user_name` from ((`mnrmp_manager_audits_t` `mmat` join `mnrmp_videos_t` `mvt`) join `mnrmp_users_t` `mut`) where ((`mmat`.`video_id` = `mvt`.`video_id`) and (`mvt`.`user_id` = `mut`.`user_id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `mnrmp_lookup_values_v`
--

/*!50001 DROP VIEW IF EXISTS `mnrmp_lookup_values_v`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `mnrmp_lookup_values_v` AS select `t`.`lookup_type_id` AS `lookup_type_id`,`t`.`lookup_type_code` AS `lookup_type_code`,`t`.`meaning` AS `lookup_type_meaning`,`v`.`lookup_value_id` AS `lookup_value_id`,`v`.`lookup_value_code` AS `lookup_value_code`,`v`.`meaning` AS `lookup_value_meaning` from (`mnrmp_lookup_types_t` `t` join `mnrmp_lookup_values_t` `v`) where (`t`.`lookup_type_id` = `v`.`lookup_type_id`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-29 10:45:19
