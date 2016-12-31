-- MySQL dump 10.13  Distrib 5.5.53, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: db_saklar
-- ------------------------------------------------------
-- Server version	5.5.53-0ubuntu0.14.04.1

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
-- Table structure for table `tb_gas`
--

DROP TABLE IF EXISTS `tb_gas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_gas` (
  `id_gas` int(11) NOT NULL AUTO_INCREMENT,
  `nama_gas` varchar(35) NOT NULL,
  `status_gas` varchar(10) NOT NULL,
  PRIMARY KEY (`id_gas`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_gas`
--

LOCK TABLES `tb_gas` WRITE;
/*!40000 ALTER TABLE `tb_gas` DISABLE KEYS */;
INSERT INTO `tb_gas` VALUES (1,'nam','mati'),(2,'hama','mati');
/*!40000 ALTER TABLE `tb_gas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_saklar`
--

DROP TABLE IF EXISTS `tb_saklar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_saklar` (
  `id_saklar` int(11) NOT NULL AUTO_INCREMENT,
  `nama_saklar` varchar(35) NOT NULL,
  `status_saklar` varchar(10) NOT NULL,
  PRIMARY KEY (`id_saklar`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_saklar`
--

LOCK TABLES `tb_saklar` WRITE;
/*!40000 ALTER TABLE `tb_saklar` DISABLE KEYS */;
INSERT INTO `tb_saklar` VALUES (1,'led mera','hidup'),(2,'kamar kakak','hidup'),(3,'saklar_3','hidup'),(4,'saklar_4','hidup'),(5,'led biru','hidup'),(6,'saklar_6','hidup'),(7,'saklar_7','hidup'),(8,'sakla','hidup');
/*!40000 ALTER TABLE `tb_saklar` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-01  2:01:11
