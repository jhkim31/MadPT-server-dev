-- MariaDB dump 10.19  Distrib 10.5.15-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: MadPT
-- ------------------------------------------------------
-- Server version	10.5.15-MariaDB-1:10.5.15+maria~focal

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
-- Current Database: `MadPT`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `MadPT` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `MadPT`;

--
-- Table structure for table `diet`
--

DROP TABLE IF EXISTS `diet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diet` (
  `diet_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `diet_date` datetime(6) DEFAULT NULL,
  `diet_type` varchar(255) DEFAULT NULL,
  `member_id` bigint(20) DEFAULT NULL,
  `simple_total_kcal` double NOT NULL,
  PRIMARY KEY (`diet_id`),
  KEY `FK9o446srb6o6fm3lklugo9mq0v` (`member_id`),
  CONSTRAINT `FK9o446srb6o6fm3lklugo9mq0v` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diet`
--

LOCK TABLES `diet` WRITE;
/*!40000 ALTER TABLE `diet` DISABLE KEYS */;
/*!40000 ALTER TABLE `diet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diet_food`
--

DROP TABLE IF EXISTS `diet_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diet_food` (
  `diet_food_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `count` int(11) NOT NULL,
  `food_weight` double NOT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `diet_id` bigint(20) DEFAULT NULL,
  `food_id` bigint(20) DEFAULT NULL,
  `diet_kcal` double NOT NULL,
  PRIMARY KEY (`diet_food_id`),
  KEY `FKg8ebdt611y8sqd6pa4e47bnqq` (`diet_id`),
  KEY `FKn0gmvmwvs43r9cs0ihtoaieni` (`food_id`),
  CONSTRAINT `FKg8ebdt611y8sqd6pa4e47bnqq` FOREIGN KEY (`diet_id`) REFERENCES `diet` (`diet_id`),
  CONSTRAINT `FKn0gmvmwvs43r9cs0ihtoaieni` FOREIGN KEY (`food_id`) REFERENCES `food` (`food_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diet_food`
--

LOCK TABLES `diet_food` WRITE;
/*!40000 ALTER TABLE `diet_food` DISABLE KEYS */;
/*!40000 ALTER TABLE `diet_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise`
--

DROP TABLE IF EXISTS `exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exercise` (
  `exercise_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `exercise_type` varchar(255) DEFAULT NULL,
  `exercise_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`exercise_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise`
--

LOCK TABLES `exercise` WRITE;
/*!40000 ALTER TABLE `exercise` DISABLE KEYS */;
/*!40000 ALTER TABLE `exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise_routine`
--

DROP TABLE IF EXISTS `exercise_routine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exercise_routine` (
  `exercise_routine_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`exercise_routine_id`),
  KEY `FKiadmkna943odcxo0plobpm2jh` (`member_id`),
  CONSTRAINT `FKiadmkna943odcxo0plobpm2jh` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise_routine`
--

LOCK TABLES `exercise_routine` WRITE;
/*!40000 ALTER TABLE `exercise_routine` DISABLE KEYS */;
/*!40000 ALTER TABLE `exercise_routine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `food` (
  `food_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `default_carbohydrate` double NOT NULL,
  `default_fat` double NOT NULL,
  `default_kcal` double NOT NULL,
  `default_protein` double NOT NULL,
  `default_weight` double NOT NULL,
  `food_name` varchar(1000) DEFAULT NULL,
  `is_custom` bit(1) NOT NULL,
  `maker_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`food_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goal`
--

DROP TABLE IF EXISTS `goal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goal` (
  `gaol_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `diet_kcal` double NOT NULL,
  `exercise_kcal` double NOT NULL,
  `weight` double NOT NULL,
  `member_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`gaol_id`),
  KEY `FK62jdhr16mniv5cf7pd2gtc79y` (`member_id`),
  CONSTRAINT `FK62jdhr16mniv5cf7pd2gtc79y` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goal`
--

LOCK TABLES `goal` WRITE;
/*!40000 ALTER TABLE `goal` DISABLE KEYS */;
/*!40000 ALTER TABLE `goal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `member_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gender_type` varchar(255) DEFAULT NULL,
  `height` double NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `weight` double NOT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `record` (
  `record_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `end_time` datetime(6) DEFAULT NULL,
  `reps` tinyblob DEFAULT NULL,
  `start_time` datetime(6) DEFAULT NULL,
  `exercise_id` bigint(20) DEFAULT NULL,
  `member_id` bigint(20) DEFAULT NULL,
  `avg_score` double NOT NULL,
  `break_time` int(11) NOT NULL,
  `burned_kcal` double NOT NULL,
  `real_time` bigint(20) DEFAULT NULL,
  `sets` int(11) NOT NULL,
  PRIMARY KEY (`record_id`),
  KEY `FKjs1jiif7ahtops6jfwdw17ip1` (`exercise_id`),
  KEY `FKt0rib4n7orlcfx52cnsicmriw` (`member_id`),
  CONSTRAINT `FKjs1jiif7ahtops6jfwdw17ip1` FOREIGN KEY (`exercise_id`) REFERENCES `exercise` (`exercise_id`),
  CONSTRAINT `FKt0rib4n7orlcfx52cnsicmriw` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routine`
--

DROP TABLE IF EXISTS `routine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `routine` (
  `routine_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `breaktime` int(11) NOT NULL,
  `date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `member_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`routine_id`),
  KEY `FK546lpheu7wdmjm1fj26wpyno2` (`member_id`),
  CONSTRAINT `FK546lpheu7wdmjm1fj26wpyno2` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routine`
--

LOCK TABLES `routine` WRITE;
/*!40000 ALTER TABLE `routine` DISABLE KEYS */;
/*!40000 ALTER TABLE `routine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routine_exercise`
--

DROP TABLE IF EXISTS `routine_exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `routine_exercise` (
  `routine_exercise_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `reps` int(11) NOT NULL,
  `sets` int(11) NOT NULL,
  `exercise_id` bigint(20) DEFAULT NULL,
  `routine_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`routine_exercise_id`),
  KEY `FKsn88y4ra5dickg7y7x3ouhykf` (`exercise_id`),
  KEY `FKcbc9ikf3pspchwepg7x4lqm9s` (`routine_id`),
  CONSTRAINT `FKcbc9ikf3pspchwepg7x4lqm9s` FOREIGN KEY (`routine_id`) REFERENCES `routine` (`routine_id`),
  CONSTRAINT `FKsn88y4ra5dickg7y7x3ouhykf` FOREIGN KEY (`exercise_id`) REFERENCES `exercise` (`exercise_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routine_exercise`
--

LOCK TABLES `routine_exercise` WRITE;
/*!40000 ALTER TABLE `routine_exercise` DISABLE KEYS */;
/*!40000 ALTER TABLE `routine_exercise` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-24  7:02:07
