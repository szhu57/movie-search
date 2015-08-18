CREATE DATABASE  IF NOT EXISTS `id26346915` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `id26346915`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: id26346915
-- ------------------------------------------------------
-- Server version	5.6.21-log

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
-- Table structure for table `moviedb`
--

DROP TABLE IF EXISTS `moviedb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `moviedb` (
  `Movieid` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(20) NOT NULL,
  `Type` varchar(100) NOT NULL,
  `Rating` double DEFAULT NULL,
  `Starts` varchar(100) DEFAULT NULL,
  `Director` varchar(100) DEFAULT NULL,
  `Description` varchar(500) DEFAULT NULL,
  `Coverurl` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Movieid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moviedb`
--

LOCK TABLES `moviedb` WRITE;
/*!40000 ALTER TABLE `moviedb` DISABLE KEYS */;
INSERT INTO `moviedb` VALUES (1,'The Godfather','Crime,Drama',9.2,'Marlon Brando,Al Pacino,James Caan','Francis Ford Coppola','The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.','http://s4.sinaimg.cn/bmiddle/56da9b6106ea498989593'),(2,'Idiots','Commedy,Drama',8.5,'Aamir Khan,Madhavan,Mona Singh','Rajkumar Hirani','Two friends are searching for their long lost companion. They revisit their college days and recall the memories of their friend who inspired them to think differently, even as the rest of the world called them \"idiots\".','http://ia.media-imdb.com/images/M/MV5BMTMyOTg0ODQ1OF5BMl5BanBnXkFtZTcwNjc0NTMwNQ@@._V1_SY317_CR5,0,214,317_AL_.jpg'),(3,'2012','Action,Adventure,Sci-Fi',5.8,'John Cusack, Thandie Newton, Chiwetel Ejiofor','Roland Emmerich','A frustrated writer struggles to keep his family alive when a series of global catastrophes threatens to annihilate mankind.','http://ia.media-imdb.com/images/M/MV5BMTY0MjEyODQzMF5BMl5BanBnXkFtZTcwMTczMjQ4Mg@@._V1_SX214_AL_.jpg'),(4,'Leon','Crime,Drama,Thriller',8.6,'Jean Reno,Gary Oldman,Natalie Portman','Luc Besson','Mathilda, a 12-year-old girl, is reluctantly taken in by Léon, a professional assassin, after her family is murdered. Léon and Mathilda form an unusual relationship, as she becomes his protégée and learns the assassin\'s trade.','http://ia.media-imdb.com/images/M/MV5BMTgzMzg4MDkwNF5BMl5BanBnXkFtZTcwODAwNDg3OA@@._V1_SY317_CR4,0,214,317_AL_.jpg'),(5,'Forrest Gump','Drama,Romance',8.8,'Tom Hanks,Robin Wright,Gary Sinise','Robert Zemeckis','Forrest Gump, while not intelligent, has accidentally been present at many historic moments, but his true love, Jenny Curran, eludes him.','http://ia.media-imdb.com/images/M/MV5BMTQwMTA5MzI1MF5BMl5BanBnXkFtZTcwMzY5Mzg3OA@@._V1_SX214_AL_.jpg'),(6,'Inception','Action,Mystery,Sci-Fi',8.8,'Leonardo DiCaprio,Joseph Gordon-Levitt','Christopher Nolan','A thief who steals corporate secrets through use of dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO.','http://ia.media-imdb.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX214_AL_.jpg'),(7,'Intouchables','Biograhpy,Comedy,Drama',8.6,'Francois Cluzet,Omar Sy,Anne Le Ny','Olivier Nakache,Eric Toledano','After he becomes a quadriplegic from a paragliding accident, an aristocrat hires a young man from the projects to be his caregiver.','http://ia.media-imdb.com/images/M/MV5BMTYxNDA3MDQwNl5BMl5BanBnXkFtZTcwNTU4Mzc1Nw@@._V1_SX214_AL_.jpg'),(8,'Flipped','Comedy,Drama,Romance',7.7,'Madeline Carroll,Callan McAuliffe','Rob Reiner','Two eighth-graders start to have feelings for each other despite being total opposites. Based on the novel \"Flipped\" by Wendelin Van Draanen.','http://ia.media-imdb.com/images/M/MV5BMTU2NjQ1Nzc4MF5BMl5BanBnXkFtZTcwNTM0NDk1Mw@@._V1_SX214_AL_.jpg'),(9,'Avatar','Action,Adventure,Fantasy',7.9,'Sam Worthington,Zoe Saldana','James Cameron','A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.','http://ia.media-imdb.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_SY317_CR0,0,214,317_AL_.jpg'),(10,'Despicable Me','Animation,Comedy,Family',7.7,'Steve Carell,Jason Segel,Russel Brand','Poerre Coffin,Chris Renaud','When a criminal mastermind uses a trio of orphan girls as pawns for a grand scheme, he finds their love is profoundly changing him for the better.','http://ia.media-imdb.com/images/M/MV5BMTY3NjY0MTQ0Nl5BMl5BanBnXkFtZTcwMzQ2MTc0Mw@@._V1_SY317_CR0,0,214,317_AL_.jpg');
/*!40000 ALTER TABLE `moviedb` ENABLE KEYS */;
UNLOCK TABLES;



--
-- Dumping events for database 'id26346915'
--

--
-- Dumping routines for database 'id26346915'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-16 13:30:21
