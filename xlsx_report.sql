-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: xlsx
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `report` (
  `credit_turnover_for_reporting_period_foreign_currency` varchar(255) DEFAULT NULL,
  `credit_turnover_for_reporting_period_rubles` varchar(255) DEFAULT NULL,
  `credit_turnover_for_reporting_period_total` varchar(255) DEFAULT NULL,
  `debit_turnover_for_reporting_period_foreign_currency` varchar(255) DEFAULT NULL,
  `debit_turnover_for_reporting_period_rubles` varchar(255) DEFAULT NULL,
  `debit_turnover_for_reporting_period_total` varchar(255) DEFAULT NULL,
  `incoming_balances_foreign_currency` varchar(255) DEFAULT NULL,
  `incoming_balances_rubles` varchar(255) DEFAULT NULL,
  `incoming_balances_total` varchar(255) DEFAULT NULL,
  `outgoing_balances_foreign_currency` varchar(255) DEFAULT NULL,
  `outgoing_balances_rubles` varchar(255) DEFAULT NULL,
  `outgoing_balances_total` varchar(255) DEFAULT NULL,
  `registration_account_number` int(11) NOT NULL,
  `second_account_number` int(11) NOT NULL,
  PRIMARY KEY (`second_account_number`,`registration_account_number`),
  KEY `FKh5vb1t13lrhhfooc7w8ik1sk1` (`registration_account_number`),
  CONSTRAINT `FKh5vb1t13lrhhfooc7w8ik1sk1` FOREIGN KEY (`registration_account_number`) REFERENCES `bill` (`id`),
  CONSTRAINT `FKlqeu508pklfy670knu2qdbjtb` FOREIGN KEY (`second_account_number`) REFERENCES `bank` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-26 16:23:03
