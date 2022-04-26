-- --------------------------------------------------------
-- 호스트:                          localhost
-- 서버 버전:                        10.5.15-MariaDB-1:10.5.15+maria~focal - mariadb.org binary distribution
-- 서버 OS:                        debian-linux-gnu
-- HeidiSQL 버전:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- MadPT 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `MadPT`/*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `MadPT`;

-- 테이블 MadPT.diet 구조 내보내기
CREATE TABLE IF NOT EXISTS `diet` (
  `diet_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `food_id` int(11) DEFAULT NULL,
  `type` int(2) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `unit` varchar(50) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`diet_id`),
  KEY `user_id` (`user_id`),
  KEY `food_id` (`food_id`),
  CONSTRAINT `FK_diet_food` FOREIGN KEY (`food_id`) REFERENCES `food` (`food_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_diet_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 테이블 데이터 MadPT.diet:~0 rows (대략적) 내보내기
DELETE FROM `diet`;
/*!40000 ALTER TABLE `diet` DISABLE KEYS */;
/*!40000 ALTER TABLE `diet` ENABLE KEYS */;

-- 테이블 MadPT.exercise 구조 내보내기
CREATE TABLE IF NOT EXISTS `exercise` (
  `exercise_id` int(11) NOT NULL AUTO_INCREMENT,
  `exercise_name` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`exercise_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 테이블 데이터 MadPT.exercise:~0 rows (대략적) 내보내기
DELETE FROM `exercise`;
/*!40000 ALTER TABLE `exercise` DISABLE KEYS */;
/*!40000 ALTER TABLE `exercise` ENABLE KEYS */;

-- 테이블 MadPT.food 구조 내보내기
CREATE TABLE IF NOT EXISTS `food` (
  `food_id` int(11) NOT NULL AUTO_INCREMENT,
  `food_name` varchar(1000) DEFAULT NULL,
  `maker_name` varchar(100) DEFAULT NULL,
  `default_weight` double DEFAULT NULL,
  `default_kcal` double DEFAULT NULL,
  `dafault_carbohydrate` double DEFAULT NULL,
  `default_protein` double DEFAULT NULL,
  `default_fat` double DEFAULT NULL,
  PRIMARY KEY (`food_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 테이블 데이터 MadPT.food:~0 rows (대략적) 내보내기
DELETE FROM `food`;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
/*!40000 ALTER TABLE `food` ENABLE KEYS */;

-- 테이블 MadPT.record 구조 내보내기
CREATE TABLE IF NOT EXISTS `record` (
  `record_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `exercise_id` int(11) NOT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `sets` int(11) DEFAULT NULL,
  `reps` int(11) DEFAULT NULL,
  PRIMARY KEY (`record_id`),
  KEY `FK_record_user` (`user_id`),
  KEY `FK_record_exercise` (`exercise_id`),
  CONSTRAINT `FK_record_exercise` FOREIGN KEY (`exercise_id`) REFERENCES `exercise` (`exercise_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_record_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 테이블 데이터 MadPT.record:~0 rows (대략적) 내보내기
DELETE FROM `record`;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
/*!40000 ALTER TABLE `record` ENABLE KEYS */;

-- 테이블 MadPT.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `birth` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `height` double DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 테이블 데이터 MadPT.user:~0 rows (대략적) 내보내기
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
