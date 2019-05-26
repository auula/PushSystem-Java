CREATE DATABASE  IF NOT EXISTS `xywbxt` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `xywbxt`;
-- MySQL dump 10.13  Distrib 5.5.61, for Win64 (AMD64)
--
-- Host: localhost    Database: xywbxt
-- ------------------------------------------------------
-- Server version	5.5.61

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
-- Table structure for table `call_inf`
--

DROP TABLE IF EXISTS `call_inf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `call_inf` (
  `call_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` int(11) DEFAULT NULL,
  `equ_id` int(11) NOT NULL,
  `call_time` datetime DEFAULT NULL,
  `fault_id` int(11) DEFAULT NULL,
  `call_sta` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `call_num` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `reply_time` datetime DEFAULT NULL,
  `end_sta` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`call_id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `call_inf`
--

LOCK TABLES `call_inf` WRITE;
/*!40000 ALTER TABLE `call_inf` DISABLE KEYS */;
INSERT INTO `call_inf` VALUES (44,1,3,'2019-02-11 12:07:48',9,'待审核','',NULL,'未修复',NULL),(45,1,3,'2019-02-11 12:15:36',8,'已审核','','2019-02-11 12:15:50','未修复',NULL),(46,1,3,'2019-02-11 12:16:45',9,'待审核','',NULL,'未修复',NULL),(47,1,3,'2019-02-11 12:17:22',9,'待审核','',NULL,'未修复',NULL),(48,1,3,'2019-02-11 12:18:42',9,'已审核','','2019-02-11 12:18:57','未修复',NULL),(50,1,3,'2019-02-11 12:42:01',9,'待审核','',NULL,'未修复',NULL),(51,1,4,'2019-02-11 12:43:29',9,'已审核','','2019-02-11 12:43:36','未修复',NULL),(52,2,3,'2019-02-11 13:42:45',8,'待审核','',NULL,'未修复',NULL),(53,1,3,'2019-02-11 13:52:48',9,'待审核','',NULL,'已修复',NULL),(54,3,3,'2019-02-13 11:52:34',8,'已审核','','2019-02-13 12:04:44','已修复','2019-02-13 12:26:07'),(55,3,3,'2019-02-13 12:32:21',9,'已审核','','2019-02-13 12:32:48','已修复','2019-02-13 12:44:14');
/*!40000 ALTER TABLE `call_inf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_inf`
--

DROP TABLE IF EXISTS `employee_inf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_inf` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_role` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `emp_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `emp_pass` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_inf`
--

LOCK TABLES `employee_inf` WRITE;
/*!40000 ALTER TABLE `employee_inf` DISABLE KEYS */;
INSERT INTO `employee_inf` VALUES (1,'管理员','admin','admin'),(2,'员工','2','2'),(3,'维修人员','11','11'),(4,'维修人员','3','3');
/*!40000 ALTER TABLE `employee_inf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipment_inf`
--

DROP TABLE IF EXISTS `equipment_inf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipment_inf` (
  `equ_id` int(11) NOT NULL AUTO_INCREMENT,
  `equ_name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `equ_sta` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `equ_type` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`equ_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment_inf`
--

LOCK TABLES `equipment_inf` WRITE;
/*!40000 ALTER TABLE `equipment_inf` DISABLE KEYS */;
INSERT INTO `equipment_inf` VALUES (3,'3-2','1','1, 1'),(4,'3-1','23','23, 23'),(5,'3-3','123','123, 123');
/*!40000 ALTER TABLE `equipment_inf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fault_inf`
--

DROP TABLE IF EXISTS `fault_inf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fault_inf` (
  `fault_id` int(11) NOT NULL AUTO_INCREMENT,
  `fault_type` varchar(45) COLLATE utf8_bin NOT NULL,
  `fault_describe` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`fault_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fault_inf`
--

LOCK TABLES `fault_inf` WRITE;
/*!40000 ALTER TABLE `fault_inf` DISABLE KEYS */;
INSERT INTO `fault_inf` VALUES (8,'机械','小盒划痕'),(9,'电气','看门狗1');
/*!40000 ALTER TABLE `fault_inf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `part_inf`
--

DROP TABLE IF EXISTS `part_inf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `part_inf` (
  `part_id` int(11) NOT NULL AUTO_INCREMENT,
  `part_type` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `part_time` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `part_name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`part_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part_inf`
--

LOCK TABLES `part_inf` WRITE;
/*!40000 ALTER TABLE `part_inf` DISABLE KEYS */;
INSERT INTO `part_inf` VALUES (6,'中班','2019-02-04','乙'),(7,'早班','2019-02-05','甲');
/*!40000 ALTER TABLE `part_inf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `punch_inf`
--

DROP TABLE IF EXISTS `punch_inf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `punch_inf` (
  `punch_id` int(11) NOT NULL AUTO_INCREMENT,
  `punch_time` datetime DEFAULT NULL,
  `part_id` int(11) DEFAULT NULL,
  `emp_id` int(11) DEFAULT NULL,
  `equ_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`punch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `punch_inf`
--

LOCK TABLES `punch_inf` WRITE;
/*!40000 ALTER TABLE `punch_inf` DISABLE KEYS */;
/*!40000 ALTER TABLE `punch_inf` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-16 18:59:39
